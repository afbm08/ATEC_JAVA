import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) throws IOException {

		int valorExistente = 124;
		System.out.println("Teste de interação com o utilizador");
		System.out.println("Valor = " + valorExistente);

		System.out.print("Valor =");
		System.out.print(" ");
		System.out.print(valorExistente);
		System.out.println(".");

		int quantidade = 25;
		int repeticoes = 3;
		System.out.println(MessageFormat.format(
				"O valor para a qtd é = {0} e o valor repete {1}",
				new Object[] { quantidade, repeticoes }));

		int read = System.in.read();
		System.out.println(read);

		// leitura de texto
		String textoALer;
		Scanner scanner = new Scanner(System.in);
		textoALer = scanner.nextLine();
		scanner.close();

		// leitura de texto
		long numeroGrande;
		Scanner scanner2 = new Scanner(System.in);
		numeroGrande = scanner2.nextLong();
		scanner2.close();

	}

}
