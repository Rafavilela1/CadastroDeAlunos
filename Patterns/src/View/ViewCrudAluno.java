package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import Aplicacao.CRUDAluno;
import Modelo.Aluno;
import Util.ListaDeAlunos;

public class ViewCrudAluno 
{

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException
	{
		
					System.out.println();
					System.out.println("[1] PARA CADASTRO");
					System.out.println("[2] PARA MOTRAR CADASTRO");
					System.out.println("[3] PARA DELETAR CADASTRO");
					System.out.println("[4] PARA ALTERAR CADASTRO");
					System.out.println("[5] PARA SAIR");
					System.out.println();
				
					
					return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno= { "Nome do Aluno:","Data de Nascimento:", "CPF:", "Curso:", "Endereço: \nRua:", "Número:", "Cidade:", "Estado:", "CEP:"};
		String[] dadosAluno={"","","","","","","","",""};
		for(int i=0;i<dadosAluno.length;i++)
		{
			System.out.println(menuAluno[i]);
			dadosAluno[i]=reader.readLine();
		}
		
		return dadosAluno;
	}
	
	public static int ViewListaAluno(String deletarAlterar,BufferedReader reader) throws NumberFormatException, IOException
	{
		
		
		
		
		for(int i=0;i<ListaDeAlunos.getInstance().size();i++)
		{
			System.out.println(i +" - "+ ListaDeAlunos.getInstance().get(i));

		}
		
		
		System.out.println();
		System.out.println("Dentre a lista acima,escolha o número do Produto que deseja "+ deletarAlterar);
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws NumberFormatException, IOException {

		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar:");
		System.out.println("[1]- Nome");
		System.out.println("[2]- Data de Nascimento");
		System.out.println("[3]- CPF");
		System.out.println("[4]- Curso");
		System.out.println("[5]- Rua");
		System.out.println("[6]- Número");
		System.out.println("[7]- Cidade");
		System.out.println("[8]- Estado");
		System.out.println("[9]- Cep");
		
		dadosEditados[0] = reader.readLine();
		
		System.out.println("Escreva o nome do atributo:");

		dadosEditados[1]= reader.readLine();
		
		
		return dadosEditados;
	}
	
	public static void ViewListaDeAlunosEditada() {
		for(Aluno a : ListaDeAlunos.getInstance()) {
			System.out.println("------Aluno------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("CPF: " + a.getCpf());
			System.out.println("Curso: " + a.getCurso());
			System.out.println("Rua: " + a.getEndereco().getRua());
			System.out.println("Número: " + a.getEndereco().getNum());
			System.out.println("Cidade: " + a.getEndereco().getCidade());
			System.out.println("Estado: " + a.getEndereco().getEstado());
			System.out.println("CEP: " + a.getEndereco().getCep());
			System.out.println("-----------------");
			
		}
	}
	
	public static void MsgFinal(int opa)
	{
		String[] msgFinal = {"\nObrigado e volte sempre!!",
								"\nCaractere Inválido!",
								"\nCadastro Realizado!",
								"\nDentre a lista acima,escolha o número do Produto que deseja Deletar:",
								"\nCadastro Removido!",
								"\nCadastro alterado!"};
		
		System.out.println(msgFinal[opa]);
	}
	
}