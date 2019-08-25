<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 25/08/2019
  Time: 08:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Confirmação de reserva</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>

<body>
<nav class="orange lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/" class="brand-logo">USPortivo</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#">Login</a></li>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Login</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>

<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <h3 id="local_res" class="left-align light-blue-text"></h3>
        </div>
    </div>
    <table>
        <thead>
        <tr>
            <th>Horários</th>
            <th>Status</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>10:00-12:00</td>
            <td>Livre</td>
        </tr>
        <tr>
            <td class="yellow">12:00-14:00</td>
            <td >Possui reservas em análise</td>
        </tr>
        <tr>
            <td class="grey">14:00-16:00</td>
            <td>Indisponível</td>
        </tr>
        </tbody>
    </table>
    <div class="row">
        <div class="row"></div>
        <div class="divider"></div>
        <form action="#" class="col s12">
            <div class="row">
                <div class="input-field col s12">
                    <textarea id="textarea1" class="materialize-textarea"></textarea>
                    <label for="textarea1">Justificativa</label>
                </div>
            </div>
            <div class="row">
                <div class=" input-field col s6">
                    <input placeholder="Nome" id="first_name" type="text" class="validate">
                    <label for="first_name">Nome</label>
                </div>
                <div class="input-field col s6">
                    <input placeholder="Nome da entidade" id="nome_entidade1" type="text" class="">
                    <label for="nome_entidade3">Entidade</label>
                </div>
            </div>
            <div class="row" id="primeessaporra">
                <div class="input-field col s6 m6">
                    <input placeholder="Email para contato" id="imeiu" type="text" class="validate email">
                    <label id="email">Email</label>
                    <span class="darken-4 red-text">(A confirmação de reserva da quadra será enviada por esse Email)</span>
                </div>
            </div>
            <div class="row">
                <button class="pull-s7 btn waves-effect waves-light"   onclick="aviso()">Submeter
                    <i class="material-icons right">send</i>
                </button>
            </div>
    </div>
    </form>
</div>
</div>
</body>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script>M.AutoInit();</script>
<script>
    function aviso() {
        $.getJSON("fim/email-send/danielfilho@usp.br");
        alert("Sua solicitação de reserva será processada! ");
    }
</script>
</body>