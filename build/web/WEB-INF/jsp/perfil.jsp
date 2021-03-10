<%-- 
    Document   : perfil
    Created on : 06/09/2018, 00:26:49
    Author     : pein2
--%>

<%@page import="br.edu.unifeg.autoescola.entidade.Agendamento"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.unifeg.autoescola.modelo.agendamentoDAO"%>
<%@page import="br.edu.unifeg.autoescola.entidade.Pessoa"%>
<%@page import="br.edu.unifeg.autoescola.modelo.pessoaDAO"%>
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    </head>

    <style>
        body {
            background-color: #eeeeee;
        }

        body {margin:0;}

        .topnav {
            overflow: hidden;
            background-color: #ffffff;
            border-style: solid;
            border-bottom-width: 3px;
            border-top-width: 0;
            border-right-width: 0;
            border-left-width: 0;
            border-color: #3897f0;
        }

        .topnav a {
            float: left;
            display: block;
            color: #666;
            font-weight: bold;
            font-family: 'Barlow Condensed', sans-serif;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 15px;
        }

        .active {
            background-color: #337ab712;
            color: #666;
            font-size: 18px;
        }

        .topnav .icon {
            display: none;
        }

        .dropdown-sB {
            float: left;
            overflow: hidden;
        }

        .dropdown-sB .dropbtn {
            font-size: 15px;    
            border: none;
            outline: none;
            color: #666;
            font-weight: bold;
            font-family: 'Barlow Condensed', sans-serif;    padding: 14px 16px;
            background-color: inherit;
            margin: 0;
        }

        .dropdown-content-sB {
            display: none;
            position: absolute;
            background-color: #ffffff;
            min-width: 160px;
            z-index: 20;
            border-style: solid;
            border-bottom-width: 3px;
            border-top-width: 0;
            border-right-width: 0;
            border-left-width: 0;
            border-color: #337ab7;
        }

        .dropdown-content-sB a {
            float: none;
            color: #666;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;

        }

        .topnav a:hover, .dropdown-sB:hover .dropbtn {
            background-color: #337ab712;
            color: #666;
        }

        .dropdown-content-sB a:hover {
            background-color: #337ab712;
            color: #666;
        }

        .dropdown-sB:hover .dropdown-content-sB {
            display: block;
        }

        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child), .dropdown-sB .dropbtn {
                display: none;
            }
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
            .topnav.responsive .dropdown-sB {float: none;}
            .topnav.responsive .dropdown-content-sB {position: relative;}
            .topnav.responsive .dropdown-sB .dropbtn {
                display: block;
                width: 100%;
                text-align: left;
            }
        }
    </style>
    <body>
        <%
            pessoaDAO pes = new pessoaDAO();
            Pessoa p = pes.dadosPessoa("" + session.getAttribute("pessoaLogin"));
        %> 

        <div class="topnav" id="myTopnav">
            <a href="/WebAutoEscolaSpring/perfil" class="active">Web Auto Escola </i></a>
            <a href="/WebAutoEscolaSpring/perfil"><i class="fa fa-user" aria-hidden="true"></i> Perfil</a>
            <a href="/WebAutoEscolaSpring/cadastrarAgendamento"><i class="fas fa-hand-holding-usd"></i> Cadastrar Agendamento</a>

            <% if ((p.getTipoconta().equalsIgnoreCase("I"))) { %>
            <a href="/WebAutoEscolaSpring/avaliarAgendamento"><i class="fas fa-crosshairs"></i> Avaliar Agendamento</a> 
            <a href="/WebAutoEscolaSpring/cadastrarPessoa"><i class="fas fa-crosshairs"></i> Cadastrar Pessoa</a> 
            <a href="/WebAutoEscolaSpring/cadastrarCarro"><i class="fas fa-crosshairs"></i> Cadastrar Carro</a> 
            <% }%>
            <a href="/WebAutoEscolaSpring/"><i class="fa fa-power-off" aria-hidden="true"></i> Sair</a>
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

        <div class="container" style="margin-top:3%; margin-bottom: 5%;">
            <div class="row">
                <div class="col-md-8">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <div class="row">
                            <div class="col-md-3" align="center">
                                <img src="<%=p.getImagem()%>"class="img-circle" alt="<%=p.getNome()%>" width="136" height="136"> 
                            </div>
                            <div class="col-md-9">
                                <h1>Bem Vindo, <%=p.getNome()%>!</h1>
                                <p>Esta é sua página de perfil, aqui você encontra todo seu histórico de aulas marcadas
                                    e informações adicionais sobre a Autoescola.</p>
                                </br>  
                            </div>                         
                        </div>                         
                    </div>                         
                </div>     
                <div class="col-md-4">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        Links Úteis:<br>
                        <br>
                        - <a href="https://www.detran.mg.gov.br/" target="_blank">Detran MG</a><br>
                        - <a href="https://www.detran.mg.gov.br/habilitacao/1-habilitacao-quero-ser-condutor" target="_blank">1º Habilitação</a><br>
                        - <a href="https://www.detran.mg.gov.br/habilitacao/cnh-e-permissao-para-dirigir/solicitar-cnh-definitiva" target="_blank">CNH e Permissão para dirigir</a><br>
                        - <a href="https://www.detran.mg.gov.br/habilitacao/cnh-e-permissao-para-dirigir/consulta-pontuacao" target="_blank">Consultar Pontuação</a><br>
                        - <a href="https://www.detran.mg.gov.br/habilitacao/cnh-e-permissao-para-dirigir/solicitar-renovacao-da-cnh" target="_blank">Renovação de CNH</a><br>
                    </div>
                </div>
                <div class="col-md-12">
                    <center>
                        <h3>AULAS AGENDADAS</h3>
                    </center>
                    <br>
                </div>
                <div class="col-md-12">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Data Aula</th>
                                    <th scope="col">Situação</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>                        

                                <%
                                    agendamentoDAO dao = new agendamentoDAO();

                                    if ((p.getTipoconta().equalsIgnoreCase("A"))) {
                                        List<Agendamento> meusAgendamentos = dao.meusAgendamentos("" + p.getCpf(), 1);

                                        for (Agendamento ag : meusAgendamentos) {
                                %>   
                            <form action="submitSituacaoAluno" method="POST">
                                <tr>
                                <input type="hidden" id="id" name="id" class="form-control" readonly="readonly" value="<%=ag.getId()%>">
                                <td><input type="text" class="form-control" readonly="readonly" value="<%=ag.getData()%>"></td>
                                <td>
                                    <select class="form-control" name="situacao">   
                                        <option><%=ag.getSituacao()%></option>
                                        <% if (ag.getSituacao().equals("Aguardando")) {%>
                                        <option>Cancelada</option>
                                        <% } %>
                                    </select>  
                                </td>
                                <td align="center">
                                    <% if (ag.getSituacao().equals("Aguardando")) {%>
                                    <button type="submit" name="submit" class="btn btn-success" value="Cadastrar">Alterar Situação</button>
                                    <% } else { %>
                                    -
                                    <% } %>
                                </td>
                                </tr>
                            </form>
                            <% }
                            } else {
                                List<Agendamento> meusAgendamentos = dao.meusAgendamentos("" + p.getCpf(), 2);
                                for (Agendamento ag : meusAgendamentos) {
                            %>
                            <form action="submitSituacaoAluno" method="POST">
                                <tr>
                                <input type="hidden" id="id" name="id" class="form-control" readonly="readonly" value="<%=ag.getId()%>">
                                <td><input type="text" class="form-control" readonly="readonly" value="<%=ag.getData()%>"></td>
                                <td>
                                    <select class="form-control" name="situacao">   
                                        <option>Concluida</option>
                                    </select>  
                                </td>
                                <td align="center">
                                    <button type="submit" name="submit" class="btn btn-success" value="Cadastrar">Alterar Situação</button>
                                </td>
                                </tr>
                            </form>                                               
                            <% }
                                }%>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <center>
                            <i class="fas fa-user fa-7x"></i>
                            <br><br>
                            <div style="font-size: 11px;">TIPO CONTA:</div>
                            <div style="font-size: 16px;"><b>
                                    <%
                                        if (p.getTipoconta().equalsIgnoreCase("I")) {
                                            out.print("INSTRUTOR");

                                        } else {
                                            out.print("ALUNO");
                                        }
                                    %></b></div>
                        </center>
                    </div>   
                </div>  
                <div class="col-md-3">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <center>
                            <i class="far fa-clock fa-7x"></i>
                            <br><br>
                            <div style="font-size: 11px;">AULAS CONFIRMADAS:</div>
                            <div style="font-size: 16px; color: navy;"><b><%=dao.somaAulasAguardando(p.getCpf(), p.getTipoconta())%></b></div>
                        </center>
                    </div>   
                </div> 
                <div class="col-md-3">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <center>
                            <i class="far fa-check-circle fa-7x"></i>
                            <br><br>
                            <div style="font-size: 11px;">AULAS CONCLUÍDAS:</div>
                            <div style="font-size: 16px; color: green;"><b><%=dao.somaAulasConfirmadas(p.getCpf(), p.getTipoconta())%></b></div>
                        </center>
                    </div>   
                </div>  
                <div class="col-md-3">
                    <div class="well" style="background: #FFFFFF; border-radius: 0px;">
                        <center>
                            <i class="fas fa-ban fa-7x"></i>
                            <br><br>
                            <div style="font-size: 11px;">AULAS CANCELADAS:</div>
                            <div style="font-size: 16px; color: red;"><b><%=dao.somaAulasCanceladas(p.getCpf(), p.getTipoconta())%></b></div>
                        </center>
                    </div>   
                </div>                         
            </div> 
        </div>


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

