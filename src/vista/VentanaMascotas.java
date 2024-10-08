package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.vo.MascotaVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaMascotas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtRaza;
	private JTextField txtNombre;
	private JTextField txtSexo;
	private JLabel lblId;
	private JLabel lblTitulo;
	private JLabel lblRaza;
	private JLabel lblNombre;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultarLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JSeparator separator;
	private JLabel lblSexo;
	private Controlador miControlador;
	

	/**
	 * Create the frame.
	 */
	public VentanaMascotas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Gestionar Mascotas");
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	
	private void iniciarComponentes() {
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblId = new JLabel("Id Dueño:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(10, 100, 95, 30);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(100, 100, 200, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		lblTitulo = new JLabel("Gestionar Mascotas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 20, 576, 40);
		contentPane.add(lblTitulo);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRaza.setBounds(315, 100, 60, 30);
		contentPane.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(376, 100, 200, 30);
		contentPane.add(txtRaza);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(10, 170, 81, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 170, 200, 30);
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
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSexo.setBounds(315, 170, 81, 30);
		contentPane.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(376, 170, 200, 30);
		contentPane.add(txtSexo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			
		} else if (e.getSource() == btnConsultar) {
			
		} else if (e.getSource() == btnActualizar) {
			
		} else if (e.getSource() == btnEliminar) {
			
		}
		
	}
	
	public void capturarDatos(int opcion) {
		if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtRaza.getText().isEmpty() || txtSexo.getText().isEmpty()) {
			textArea.setText("Todos los campos deben estar diligenciados obligatoriamente");
			
		} else {
			MascotaVO miMascotaVO = new MascotaVO();
			miMascotaVO.setIdDueño(txtId.getText());
			miMascotaVO.setNombre(txtNombre.getText());
			miMascotaVO.setRaza(txtRaza.getText());
			miMascotaVO.setSexo(txtSexo.getText());
			String mensaje = "";
			
		}
		
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}




}
