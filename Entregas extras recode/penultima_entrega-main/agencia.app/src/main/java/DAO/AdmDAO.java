package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDatabase.MySqlConnection;
import models.Adm;




public class AdmDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static boolean validar(Adm adm){
		
		boolean status = false;
		sql = "SELECT * FROM adm WHERE email = ? and senha = ?;";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, adm.getUser());
			ps.setString(2, adm.getSenha());
			ResultSet rs = ps.executeQuery();
			status = rs.next();

			
		} catch(SQLException e) {
			System.out.println("--Error: " + e.getMessage());
		}
		return status;
	}
}
