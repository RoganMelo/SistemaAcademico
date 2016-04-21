<%@ include file="cabecalho.jsp" %>
<section class="boxCadCurso">
        <form name="cadAluno" action="ServletCurso" method="post">
            <h1>Cadastro de Curso</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
                <a href="pesqCurso.jsp"><img title="Voltar pesquisa Curso" src="imagens/botaoPesquisa.png"></a>
            </section>
            <section id="boxdecadastros">
            	<p>
                    Identificador:
                    <input id="id" name="id" size="40" required="required"> *
                </p>
                <p>
                    Nome do Curso:
                    <input id="nome" name="nome" size="40" required="required"> *
                </p>
                <p>* campos obrigatórios.</p>
                <input class="botao" name="acaoCurso" type="submit" onclick="perguntaSalvar()" value="Salvar">
                <input class="botao" type="reset" onclick="perguntaLimpar()" value="Limpar">
            </section>
        </form>
    </section>
</body>
</html>
