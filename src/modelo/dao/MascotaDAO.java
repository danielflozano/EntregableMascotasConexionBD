package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Controlador;
import modelo.conexion.Conexion;
import modelo.vo.MascotaVO;

public class MascotaDAO {

	private Controlador miControlador;
	
	public String registrarMascota(MascotaVO miMascotaVO) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO mascotas (idDueño, nombre, raza, sexo) VALUES (?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miMascotaVO.getIdDueño());
			preStatement.setString(2, miMascotaVO.getNombre());
			preStatement.setString(3, miMascotaVO.getRaza());
			preStatement.setString(4, miMascotaVO.getSexo());
			preStatement.execute();
			
			resultado = "Registro de mascota exitoso";
			
		} catch (SQLException e) {
			resultado = "Error, no se pudo registrar la mascota correctamente " + e.getMessage();
			
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
	
	public MascotaVO consultarMascota(String documento) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		MascotaVO miMascotaVO = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT idDueño, nombre, raza, sexo FROM mascotas WHERE idDueño = ?";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					miMascotaVO = new MascotaVO();
					miMascotaVO.setIdDueño(result.getString("idDueño"));
					miMascotaVO.setNombre(result.getString("nombre"));
					miMascotaVO.setRaza(result.getString("raza"));
					miMascotaVO.setSexo(result.getString("sexo"));
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de la mascota" + e.getMessage());
			
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
		return miMascotaVO;
		
	}
	
	public List<MascotaVO> consultarMascotas() {
		List<MascotaVO> listaMascotas = new ArrayList<>();
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT idDueño, nombre, raza, sexo FROM mascotas";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				result = preStatement.executeQuery();
				
				while (result.next()) {
					MascotaVO miMascotaVO = new MascotaVO();
					miMascotaVO.setIdDueño(result.getString("idDueño"));
					miMascotaVO.setNombre(result.getString("nombre"));
					miMascotaVO.setRaza(result.getString("raza"));
					miMascotaVO.setSexo(result.getString("sexo"));
					
					listaMascotas.add(miMascotaVO);
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de las mascotas " + e.getMessage());
			
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
		return listaMascotas;
		
	}
	
	public String actualizarMascota(MascotaVO miMascotaVO) {
		String resultado = "";
		String documento = miMascotaVO.getIdDueño();
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM mascotas WHERE idDueño = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "UPDATE mascotas SET idDueño = ?, nombre = ?, raza = ?, sexo = ? WHERE idDueño = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, miMascotaVO.getIdDueño());
					preStatement.setString(2, miMascotaVO.getNombre());
					preStatement.setString(3, miMascotaVO.getRaza());
					preStatement.setString(4, miMascotaVO.getSexo());
					preStatement.setString(5, miMascotaVO.getIdDueño());
					preStatement.executeUpdate();
					
					resultado = "La Mascota " + miMascotaVO.getNombre() + " Ha sido actualizada";
					
				} else {
					resultado = "La mascota que intenta actualizar no existe en la base de datos";
					
				}
			}
			
		} catch (SQLException e) {
			resultado = "error " + e.getMessage();
			
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
	
	public String eliminarMascota(String documento) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM mascotas WHERE idDueño = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "DELETE FROM mascotas WHERE idDueño = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, documento);
					preStatement.executeUpdate();
					resultado = "La mascota ha sido eliminada correctamente";
					
				} else {
					resultado = "La mascota que intenta eliminar no existe en la base de datos";
					
				}
				
			}
			
		} catch (SQLException e) {
			resultado = "error";
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
