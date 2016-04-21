package br.edu.flf.sistemaAcademico.business;

import java.util.ArrayList;

import br.edu.flf.sistemaAcademico.objetos.Aluno;

public class AlunoBusiness {
	
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

	public AlunoBusiness() {

	}

	public void cadastrar(Aluno aluno) {
		listaAlunos.add(aluno);
	}

	public void alterar(Aluno aluno, Aluno alunoAlterado) {
		listaAlunos.set(buscaIndice(aluno), alunoAlterado);
	}

	public Aluno buscar(Aluno aluno) {
		return listaAlunos.get(buscaIndice(aluno));
	}

	public void deletar(Aluno aluno) {
		listaAlunos.remove(listaAlunos.indexOf(aluno));
	}

	public Integer buscaIndice(Aluno aluno) {
		int i = listaAlunos.indexOf(aluno);
		return i;
	}

	public ArrayList<Aluno> listar() {
		return this.listaAlunos;
	}
	
	public Aluno listarUnico(Aluno aluno){
		return buscar(aluno);
	
	}
	public Aluno getById(Integer valor){
		for (int i = 0; i < listaAlunos.size(); i++) {
			if (listaAlunos.get(i).getId() == valor) {
				return listaAlunos.get(i);
			}
		}
		return null; 
	}

}
