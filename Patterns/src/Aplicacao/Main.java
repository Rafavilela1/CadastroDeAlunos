package Aplicacao;
//Importando o Buffer
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

//Importando os Pacotes
import Modelo.Aluno;
import Modelo.Endereco;
import View.ViewCrudAluno;

public class Main 
{
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException
	{
		
		//Chama o buffer
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		//Cria uma lista para colocar informações
		CRUDAluno.ListarAluno(1);
		int menu=0;
		//Loop para menu
		while(menu!=5) 
		{
			menu= ViewCrudAluno.ViewMenuPrincipal(reader);
		//usando try/catch  pedindo para o usuário colocar os atributos	
			try 
			
			{	
				//Chama o objeto
				
				switch(menu)
				{
				case 1:
				{
					CRUDAluno.SalvarAluno(reader);
					break;
				}
				case 2:
				{
					CRUDAluno.ListarAluno(0);
					break;
					
				}
				case 3:{
					CRUDAluno.DeletaAluno(reader);
					break;
				}
				case 4:{
					CRUDAluno.EditarAluno(reader);
					break;
				}
				case 5:
				{
					ViewCrudAluno.MsgFinal(0);
					break;
				}
				}
				
														
				} catch (IOException e) 
				{
				// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}	
	}
}
