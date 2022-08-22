<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <video id="videoPlayer" controls height="100%" src="video/play?vid=${vid}"></video>
    <input type="hidden" id="startTime" value="${startTime}">

    <script>
        let startTime = document.getElementById('startTime').value;
        document.getElementById('videoPlayer').currentTime = startTime;
    </script>
</body>
</html>
