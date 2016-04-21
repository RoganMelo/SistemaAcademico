package br.edu.flf.sistemaAcademico.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.sistemaAcademico.business.CursoBusiness;
import br.edu.flf.sistemaAcademico.objetos.Curso;

/**
 * Servlet implementation class ServletCurso
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCurso() {
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
		String acaoCurso = request.getParameter("acaoCurso");
		
		CursoBusiness cursoBusiness = (CursoBusiness)request.getServletContext().getAttribute("CursoBusiness");
		Curso curso = new Curso();
		request.setAttribute("listaCursos", cursoBusiness.listar());
		
		System.out.println(acaoCurso);
		
		switch (acaoCurso) {
		
		case "Novo":
			response.sendRedirect("cadCurso.jsp");
			break;
		
		case "ListaDeCursos":
			request.getRequestDispatcher("pesqCurso.jsp").forward(request, response);
			break;
		
		case "Salvar":
			curso.setId(Integer.parseInt(request.getParameter("id")));			
			curso.setNome(request.getParameter("nome"));
			cursoBusiness.cadastrar(curso);
			request.getRequestDispatcher("pesqCurso.jsp").forward(request, response);
			break;
				
		case "ListId":
			Curso c = cursoBusiness.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("curso", c);
			request.getRequestDispatcher("altCurso.jsp").forward(request, response);
			break;
		case "Alterar":
			Curso cursoAlterado = new Curso();
			cursoAlterado.setNome(request.getParameter("nome"));
			cursoAlterado.setId(Integer.parseInt(request.getParameter("id")));
			Curso cur = cursoBusiness.getById(Integer.parseInt(request.getParameter("id")));
			
			cursoBusiness.alterar(cur, cursoAlterado);
			request.getRequestDispatcher("pesqCurso.jsp").forward(request, response);;
			break;
		
		case "Deletar":
			cursoBusiness.deletar(cursoBusiness.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("pesqCurso.jsp").forward(request, response);
			break;
		}	
	}

}
