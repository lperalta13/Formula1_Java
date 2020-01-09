package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.PontuacaoDAO;
import br.com.empresa.model.Pontuacao;


@WebServlet("/relPontuacao")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PontuacaoDAO pontuacaoDAO = new PontuacaoDAO();
		 
    	//buscar o piloto e setar na classe Pontuacao
		 
	   	List<Pontuacao> listaPontuacao = pontuacaoDAO.buscaTodosSomandoPontos();
	   	RequestDispatcher rd = request.getRequestDispatcher("listaPontuacao.jsp");
		request.setAttribute("pontuacao", listaPontuacao);
		rd.forward(request, response);
		 
	}

}
