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

import br.com.fiap.model.Dieta;

public class DietaDAO {
	
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
	 	
	 	public static int delete(Dieta dieta) {
	 		int status=0;
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("DELETE FROM T_SHT_DIETA_USUARIO WHERE DT_COMIDA=?");
	 			ps.setString(1, dieta.getData());

	 			status=ps.executeUpdate();
	 		}catch (Exception e) {
	 			System.out.println(e);
	 			
	 		}
	 		return status;
	 	}
	 
	 
	 	public static int salvar(Dieta dieta) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO T_SHT_DIETA_USUARIO VALUES(?,?,?)");
	 			ps.setString(1,dieta.getComida());
	 			ps.setFloat(2,dieta.getCaloria());
	 			ps.setString(3,dieta.getData());

	 			status=ps.executeUpdate();
	 			
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 	}
	 
	 	
	 	public static Dieta getRegistrobyData(String data) {
	 		Dieta dieta = null;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM T_SHT_DIETA_USUARIO WHERE DT_COMIDA=?");
	 			ps.setString(1, data);
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				dieta = new Dieta();
	 				dieta.setComida(rs.getString("DS_COMIDA"));
	 				dieta.setCaloria(rs.getFloat("NR_CALORIA"));
	 				dieta.setData(rs.getString("DT_COMIDA"));

	 			}
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return dieta;
	 	}
	 	
	 	public static int update(Dieta dieta) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps= conexao.prepareStatement("UPDATE T_SHT_DIETA_USUARIO SET DS_COMIDA=?,NR_CALORIA=? WHERE DT_COMIDA=?");
	 	
	 			ps.setString(1,dieta.getComida());
	 			ps.setFloat(2,dieta.getCaloria());
	 			ps.setString(3,dieta.getData());

	 			status=ps.executeUpdate();
	 			
	 		}catch (Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 		
	 	}
	 	
	 	
	 	public static List<Dieta> getAllComida(){
	 		List<Dieta> list = new ArrayList<Dieta>();
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM T_SHT_DIETA_USUARIO");
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				Dieta dieta = new Dieta();
	 				dieta.setComida(rs.getString("DS_COMIDA"));
	 				dieta.setCaloria(rs.getFloat("NR_CALORIA"));
	 				dieta.setData(rs.getString("DT_COMIDA"));

	 				list.add(dieta);
	 			}
	 		}
	 		catch (Exception e) {
	 			System.out.println(e);
	 		}
			return list;
	 	}
	 	
	 	public static int insert(Dieta dieta){
			int status=0;
			try{
				Connection con=DietaDAO.obterConexao();
				PreparedStatement ps=con.prepareStatement("INSERT INTO T_SHT_DIETA_USUARIO(DS_COMIDA,NR_CALORIA,DT_COMIDA) values (?,?,?)");
				ps.setString(1,dieta.getComida());
				ps.setFloat(2,dieta.getCaloria());
	 			ps.setString(3,dieta.getData());

				
				status=ps.executeUpdate();
				
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
	 	
	 	
	 	
	 }







	
	

