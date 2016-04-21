<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="boxCadAluno">
	<form name="" action="ServletCurso" method="post">
		<h1>Edição de Curso</h1>
		<section id="voltarmenu">
			<a href="menu.jsp"><img title="Voltar ao menu"
				src="imagens/botaoMenu.png"></a> <a href="pesqAluno.jsp"><img
				title="Voltar curso" src="imagens/botaoPesquisa.png"></a>
		</section>
		<section id="boxdecadastros">
			<b>Dados Pessoais</b>
			<p>
				Id:* <input id="id" name="id" readonly="readonly" required="required"
					value="${curso.id}">
			</p>
			<p>
				Nome:* <input id="nome" name="nome" required="required"
					value="${curso.nome} ">
			</p>
			
			<p>* campos obrigatórios.</p>
			<input class="botao" type="submit" name="acaoCurso"
				onclick="perguntaSalvar()" value="Alterar"> <input
				class="botao" type="reset" onclick="perguntaLimpar()" value="Limpar">
		</section>
	</form>
</section>
<script src="jquery-1.8.2.min.js" ></script>
<script>
	$(function(){
	});	
</script>
</body>
</html>
