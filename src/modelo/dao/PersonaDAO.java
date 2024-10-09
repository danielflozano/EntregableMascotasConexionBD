package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

import controlador.Controlador;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVO;

public class PersonaDAO {
	
	private Controlador miControlador;

	public String registrarPersona(PersonaVO miPersonaVO) {
		String resultado ="";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO personas (documento, nombre, telefono) VALUES (?,?,?)"; // Probar con el punto y coma al final de la sentencia sql
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersonaVO.getDocumento());
			preStatement.setString(2, miPersonaVO.getNombre());
			preStatement.setString(3, miPersonaVO.getTelefono());
			preStatement.execute();
			
			resultado = "Registro de persona exitoso";
			
		} catch (SQLException e) {
			resultado = "Error, No se pudo registrar la persona correctamente " + e.getMessage();
			
		} finally {
			try {
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}	
		
		return resultado;
		
	}
	
	public PersonaVO consultarPersona(String documento) { //Tener en cuenta este metodo para mejorar los demas!!!
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		PersonaVO miPersonaVO = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT documento, nombre, telefono FROM personas WHERE documento =?";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					miPersonaVO = new PersonaVO();
					miPersonaVO.setDocumento(result.getString("documento"));
					miPersonaVO.setNombre(result.getString("nombre"));
					miPersonaVO.setTelefono(result.getString("telefono"));
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de la persona " + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return miPersonaVO;
		
	}
	
	public List<PersonaVO> consultarPersonas() {
		List<PersonaVO> listaPersonas = new ArrayList<>();
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT documento, nombre, telefono FROM personas";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				result = preStatement.executeQuery();
				
				while (result.next()) {
					PersonaVO miPersonaVO = new PersonaVO();
					miPersonaVO.setDocumento(result.getString("documento"));
					miPersonaVO.setNombre(result.getString("nombre"));
					miPersonaVO.setTelefono(result.getString("telefono"));
					
					listaPersonas.add(miPersonaVO);
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de las personas " + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return listaPersonas;
		
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		String resultado = "";
		String documento = miPersonaVO.getDocumento();
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM personas WHERE documento = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "UPDATE personas SET documento = ?, nombre = ?, telefono = ? WHERE documento = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, miPersonaVO.getDocumento());
					preStatement.setString(2, miPersonaVO.getNombre());
					preStatement.setString(3, miPersonaVO.getTelefono());
					preStatement.setString(4, miPersonaVO.getDocumento());
					preStatement.executeUpdate();
					
					resultado = "La persona " + miPersonaVO.getNombre() + " Ha sido actualizada";
					
				} else {
					resultado = "La persona que intenta actualizar no existe en la base de datos";
					
				}
				
			}
			
		} catch (SQLException e) {
			resultado = "Error: " + e.getMessage();
			
		} finally {
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}		
		return resultado;
		
	}
	
	public String eliminarPersona (String documento) {
		String resultado = "";
				
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM personas WHERE documento = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "DELETE FROM personas WHERE documento = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, documento);
					preStatement.executeUpdate();
					resultado = "La persona ha sido eliminada satisfactoriamente";
					
				} else {
					resultado = "La persona que intenta eliminar no existe en la base de datos";
					
				}
			}
										
		} catch (SQLException e) {
			resultado = "Error";
			throw new RuntimeException(e.getMessage());
			
		} finally {
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
			
			}
			
		}
		return resultado;
		
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

}
