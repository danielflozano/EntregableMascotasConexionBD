package vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoConImagen extends JPanel {
	private Image imagen;
	
	public FondoConImagen(String rutaImagen) {
		imagen = new ImageIcon(rutaImagen).getImage();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, -9, 40, getWidth(), getHeight(), this);
	}	
	
}
