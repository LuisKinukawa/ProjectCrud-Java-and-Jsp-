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

import br.com.fiap.model.Pessoa;

public class PessoaDAO {
	
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
	 	
	 	public static int delete(Pessoa pessoa) {
	 		int status=0;
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("DELETE FROM T_SHT_DADOS_USUARIO WHERE NM_USUARIO=?");
	 			ps.setString(1, pessoa.getNome());

	 			status=ps.executeUpdate();
	 		}catch (Exception e) {
	 			System.out.println(e);
	 			
	 		}
	 		return status;
	 	}
	 
	 
	 	public static int salvar(Pessoa pessoa) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO T_SHT_DADOS_USUARIO VALUES(?,?,?,?,?)");
	 			ps.setString(1,pessoa.getNome());
	 			ps.setString(2,pessoa.getData());
	 			ps.setString(3,pessoa.getSexo());
	 			ps.setString(4,pessoa.getEmail());
	 			ps.setString(5,pessoa.getSenha());
	 			status=ps.executeUpdate();
	 			
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 	}
	 
	 	
	 	public static Pessoa getRegistrobyNome(String nome) {
	 		Pessoa pessoa = null;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM T_SHT_DADOS_USUARIO1 WHERE NM_USUARIO=?");
	 			ps.setString(1, nome);
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				pessoa = new Pessoa();
	 				pessoa.setNome(rs.getString("NM_USUARIO"));
	 				pessoa.setData(rs.getString("DT_NASCIMENTO"));
	 				pessoa.setSexo(rs.getString("DS_SEXO"));
	 				pessoa.setEmail(rs.getString("DS_EMAIL"));
	 				pessoa.setSenha(rs.getString("DS_SENHA"));
	 			}
	 		}catch(Exception e) {
	 			System.out.println(e);
	 		}
	 		return pessoa;
	 	}
	 	
	 	public static int update(Pessoa pessoa) {
	 		int status=0;
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps= conexao.prepareStatement("UPDATE T_SHT_DADOS_USUARIO SET DT_NASCIMENTO=?,DS_SEXO=?,DS_EMAIL=?,DS_SENHA=? WHERE NM_USUARIO=?");
	 	
	 			ps.setString(1,pessoa.getData());
	 			ps.setString(2,pessoa.getSexo());
	 			ps.setString(3,pessoa.getEmail());
	 			ps.setString(4,pessoa.getSenha());
	 			ps.setString(5, pessoa.getNome());
	 			status=ps.executeUpdate();
	 			
	 		}catch (Exception e) {
	 			System.out.println(e);
	 		}
	 		return status;
	 		
	 	}
	 	
	 	
	 	public static List<Pessoa> getAllPessoas(){
	 		List<Pessoa> list = new ArrayList<Pessoa>();
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM T_SHT_DADOS_USUARIO");
	 			ResultSet rs = ps.executeQuery();
	 			
	 			while(rs.next()) {
	 				Pessoa pessoa = new Pessoa();
	 				pessoa.setNome(rs.getString("NM_USUARIO"));
	 				pessoa.setData(rs.getString("DT_NASCIMENTO"));
	 				pessoa.setSexo(rs.getString("DS_SEXO"));
	 				pessoa.setEmail(rs.getString("DS_EMAIL"));
	 				pessoa.setSenha(rs.getString("DS_SENHA"));
	 				list.add(pessoa);
	 			}
	 		}
	 		catch (Exception e) {
	 			System.out.println(e);
	 		}
			return list;
	 	}
	 	
	 	public static int insert(Pessoa pessoa){
			int status=0;
			try{
				Connection con=PessoaDAO.obterConexao();
				PreparedStatement ps=con.prepareStatement("INSERT INTO T_SHT_DADOS_USUARIO(NM_USUARIO,DT_NASCIMENTO,DS_SEXO,DS_EMAIL,DS_SENHA) values (?,?,?,?,?)");
				ps.setString(1,pessoa.getNome());
				ps.setString(2,pessoa.getData());
	 			ps.setString(3,pessoa.getSexo());
	 			ps.setString(4,pessoa.getEmail());
	 			ps.setString(5,pessoa.getSenha());
				
				status=ps.executeUpdate();
				
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
	 	
	 	public static boolean validarUsuario(Pessoa pessoa) {
	 		
	 		try {
	 			Connection conexao = obterConexao();
	 			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM T_SHT_DADOS_USUARIO WHERE DS_EMAIL=? AND DS_SENHA=?");
	 			ps.setString(1, pessoa.getEmail());
	 			ps.setString(2, pessoa.getSenha());
	 			ResultSet rs = ps.executeQuery();
	 		
	 			if(rs.next()) {
	 				return true;
	 			}
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 			
	 		
	 		}
	 		return false;
	 	}
	 	
	 	
	 	
	 }







	
	

