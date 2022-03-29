package Modelo;

public class Endereco 
{
	private String rua,num,cidade,estado;
	private int cep;
	
	public Endereco(String[] dados)
	{
		String[] rua =dados[5].split("=");
		this.rua= rua[1].trim();
		this.num= dados[6].trim();
		this.cidade=dados[7].trim();
		this.estado= dados[8].trim();
		this.cep= Integer.parseInt(dados[9].trim());
		
		
	}
	public Endereco()
	{
		
	}
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return  rua + ", " + num + ", " + cidade + ", " + estado + ", " + cep ;
	}
	
	
}
