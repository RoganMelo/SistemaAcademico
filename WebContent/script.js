/* JavaScript do Sistema Controle Acadêmico */

/* Feito por João Paulo */
function perguntaLimpar() {
	if (confirm("Deseja Limpar os dados?")) {
		return true;
	} else {
		return false;
	}
}

/* Feito por João Paulo */
function perguntaSalvar() {
	if (confirm("Salvar os dados?")) {
		return true;
	} else {
		return false;
	}
}

function perguntaExcluir() {
	if (confirm("Deseja Excluir?")) {
		return true;
	} else {
		return false;
	}
}

/* Feito por Thiago Façanha */
function verificarCPF(c) {
	var i;
	s = c;
	var c = s.substr(0, 9);
	var dv = s.substr(9, 2);
	var d1 = 0;
	var v = false;

	for (i = 0; i < 9; i++) {
		d1 += c.charAt(i) * (10 - i);
	}
	if (d1 == 0) {
		alert("CPF Inválido")
		v = true;
		return false;
	}
	d1 = 11 - (d1 % 11);
	if (d1 > 9)
		d1 = 0;
	if (dv.charAt(0) != d1) {
		alert("CPF Inválido")
		v = true;
		return false;
	}

	d1 *= 2;
	for (i = 0; i < 9; i++) {
		d1 += c.charAt(i) * (11 - i);
	}
	d1 = 11 - (d1 % 11);
	if (d1 > 9)
		d1 = 0;
	if (dv.charAt(1) != d1) {
		alert("CPF Inválido")
		v = true;
		return false;
	}
	if (!v) {
		alert("CPF Válido")
	}
}

/* Feito por Thiago Façanha */
function verificarEmail() {
	if (document.forms[0].email.value == ""
			|| document.forms[0].email.value.indexOf('@') == -1
			|| document.forms[0].email.value.indexOf('.') == -1) {
		alert("Por favor, informe um e-mail v�lido!");
		return false;
	}
}

/* Feito por João Paulo */
function pergunta() {
	if (confirm("Deseja excluir essa matr�cula?")) {
		return true;
	} else {
		return false;
	}
}

/* Feito por Leonardo Couto */
function mascaraTelefone(campo) {

	function trata(valor, isOnBlur) {

		valor = valor.replace(/\D/g, "");
		valor = valor.replace(/^(\d{2})(\d)/g, "($1)$2");

		if (isOnBlur) {

			valor = valor.replace(/(\d)(\d{4})$/, "$1-$2");
		} else {

			valor = valor.replace(/(\d)(\d{3})$/, "$1-$2");
		}
		return valor;
	}
	campo.maxLength = 14;
}

/* Feito por Larissa Rebecca */
var CheckMaximo = 3;
function verificar() {
	var Marcados = 1;
	var objCheck = document.forms['disciplina'].elements['disciplinas'];

	// Percorrendo os checks para ver quantos foram selecionados:
	for (var iLoop = 0; iLoop < objCheck.length; iLoop++) {
		// Se o número máximo de checkboxes ainda não tiver sido atingido,
		// continua a verificação:
		if (Marcados <= CheckMaximo) {
			if (objCheck[iLoop].checked) {
				Marcados++;
			}
			// Habilitando todos os checkboxes, pois o máximo ainda não foi
			// alcançado.
			for (var i = 0; i < objCheck.length; i++) {
				objCheck[i].disabled = false;
			}
			// Caso contrário, desabilitar o checkbox;
		} else {
			for (var i = 0; i < objCheck.length; i++) {
				if (objCheck[i].checked == false) {
					objCheck[i].disabled = true;
				}

			}
		}
	}
}