<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>video</title>
</head>
<body>
<a href="#" onclick="video()">播放影片</a>
</body>

<script>
    function video() {
        const url = "video";
        open(url, "_blank", "width=1280,height=720");
    }
</script>
</html>
