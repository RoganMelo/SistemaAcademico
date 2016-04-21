package br.edu.flf.sistemaAcademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.sistemaAcademico.business.AlunoBusiness;
import br.edu.flf.sistemaAcademico.business.CursoBusiness;
import br.edu.flf.sistemaAcademico.objetos.Aluno;
import br.edu.flf.sistemaAcademico.objetos.Curso;

@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {

	private static final long serialVersionUID = -2799558720753243009L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoAluno = request.getParameter("acaoAluno");
		AlunoBusiness alunoBusiness = (AlunoBusiness) request.getServletContext().getAttribute("AlunoBusiness");
		Aluno aluno = new Aluno();
		request.setAttribute("listaAlunos", alunoBusiness.listar());
		CursoBusiness cursoBusiness = (CursoBusiness) request.getServletContext().getAttribute("CursoBusiness");
		Curso curso = new Curso();
		request.setAttribute("listaCursos", cursoBusiness.listar());
		System.out.println(acaoAluno);
		
		switch (acaoAluno) {
		case "Novo":
			request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
			break;

		case "ListaDeAlunos":
			System.out.println("lista cursos");
			request.getRequestDispatcher("pesqAluno.jsp").forward(request, response);
			break;

		case "Salvar":
			curso = cursoBusiness.getById(Integer.parseInt(request.getParameter("curso")));
			aluno.setNome(request.getParameter("nome"));
			aluno.setId(Integer.parseInt(request.getParameter("id")));
			aluno.setCurso(curso);
			aluno.setDataNasc(request.getParameter("dataNascimento"));
			aluno.setEmail(request.getParameter("email"));
			aluno.setCpf(request.getParameter("cpf"));
			aluno.setSexo(request.getParameter("sexo").charAt(0));
			aluno.setTelefone(request.getParameter("telefone"));
			aluno.setEndereco(request.getParameter("endereco"));
			alunoBusiness.cadastrar(aluno);
			request.getRequestDispatcher("pesqAluno.jsp").forward(request, response);
			break;

		case "ListIdAlterar":
			Aluno a = alunoBusiness.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("aluno", a);
			request.getRequestDispatcher("altAluno.jsp").forward(request, response);
			break;
			
		case "Alterar":
			curso = cursoBusiness.getById(Integer.parseInt(request.getParameter("curso")));
			aluno = alunoBusiness.getById(Integer.parseInt(request.getParameter("id")));
			Aluno alunoAlterado = new Aluno();
			alunoAlterado.setNome(request.getParameter("nome"));
			alunoAlterado.setId(Integer.parseInt(request.getParameter("id")));
			alunoAlterado.setCurso(curso);
			alunoAlterado.setDataNasc(request.getParameter("dataNascimento"));
			alunoAlterado.setEmail(request.getParameter("email"));
			alunoAlterado.setCpf(request.getParameter("cpf"));
			alunoAlterado.setSexo(request.getParameter("sexo").charAt(0));
			alunoAlterado.setTelefone(request.getParameter("telefone"));
			alunoAlterado.setEndereco(request.getParameter("endereco"));
			alunoBusiness.alterar(aluno, alunoAlterado);
			request.getRequestDispatcher("pesqAluno.jsp").forward(request, response);
			break;

		case "Deletar":
			alunoBusiness.deletar(alunoBusiness.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("pesqCurso.jsp").forward(request, response);
			break;
		}
	}
}
