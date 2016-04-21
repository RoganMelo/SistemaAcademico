<%@ include file="cabecalho.jsp"%>
<section class="boxCadProfessor">
	<form name="cadProfessor" action="ServletProfessor" method="post">
		<h1>Edição de Professor</h1>
		<section id="voltarmenu">
			<a href="menu.jsp"><img title="Voltar ao menu"
				src="imagens/botaoMenu.png"></a> <a href="pesqProfessor.jsp"><img
				title="Voltar pesquisa Professor" src="imagens/botaoPesquisa.png"></a>
		</section>
		<section id="boxdecadastros">
			<p>
				Código do Professor: <input type="text" id="codigo" name="codigo"
					size="40" value="${professor.id}" readonly="readonly"
					required="required">
			</p>
			<p>
				Nome:* <input type="text" id="nome" name="nome" size="40"
					value="${professor.nome}" required="required">
			</p>
			<p>
				Sexo: <input  type="radio" name="sexo" id="sexoM" value="m" />Masculino
                    <input  type="radio" name="sexo" id="sexoF" value="f" />Feminino
                    <input hidden id="valueSexo" value="${professor.sexo}"/>
			</p>
			<p>
				Data de nascimento: <input id="dataNascimento" name="dataNascimento"
					type="text" value="${professor.dataNasc}">
			</p>
			
			<p>
				CPF:* <input id="cpf" type="text" name="cpf" maxlength="14"
					value="${professor.cpf}" required="required">
			</p>
			<p>
				Telefone: <input id="telefone" type="text" name="telefone"
					value="${professor.telefone}" maxlength="15"
					onkeyup="mascaraTelefone( this, mtel );">
			</p>
			<p>
				E-mail: <input id="email" name="email" type="email"
					value="${professor.email}" size="40">
			</p>

			<input id="Salvar" class="botao" name="acaoProfessor" type="submit"
				onclick="perguntaSalvar()" value="Alterar"> <input
				id="Limpar" class="botao" type="reset" value="Limpar">
		</section>
	</form>
</section>
<script src="jquery-1.8.2.min.js" ></script>
<script>
$(function(){
	var valueSexo = $("#valueSexo").val();
	if(valueSexo == "m"){
		$("#sexoM").attr("checked","checked");
	}else{
		$("#sexoF").attr("checked","checked");
	}
});
</script>
</body>
</html>