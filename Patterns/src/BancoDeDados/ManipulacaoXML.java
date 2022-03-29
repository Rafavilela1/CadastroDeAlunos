package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerAlunos;
import Modelo.Aluno;
import Util.ListaDeAlunos;

public class ManipulacaoXML 
{
	private static String nomeArquivo = "CadastroDeAlunos.xml";
	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException 
	{
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		
		Element alunosTag = doc.createElement("Alunos");
		
		doc.appendChild(alunosTag);
		
		for(Aluno a: ListaDeAlunos.getInstance()) {
			Element alunoTag = doc.createElement("Aluno");
			alunoTag.setAttribute("ID", "1");
			alunosTag.appendChild(alunoTag);
			
			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			alunoTag.appendChild(nomeTag);
			
			Element nomeTag1 = doc.createElement("Nascimento");
			nomeTag1.setTextContent(a.getNasc());
			alunoTag.appendChild(nomeTag1);
			
			Element nomeTag2 = doc.createElement("CPF");
			nomeTag2.setTextContent(a.getCpf());
			alunoTag.appendChild(nomeTag2);
			
			Element nomeTag3 = doc.createElement("Curso");
			nomeTag3.setTextContent(a.getCurso());
			alunoTag.appendChild(nomeTag3);
			
			Element enderecoTag = doc.createElement("Endereço");
			alunoTag.appendChild(enderecoTag);
			
				Element ruaTag = doc.createElement("Rua");
				ruaTag.setTextContent(a.getEndereco().getRua());
				enderecoTag.appendChild(ruaTag);
				Element numTag = doc.createElement("Número");
				numTag.setTextContent(a.getEndereco().getNum());
				enderecoTag.appendChild(numTag);
				Element cidTag = doc.createElement("Cidade");
				cidTag.setTextContent(a.getEndereco().getCidade());
				enderecoTag.appendChild(cidTag);
				Element estTag = doc.createElement("Estado");
				estTag.setTextContent(a.getEndereco().getEstado());
				enderecoTag.appendChild(estTag);
				Element cpfTag = doc.createElement("CEP");
				cpfTag.setTextContent(String.valueOf(a.getEndereco().getCep()));
				enderecoTag.appendChild(ruaTag);
		
			
		}
		
		
		TransformerFactory tf= TransformerFactory.newInstance();
		Transformer trans= tf.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT,"yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}ident-amount","4");
		
		DOMSource source= new DOMSource(doc);
		
		try(OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(nomeArquivo),"ISO-8859-1")){
			StreamResult result= new StreamResult(osw);
			trans.transform(source,result);
		}
		
			
	}
	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr=new InputStreamReader(new FileInputStream(nomeArquivo),"ISO-8859-1")){
			InputSource source = new InputSource(isr);
			XMLHandlerAlunos handler = new XMLHandlerAlunos();
			parser.parse(source, handler);
		}
		
	}
}

