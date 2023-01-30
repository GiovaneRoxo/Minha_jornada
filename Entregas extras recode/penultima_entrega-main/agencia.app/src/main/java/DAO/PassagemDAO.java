package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDatabase.MySqlConnection;
import models.Passagem;

public class PassagemDAO {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void criarPassagem(Passagem passagem) {		
		sql = "INSERT INTO passagem VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, passagem.getFk_Cliente_cliente_id());
			preparedStatement.setString(2, passagem.getData_viagem());
			preparedStatement.setString(3, passagem.getDestino());
			preparedStatement.setString(4, passagem.getOrigem());
			preparedStatement.setString(5, passagem.getStatus_compra());
			preparedStatement.setDate(6, passagem.getData_compra());
			preparedStatement.executeUpdate();
			
			System.out.println("--corect insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect insert on database. " + e.getMessage());
		}
	}

	public static List<Passagem> find(){
		
		sql = "SELECT * FROM passagem";
		List<Passagem> passagens = new ArrayList<Passagem>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Passagem passagem = new Passagem();
				passagem.setPassagem_id(rs.getInt("PASSAGEM_ID"));
				passagem.setFk_Cliente_cliente_id(rs.getInt("fk_Cliente_CLIENTE_ID"));;
				passagem.setData_viagem(rs.getString("Data_viagem"));
				passagem.setDestino(rs.getString("Destino"));
				passagem.setOrigem(rs.getString("Origem"));
				passagem.setStatus_compra(rs.getString("Status_compra"));
				passagem.setData_compra(rs.getDate("Data_compra"));
				passagens.add(passagem);
			}
			
		System.out.println("--Correct find passagens");
		return passagens;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find passagens. " + e.getMessage());
			return null;
		}
	} 

	public static List<Passagem> findById(int clienteid){
		
		sql = "SELECT * FROM passagem";
		List<Passagem> passagens = new ArrayList<Passagem>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Passagem passagem = new Passagem();
				passagem.setPassagem_id(rs.getInt("PASSAGEM_ID"));
				passagem.setFk_Cliente_cliente_id(rs.getInt("fk_Cliente_CLIENTE_ID"));;
				passagem.setData_viagem(rs.getString("Data_viagem"));
				passagem.setDestino(rs.getString("Destino"));
				passagem.setOrigem(rs.getString("Origem"));
				passagem.setStatus_compra(rs.getString("Status_compra"));
				passagem.setData_compra(rs.getDate("Data_compra"));
				passagens.add(passagem);
			}
			
		System.out.println("--Correct find passagens");
		return passagens;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find passagens. " + e.getMessage());
			return null;
		}
	}

	public static void delete(int passagemId) {

		sql = "DELETE FROM passagem WHERE PASSAGEM_ID = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, passagemId);
			ps.executeUpdate();
			
			System.out.println("--Correct delete on passagem");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect delete on passagem. " + e.getMessage());
		}
	}

	public static Passagem findByPk(int passagemId) {
		
		sql = String.format("SELECT * FROM passagem WHERE PASSAGEM_ID = %d ", passagemId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			Passagem passagem = new Passagem();
			
			while(rs.next()) {
				passagem.setPassagem_id(rs.getInt("PASSAGEM_ID"));
				passagem.setData_viagem(rs.getString("Data_viagem"));
				passagem.setDestino(rs.getString("Destino"));
				passagem.setOrigem(rs.getString("Origem"));
			}
			
		System.out.println("--Correct find by pk cliente");
		return passagem;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find by pk clientes. " + e.getMessage());
			return null;
		}		
	}

	public static void update(Passagem passagem) {
		
		sql = "UPDATE passagem SET Data_viagem=?, Destino=?, Origem=? WHERE PASSAGEM_ID=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, passagem.getData_viagem());
			preparedStatement.setString(2, passagem.getDestino());
			preparedStatement.setString(3, passagem.getOrigem());
			preparedStatement.setInt(4, passagem.getPassagem_id());
			preparedStatement.executeUpdate();
			
			System.out.println("--corect update on database.");
			
		} catch(SQLException e) {
			System.out.println("--incorect update on database. " + e.getMessage());
		}
	}
}
