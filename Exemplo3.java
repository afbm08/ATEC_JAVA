import java.io.IOException;
import java.text.MessageFormat;

public class Exemplo3 {

	public static void main(String[] args) throws IOException {
		 System.out.println("----------------------------------------");
		 System.out.println("- Exercício 2");
		 System.out.println("----------------------------------------");
		 exercicio2();
		
		 System.out.println("----------------------------------------");
		 System.out.println("- Exercício 3");
		 System.out.println("----------------------------------------");
		 System.out.println(ex3(67, 1.79));
		
		 System.out.println("----------------------------------------");
		 System.out.println("- Exercício 4");
		 System.out.println("----------------------------------------");
		
		 // 3600 * 50 + 65 * 60 + 15
		 exercicio4(3600 * 50 + 65 * 60 + 15);
		 System.out.println("");
		 exercicio4v2(3600 * 50 + 65 * 60 + 15);

		
		 System.out.println("----------------------------------------");
		 System.out.println("- Exercício  ler valor e mostrar valor decimal e ascii");
		 System.out.println("----------------------------------------");
		char valorIntroduzido;
		do {
			valorIntroduzido = (char) System.in.read();

			if (valorIntroduzido != '\r' && valorIntroduzido != '\n'
					&& valorIntroduzido != '0') {
				System.out.println(valorIntroduzido);
				System.out.println((int) valorIntroduzido);
			}
		} while (valorIntroduzido != (int) '0');


	}

	public static void exercicio4(int p_seconds) {
		int seconds = p_seconds % 60;
		int minutes = (p_seconds / 60) % 60;
		int hours = p_seconds / (60 * 60);

		System.out.print(p_seconds + "s = " + hours + "h " + minutes + "m "
				+ seconds + "s");

	}

	/**
	 * ,number,# String.valueOf
	 * 
	 * @param p_seconds
	 */
	public static void exercicio4v2(int p_seconds) {

		String texto = MessageFormat.format("{0}s = {1}d {2}h {3}m {4}s",
				new Object[] { String.valueOf(p_seconds),
						p_seconds / (60 * 60 * 24), p_seconds / (60 * 60) % 24,
						(p_seconds / 60) % 60, p_seconds % 60 });

		System.out.println(texto);
	}

	/**
	 * @param peso
	 * @param altura
	 * @return
	 */
	public static double ex3(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}

	/**
	 * 
	 */
	public static void exercicio2() {
		double raio = 1;
		double pi = 3.14;
		double diametro = raio * 2;
		double perimetro = diametro * pi;
		double area = pi * Math.pow(raio, 2);

		System.out.println(diametro);
		System.out.println(perimetro);
		System.out.println(area);
	}

}
