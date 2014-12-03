import java.util.Scanner;

public class Exemplo5 {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Introduza um inteiro");

		int lerInteiro = lerInteiro(myScanner);
		System.out.println(lerInteiro);
		

		System.out.println("Introduza um nome");
		System.out.println(lerString(myScanner));
		
		myScanner.close();

	}

	public static int lerInteiro(Scanner a) {
		int myNextInt = a.nextInt();
		a.skip("\r\n");
		return myNextInt;
	}

	public static String lerString(Scanner xpto) {
		String myString = xpto.nextLine();
		return myString;
	}
}
