<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxCadProfessor">
        <form name="cadmatricula" action="ServletDisciplina" method="post">
            <h1>Edição de Disciplina</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
            </section>
            <section id="boxdecadastros">
                <p>Identificador: <input type="text" name="id" size="37" readonly="readonly" value="${disciplina.id}" required></p>
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
                <p>Nome da disciplina: <input type="text" name="nome" size="37" value="${disciplina.nome}" required></p>
                <input class="botao" type="submit" name="acaoDisciplina" onclick="perguntaSalvar()" value="Alterar">
                <input class="botao" type="reset" value="Limpar">
            </section>
        </form>
    </section>
    <script src="jquery-1.8.2.min.js" ></script>
    <script>
    	var curso = $("#curso");
    	curso.val('${disciplina.curso.id}');
    	
    	var professor = $("#professor");
    	professor.val('${disciplina.professor.id}');
    </script>
</body>
</html>