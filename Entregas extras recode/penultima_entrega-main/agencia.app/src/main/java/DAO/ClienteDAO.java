package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDatabase.MySqlConnection;
import models.Cliente;


public class ClienteDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void criarCliente(Cliente cliente) {		
		sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setInt(3, cliente.getIdade());
			preparedStatement.setDate(4, cliente.getDataCadastro());
			preparedStatement.setString(5, cliente.getEmail());
			preparedStatement.setString(6, cliente.getSenha());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--corect insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect insert on database. " + e.getMessage());
		}
	}

	public static boolean validar(Cliente cliente){
		
		boolean status = false;
		sql = "SELECT * FROM cliente WHERE email = ? and senha = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, cliente.getEmail());
			ps.setString(2, cliente.getSenha());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch(SQLException e) {
			System.out.println("--Error: " + e.getMessage());
		}
		return status;
	}

	public static List<Cliente> find(){
		
		sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCliente_id(rs.getInt("CLIENTE_ID"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setIdade(rs.getInt("Idade"));
				cliente.setDataCadastro(rs.getDate("dataCadastro"));
				cliente.setEmail(rs.getString("email"));
				clientes.add(cliente);
			}
			
		System.out.println("--Correct find clientes");
		return clientes;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find clientes. " + e.getMessage());
			return null;
		}
	}

	public static void delete(int clienteId) {
		
		sql = "DELETE FROM cliente WHERE CLIENTE_ID = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, clienteId);
			ps.executeUpdate();
			
			System.out.println("--Correct delete on cliente");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect delete on cliente. " + e.getMessage());
		}
	}

	public static Cliente findByPk(int clienteId) {
	
		sql = String.format("SELECT * FROM cliente WHERE CLIENTE_ID = %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while(rs.next()) {
				cliente.setCliente_id(rs.getInt("CLIENTE_ID"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setIdade(rs.getInt("Idade"));
				cliente.setDataCadastro(rs.getDate("dataCadastro"));
				cliente.setEmail(rs.getString("email"));
			}
			
		System.out.println("--Correct find by pk cliente");
		return cliente;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find by pk clientes. " + e.getMessage());
			return null;
		}		
	}

	public static void update(Cliente cliente) {
	
		sql = "UPDATE cliente SET nome=?, cpf=?, Idade=?, email=?, senha=? WHERE CLIENTE_ID=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setInt(3, cliente.getIdade());
			preparedStatement.setString(4, cliente.getEmail());
			preparedStatement.setString(5, cliente.getSenha());
			preparedStatement.setInt(6, cliente.getCliente_id());
			preparedStatement.executeUpdate();
			
			System.out.println("--corect update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect update on database. " + e.getMessage());
		}
	}

	@SuppressWarnings("null")
	public static int findIdByEmail(String email) {
		
		sql = "SELECT * FROM cliente WHERE email=? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs =preparedStatement.executeQuery();
			Cliente cliente = new Cliente();
			
			while(rs.next()) {
				cliente.setCliente_id(rs.getInt("CLIENTE_ID"));
			}
			
			System.out.println("--Correct find ID by email.");
			return cliente.getCliente_id();
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find ID by email. " + e.getMessage());
			return (Integer) null;
		}
	}
}

