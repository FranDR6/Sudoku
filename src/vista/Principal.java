package vista;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

public class Principal {

	protected JFrame ventana;
	protected JButton[][] botonera = new JButton[9][9];
	protected JButton[] botoneraNumeros = new JButton[9];
	protected JPanel panelBotonera;
	protected JPanel panelNumeros;

	public Principal() {

		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(0, 0, 900, 900);

		panelBotonera = new JPanel();

		JLabel lblNewLabel = new JLabel("SUDOKU");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panelNumeros = new JPanel();
		GroupLayout groupLayout = new GroupLayout(ventana.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(15)
						.addComponent(panelBotonera, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE).addGap(15))
				.addGroup(groupLayout.createSequentialGroup().addGap(300)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE).addGap(300))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(15)
						.addComponent(panelNumeros, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(15)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(15)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(panelBotonera, GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE).addGap(25)
				.addComponent(panelNumeros, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(15)));
		panelNumeros.setLayout(new GridLayout( 0, 9));
		panelBotonera.setLayout(new GridLayout(9, 9));
		ventana.getContentPane().setLayout(groupLayout);

	}
}
