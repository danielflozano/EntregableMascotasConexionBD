package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.vo.PersonaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaPersonas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDoc;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JLabel lblDoc;
	private JLabel lblTitulo;
	private JLabel lblTelefono;
	private JLabel lblNombre;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultarLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JSeparator separator;
	private Controlador miControlador;
	

	/**
	 * Create the frame.
	 */
	public VentanaPersonas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Gestionar Personas");
		setLocationRelativeTo(null);
		setResizable(false);		
		
	}
	

	private void iniciarComponentes() {
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDoc = new JLabel("Documento:");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoc.setBounds(10, 100, 110, 30);
		contentPane.add(lblDoc);
		
		txtDoc = new JTextField();
		txtDoc.setBounds(115, 100, 196, 30);
		contentPane.add(txtDoc);
		txtDoc.setColumns(10);
		
		lblTitulo = new JLabel("Gestionar Personas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 20, 576, 40);
		contentPane.add(lblTitulo);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefono.setBounds(321, 100, 85, 30);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(406, 100, 170, 30);
		contentPane.add(txtTelefono);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(10, 170, 110, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(115, 170, 461, 30);
		contentPane.add(txtNombre);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(80, 240, 180, 40);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(321, 240, 180, 40);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(80, 300, 180, 40);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(321, 300, 180, 40);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(80, 360, 421, 40);
		contentPane.add(btnConsultarLista);
		btnConsultarLista.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 420, 566, 320);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		separator = new JSeparator();
		separator.setBounds(30, 220, 532, 2);
		contentPane.add(separator);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			capturarDatos(1);
			
		} else if (e.getSource() == btnConsultar) {
			capturarDatosConsulta();
		} else if (e.getSource() == btnActualizar) {
			capturarDatos(2);
		} else if (e.getSource() == btnEliminar) {
			capturarDatosEliminacion();
		} else if (e.getSource() == btnConsultarLista) {
			consultarLista();			
		}		
	}
	
	public void capturarDatos(int opcion) {
		if (txtDoc.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
			textArea.setText("Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				PersonaVO miPersonaVO = new PersonaVO();
				miPersonaVO.setDocumento(txtDoc.getText());
				miPersonaVO.setNombre(txtNombre.getText());
				miPersonaVO.setTelefono(txtTelefono.getText());
				String mensaje = "";
				
				switch (opcion) {
				case 1:
					mensaje = miControlador.registrarPersona(miPersonaVO);
					limpiarCampos();
					break;
				case 2:
					mensaje = miControlador.actualizarPersona(miPersonaVO);
					break;
				}
				
				textArea.setText(mensaje);
				
			}
	}
	
	public void capturarDatosConsulta() {
		String documento = txtDoc.getText();
		
		if (txtDoc.getText().isEmpty()) {
			textArea.setText("Ingrese algún documento para realizar la busqueda");
			
		} else {
			try {
				PersonaVO miPersonaVO = miControlador.consultarPersona(documento);
				if (miPersonaVO == null) {
					textArea.setText("La persona no se encuentra en la base de datos");
					
				} else {
					textArea.setText(miPersonaVO.toString());
					
				}
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar la persona: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
			}			
			
		}
		
	}
	
	public void consultarLista() {
		textArea.setText("");
		
		List<PersonaVO> listaPersonas = miControlador.consultarPersonas();
		
		for (PersonaVO persona : listaPersonas) {
			textArea.append("Documento: " + persona.getDocumento() + "\n" +
					"Nombre: " + persona.getNombre() + "\n" +
					"Teléfono: " + persona.getTelefono() + "\n\n");
			
		}
		
	}
	
	public void capturarDatosEliminacion() {
		String documento = txtDoc.getText();
		String mensaje = "";
		
		if (txtDoc.getText().isEmpty()) {
			textArea.setText("Ingrese un documento para eliminar la persona");
			
		} else {
			try {
				mensaje = miControlador.eliminarPersona(documento);
				textArea.setText(mensaje);
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
	}	
	
	private void limpiarCampos() {
		txtDoc.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

	
}
