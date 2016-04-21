package br.edu.flf.sistemaAcademico.business;

import java.util.ArrayList;

import br.edu.flf.sistemaAcademico.objetos.Professor;

public class ProfessorBusiness {
	
	private ArrayList<Professor> listaProfessores = new ArrayList<Professor>();

	public ProfessorBusiness() {

	}

	public void cadastrar(Professor professor) {
		listaProfessores.add(professor);
	}

	public void alterar(Professor professor, Professor professorAlterado) {
		listaProfessores.set(buscaIndice(professor), professorAlterado);
	}

	public Professor buscar(Professor professor) {
		return listaProfessores.get(buscaIndice(professor));
	}

	public void deletar(Professor professor) {
		listaProfessores.remove(listaProfessores.indexOf(professor));
	}

	public Integer buscaIndice(Professor professor) {
		int i = listaProfessores.indexOf(professor);
		return i;
	}

	public ArrayList<Professor> listar() {
		return this.listaProfessores;
	}
	
	public Professor listarUnico(Professor professor){
		return buscar(professor);
	}
	
	public Professor getById(Integer valor){
		for (int i = 0; i < listaProfessores.size(); i++) {
			if (listaProfessores.get(i).getId() == valor) {
				return listaProfessores.get(i);
			}
		}
		return null; 
	}
}
