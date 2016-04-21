package br.edu.flf.sistemaAcademico.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.flf.sistemaAcademico.objetos.Usuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		
		/*Fazer a seguinte lógica:
		Pegar os campos da tela de login e verificar são iguais ao usuario e senha definido por vcs.
		Se for igual, criar a session a partir do request: request.getSession().
		Colocar um atributo(de uma classe Usuario) na sessão chamado "usuariologado", qual conterá os dados do login do usuario.
		Depois mandar(redirecionar) para a tela inicial da aplicação de vcs.
		Para deslogar, usar request.getSession().invalidate(), caso o parametro de logout diga isso(podem usar um pamametro direto na url).
		Ex: /Servlet.do?logout=sim
		*/
		HttpSession sessao  = request.getSession();
		Usuario usuario = new Usuario();
		
		String nome  = request.getParameter("login");
		String senha  = request.getParameter("senha");
		usuario.setNome(nome);
		usuario.setSenha(senha);
		request.getSession().setAttribute("usuariologado", usuario);
		sessao.setAttribute("usuariologado",usuario);
		response.sendRedirect("menu.jsp");
	}

}
