public class Exemplo1 {

	public static int variavelGlobalExemplo = 15;

	public static void main(String[] args) {
		int x1 = 3;
		int x2 = 9;
		int y1 = 0;
		int y2 = 6;

		// int valorX = (int) Math.pow(x2 - x1, 2);
		// int valorY = (int) Math.pow(y2 - y1, 2);
		//
		// int somaValores = 0;
		// somaValores = valorX + valorY;
		//
		// int distancia = (int) Math.sqrt(somaValores);
		//
		// System.out.println("Distancia = " + distancia);
		// alinea 1 acaba aqui

		// alinea 3
		int valorAuxiliarXTemp = calcularDistancia(x1, x2, y1, y2);
		System.out.println("Distancia = " + valorAuxiliarXTemp);

	}

	/**
	 * Alinea 2
	 * 
	 * @param valorX1
	 * @param valorX2
	 * @param valorY1
	 * @param valorY2
	 * @return
	 */
	public static int calcularDistancia(int valorX1, int valorX2, int valorY1,
			int valorY2) {
		int distanciaAuxiliar = 0;

		int valorX = (int) Math.pow(valorX2 - valorX1, 2);
		int valorY = (int) Math.pow(valorY2 - valorY1, 2);

		int somaValores = 0;
		somaValores = valorX + valorY;

		distanciaAuxiliar = (int) Math.sqrt(somaValores);

		return distanciaAuxiliar;

	}

	public static int calcularDistanciaV2(int valorX1, int valorX2,
			int valorY1, int valorY2) {
		return (int) Math.sqrt(Math.pow(valorX2 - valorX1, 2)
				+ Math.pow(valorY2 - valorY1, 2));
	}

}
