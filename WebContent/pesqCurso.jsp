<%@ include file="cabecalho.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxpesqProfessor">
        <form name="pesqCurso" method="post">
            <h1>Pesquisar por Curso</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
            </section>
            <section class="boxdecadastros">
                <p>
                    <fieldset>
                        <legend>Busca</legend>
                        Nome:
                        <input type="text" id="nome" name="nome" size="30" required="required" data-search="search" data-name-field="fieldText">
                        <!--<input id="Pesquisa" class="botao" type="submit" value="Buscar">-->
                    </fieldset>
                </p>
            </section>
        </form>
        <section class="boxdecadastros">
            <form action="ServletCurso" method="post">
                <p><input id="pesqCurso" name="acaoCurso" class="botao" type="submit" value="Novo"></p>
            </form>
            <table id="tabelapesquisa">
                <thead>
                    <tr>
                        <td>Curso:</td>
                        <td>Ação</td>
                    </tr>
                </thead>
                <tbody data-search="search" data-painel>
                    <c:forEach items="${listaCursos}" var="curso">
                        <tr data-item>
                            <td name="${curso.nome}" data-field="fieldText"><a href="ServletCurso?id=${curso.id}&acaoCurso=ListId">${curso.nome}</a></td>
                            <td>
                              	<a href="ServletCurso?acaoCurso=Deletar&id=${curso.id}">Excluir</a>
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
        var search = new Search("search", [fieldText]);
    </script>
</body>
</html>
