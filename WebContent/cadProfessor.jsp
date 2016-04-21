<%@ include file="cabecalho.jsp"%>
<section class="boxCadProfessor">
        <form name="cadProfessor" action="ServletProfessor" method="post">
            <h1>Cadastro de Professor</h1>
            <section id="voltarmenu">
                <a href="menu.jsp"><img title="Voltar ao menu" src="imagens/botaoMenu.png"></a>
                <a href="pesqProfessor.jsp"><img title="Voltar pesquisa Professor" src="imagens/botaoPesquisa.png"></a>
            </section>
            <section id="boxdecadastros">
                <p>
                    Código do Professor: <input type="text" id="codigo"
                                                name="codigo" size="40" required="required">
                </p>
                <p>
                    Nome:* <input type="text" id="nome" name="nome" size="40" required="required">
                </p>
                <p>
                    Sexo: <input type="radio" name="sexo" value="m">Masculino
                    <input type="radio" name="sexo" value="f">Feminino
                <p>
                    Data de nascimento: <input type="date" id="dataNascimento" name="dataNascimento"
                                               onBlur="return valData(this.value)">
                </p>
                <p>
                    Data de admissão:* <input id="dataAdmissao" type="date" name="dataAdmissao"
                                              required="required">
                </p>
                <p>
                    CPF:* <input id="cpf" type="text" name="cpf" maxlength="14"
                                 required="required">
                </p>
                <p>
                    Telefone: <input id="telefone" type="text" name="telefone"
                                     maxlength="15" onkeyup="mascaraTelefone( this, mtel );">
                </p>
                <p>
                    E-mail: <input id="email" name="email" type="email" size="40">
                </p>
                
                <input id="Salvar" class="botao" name="acaoProfessor" type="submit" onclick="perguntaSalvar()" value="Salvar">
                <input id="Limpar" class="botao" type="reset" value="Limpar">
            </section>
        </form>
    </section>
</body>
</html>
