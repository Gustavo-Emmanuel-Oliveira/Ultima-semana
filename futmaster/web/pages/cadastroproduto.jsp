<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FuteMaster</title>
        <link rel="stylesheet" href="styles/logn.css">
    </head>

    <body>
        
        
        <div class="page">
            <a href="./inicio"> <h2 id="text">FuteMaster</h2></a>
            <form method="POST" class="formLogin"  enctype="multipart/form-data" action="cadastrarProduto">
                <h1>Cadastrar Produto</h1>
                <p>Digite os dados do produto no campo abaixo.</p>
                <label for="nome">Nome</label>
                <input id="nome" name="nome" type="nome" placeholder="Digite o nome" required autofocus="true" />
                <label for="descricao">Descricao</label>
                <input id="descricao" name="descricao" type="text" placeholder="Digite a descricao" required autofocus="true" />
                <label for="preco">Preco</label>
                <input id="preco" name="preco" type="number" placeholder="Digite o preco" required autofocus="true" />
                <label for="imagem">Imagem</label>
                <input id="imagem" name="imagem" type="file" placeholder="Coloque a imagem" required autofocus="true" />
                
                <input type="hidden" name="teste" id="teste" value="2"/>
                <button type="submit" class="btn">Cadastrar Produto</button>
            </form>
        </div>
    </body>
</html>