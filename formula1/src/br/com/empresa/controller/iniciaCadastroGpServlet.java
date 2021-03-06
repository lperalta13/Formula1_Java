package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.PaisDAO;
import br.com.empresa.model.Pais;

@WebServlet("/iniciaCadGp")
public class iniciaCadastroGpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lista de paises
		PaisDAO paisDAO = new PaisDAO();
		List<Pais> paises = paisDAO.buscarTodos();
		
		//dispachando para a p�gina ModeloCarro.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("gp.jsp");
	    //setando as listas na requisi��o
	    request.setAttribute("paises", paises);
	    
	    rd.forward(request, response);
	
	}

}
