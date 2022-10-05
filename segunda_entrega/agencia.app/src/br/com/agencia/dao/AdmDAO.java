package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.agencia.factory.ConnectionFactory;

public class AdmDAO {

// AUTENTICAÇAO
  	// metodo para validar admin
	public static boolean validarAdmin(String login, String senha) {
		
		String sql = "SELECT * FROM agencia.adm WHERE usuario = ? AND Senha = ? ;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, login);
			pstm.setString(2, senha);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro");
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
		
// CREATE
	// metodo para cadastrar admin
	public static void cadastrarAdmin(String login, String senha) {
		
		String sql = "INSERT INTO agencia.adm (usuario, senha) VALUES (?, ?);";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, login);
			pstm.setString(2, senha);
			
			pstm.execute();
			System.out.println("Administrador cadastrado com sucesso!!");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar administrador!!");
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
// READ
		// metodo para listar administradores
	public static void listarAdmins(){

		String sql = "SELECT * FROM agencia.adm;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("ID do adm: " + rset.getString("idadm"));
				System.out.println("Usuario: " + rset.getString("usuario"));
				System.out.println("------------------------------------------------");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar administradores!!");
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
// UPDATE
		// metodo para atualizar senha do admin
	public static void updateSenhaAdm(String senha, String login) {

			String sql = "UPDATE agencia.adm SET senha = ? WHERE usuario = ? ;";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, senha);
				pstm.setString(2, login);
				
				pstm.execute();
				System.out.println("Senha atualizada com sucesso!!");
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao atualizar senha!!");
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
// DELETE	
	// metodo para deletar admin
	public static void deletarAdmin(String senha) {
		
		String sql = "DELETE FROM agencia.adm WHERE senha = ? ;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, senha);
			
			pstm.execute();
			System.out.println("Administrador deletado com sucesso!!");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao deletar administrador!!");
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


