package Aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoXML;
import BancoDeDados.ManupulaTXT;
import Modelo.Aluno;
import Modelo.Endereco;
import Util.ListaDeAlunos;
import View.ViewCrudAluno;


public class CRUDAluno 
{
	public static void SalvarAluno(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException
	{
		
		//Chama o objeto
		
		Aluno aluno= new Aluno();	
		Endereco endAluno= new Endereco();
		String[] dados=ViewCrudAluno.ViewSalvarAluno(reader);
		
		
		
			//Insere informações sobre o aluno e guarda em forma de lista
			
			aluno.setNome(dados[0]);
			aluno.setNasc((dados[1]));
			aluno.setCpf(dados[2]);
			aluno.setCurso(dados[3]);
			endAluno.setRua(dados[4]);
			endAluno.setNum(dados[5]);
			endAluno.setCidade(dados[6]);
			endAluno.setEstado(dados[7]);
			endAluno.setCep(Integer.parseInt(dados[8]));
			aluno.setEndereco(endAluno);
			ListaDeAlunos.getInstance().add(aluno);
			ViewCrudAluno.MsgFinal(2);
			ManupulaTXT.SalvarArquivoTxt();
			ManipulacaoXML.SalvarArquivoXML();
	}
	
	public static void ListarAluno(int op) throws IOException, ParserConfigurationException, SAXException {
		ListaDeAlunos.getInstance().clear();
		ManupulaTXT.LerTxt();
		ManipulacaoXML.LerArquivoXML();
		
		if(op==0) {
			ViewCrudAluno.ViewListaDeAlunosEditada();
		}
		
		
		
		
	}
	
	
	
	
	public static void DeletaAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException
	{
		
		
		
		int indice = ViewCrudAluno.ViewListaAluno("deletar",reader);
		ListaDeAlunos.getInstance().remove(indice);
		
		
		ManupulaTXT.SalvarArquivoTxt();
		ManipulacaoXML.SalvarArquivoXML();
		ViewCrudAluno.MsgFinal(4);
		
		}
	
	
	public static void EditarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException
	{

				
				//chama os objetos
		
				int indice=ViewCrudAluno.ViewListaAluno("editar",reader);
				
				Aluno aluno= ListaDeAlunos.getInstance().get(indice);
				
				String[] edicao = ViewCrudAluno.ViewOpcaoEdicao(reader);
				
				switch(Integer.parseInt(edicao[0]))
				{
				case 1:
				{
					//faz a mudança dos atributos
					aluno.setNome(edicao[1]);
					break;
				}
				case 2:
				{
					//faz a mudança dos atributos
					aluno.setNasc(edicao[1]);
					
					break;
				}
				case 3:
				{
					//faz a mudança dos atributos
					aluno.setCpf(edicao[1]);
				}
				case 4:
				{
					//faz a mudança dos atributos
					aluno.setCurso(edicao[1]);
					break;
				}
				case 5:
				{
					aluno.getEndereco().setRua(edicao[1]);
					break;
				}
				case 6:{
					
					aluno.getEndereco().setNum(edicao[1]);
					break;
				}
				case 7:
				{
					aluno.getEndereco().setCidade(edicao[1]);
					break;
					
				}
				case 8:{
					aluno.getEndereco().setEstado(edicao[1]);
					break;
				}
				case 9:{
					aluno.getEndereco().setCep(Integer.parseInt(edicao[1]));
					break;
				}
				
				default:
				{
					ViewCrudAluno.MsgFinal(1);
					break;
				}
				}
			
				
				ListaDeAlunos.getInstance().set(indice, aluno);
				
				ManupulaTXT.SalvarArquivoTxt();
				ManipulacaoXML.SalvarArquivoXML();
				ViewCrudAluno.MsgFinal(5);
				
				}
				
	

	private static int ViewListaAluno(String string, List<Aluno> listaDeAlunos, BufferedReader reader) {
		// TODO Auto-generated method stub
		return 0;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
