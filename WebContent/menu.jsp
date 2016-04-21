<%@ include file="cabecalho.jsp" %>

	<div class="boxMenu">
        <h2>Sistema de Controle Acadêmico</h2>

        <nav>
            <ul>
                <li>
                    <a href="ServletAluno?acaoAluno=ListaDeAlunos">
                        <img src="imagens/iconeAluno.png">
                        Alunos
                    </a>
                </li>
                <li>
                    <a href="ServletDisciplina?acaoDisciplina=ListaDeDisciplinas">
                        <img src="imagens/iconeDisciplina1.png">
                        Disciplinas
                    </a>
                </li>
                <li>
                    <a href="ServletProfessor?acaoProfessor=ListaDeProfessores">
                        <img src="imagens/iconeProfessor.png">
                        Professores
                    </a>
                </li>
                <li>
                    <a href="ServletCurso?acaoCurso=ListaDeCursos">
                        <img src="imagens/iconeCurso.png">
                        Cursos
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</body>
</html>