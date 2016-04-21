package br.edu.flf.sistemaAcademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.sistemaAcademico.business.CursoBusiness;
import br.edu.flf.sistemaAcademico.business.DisciplinaBusiness;
import br.edu.flf.sistemaAcademico.business.ProfessorBusiness;
import br.edu.flf.sistemaAcademico.objetos.Curso;
import br.edu.flf.sistemaAcademico.objetos.Disciplina;
import br.edu.flf.sistemaAcademico.objetos.Professor;

/**
 * Servlet implementation class ServletDisciplina
 */
@WebServlet("/ServletDisciplina")
public class ServletDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String selecionarCurso = request.getParameter("selecionarCurso");
		//String disciplinaNome = request.getParameter("disciplinaNome");
		//String qtdVagas = request.getParameter("qtdVagas");
		
		String acaoDisciplina = request.getParameter("acaoDisciplina");
		
		DisciplinaBusiness disciplinaBusiness = (DisciplinaBusiness)request.getServletContext().getAttribute("DisciplinaBusiness");
		Disciplina disciplina = new Disciplina();
		
		CursoBusiness cursoBusiness = (CursoBusiness)request.getServletContext().getAttribute("CursoBusiness");
		Curso curso = new Curso();
		
		ProfessorBusiness professorBusiness = (ProfessorBusiness)request.getServletContext().getAttribute("ProfessorBusiness");
		Professor professor = new Professor();
		
		request.setAttribute("listaDisciplinas", disciplinaBusiness.listar());
		request.setAttribute("listaCursos", cursoBusiness.listar());
		request.setAttribute("listaProfessores", professorBusiness.listar());
		
		switch (acaoDisciplina) {
		
		case "Novo":
			request.getRequestDispatcher("cadDisciplina.jsp").forward(request, response);
			break;
		
		case "ListaDeDisciplinas":
		
			System.out.println("lista usuario");
			request.getRequestDispatcher("pesqDisciplina.jsp").forward(request, response);
			break;
		
		case "Salvar":
			curso = cursoBusiness.getById(Integer.parseInt(request.getParameter("curso")));
			professor = professorBusiness.getById(Integer.parseInt(request.getParameter("professor")));
			
			disciplina.setId(Integer.parseInt(request.getParameter("id")));
			disciplina.setNome(request.getParameter("nome"));
			disciplina.setCurso(curso);
			disciplina.setProfessor(professor);
			
			disciplinaBusiness.cadastrar(disciplina);
			request.getRequestDispatcher("pesqDisciplina.jsp").forward(request, response);
				
			break;
				
		case "ListIdAlterar":
			Disciplina disciplinaAlterada = disciplinaBusiness.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("disciplina", disciplinaAlterada);
			request.getRequestDispatcher("altDisciplina.jsp").forward(request, response);
			break;
			
		case "Alterar":
			professor = professorBusiness.getById(Integer.parseInt(request.getParameter("professor")));
			curso = cursoBusiness.getById(Integer.parseInt(request.getParameter("curso")));
			disciplina = disciplinaBusiness.getById(Integer.parseInt(request.getParameter("id")));
			
			Disciplina disciplinaAlterado = new Disciplina();
			disciplinaAlterado.setId(Integer.parseInt(request.getParameter("id")));
			disciplinaAlterado.setNome(request.getParameter("nome"));
			disciplinaAlterado.setCurso(curso);
			disciplinaAlterado.setProfessor(professor);		
			
			disciplinaBusiness.alterar(disciplina, disciplinaAlterado);
			request.getRequestDispatcher("pesqDisciplina.jsp").forward(request, response);;
			break;
		
		case "Deletar":
			disciplinaBusiness.deletar(disciplinaBusiness.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("pesqDisciplina.jsp").forward(request, response);
			break;
		}	
		
	}

}
