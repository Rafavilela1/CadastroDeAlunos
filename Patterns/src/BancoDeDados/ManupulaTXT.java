package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Modelo.Aluno;
import Util.ListaDeAlunos;

public class ManupulaTXT 
{
	private static String NomeDoArquivo = "CadastroDeAlunos.txt";
	public static void SalvarArquivoTxt() throws IOException
	{
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(NomeDoArquivo))){
			PrintWriter pw= new PrintWriter(buffer);
		for(Aluno a: ListaDeAlunos.getInstance())
			pw.println(a);
	}
	}
	public static void LerTxt() throws IOException {
		try(FileWriter arq = new FileWriter(NomeDoArquivo,true))
		{		
		};
		String line="";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(NomeDoArquivo)))
				{
					while((line= reader.readLine())!=null && !"".equals(line))
					{
						Aluno aluno= new Aluno(line);
						ListaDeAlunos.getInstance().add(aluno);
					}
			
			
			
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
	}
}

