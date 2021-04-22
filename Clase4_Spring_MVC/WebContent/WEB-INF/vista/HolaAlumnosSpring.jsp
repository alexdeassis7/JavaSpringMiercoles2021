<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<!-- utilizamos un jsp tag -->

Hola  ${param.nombreAlumno }. Bienvenidos a Spring MVC

<br>

el siguiente mensaje estaba en el modelo !, fue seteado mediante el metodo "addAtribute()"

${mensaje}

</body>
</html>