<!DOCTYPE html>
<html>
<head>
    <title>Add Student To directory</title>
    <meta content="UTF-8"/>

    <style>
        h3 {
            text-align: center;
        }
        a {
            font-family: Georgia, 'Times New Roman', Times, serif;
            color: rgb(0, 0, 0);
            text-align: end;
        }
        div {
            background-color:rgb(2, 143, 156) ;
            width: 300px;
            border: 10px solid rgb(2, 98, 105);
            padding: 50px;
            padding-top: 20px;
            margin: 20px;
            margin: auto;
            border-radius: 12px;
        }
        body{
            background-image: url("https://us.123rf.com/450wm/katyau/katyau1507/katyau150700120/42585738-mer-vagues-motif-seamless-vague-de-fond-textile-design-de-papier-peint-motifs-de-remplissage-page-we.jpg?ver=6");
        }
        td {
            font-family: Georgia, 'Times New Roman', Times, serif;
        }
    </style>

</head>
<body>
<div>
    <h3>Create schedule for airplanes</h3>
    <form id="form1" action="createSchedule" method="post">
        <table>
            <tr>
                <td>Number of airplanes</td>
                <td><input name="numOfAirplanes" type="text"/></td>
            </tr>
            <tr>
                <td>Number of Areas</td>
                <td><input name="numOfAreas" type="text"/></td>
            </tr>
            <tr>
                <td>Number Of cities</td>
                <td><input name="numOfCities" type="text"/></td>
            </tr>
            <tr>
                <td>Cities name and hour list</td>
                <td><textarea name="list" type="text"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>