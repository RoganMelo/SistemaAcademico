package br.edu.flf.sistemaAcademico.business;

import java.util.ArrayList;

import br.edu.flf.sistemaAcademico.objetos.Disciplina;

public class DisciplinaBusiness {
	private ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();

	public DisciplinaBusiness() {

	}

	public void cadastrar(Disciplina disciplina) {
		listaDisciplina.add(disciplina);
	}

	public void alterar(Disciplina disciplina, Disciplina disciplinaAlterado) {
		listaDisciplina.set(buscaIndice(disciplina), disciplinaAlterado);
	}

	public Disciplina buscar(Disciplina disciplina) {
		return listaDisciplina.get(buscaIndice(disciplina));
	}

	public void deletar(Disciplina disciplina) {
		listaDisciplina.remove(listaDisciplina.indexOf(disciplina));
	}

	public Integer buscaIndice(Disciplina disciplina) {
		int i = listaDisciplina.indexOf(disciplina);
		return i;
	}

	public ArrayList<Disciplina> listar() {
		return this.listaDisciplina;
	}
	
	public Disciplina listarUnico(Disciplina disciplina){
		return buscar(disciplina);
	}
	public Disciplina getById(Integer valor){
		for (int i = 0; i < listaDisciplina.size(); i++) {
			if (listaDisciplina.get(i).getId() == valor) {
				return listaDisciplina.get(i);
			}
		}
		return null; 
	}
}
