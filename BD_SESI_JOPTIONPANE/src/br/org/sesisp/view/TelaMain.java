package br.org.sesisp.view;

import java.sql.Connection;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.org.sesisp.controller.Conexao;
import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;

public class TelaMain {

	public static void main(String[] args) {
		//instanciar um objeto da classe crudDAO
		CrudDAO inserir_aluno = new CrudDAO();
		//instanciar um objeto aluno
		Aluno aluno1 = new Aluno();
		int escolhas;
		/*aluno1.setNome("Jose");
		aluno1.setIdade(17);
		inserir_aluno.create(aluno1);
		System.out.println("Nome: "+ aluno1.getNome()+ "\nIdade: "+aluno1.getIdade());
		//************************************************
		//atualizar valores 
		aluno1.setNome("Marcelo Vieira");
		aluno1.setIdade(18);
		aluno1.setRa(1);
		inserir_aluno.update(aluno1);
		System.out.println("Nome: "+ aluno1.getNome()+ "\nIdade: "+aluno1.getIdade());
		//*************************************************
		//ler tabela alunos do BD
		System.out.println("lendo a lista...");
		for(Aluno olho : inserir_aluno.read()) {
			System.out.println("Dados do aluno: "+ olho.getRa() 
			+ olho.getNome() + olho.getIdade());
	
		}
	//*********************************************8
	//excluir dados
	CrudDAO remover_aluno = new CrudDAO();
	remover_aluno.delete(2);
*/
	//escolher opções do crud
		do {
	Scanner entrada = new Scanner (System.in);
	String valor;
	valor = JOptionPane.showInputDialog("O que deseja realizar?" + 
	"\n 1-CREATE \n 2-UPDATE \n 3-READ \n 4-DELETE");
	 escolhas = Integer.parseInt(valor);
	switch (escolhas) {

    case 1:
    	String nome;
    	nome = JOptionPane.showInputDialog("Digite o nome do aluno para criar:");
    	aluno1.setNome(nome);
    	String id;
    	id = JOptionPane.showInputDialog("Digite a idade do aluno para criar:");
    	int i = Integer.parseInt(id);
		aluno1.setIdade(i);
		inserir_aluno.create(aluno1);
		System.out.println("Nome: "+ aluno1.getNome()+ "\nIdade: "+aluno1.getIdade());
    break;
    case 2:
    	String ra;
    	ra = JOptionPane.showInputDialog("Digite o numero do RA que voce deseja atualizar:");
    	int r = Integer.parseInt(ra);
		aluno1.setRa(r);
    	nome = JOptionPane.showInputDialog("Digite o nome novo:");
    	aluno1.setNome(nome);
    	id = JOptionPane.showInputDialog("Digite a idade nova:");
    	i = Integer.parseInt(id);
		aluno1.setIdade(i);
		JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso!");
		inserir_aluno.update(aluno1);
		
		break;
    case 3:
    	JOptionPane.showMessageDialog(null, "lendo a lista...");
		for(Aluno olho : inserir_aluno.read()) {
			JOptionPane.showMessageDialog(null, "Dados do aluno: "+ olho.getRa() 
			+ olho.getNome() + olho.getIdade());}
		break;
    case 4:
    	CrudDAO remover_aluno = new CrudDAO();
    	String ra1;
    	ra1 = JOptionPane.showInputDialog("Digite o numero do RA que voce deseja deletar:");
    	int r1 = Integer.parseInt(ra1);
		aluno1.setRa(r1);
		remover_aluno.delete(r1);
		break;
	}
 }  while (escolhas != 4);   
		
}
}




