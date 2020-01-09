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
import br.com.empresa.model.Pontuacao;

@WebServlet("/alteraPontuacao")
public class AlteraPontuacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long codigoPiloto = Long.parseLong(request.getParameter("piloto"));
		 System.out.println("atributo piloto: " + request.getParameter("piloto") );

		 Long codigoEquipe = Long.parseLong(request.getParameter("equipe"));
		 System.out.println("atributo equipe: " + request.getParameter("equipe") );

		 Long codigoGp = Long.parseLong(request.getParameter("gp"));
		 System.out.println("atributo gp: " + request.getParameter("gp") );

		 PilotoDAO pilotoDAO = new PilotoDAO();
		 EquipeDAO equipeDAO = new EquipeDAO();
		 GpDAO gpDAO = new GpDAO();
		 PontuacaoDAO pontuacaoDAO = new PontuacaoDAO();
		 
		 Long codigo = Long.parseLong(request.getParameter("codigo"));
		 Pontuacao pontuacao = pontuacaoDAO.buscarPeloCodigo(codigo);
		 
		 
		 
		 //buscar o pais e setar na classe Equipe
		 pontuacao.setPiloto(pilotoDAO.buscarPeloCodigo(codigoPiloto));
		 pontuacao.setEquipe(equipeDAO.buscarPeloCodigo(codigoEquipe));
		 pontuacao.setGp(gpDAO.buscarPeloCodigo(codigoGp));
		 
		 pontuacao.setPontos(Long.parseLong(request.getParameter("pontos")));
		 System.out.println("atributo pontos: " + request.getParameter("pontos") );
		 
		 
		pontuacaoDAO.alterar(pontuacao);
						
		// buscar os Pilotos no BD
		List<Pontuacao> listaPontuacao = pontuacaoDAO.buscarTodos();
				 		
		//O sistema é direcionado para a página 
		//listaPontuacao.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaPontuacao.jsp");
		request.setAttribute("pontuacao", listaPontuacao);
		rd.forward(request, response);

	}

}
