public class Exemplo4 {

	public static void main(String[] args) {

//		asciiForDummies();
		asciiAdvanced(256);

	}

	public static void asciiAdvanced(int columnSize) {

		for (int j = 0; j <= 255; j += columnSize) {
			System.out.print("Dec \t Oct \t Hex \t Valor \t ");
		}

		System.out.println("");

		for (int i = 0; i < columnSize; i++) {
			for (int j = i; j <= 255; j += columnSize) {

				System.out.print(j);
				System.out.print("\t");
				System.out.print(Integer.toOctalString(j));
				System.out.print("\t");
				System.out.print(Integer.toHexString(j));
				System.out.print("\t");

				switch (j) {
				case 9:
					System.out.print("TAB");
					break;
				case 10:
					System.out.print("CR");
					break;
				case 13:
					System.out.print("LF");
					break;
				default:
					System.out.print((char) j);
					break;
				}

				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public static void asciiForDummies() {
		System.out.println("Dec \t Valor");

		for (int i = 0; i <= 255; i++) {
			System.out.println(i + "\t" + (char) i);
		}
	}

}
