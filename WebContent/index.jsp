<%@ include file="cabecalho.jsp" %>

	<div align="center" class="boxFormularioLogin">
		<img src="imagens/logomarca.png">
		<form name="form_login" action="ServletLogin" method="post">
			<span>Login</span>
			<p>
				<input class="login" id="login" name="login" type="text" maxlength="20">
			</p>
			<span>Senha</span>
			<P>
				<input class="login" id="login" name="senha" type="password" maxlength="20">
			</p>
			<input class="botao-enviar" type="submit" value="Entrar"
				name="btnLogin">
		</form>
	</div>

</body>
</html>