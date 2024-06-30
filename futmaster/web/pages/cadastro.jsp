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
            <form method="POST" class="formLogin" enctype="multipart/form-data" action="cadastrar">
                <h1>Cadastrar</h1>
                <p>Digite os seus dados de acesso no campo abaixo.</p>
                <label for="email">E-mail</label>
                <input name="email" type="email" placeholder="Digite seu e-mail" autofocus="true" />
                <label for="nome">Nome</label>
                <input name="nome" type="text" placeholder="Digite seu nome" autofocus="true" />
                <label for="telefone">Telefone</label>
                <input name="telefone" type="text" placeholder="Digite seu telefone" autofocus="true" />
                <label for="CPF">CPF</label>
                <input name="cpf" type="text" placeholder="Digite seu cpf" autofocus="true" />
                <label for="password">Senha</label>
                <input name="senha" type="password" placeholder="Digite sua senha" />
                <input type="submit" value="Cadastrar-se" class="btn" />
                <p>Caso já tenha uma conta: <a href="./logincontroler">Logar</a></p>
            </form>
        </div>
    </body>
</html>