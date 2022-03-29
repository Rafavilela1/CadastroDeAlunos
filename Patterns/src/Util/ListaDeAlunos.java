package Util;

import java.util.ArrayList;
import java.util.List;

import Modelo.Aluno;

public class ListaDeAlunos 
{
	private static List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
	
	public static List<Aluno> getInstance(){
		return listaDeAlunos;
	}
}
