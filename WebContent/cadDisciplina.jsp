<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxCadProfessor">
        <form name="cadmatricula" action="ServletDisciplina" method="post">
            <h1>Cadastro de Disciplina</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
            </section>
            <section id="boxdecadastros">
                <p>Identificador: <input type="text" name="id" size="37" required></p>
                <p>
                    Curso:
                    <select name="curso" id="curso">
                        <option value="0" selected>Selecione</option>
                        <c:forEach items="${listaCursos}" var="curso">
                            <option value="${curso.id}">${curso.nome}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    Professor:
                    <select name="professor" id="professor">
                        <option value="0" selected>Selecione</option>
                        <c:forEach items="${listaProfessores}" var="professor">
                            <option value="${professor.id}">${professor.nome}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>Nome da disciplina: <input type="text" name="nome" size="37" required></p>
                <input class="botao" type="submit" name="acaoDisciplina" onclick="perguntaSalvar()" value="Salvar">
                <input class="botao" type="reset" value="Limpar">
            </section>
        </form>
    </section>
</body>
</html>