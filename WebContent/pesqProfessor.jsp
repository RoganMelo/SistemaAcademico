<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxpesqProfessor">
        <form name="pesqProfessor" method="post">
            <h1>Pesquisar por Professor</h1>
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
            <form id="form" action="ServletProfessor" method="post">
                <p><input id="acao" name="acaoProfessor" class="botao" type="submit" value="Novo"></p>
                <p><input id="item" hidden="hidden" name="identificador" class="botao" type="text" value=""></p>
            </form>
            <table id="tabelapesquisa">
                <thead>
                    <tr>
                        <td>Nome:</td>
                        <td>CPF:</td>
                        <td>E-mail:</td>
                        <td>Ações</td>
                    </tr>
                </thead>
                <tbody data-search="search" data-painel>
                    <c:forEach items="${listaProfessores}" var="professor">
                        <tr data-item>
                            <td name="${professor.nome}" data-field="fieldText"><a href="ServletProfessor?id=${professor.id}&acaoProfessor=ListIdAlterar">${professor.nome}</a></td>
                            <td>${professor.cpf}</td>
                            <td>${professor.email}</td>
                            <td>
								<a href="ServletProfessor?acaoProfessor=Deletar&id=${professor.id}">Excluir</a>
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
