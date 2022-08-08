package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.model.Atividade;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Addatividade
 */
@WebServlet("/Addatividade")
public class Addatividade extends HttpServlet {
	private static final long serialVersionUID = 1L;

        // TODO Auto-generated constructor stub


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String nome=request.getParameter("nome");
		String data=request.getParameter("data");
		String tempo=request.getParameter("tempo");
		
		Atividade e=new Atividade();
		e.setNome(nome);
		e.setData(data);
		e.setTempo(tempo);
		
		int i = AtividadeDAO.salvar(e);
		
		if(i>0){
			response.sendRedirect("addAtv-success.jsp");
		}else{
			response.sendRedirect("addAtv-error.jsp");		
		}
		
		out.close();
	}

}
