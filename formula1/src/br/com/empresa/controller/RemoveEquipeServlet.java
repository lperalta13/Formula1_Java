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
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Equipe;

@WebServlet("/removeEquipe")
public class RemoveEquipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperando o valor do parametro codigo
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		//preciso consultar o codigo na tabela equipes
		EquipeDAO dao = new EquipeDAO();
		
		try {
			dao.excluir(codigo);
			
		}catch (NegocioException e) {
			e.printStackTrace();
		}

		List<Equipe> listaEquipes = dao.buscarTodos();
		
		//manda o request e o response
		RequestDispatcher rd = request.getRequestDispatcher("listaEquipes.jsp");
		request.setAttribute("equipes", listaEquipes);
		rd.forward(request, response);
	}

}
