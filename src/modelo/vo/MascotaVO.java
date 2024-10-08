package modelo.vo;

public class MascotaVO {
	
	private String idDueño;
	private String nombre;
	private String raza;
	private String sexo;
	
	public MascotaVO(String idDueño, String nombre, String raza, String sexo) {
		this.idDueño = idDueño;
		this.nombre = nombre;
		this.raza = raza;
		this.sexo = sexo;
		
	}
	
	public MascotaVO() {
		
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Id Dueño = " + idDueño + "\n" +
				"Nombre = " + nombre + "\n" +
				"Raza = " + raza + "\n" +
				"Sexo = " + sexo;
		
	}	
	
}
