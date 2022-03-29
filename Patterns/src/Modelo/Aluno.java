package Modelo;

public class Aluno 
{
	private String nome,nasc,cpf,curso;
	private Endereco endereco;
	public String getNome() {
		return nome;
	}
	public Aluno(String dados)
	{
		String[] atributos = dados.split(",");
		String[] nome=atributos[1].split("=");
		String[] nasc=atributos[2].split("=");
		String[] cpf=atributos[3].split("=");
		String[] curso=atributos[4].split("=");
		
		Endereco endAluno = new Endereco(atributos);
		this.nome = nome[1].trim();
		this.nasc = nasc[1].trim();
		this.cpf= cpf[1].trim();
		this.curso= curso[1].trim();
		
		this.endereco=endAluno;
		
		
	}
	public Aluno()
	{
		
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNasc() {
		return nasc;
	}
	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Alunox,Nome=" + nome + ",Nasc=" + nasc + ",CPF=" + cpf + ",Curso=" + curso + ",Endereco=" + endereco;
	}
	
	
	
	
}
