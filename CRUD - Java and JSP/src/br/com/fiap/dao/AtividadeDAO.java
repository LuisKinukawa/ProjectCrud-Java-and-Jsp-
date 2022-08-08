package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

import br.com.fiap.model.Atividade;

public class AtividadeDAO {
	
	 public static Connection obterConexao() {
	      Connection conexao = null;
	      try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	  
	        conexao = DriverManager.getConnection(
	            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
	            "rm88954", "250994");
	  
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return conexao;
	    }
	 	
	 	public static int delete(Atividade atividade) {
	 		int status=0;
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("DELETE FROM T_SHT_ATV_USUARIO WHERE DT_ATIVIDADE=?");
	 			ps.setString(1, atividade.getData());

	 			status=ps.executeUpdate();
	 		}catch (Exception e) {
	 			System.out.println(e);
	 			
	 		}
	 		return status;
	 	}
	 
	 
	 	public static int salvar(Atividade atividade) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO T_SHT_ATV_USUARIO VALUES(?,?,?)");
	 			ps.setString(1,atividade.getNome());
	 			ps.setString(2,atividade.getData());
	 			ps.setString(3,atividade.getTempo());

	 			status=ps.executeUpdate();
	 			
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 	}
	 
	 	
	 	public static Atividade getRegistrobyData(String data) {
	 		Atividade atividade = null;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM T_SHT_ATV_USUARIO WHERE DT_ATIVIDADE=?");
	 			ps.setString(1, data);
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				atividade = new Atividade();
	 				atividade.setNome(rs.getString("NM_ATIVIDADE"));
	 				atividade.setTempo(rs.getString("TP_ATIVIDADE"));
	 				atividade.setData(rs.getString("DT_ATIVIDADE"));

	 			}
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return atividade;
	 	}
	 	
	 	public static int update(Atividade atividade) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps= conexao.prepareStatement("UPDATE T_SHT_ATV_USUARIO SET NM_ATIVIDADE=?,TP_ATIVIDADE=? WHERE DT_ATIVIDADE=?");
	 	
	 			ps.setString(1,atividade.getNome());
	 			ps.setString(2,atividade.getTempo());
	 			ps.setString(3,atividade.getData());

	 			status=ps.executeUpdate();
	 			
	 		}catch (Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 		
	 	}
	 	
	 	
	 	public static List<Atividade> getAllAtividade(){
	 		List<Atividade> list = new ArrayList<Atividade>();
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM T_SHT_ATV_USUARIO");
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				Atividade atividade = new Atividade();
	 				atividade.setNome(rs.getString("NM_ATIVIDADE"));
	 				atividade.setData(rs.getString("DT_ATIVIDADE"));
	 				atividade.setTempo(rs.getString("TP_ATIVIDADE"));

	 				list.add(atividade);
	 			}
	 		}
	 		catch (Exception e) {
	 			System.out.println(e);
	 		}
			return list;
	 	}
	 	
	 	public static int insert(Atividade atividade){
			int status=0;
			try{
				Connection con=AtividadeDAO.obterConexao();
				PreparedStatement ps=con.prepareStatement("INSERT INTO T_SHT_ATV_USUARIO(NM_ATIVIDADE,DT_ATIVIDADE,TP_ATIVIDADE) values (?,?,?)");
				ps.setString(1,atividade.getNome());
				ps.setString(2,atividade.getData());
	 			ps.setString(3,atividade.getTempo());

				
				status=ps.executeUpdate();
				
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
	 	
	 	
	 	
	 }







	
	

