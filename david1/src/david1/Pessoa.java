package david1;

import java.util.Scanner;

public class Pessoa {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nome;
		System.out.println("digite seu nome ");
		nome = teclado.next();
		System.out.println("seu nome e "+nome);
	}
}
