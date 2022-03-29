package Handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelo.Aluno;
import Modelo.Endereco;
import Util.ListaDeAlunos;

public class XMLHandlerAlunos extends DefaultHandler{
	private StringBuilder texto;
	Aluno aluno;
	Endereco end;
	

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if(qName.equals("Aluno")) {
		aluno = new Aluno();
		end= new Endereco();
	}else {
		texto = new StringBuilder();
	}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("Nome"))
		{
			aluno.setNome(texto.toString());
		}
		else if(qName.equals("Nascimento"))
		{
			aluno.setNasc(texto.toString());
		}
		else if(qName.equals("CPF"))
		{
			aluno.setCpf(texto.toString());
		}
		else if(qName.equals("Curso"))
		{
			aluno.setCurso(texto.toString());
		}
		else if(qName.equals("Rua"))
		{
			end.setRua(texto.toString());
		}
		else if(qName.equals("Número"))
		{
			end.setNum(texto.toString());
		}
		else if(qName.equals("Cidade"))
		{
			end.setCidade(texto.toString());
		}
		else if(qName.equals("Estado"))
		{
			end.setEstado(texto.toString());
		}
		else if(qName.equals("Cep"))
		{
			end.setCep(Integer.parseInt(texto.toString()));
			aluno.setEndereco(end);
			ListaDeAlunos.getInstance().add(aluno);
		}
		
		
		
		
				
		
		
		
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto.append(ch,start,length);
	}
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		super.error(e);
	}

	
}
