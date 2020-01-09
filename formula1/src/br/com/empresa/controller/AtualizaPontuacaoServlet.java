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
import br.com.empresa.dao.PontuacaoDAO;
import br.com.empresa.model.Equipe;
import br.com.empresa.model.Gp;
import br.com.empresa.model.Piloto;
import br.com.empresa.model.Pontuacao;

@WebServlet("/atualizaPontuacao")
public class AtualizaPontuacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		PontuacaoDAO dao = new PontuacaoDAO();
		
		//buscar o Piloto no BD para realizar alteração
		Pontuacao pontuacao = dao.buscarPeloCodigo(codigo);
		
		//lista de paises
		PilotoDAO pilotoDAO = new PilotoDAO();
		List<Piloto> pilotos = pilotoDAO.buscarTodos();
				
		//lista de equipes
		EquipeDAO equipeDAO = new EquipeDAO();
		List<Equipe> equipes = equipeDAO.buscarTodos();

		//lista de gps
		GpDAO gpDAO = new GpDAO();
		List<Gp> gps = gpDAO.buscarTodos();
		
		//redirecionar para a pagina que o usuario pode alterar os dados da Equipe
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraPontuacao.jsp");
		
		//colocar objeto modelo em memoria
		request.setAttribute("pontuacao", pontuacao);
		
		//setando as listas na requisição
	    request.setAttribute("pilotos", pilotos);
	    request.setAttribute("equipes", equipes);
	    request.setAttribute("gps", gps);
	    
	    rd.forward(request, response);
		

	}

}
