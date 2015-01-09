package com.atec.FLJ;

import java.util.Scanner;

public class FourInARow {

	public static void main(String[] args) {
		int dimensao = 0;
		boolean jogoTerminou = false;
		Scanner scn = new Scanner(System.in);
		
		try {
			System.out.println("Introduza a dimensão do tabuleiro");
			
			dimensao = scn.nextInt();
			scn.skip("\r\n");

			if (dimensao < 8) {
				System.err
						.println("Erro na definição da dimensao, default 8 assumido");
				dimensao = 8;
			}

		} catch (Exception e) {
			System.err
					.println("Erro na definição da dimensao, default 8 assumido");
			dimensao = 8;
		}

		char[][] grid = new char[dimensao][dimensao];
		char[] jogadores = new char[3];
		jogadores[0] = 'X';
		jogadores[1] = 'O';
		jogadores[2] = 'H';
		
		int jogadorActual = 0;

		while (!jogoTerminou) {
			desenhaGrid(grid);
			int colunaJogada = solicitaJogada();
			if (colunaJogada > 0) {
				boolean jogadaValida = efectuaJogada(grid,
						jogadores[jogadorActual], colunaJogada);
				if (jogadaValida) {
					desenhaGrid(grid);
					jogoTerminou = detectarVencedor(grid,
							jogadores[jogadorActual], colunaJogada);
					if (!jogoTerminou)
						jogadorActual = alternaJogador(jogadores, jogadorActual);
				} else
					System.err.println("Jogada inválida!");
			} else
				System.err.println("Jogada inválida!");
		}
		
		scn.close();

	}

	/**
	 * Desenha a grid
	 * 
	 * @param grid
	 */
	private static void desenhaGrid(char[][] grid) {
		for (int i = 0; i < grid.length * 2; i++) {
			System.out.print("_");
		}
		System.out.println("");

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (j == 0)
					System.out.print("|");
				System.out.print(grid[i][j]);
				System.out.print("|");
			}
			System.out.println("");
			for (int w = 0; w < grid.length * 2; w++) {
				System.out.print("_");
			}
			System.out.println("");
		}

		System.out.println("");
	}

	/**
	 * Detectar se existem vencedores
	 * 
	 * @param grid
	 * @param jogadorActual
	 * @param colunaJogada
	 * @return
	 */
	private static boolean detectarVencedor(char[][] grid, char jogadorActual,
			int colunaJogada) {
		int colunaReal = colunaJogada - 1;
		int linhaReal = -1;
		boolean terminouJogo = false;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][colunaReal] != '\u0000') {
				linhaReal = i;
				break;
			}
		}

		if (linhaReal != -1) {
			boolean jogoColuna = validaColuna(grid, jogadorActual, linhaReal,
					colunaReal);
			if (jogoColuna) {
				terminouJogo = true;
				System.out.print("Jogador " + jogadorActual
						+ "ganhou -> Coluna=>" + colunaReal);
			}

			boolean jogoLinha = validaLinha(grid, jogadorActual, linhaReal,
					colunaReal);
			if (jogoLinha) {
				terminouJogo = true;
				System.out.print("Jogador " + jogadorActual
						+ " ganhou -> Linha=>" + linhaReal);
			}

			boolean jogoDiagonal = validaDiagonal(grid, jogadorActual,
					linhaReal, colunaReal);
			if (jogoDiagonal) {
				terminouJogo = true;
				System.out
						.print("Jogador " + jogadorActual
								+ " ganhou -> Diagonal=>" + linhaReal + "-"
								+ colunaReal);
			}

		}

		return terminouJogo;
	}

	/**
	 * Validar diagonais
	 * 
	 * @param grid
	 * @param jogadorActual
	 * @param linhaReal
	 * @param colunaReal
	 * @return
	 */
	private static boolean validaDiagonal(char[][] grid, char jogadorActual,
			int linhaReal, int colunaReal) {
		int found = 0;

		int beginLinha = linhaReal;
		int beginColuna = colunaReal;

		// Diagonal esquerda direita
		while (beginLinha > 0 && beginColuna > 0) {
			beginLinha--;
			beginColuna--;
		}

		//   declarações            condição paragem                           invcrementos
		for (int i = beginLinha, 
			     j = beginColuna;   i < grid.length && j < grid.length;        i++, j++) {
			
			if (grid[i][j] == jogadorActual) {
				found++;
			} else
				found = 0;

			if (found == 4)
				return true;
		}

		found = 0;
		beginLinha = linhaReal;
		beginColuna = colunaReal;

		while (beginColuna > 0 && beginLinha < grid.length - 1) {
			beginLinha++;
			beginColuna--;
		}

		for (int i = beginLinha, 
				 j = beginColuna; i >= 0 && j < grid.length;     i--, j++) {
			if (grid[i][j] == jogadorActual) {
				found++;
			} else
				found = 0;

			if (found == 4)
				return true;
		}

		return false;
	}

	/**
	 * Validar jogo termina por linha
	 * 
	 * @param grid
	 * @param jogadorActual
	 * @param linhaReal
	 * @param colunaReal
	 * @return
	 */
	private static boolean validaLinha(char[][] grid, char jogadorActual,
			int linhaReal, int colunaReal) {
		int found = 0;

		for (int i = 0; i < grid.length; i++) {
			if (grid[linhaReal][i] == jogadorActual) {
				found++;
			} else
				found = 0;

			if (found == 4)
				return true;
		}

		return false;
	}

	/**
	 * Validar jogo termina por coluna
	 * 
	 * @param grid
	 * @param jogadorActual
	 * @param linhaReal
	 * @param colunaReal
	 * @return
	 */
	private static boolean validaColuna(char[][] grid, char jogadorActual,
			int linhaReal, int colunaReal) {

		int found = 0;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][colunaReal] == jogadorActual) {
				found++;
			} else
				found = 0;

			if (found == 4)
				return true;
		}

		return false;
	}

	/**
	 * alternar a vez do jogador
	 * 
	 * @param jogadores
	 * @param jogadorActual
	 * @return
	 */
	private static int alternaJogador(char[] jogadores, int jogadorActual) {
		int retJogador;
		if (jogadorActual == jogadores.length - 1)
			retJogador = 0;
		else
			retJogador = jogadorActual + 1;

		return retJogador;
	}

	/**
	 * Efectua uma jogada na grid
	 * 
	 * @param grid
	 * @param jogador
	 * @param colunaJogada
	 * @return
	 */
	private static boolean efectuaJogada(char[][] grid, char jogador,
			int colunaJogada) {
		boolean jogadaValida = false;

		if (colunaJogada > 0 && colunaJogada < grid.length) {
			int colunaReal = colunaJogada - 1;

			for (int linha = grid.length - 1; linha >= 0; linha--) {
				if (!jogadaValida && grid[linha][colunaReal] == '\u0000') {
					grid[linha][colunaReal] = jogador;
					jogadaValida = true;
					break;
				}
			}
		}

		return jogadaValida;
	}

	/**
	 * Solicita ao utilizador uma jogada
	 * 
	 * @return Jogada
	 */
	private static int solicitaJogada() {
		int jogada = -1;
		try {
			System.out.println("Coluna:");
			Scanner scn = new Scanner(System.in);
			jogada = scn.nextInt();
			scn.skip("\r\n");

		} catch (Exception e) {
			jogada = -1;
		}
		return jogada;
	}

}
