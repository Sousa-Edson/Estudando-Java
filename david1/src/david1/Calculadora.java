package david1;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
//variaveis 
		Scanner ler = new Scanner(System.in);
		int numA;
		int numB;
		int soma = 0;
// populando varriaveis
		System.out.print("digite o numero");
		numA = ler.nextInt();
		System.out.print("digite outro numero");
		numB = ler.nextInt();

		// calculo
		soma=numA+numB;
		
		// exibindo o resutado
		System.out.print("sua soma e :" + soma);

	}

}
