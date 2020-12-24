<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello World</title>
</head>
   <body>
   베이스임당
    <section class="content">
      <tiles:insertAttribute name="body"/> <!-- body -->

    </section>
  </body>
</html>