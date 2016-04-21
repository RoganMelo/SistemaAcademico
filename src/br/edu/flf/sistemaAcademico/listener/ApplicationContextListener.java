package br.edu.flf.sistemaAcademico.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.flf.sistemaAcademico.business.AlunoBusiness;
import br.edu.flf.sistemaAcademico.business.CursoBusiness;
import br.edu.flf.sistemaAcademico.business.DisciplinaBusiness;
import br.edu.flf.sistemaAcademico.business.ProfessorBusiness;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent context) {
		
		
		AlunoBusiness alunoBusiness = new AlunoBusiness();
		CursoBusiness cursoBusiness = new CursoBusiness();
		DisciplinaBusiness disciplinaBusiness = new DisciplinaBusiness();
		ProfessorBusiness professorbusiness = new ProfessorBusiness();
		
		context.getServletContext().setAttribute("AlunoBusiness", alunoBusiness);
		context.getServletContext().setAttribute("CursoBusiness", cursoBusiness);
		context.getServletContext().setAttribute("DisciplinaBusiness", disciplinaBusiness);
		context.getServletContext().setAttribute("ProfessorBusiness", professorbusiness);
		//Aqui deve ser criado os business e colocados no escopo de aplicação.
		//Aplicação = ServletContext
				
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		System.out.println("Finalizando aplicação");
		//Aqui deve ser apagado os business. método removeAttribute("NomeDoAtributo")
		
	}

}
