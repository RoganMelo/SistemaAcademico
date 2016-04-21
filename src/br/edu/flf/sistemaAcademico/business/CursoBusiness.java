package br.edu.flf.sistemaAcademico.business;

import java.util.ArrayList;

import br.edu.flf.sistemaAcademico.objetos.Curso;

public class CursoBusiness {
	private ArrayList<Curso> listaCursos = new ArrayList<Curso>();

	public CursoBusiness() {

	}

	public void cadastrar(Curso curso) {
		listaCursos.add(curso);
	}

	public void alterar(Curso curso, Curso cursoAlterado) {
		listaCursos.set(buscaIndice(curso), cursoAlterado);
	}

	public Curso buscar(Curso curso) {
		return listaCursos.get(buscaIndice(curso));
	}

	public void deletar(Curso curso) {
		listaCursos.remove(listaCursos.indexOf(curso));
	}

	public Integer buscaIndice(Curso curso) {
		int i = listaCursos.indexOf(curso);
		return i;
	}

	public ArrayList<Curso> listar() {
		return this.listaCursos;
	}
	
	public Curso listarUnico(Curso curso){
		return buscar(curso);
	}
	
	public Curso getById(Integer valor){
		for (int i = 0; i < listaCursos.size(); i++) {
			if (listaCursos.get(i).getId() == valor) {
				return listaCursos.get(i);
			}
		}
		return null; 
	}

}
