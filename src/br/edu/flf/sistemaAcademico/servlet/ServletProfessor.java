package br.edu.flf.sistemaAcademico.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.sistemaAcademico.business.ProfessorBusiness;
import br.edu.flf.sistemaAcademico.objetos.Aluno;
import br.edu.flf.sistemaAcademico.objetos.Professor;

/**
 * Servlet implementation class ServletProfessor
 */
@WebServlet({ "/ServletProfessor", "/ServletProfessor.do" })
public class ServletProfessor extends HttpServlet {

	private static final long serialVersionUID = -869695312068198632L;

	
	public ServletProfessor(){
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String acaoProfessor = request.getParameter("acaoProfessor");
		
		ProfessorBusiness professorBusiness = (ProfessorBusiness)request.getServletContext().getAttribute("ProfessorBusiness");
		Professor professor = new Professor();
		request.setAttribute("listaProfessores", professorBusiness.listar());
		
		System.out.println(acaoProfessor);
		
		switch (acaoProfessor) {
		
		case "Novo":
			response.sendRedirect("cadProfessor.jsp");
			break;
		
		case "ListaDeProfessores":
		
			System.out.println("lista usuario");
			request.getRequestDispatcher("pesqProfessor.jsp").forward(request, response);
			break;
		
		case "Salvar":
						
			professor.setNome(request.getParameter("nome"));
			professor.setSexo(request.getParameter("sexo").charAt(0));
			professor.setDataNasc(request.getParameter("dataNascimento"));
			professor.setDataAdm(request.getParameter("dataAdmissao"));
			professor.setCpf(request.getParameter("cpf"));
			professor.setTelefone(request.getParameter("telefone"));
			professor.setEmail(request.getParameter("email"));
			professor.setId(Integer.parseInt(request.getParameter("codigo")));
			
			professorBusiness.cadastrar(professor);
			request.getRequestDispatcher("pesqProfessor.jsp").forward(request, response);
			System.out.println("cadastrou professor");
			break;
				
		case "ListIdAlterar":
			professor = professorBusiness.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("professor", professor);
			request.getRequestDispatcher("altProfessor.jsp").forward(request, response);
			break;
			
		case "Alterar":
			professor = professorBusiness.getById(Integer.parseInt(request.getParameter("codigo")));
			Professor professorAlterado = new Professor();
						
			professorAlterado.setNome(request.getParameter("nome"));
			professorAlterado.setSexo(request.getParameter("sexo").charAt(0));
			professorAlterado.setDataNasc(request.getParameter("dataNascimento"));
			professorAlterado.setDataAdm(request.getParameter("dataAdmissao"));
			professorAlterado.setCpf(request.getParameter("cpf"));
			professorAlterado.setTelefone(request.getParameter("telefone"));
			professorAlterado.setEmail(request.getParameter("email"));
			professorAlterado.setId(Integer.parseInt(request.getParameter("codigo")));
			
			professorBusiness.alterar(professor, professorAlterado);
			request.getRequestDispatcher("pesqProfessor.jsp").forward(request, response);;
			break;
		
		case "Deletar":
			professorBusiness.deletar(professorBusiness.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("pesqProfessor.jsp").forward(request, response);
			break;
		}	
	}
}