<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .link {
            font-size: x-large;
            font-family: Georgia, 'Times New Roman', Times, serif;
            color: rgb(0, 0, 0);
            background-color:rgb(125, 219, 228) ;
            width:auto;
            padding: 4px;
            border: 5px solid rgb(73, 152, 158);
            border-radius: 10px;
        }
        body {
            background-image: url("https://us.123rf.com/450wm/katyau/katyau1507/katyau150700120/42585738-mer-vagues-motif-seamless-vague-de-fond-textile-design-de-papier-peint-motifs-de-remplissage-page-we.jpg?ver=6");
        }
        div {
            background-color:rgb(125, 219, 228) ;
            width:auto;
            border: 10px solid rgb(73, 152, 158);
            padding: 20px;
            margin-top: 30px;
            margin-left:auto;
            margin-right: auto;
            border-radius: 12px;
        }
        td {
            font-family: Georgia, 'Times New Roman', Times, serif;
            font-size:larger;
        }
    </style>
</head>
<body>

    <div>
        <table rules="all">
            <tr>
                <td>Airplane #: </td>
                <td>Leave for City: </td>
                <td>Leave week day: </td>
                <td>Leave time: </td>
                <td>Leave road: </td>
                <td>Back week day: </td>
                <td>Back time: </td>
                <td>Back road: </td>
            </tr>
            <c:forEach var="response" items="${responseSchedules}">
            <tr>
                <td>${response.airplane}</td>
                <td>${response.leaveCity}</td>
                <td>${response.weekLeaveDay}</td>
                <td>${response.leaveTime}</td>
                <td>${response.leaveRoad}</td>
                <td>${response.backDay}</td>
                <td>${response.backTime}</td>
                <td>${response.backRoad}</td>
            </tr>
            </c:forEach>
        </table>

    </div>

</body>
</html>