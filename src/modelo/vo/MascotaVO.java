package modelo.vo;

public class MascotaVO {
	
	String idDueño;
	String nombre;
	String raza;
	String edad;
	
	public MascotaVO (String idDueño, String nombre, String raza, String edad) {
		this.idDueño = idDueño;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		
	}

	public String getIdDueño() {
		return idDueño;
	}

	public void setIdDueño(String idDueño) {
		this.idDueño = idDueño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Id Dueño = " + idDueño + "\n" +
				"Nombre = " + nombre + "\n" +
				"Raza = " + raza + "\n" +
				"Edad = " + edad;
		
	}
	
	

}
