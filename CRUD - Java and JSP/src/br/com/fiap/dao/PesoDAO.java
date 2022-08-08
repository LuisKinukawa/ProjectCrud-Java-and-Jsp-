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

import br.com.fiap.model.Peso;

public class PesoDAO {
	
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
	 	
	 	public static int deletePeso(Peso peso) {
	 		int status=0;
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("DELETE FROM T_SHT_PESO_USUARIO WHERE DT_PESO=?");
	 			ps.setString(1,peso.getData());

	 			status=ps.executeUpdate();
	 		}catch (Exception e) {
	 			System.out.println(e);
	 			
	 		}
	 		return status;
	 	}
	 
	 	
	 	public static int salvarPeso(Peso peso) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO T_SHT_PESO_USUARIO VALUES(?,?)");
	 			ps.setString(1, peso.getPeso());
	 			ps.setString(2,peso.getData());
	 			status=ps.executeUpdate();
	 			
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 	}
	 
	 	
	 	public static Peso getRegistrobyData(String data) {
	 		Peso peso = null;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM T_SHT_PESO_USUARIO WHERE DT_PESO=?");
	 			ps.setString(1, data);
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				peso = new Peso();
	 				peso.setData(rs.getString("DT_PESO"));
	 				peso.setPeso(rs.getString("NR_PESO"));
	 				
	 			}
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return peso;
	 	}
	 	
	 	public static int updatePeso(Peso peso) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps= conexao.prepareStatement("UPDATE T_SHT_PESO_USUARIO SET NR_PESO=? WHERE DT_PESO=?"); 			
	 			ps.setString(1, peso.getPeso());
	 			ps.setString(2,peso.getData());
	 			
	 			status=ps.executeUpdate();
	 			
	 		}catch (Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 		
	 	}
	 	
	 	
	 	public static List<Peso> getAllPesos(){
	 		List<Peso> list = new ArrayList<Peso>();
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM T_SHT_PESO_USUARIO");
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				Peso peso = new Peso();
	 				peso.setPeso(rs.getString("NR_PESO"));
	 				peso.setData(rs.getString("DT_PESO"));
	 				list.add(peso);
	 			}
	 		}
	 		catch (Exception e) {
	 			System.out.println(e);
	 		}
			return list;
	 	}
	 	
	 	public static int insertPeso(Peso peso){
			int status=0;
			try{
				Connection con=PessoaDAO.obterConexao();
				PreparedStatement ps=con.prepareStatement("INSERT INTO T_SHT_PESO_USUARIO(NR_PESO,DT_PESO) values (?,?)");
				ps.setString(1, peso.getPeso());
	 			ps.setString(2,peso.getData());

				
				status=ps.executeUpdate();
				
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
	 	
	 	
	 	
	 }







	
	

