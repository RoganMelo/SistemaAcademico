<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxCadAluno">
	<form name="cadAluno" action="ServletAluno" method="post">
		<h1>Edição de Aluno</h1>
		<section id="voltarmenu">
			<a href="menu.jsp"><img title="Voltar ao menu"
				src="imagens/botaoMenu.png"></a> <a href="pesqAluno.jsp"><img
				title="Voltar pesquisa Aluno" src="imagens/botaoPesquisa.png"></a>
		</section>
		<section id="boxdecadastros">
			<b>Dados Pessoais</b>
			<p>
				Matrícula:* <input id="id" name="id" readonly="readonly" required="required"
					value="${aluno.id}">
			</p>
			<p>
				Nome:* <input id="nome" name="nome" required="required"
					value="${aluno.nome} ">
			</p>
			<p>
				Curso: <select name="curso" id="curso">
					<option value="0" selected>Selecione</option>
					<c:forEach items="${listaCursos}" var="curso">
						<option value="${curso.id}">${curso.nome}</option>
					</c:forEach>
				</select>
				<input hidden name="idCurso" id="idCurso" value="${aluno.curso.id}"/>
			</p>
			<p>
				Data de nascimento: <input id="dataNascimento" name="dataNascimento"
					type="date" value="${aluno.dataNasc}">
			</p>
			<p>
				E-mail:* <input id="email" name="email" type="email"
					onblur="verificarEmail();" required="required"
					value="${aluno.email}" />
			</p>
			<p>
				CPF:* <input id="cpf" type="text" name="cpf" maxlength="11"
					onblur="return verificarCPF(this.value)" required="required"
					value="${aluno.cpf}" /> (informe apenas os números)
			</p>
			<p>
			                    Sexo: 
			                    <input  type="radio" name="sexo" id="sexoM" value="m" />Masculino
                    <input  type="radio" name="sexo" id="sexoF" value="f" />Feminino
                    <input hidden id="valueSexo" value="${aluno.sexo}"/>
			</p>
			<p>
				Telefone: <input id="telefone" type="text" name="telefone"
					maxlength="14" placeholder="(00) 00000-0000" value="${aluno.telefone}">
			</p>
			<p>
				Endereço: <input id="endereco" name="endereco" value="${aluno.endereco}">
			</p>

			<p>* campos obrigatórios.</p>
			<input class="botao" type="submit" name="acaoAluno"
				onclick="perguntaSalvar()" value="Alterar"> <input
				class="botao" type="reset" onclick="perguntaLimpar()" value="Limpar">
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
		
		var idCurso = $("#idCurso").val();
		var curso = $("#curso");
		curso.val(idCurso);
	});	
</script>
</body>
</html>
