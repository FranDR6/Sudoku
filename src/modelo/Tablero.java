package modelo;

import java.util.Random;

public class Tablero {
	private Casilla[][] Casilla = new Casilla[9][9];

	public Tablero() {
		super();
		crearTablero();
		darPista();
		do {
			asignarNumeros();
		} while (comprobarCero() == true);
	}

	private void crearTablero() {

		for (int i = 0; i < Casilla.length; i++) {
			for (int j = 0; j < Casilla.length; j++) {
				Casilla[i][j] = new Casilla(asignarArea(i, j));
			}
		}

	}

	public void darPista() {
		int casillasOcultas = 35;
		for (int i = 0; i < casillasOcultas;) {
			int posicionA = (int) (Math.random() * Casilla.length);
			int posicionB = (int) (Math.random() * Casilla.length);
			if (Casilla[posicionA][posicionB].isDESVELADA() == false) {
				Casilla[posicionA][posicionB].setDESVELADA(true);
				i++;
			}
		}
	}

	private void asignarNumeros() {
		boolean salir = false;
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < Casilla.length; i++) {
			for (int j = 0, intentos = 0; j < Casilla.length; j++) {
				do {
					Casilla[i][j].setNUMERO(numeros[(int) (Math.random() * numeros.length)]);
					intentos++;
					if (intentos == 100) {
						Casilla[i][j].setNUMERO(0);
						break;
					}
				} while (validarCasilla(i, j) == true);
				if (Casilla[i][j].getNUMERO() == 0) {
					salir = true;
					break;
				}
			}
			if (salir == true) {
				break;
			}
		}
	}

	private boolean validarCasilla(int a, int b) {
		for (int x = 0; x < Casilla.length; x++) {
			if (Casilla[a][b].getNUMERO() == Casilla[a][x].getNUMERO() && x != b) {
				return true;
			}
			if (Casilla[a][b].getNUMERO() == Casilla[x][b].getNUMERO() && x != a) {
				return true;
			}
		}
		for (int i = 0; i < Casilla.length; i++) {
			for (int j = 0; j < Casilla.length; j++) {
				if (Casilla[a][b].getNUMERO() == Casilla[i][j].getNUMERO()
						&& Casilla[a][b].getAREA() == Casilla[i][j].getAREA() && i != a && j != b) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean comprobarCero() {
		for (int a = 0; a < Casilla.length; a++) {
			for (int b = 0; b < Casilla.length; b++) {
				if (Casilla[a][b].getNUMERO() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private int asignarArea(int x, int y) {
		int a = 0;
		int retorno = 0;
		int[][] filas = { { 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 3, 3, 3, 4, 4, 4, 5, 5, 5 }, { 6, 6, 6, 7, 7, 7, 8, 8, 8 } };
		if (x <= 2) {
			a = 0;
		}
		if (x >= 3 && x <= 5) {
			a = 1;
		}
		if (x >= 6) {
			a = 2;
		}
		retorno = filas[a][y];
		return retorno;
	}

	public Casilla[][] getCasilla() {
		return Casilla;
	}

	public void setCasilla(Casilla[][] casilla) {
		Casilla = casilla;
	}

}
