<%-- 
    Document   : displayChart.jsp
    Created on : May 23, 2016, 6:05:41 PM
    Author     : Toshiba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
         <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        
        <style>
            #chartOfVotes{
                width:500px;
                length:200px;
            }
            </style>
<script>
    $(function () {
        
var votesForStrawberries = <%=request.getAttribute("straw")%>;
var votesForRaspberries = <%=request.getAttribute("rasp")%>;
var votesForBlueberries = <%=request.getAttribute("blue")%>;
var votesForLemons = <%=request.getAttribute("lemon")%>;
    $('#chartOfVotes').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '<u>Votes for the berries</u>'
        },
        subtitle: {
            text: ' <a href="http://www.github.com/hiresh">An app by <b>hiresh</b></a>'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: 0,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number of votes'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: 'Number of votes: <b>{point.y:.1f}</b>'
        },
        series: [{
            name: 'Population',
            data: [
                ['Strawberries',votesForStrawberries],
                ['Raspberries', votesForRaspberries],
                ['Blueberries', votesForBlueberries],
                ['Lemons', votesForLemons],
              
            ],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{point.y:.1f}', // one decimal
                y: 10, // 10 pixels down from the top
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }]
    });
});
    </script>
    </head>
    <body>
        <center><h1>Votes casted by all the users</h1></center>
        <br><hr><br>
    <center><div id="chartOfVotes"></div></center>
    </body>
</html>
