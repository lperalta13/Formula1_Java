package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.GpDAO;
import br.com.empresa.dao.PaisDAO;
import br.com.empresa.model.Gp;
import br.com.empresa.model.Pais;

@WebServlet("/atualizaGp")
public class AtualizaGpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		GpDAO dao = new GpDAO();
		
		//buscar o Gp no BD para realizar alteração
		Gp gp = dao.buscarPeloCodigo(codigo);
		
		//lista de paises
		PaisDAO paisDAO = new PaisDAO();
		List<Pais> paises = paisDAO.buscarTodos();
				
			
		//redirecionar para a pagina que o usuario pode alterar os dados da Equipe
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraGp.jsp");
		
		//colocar objeto modelo em memoria
		request.setAttribute("gp", gp);
		
		//setando as listas na requisição
	    request.setAttribute("paises", paises);
		
		rd.forward(request, response);
		

	}

}
