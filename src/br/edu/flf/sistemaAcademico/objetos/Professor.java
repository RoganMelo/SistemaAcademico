package br.edu.flf.sistemaAcademico.objetos;

public class Professor extends Pessoa
{
	private String dataAdmissao;
	
	private Disciplina disciplina;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getDataAdm() {
		return dataAdmissao;
	}

	public void setDataAdm(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
