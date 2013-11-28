package net.jadfreex.swingview.usuario.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.swingview.commons.AppContext;
import net.jadfreex.usuario.bean.TipoUsuario;
import net.jadfreex.usuario.bean.Usuario;
import net.jadfreex.usuario.bo.TipoUsuarioBO;
import net.jadfreex.usuario.bo.UsuarioBO;
import net.jadfreex.usuario.factory.UsuarioFactory;

import org.springframework.beans.factory.annotation.Autowired;

//TODO Documentar
public class JPAgregarUsuario extends JPanel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7741379703586989385L;

	@Autowired
	private UsuarioBO usuarioBO;

	@Autowired
	private TipoUsuarioBO tipoUsuarioBO;

	private JLabel jlNombre;
	private JTextField jtfNombre;

	private JLabel jlTipoUsuario;
	private JComboBox<TipoUsuario> jcbTipoUsuario;

	private JButton jbAgregar;

	/**
	 * Create the panel.
	 */
	public JPAgregarUsuario() {
		AppContext.load(this, "classpath:app-config.xml");
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		this.jlNombre = new JLabel("Nombre:");
		this.jlNombre.setBounds(40, 18, 46, 14);
		this.add(jlNombre);

		this.jtfNombre = new JTextField();
		this.jtfNombre.setBounds(90, 15, 324, 20);
		this.add(jtfNombre);
		this.jtfNombre.setColumns(10);

		this.jlTipoUsuario = new JLabel("Tipo:");
		this.jlTipoUsuario.setBounds(40, 42, 46, 14);
		this.add(jlTipoUsuario);

		this.jcbTipoUsuario = new JComboBox<TipoUsuario>();
		for (TipoUsuario e : this.tipoUsuarioBO.findAll()) {
			this.jcbTipoUsuario.addItem(e);
		}
		this.jcbTipoUsuario.setBounds(90, 39, 324, 20);
		this.add(jcbTipoUsuario);

		this.jbAgregar = new JButton("Agregar");
		this.jbAgregar.addActionListener(new JbAgregarActionListener());
		this.jbAgregar.setBounds(343, 63, 71, 23);
		this.add(jbAgregar);
	}

	private void agregar() {
		Usuario u = UsuarioFactory.newInstance();
		u.setNombre(this.jtfNombre.getText());
		TipoUsuario tu = (TipoUsuario) this.jcbTipoUsuario.getSelectedItem();
		u.setTipoUsuario(tu);
		this.usuarioBO.create(u);
	}

	private class JbAgregarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				agregar();
			} catch (AppException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
	}
}
