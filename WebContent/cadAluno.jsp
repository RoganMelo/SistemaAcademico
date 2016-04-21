<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxCadAluno">
        <form name="cadAluno" action="ServletAluno" method="post">
            <h1>Cadastro de Aluno</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
                <a href="pesqAluno.jsp"><img title="Voltar pesquisa Aluno" src="imagens/botaoPesquisa.png"></a>
            </section>
            <section id="boxdecadastros">
                <b>Dados Pessoais</b>
                <p>
                    Matrícula:* <input id="id" name="id" required="required">
                </p>
                <p>
                    Nome:* <input id="nome" name="nome" required="required">
                </p>
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
                    Data de nascimento: <input id="dataNascimento" name="dataNascimento" type="date">
                </p>
                <p>
                    E-mail:* <input id="email" name="email" type="email" onblur="verificarEmail();" required="required" />
                </p>
                <p>
                    CPF:* <input id="cpf" type="text" name="cpf" maxlength="11"
                                   required="required" />
                                  <!-- <input id="cpf" type="text" name="cpf" maxlength="11"
                                  onblur="return verificarCPF(this.value)" required="required" /> -->
                    (informe apenas os números)
                </p>
                <p>
                    Sexo: <input id="sexo" type="radio" name="sexo" value="m"/>Masculino
                    <input id="sexo" type="radio" name="sexo" value="f" />Feminino
                </p>
                <p>
                    Telefone: <input id="telefone" type="text" name="telefone" maxlength="14" placeholder="(00) 00000-0000">
                </p>
                <p>
                    Endereço: <input id="endereco" name="endereco">
                </p>

                <p>* campos obrigatórios.</p>
                <input class="botao" type="submit" name="acaoAluno" onclick="perguntaSalvar()" value="Salvar"> 
                <input class="botao" type="reset" onclick="perguntaLimpar()" value="Limpar">
            </section>
        </form>
    </section>
</body>
</html>
