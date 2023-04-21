package david1;

import java.util.Scanner;

public class Animal {

	public static void main(String[] args) {
		// variavel
		Scanner scanner = new Scanner(System.in);

		String animal;
		String sexo_do_animal;
		int idade;

		System.out.print("qual o nome do animal");
		animal = scanner.next();

		System.out.print("idade do animal");
		idade = scanner.nextInt();

		System.out.print("sexo do animal");
		sexo_do_animal = scanner.next();
		// resposta
		System.out.println(" o nome do animal é " + animal);
		System.out.println(" idade do animal é " + idade);
		System.out.println(" o sexo do animal é  " + sexo_do_animal);
		if (idade < 40) {
			System.out.println(" carne boa");

		} else if (idade == 40) {
			System.out.println(" carne ao ponto");
		} else if (idade > 41) {
			System.out.println(" carne mucha");

		}

	}
}
