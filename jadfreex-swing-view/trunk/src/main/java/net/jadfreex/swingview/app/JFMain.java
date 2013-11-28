package net.jadfreex.swingview.app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import net.jadfreex.swingview.usuario.panel.JPAgregarUsuario;

public class JFMain extends JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 427071666450827210L;

	private JPAgregarUsuario contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFMain frame = new JFMain();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		this.contentPane = new JPAgregarUsuario();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
	}

}
