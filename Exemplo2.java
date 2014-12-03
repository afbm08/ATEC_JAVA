import java.io.IOException;

public class Exemplo2 {

	public static void main(String[] args) throws IOException {
		// Dobro do valor de um inteiro (valido apenas para numeros com um
		// dígito)
		try {

			char c = (char) System.in.read();
			// char 5
			// 53 - 48 = 5;
			int valor = c - '0';

			System.out.println(valor * 2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.in.read(); // libertar o buffer do \r \n
		System.in.read(); // libertar o buffer do \r \n

		System.out.println("Introduza uma string: ");

		String readString = readString2();
		System.out.println(readString);

	}

	public static String readString2() throws IOException {
		String aux = "";
		char read = ' ';

		do {
			read = (char) System.in.read();

			if (read != '\r' && read != '\n') {
				aux += read;
			}

		} while (read != '\r' && read != '\n');

		return aux;
	}
}
