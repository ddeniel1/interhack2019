<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 24/08/2019
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>USPortivo</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/lib.js"></script>
<body>
<nav class="orange lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">USPortivo</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#">Login</a></li>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>
<div class="container">
    <h1 class="light-blue-text ">Reservas CEPE</h1>

        <form class="">
            <div class="row">
                <div class="col s12 m6 ">
                    <select onchange="checkFunction()" id = 'mod'>
                        <option value="" disabled selected>Escolha a modalidade</option>

                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col s12 m6">
                    <input  id="data" placeholder="Selecione a data" type="text" class="datepicker">
                    <Spam>Data</Spam>
                </div>
            </div>
            <div class="row">
                <h5 class="col">Espaços</h5>

            </div>
            <div class="row">
                <ul class="collapsible" id="lugar">
                    <li >
                     <div class="collapsible-header">
                            <i class="material-icons">place</i>
                            Quadra Poliesportiva 1
                        </div>
                        <div class="collapsible-body">
                            <p>
                                <label>
                                    <input type="checkbox" />
                                    <span>09:00 a 10:00</span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input type="checkbox" />
                                    <span>10:00 a 11:00</span>
                                </label>
                            </p>
                            <button class="btn waves-effect waves-light" type="submit" name="action">Finalizar Reserva
                                <i class="material-icons right">send</i>
                            </button>

                        </div>
                    </li>
                </ul>
            </div>
        </form>





</div>


<script src="js/materialize.js"></script>
<script src="js/lib.js"></script>
<script>
    $(document).ready(function(){
        $('.collapsible').collapsible();
    });

</script>
<script>
    M.AutoInit();
</script>

</body>
