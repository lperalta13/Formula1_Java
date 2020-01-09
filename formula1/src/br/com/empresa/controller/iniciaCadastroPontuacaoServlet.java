package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.EquipeDAO;
import br.com.empresa.dao.GpDAO;
import br.com.empresa.dao.PilotoDAO;
import br.com.empresa.model.Equipe;
import br.com.empresa.model.Gp;
import br.com.empresa.model.Piloto;

@WebServlet("/iniciaCadPontuacao")
public class iniciaCadastroPontuacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lista de pilotos
		PilotoDAO pilotoDAO = new PilotoDAO();
		List<Piloto> pilotos = pilotoDAO.buscarTodos();

		//lista de equipes
		EquipeDAO equipeDAO = new EquipeDAO();
		List<Equipe> equipes = equipeDAO.buscarTodos();

		//lista de paises
		GpDAO gpDAO = new GpDAO();
		List<Gp> gps = gpDAO.buscarTodos();
		
		//dispachando para a página Pontuacao.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("pontuacao.jsp");
	    //setando as listas na requisição
	    request.setAttribute("pilotos", pilotos);
	    request.setAttribute("equipes", equipes);
	    request.setAttribute("gps", gps);
	    
	    
	    rd.forward(request, response);
	
	}

}
