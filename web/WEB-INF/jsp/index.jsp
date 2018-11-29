<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../styles/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Proyecto MVC</title>
        
    </head>

    <body>
        <h1> Examenes ${requestScope.listaExamen[0]}.rut.nombre</h1>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tipo Exámen</th>
                <th>Rut</th>
            </tr>
            <c:forEach var="f" items="${requestScope.listaExamen}">
                <tr>
                    <td>${f.id}</td>
                    <td>${f.tipoExamen}</td>
                    <td>${f.rut.rut}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
