<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxPesqAluno">
        <form name="pesqAluno" method="post">
            <h1>Pesquisar Alunos</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
            </section>
            <section class="boxdecadastros">
                <p>
                    <fieldset>
                        <legend>Busca</legend>
                        Matrícula:
                        <input type="text" id="id" name="id" size="2" data-search="search" data-name-field="fieldText2">
                        Nome do Aluno:
                        <input type="text" id="nome" name="nome" size="17" data-search="search" data-name-field="fieldText">
                        <!--<input id="Pesquisa" class="botao" type="submit" value="Buscar">-->
                    </fieldset>
                </p>
            </section>
        </form>
        <section class="boxdecadastros">
            <form action="ServletAluno" method="post">
                <p><input id="pesqAluno" name="acaoAluno" class="botao" type="submit" value="Novo"></p>
            </form>
            <table id="tabelapesquisa">
                <thead>
                    <tr>
                        <td>Matrícula:</td>
                        <td>Nome:</td>
                        <td>Ações:</td>
                    </tr>
                </thead>
                <tbody data-search="search" data-painel>
                    <c:forEach items="${listaAlunos}" var="aluno">
                        <tr data-item>
                            <td name="${aluno.id}" data-field="fieldText2">${aluno.id}</td>
                            <td name="${aluno.nome}" data-field="fieldText"><a href="ServletAluno?id=${aluno.id}&acaoAluno=ListIdAlterar">${aluno.nome}</a></td>
                            <td>
                                <a href="ServletAluno?acaoAluno=Deletar&id=${aluno.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </section>
    <script src="jquery-1.8.2.min.js"></script>
    <script src="jquery.arrayUtilities.js"></script>
    <script src="busca.js"></script>
    <script>
        var fieldText = new Field("fieldText", "text");
        var fieldText2 = new Field("fieldText2", "text");
        var search = new Search("search", [fieldText, fieldText2]);
    </script>
</body>
</html>
