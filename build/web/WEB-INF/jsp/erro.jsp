<%-- 
    Document   : erro
    Created on : 05/09/2018, 00:51:01
    Author     : pein2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Web Auto Escola</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Actor" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Saira+Condensed" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=ABeeZee" rel="stylesheet">  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  
        <link href="https://fonts.googleapis.com/css?family=Barlow+Condensed" rel="stylesheet">
    </head>
    <style>

        body {
            background-color: #eeeeee;
        }

        body {margin:0;}

        .topnav {
            overflow: hidden;
            background-color: #3897f0;
            border-style: solid;
            border-bottom-width: 5px;
            border-top-width: 0;
            border-right-width: 0;
            border-left-width: 0; 
            border-color: #3897f0; 
        }

        .topnav a {
            float: left;
            display: block;
            color: #666;
            font-family: 'Barlow Condensed', sans-serif;
            font-weight: bold;
            font-size: 15px;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;

        }

        .topnav a:hover {
            background-color: #13a89e0a;
            color: black;
        }

        .active {
            background-color: #13a89e0a;
            font-color: white;
            font-size: 18px;
        }

        .topnav .icon {
            display: none;
        }

        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child) {display: none;}
            .topnav a.icon {
                float: right;
                display: block;
            }
        }

        @media screen and (max-width: 600px) {
            .topnav.responsive {position: relative;}
            .topnav.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .topnav.responsive a {
                float: none;
                display: block;
                text-align: left;
            }

        }
    </style>
    <body>

        <div class="topnav" id="myTopnav">
        </div>

        <div class="container text-center" style="margin-top:2%;">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div style="font-family: 'Pacifico', cursive; font-size: 35px; color: #000000; padding: 5px 5px 5px 5px;">
                        WEB Auto Escola
                    </div>    
                    <div style="font-size: 12px; padding-bottom: 5px; padding-top: 5px; ">
                        O seu portal WEB para agendamento de Aulas na Auto Escola!
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container" style="margin-top:5%; margin-bottom: 30%;">
            <div class="row">
                <div class="col-md-12">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">

                        Faça <a href="index">login</a> para continuar ...

                    </div>
                </div>
            </div>
        </div>

        </br></br>

        <footer class="footer" style="font-family: Gill Sans W04, GillSans, Gill Sans, Gill Sans MT, Calibri, Trebuchet MS, sans-serif; 
                background-color: #ffffff; 
                color: #000000; 
                padding-top: 15px; 
                padding-bottom: 15px;
                border-style: solid;
                border-bottom-width: 0;
                border-top-width: 3px;
                border-right-width: 0;
                border-left-width: 0; 
                border-color: #3897f0;">
            <div class="container text-center" style="padding-top: 0px;">
                <div class="col-md-12">
                    <div style="font-size: 12px;color: #39414b;">COPYRIGHT © 2018 - WEB Auto Escola | TODOS OS DIREITOS RESERVADOS.</div>
                </div>
            </div>
        </footer>

    </body>
</html>

