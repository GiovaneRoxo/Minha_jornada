package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Passagem;

public class PassagemDAO {

// CREATE
    // metodo para inserir uma passagem no banco de dados
  public static void inserir(Passagem passagem) {

    String sql = "INSERT INTO passagem(passagem_id, Dia_viagem, Mes_viagem, Ano_viagem, Destino, Origem, Status_compra, Data_compra, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
    Connection conn = null;
    PreparedStatement pstm = null;
    
    
    try {
      //cria conexão com banco de dados
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql); 
      
      pstm.setInt(1, passagem.getPassagemId());
      pstm.setInt(2, passagem.getDiaViagem());
      pstm.setInt(3, passagem.getMesViagem());
      pstm.setInt(4, passagem.getAnoViagem());
      pstm.setString(5, passagem.getDestino());
      pstm.setString(6, passagem.getOrigem());
      pstm.setString(7, passagem.getStatus_compra());
      pstm.setDate(8, new Date(passagem.getData_compra().getTime()));
      pstm.setInt(9, passagem.getCliente_id());
      pstm.execute();

      System.out.println("Passagem comprada com sucesso!");

    }catch (Exception e) {
      e.printStackTrace();
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
    // metodo para listar passagens de um determinado cliente no banco de dados
  public static List<Passagem> listarPassagensById(int cliente_id){
    
    String sql = "SELECT * FROM passagem WHERE cliente_id = ?";
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    List<Passagem> passagens = new ArrayList<Passagem>();
    
    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql);
      pstm.setInt(1, cliente_id);
      
      rset = pstm.executeQuery();

      while(rset.next()) {
        Passagem passagem = new Passagem();
          
        passagem.setDataViagem(rset.getInt("Dia_viagem"),rset.getInt("Mes_viagem"),rset.getInt("Ano_viagem"));
        passagem.setDestino(rset.getString("Destino"));
        passagem.setOrigem(rset.getString("Origem"));
        passagem.setPassagemId(rset.getInt("passagem_id"));
        passagem.setStatus_compra(rset.getString("Status_compra"));
        passagem.setData_compra(rset.getDate("Data_compra"));
        passagem.setCliente_id(rset.getInt("cliente_id"));
        passagens.add(passagem);
      }


      System.out.println("Passagens listadas com sucesso!");
    }catch (Exception e) {
      e.printStackTrace();
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
    return passagens;
  
  }
    // metodo lista todas as passagens no banco de dados
  public static List<Passagem> listarPassagens(){
    
      String sql = "SELECT * FROM passagem";
      Connection conn = null;
      PreparedStatement pstm = null;
      ResultSet rset = null;
  
      List<Passagem> passagens = new ArrayList<Passagem>();
      
      try {
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = (PreparedStatement) conn.prepareStatement(sql);
        
        rset = pstm.executeQuery();
  
        while(rset.next()) {
          Passagem passagem = new Passagem();
            
          passagem.setDataViagem(rset.getInt("Dia_viagem"),rset.getInt("Mes_viagem"),rset.getInt("Ano_viagem"));
          passagem.setDestino(rset.getString("Destino"));
          passagem.setOrigem(rset.getString("Origem"));
          passagem.setPassagemId(rset.getInt("passagem_id"));
          passagem.setStatus_compra(rset.getString("Status_compra"));
          passagem.setData_compra(rset.getDate("Data_compra"));
          passagem.setCliente_id(rset.getInt("cliente_id"));
          passagens.add(passagem);
        }
  
  
        System.out.println("Passagens listadas com sucesso!");
      }catch (Exception e) {
        e.printStackTrace();
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
      return passagens;
    
    }
 
// UPDATE
    // metodo para atualizar uma passagem no banco de dados
  public static void atualizarPassagem(Passagem passagem, int id){
        String sql = "UPDATE passagem SET Dia_viagem = ?, mes_viagem = ?, Ano_viagem = ?, Status_compra = ?, Data_compra = ?, cliente_id = ? WHERE passagem_id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
          conn = ConnectionFactory.createConnectionToMySQL();
          pstm = (PreparedStatement) conn.prepareStatement(sql);
          pstm.setInt(1, passagem.getDiaViagem());
          pstm.setInt(2, passagem.getMesViagem());
          pstm.setInt(3, passagem.getAnoViagem());
          pstm.setString(4, passagem.getStatus_compra());
          pstm.setDate(5, new Date(passagem.getData_compra().getTime()));
          pstm.setInt(6, passagem.getCliente_id());
          pstm.setInt(7, id);
          pstm.execute();
          System.out.println("Passagem atualizada com sucesso!");
        }catch (Exception e) {
          e.printStackTrace();
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
    // metodo para deletar uma passagem no banco de dados
  public static void deletarPassagem(int passagem_id, int id_cliente){
    String sql = "DELETE FROM passagem WHERE passagem_id = ? AND cliente_id = ?";
    Connection conn = null;
    PreparedStatement pstm = null;
    
    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql);
      pstm.setInt(1, passagem_id);
      pstm.setInt(2, id_cliente);
      pstm.execute();
      
    }catch (Exception e) {
      e.printStackTrace();
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
