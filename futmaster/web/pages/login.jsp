<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FuteMaster</title>
        <link rel="stylesheet" href="styles/logn.css">
    </head>

    <body>
        <div class="page">
            <form method="POST" class="formLogin" action="logar" enctype="multipart/form-data">
                <h1>Login</h1>
                <p>Entre com sua conta.</p>
                <label for="email">E-mail</label>
                <input type="email" name="email" placeholder="Digite seu e-mail" />
                <label for="password">Senha</label>
                <input type="password" name="senha" placeholder="Digite sua senha" />
                <input type="submit" value="Acessar" class="btn" />
                <p>Caso não tenha uma conta: <a href="./cadastrocontrole">Cadastrar</a></p>
            </form>
        </div>
    </body>
</html>