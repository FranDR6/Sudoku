package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import modelo.Tablero;
import vista.Principal;

public class ParaUI extends Principal {

	private int numeroSeleccionado = 0;
	private Tablero tablero = new Tablero();

	public ParaUI() {
		super();
		crearJuego();
	}

	private void crearJuego() {

		crearBotonesNumeros();

		crearBotonera();
	}

	private void crearBotonera() {
		for (int x = 0; x < botonera.length; x++) {
			for (int y = 0; y < botonera.length; y++) {
				botonera[x][y] = new JButton();
				botonera[x][y].setName(x + " " + y);
				botonera[x][y].setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				botonera[x][y].setFont(new Font("Segoe UI", Font.BOLD, 25));
				botonera[x][y].setBackground(obtenerColor(x, y));
				if (tablero.getCasilla()[x][y].isDESVELADA() == true) {
					botonera[x][y].setForeground(Color.blue);
					botonera[x][y].setText(String.valueOf(tablero.getCasilla()[x][y].getNUMERO()));
				} else {
					listenerBotones(x, y);
				}
				panelBotonera.add(botonera[x][y]);
				ventana.revalidate();

			}
		}
	}

	private void listenerBotones(int x, int y) {
		botonera[x][y].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton boton = ((JButton) e.getSource());
				String[] datos = boton.getName().split(" ");
				int x = Integer.parseInt(datos[0]);
				int y = Integer.parseInt(datos[1]);
				if (numeroSeleccionado != 0) {
					botonera[x][y].setText(String.valueOf(numeroSeleccionado));
				}

				if (victoria() == true) {
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres volver a jugar?", "Alerta!",
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						panelBotonera.removeAll();
						panelNumeros.removeAll();
						tablero = new Tablero();
						crearJuego();
					} else {
						System.exit(0);
					}
				}
			}
		});
	}

	private void crearBotonesNumeros() {
		for (int i = 0; i < botoneraNumeros.length; i++) {
			botoneraNumeros[i] = new JButton(String.valueOf(i + 1));
			botoneraNumeros[i].setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			botoneraNumeros[i].setBackground(Color.WHITE);
			botoneraNumeros[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
			listenerBotonesNumeros(i);
			panelNumeros.add(botoneraNumeros[i]);
		}
	}

	private void listenerBotonesNumeros(int i) {
		botoneraNumeros[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton boton = ((JButton) e.getSource());
				numeroSeleccionado = Integer.parseInt(boton.getText());
				System.out.println(numeroSeleccionado);
			}
		});
	}

	private Color obtenerColor(int x, int y) {
		Color color1 = Color.GRAY;
		Color color2 = Color.WHITE;
		switch (tablero.getCasilla()[x][y].getAREA()) {
		case 0:
			return color1;
		case 1:
			return color2;
		case 2:
			return color1;
		case 3:
			return color2;
		case 4:
			return color1;
		case 5:
			return color2;
		case 6:
			return color1;
		case 7:
			return color2;
		case 8:
			return color1;
		}
		return Color.BLACK;
	}

	private boolean victoria() {
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {
				if (botonera[i][j].getText().isEmpty() == true) {
					return false;
				}
				if (tablero.getCasilla()[i][j].getNUMERO() != Integer.parseInt(botonera[i][j].getText())) {
					return false;
				}
			}
		}

		return true;
	}

}
