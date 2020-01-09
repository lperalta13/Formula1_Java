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

@WebServlet("/cadPontuacao")
public class PontuacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Pontuacao pontuacao = new Pontuacao();
		 PontuacaoDAO pontuacaoDAO = new PontuacaoDAO();
		 PilotoDAO pilotoDAO = new PilotoDAO();
		 EquipeDAO equipeDAO = new EquipeDAO();
		 GpDAO gpDAO = new GpDAO();
		 
		 
		 Long codigoPiloto = Long.parseLong(request.getParameter("piloto"));
		 System.out.println("atributo piloto: " + request.getParameter("piloto"));
		 
		 //buscar o pais e setar na classe Pontuacao
		 pontuacao.setPiloto(pilotoDAO.buscarPeloCodigo(codigoPiloto));
		 
////////////////////////////////////////
		 Long codigoEquipe = Long.parseLong(request.getParameter("equipe"));
		 System.out.println("atributo equipe: " + request.getParameter("equipe") );
		 
		 //buscar a equipe e setar na classe Pontuacao
		 pontuacao.setEquipe(equipeDAO.buscarPeloCodigo(codigoEquipe));
////////////////////////////////////////
		 Long codigoGp = Long.parseLong(request.getParameter("gp"));
		 System.out.println("atributo gp: " + request.getParameter("gp") );
		 
		 //buscar a equipe e setar na classe Piloto
		 pontuacao.setGp(gpDAO.buscarPeloCodigo(codigoGp));
		 
		 
		 pontuacao.setPontos(Long.parseLong(request.getParameter("pontos")));
		 System.out.println("atributo pontos: " + request.getParameter("pontos") );
//////////////////////////////////////
		 //salvar o Piloto no BD
		 pontuacaoDAO.salvar(pontuacao);
		 
		 // buscar os Pilotos no BD
		 List<Pontuacao> listaPontuacao = pontuacaoDAO.buscarTodos();
			 		
		 //O sistema � direcionado para a p�gina 
		 //listaPilotos.jsp 
		 RequestDispatcher rd = request.getRequestDispatcher("listaPontuacao.jsp");
		 request.setAttribute("pontuacao", listaPontuacao);
		 rd.forward(request, response);

	}

}
