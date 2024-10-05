package controlador;

import modelo.operaciones.Procesos;
import modelo.vo.ModeloDatos;
import vista.VentanaMascotas;
import vista.VentanaPersonas;
import vista.VentanaPrincipal;

public class Relaciones {
	
	public Relaciones() {
		Controlador miControlador = new Controlador();
		VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
		VentanaPersonas miVentanaPersonas = new VentanaPersonas();
		VentanaMascotas miVentanaMascotas = new VentanaMascotas();
		ModeloDatos miModeloDatos = new ModeloDatos();
		Procesos miProcesos = new Procesos();
		
		miVentanaPrincipal.setControlador(miControlador);
		miVentanaPersonas.setControlador(miControlador);
		miVentanaMascotas.setControlador(miControlador);
		miModeloDatos.setControlador(miControlador);
		miProcesos.setControlador(miControlador);
		
		miControlador.setVentanaPrincipal(miVentanaPrincipal);
		miControlador.setVentanaPersonas(miVentanaPersonas);
		miControlador.setVentanaMascotas(miVentanaMascotas);
		miControlador.setmiModeloDatos(miModeloDatos);
		miControlador.setProcesos(miProcesos);
		
		miControlador.mostrarVentanaPrincipal();
		
	}

}
