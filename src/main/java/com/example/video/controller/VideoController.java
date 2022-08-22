package com.example.video.controller;

import com.example.video.config.NonStaticResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView searchView(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView("video");
        mav.addObject("vid", "1100223");
        mav.addObject("startTime", "10");

        return mav;
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public void videoPreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String vid = request.getParameter("vid");

//        String path = "D:/2.ts";
        String path = "D:/1.mp4";

        Path filePath = Paths.get(path);
        if (Files.exists(filePath)) {
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.hasText(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

}
