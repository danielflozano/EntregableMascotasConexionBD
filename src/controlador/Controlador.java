package controlador;

import modelo.dao.MascotaDAO;
import modelo.dao.PersonaDAO;
import modelo.operaciones.Procesos;
import modelo.vo.MascotaVO;
import modelo.vo.ModeloDatos;
import modelo.vo.PersonaVO;
import vista.VentanaMascotas;
import vista.VentanaPersonas;
import vista.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal miVentanaPrincipal;
	private VentanaPersonas miVentanaPersonas;
	private VentanaMascotas miVentanaMascotas;
	private PersonaDAO miPersonaDAO;
	private MascotaDAO miMascotaDAO;
	private ModeloDatos miModeloDatos;
	private Procesos miProcesos;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		
	}

	public void setVentanaPersonas(VentanaPersonas miVentanaPersonas) {
		this.miVentanaPersonas = miVentanaPersonas;
		
	}

	public void setVentanaMascotas(VentanaMascotas miVentanaMascotas) {
		this.miVentanaMascotas = miVentanaMascotas;
		
	}
	
	public void setPersonaDAO(PersonaDAO miPersonaDAO) {
		this.miPersonaDAO = miPersonaDAO;
		
	}
	
	public void setMascotaDAO(MascotaDAO miMascotaDAO) {
		this.miMascotaDAO = miMascotaDAO;
		
	}

	public void setmiModeloDatos(ModeloDatos miModeloDatos) {
		this.miModeloDatos = miModeloDatos;
		
	}

	public void setProcesos(Procesos miProcesos) {
		this.miProcesos = miProcesos;
		
	}

	public void mostrarVentanaPrincipal() {
		miVentanaPrincipal.setVisible(true);
		
	}
	
	public void mostrarVentanaPersonas() {
		miVentanaPersonas.setVisible(true);
		
	}
	
	public void mostrarVentanaMascotas() {
		miVentanaMascotas.setVisible(true);
		
	}
	
	public String registrarPersona(PersonaVO miPersonaVO) {
		return miPersonaDAO.registrarPersona(miPersonaVO);
		
	}
	
	public PersonaVO consultarPersona(String documento) {
		return miPersonaDAO.consultarPersona(documento);
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		return miPersonaDAO.actualizarPersona(miPersonaVO);
		
	}
	
	public String eliminarPersona (String documento) {
		return miPersonaDAO.eliminarPersona(documento);
		
	}
	
	public String registrarMascota(MascotaVO miMascotaVO) {
		return miMascotaDAO.registrarMascota(miMascotaVO);
		
	}
	
	public MascotaVO consultarMascota(String documento) {
		return miMascotaDAO.consultarMascota(documento);
		
	}
	
	public String actualizarMascota(MascotaVO miMascotaVO) {
		return miMascotaDAO.actualizarMascota(miMascotaVO);
	}
	
	public String eliminarMascota(String documento) {
		return miMascotaDAO.eliminarMascota(documento);
	}
	
	
	/* public String registrarPersona(PersonaVO miPersonaVO) {
		return miModeloDatos.registrarPersona(miPersonaVO);
		
	}
	
	public void consultarPersona(String documento) {
		miModeloDatos.consultarPersona(documento);
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		return miModeloDatos.actualizarPersona(miPersonaVO);
		
	}
	
	public String eliminarPersona(String documento) {
		return miModeloDatos.eliminarPersona(documento);
		
	} */
	

}
