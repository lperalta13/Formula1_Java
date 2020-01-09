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

@WebServlet("/alteraGp")
public class AlteraGpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long codigoPais = Long.parseLong(request.getParameter("pais"));
		 System.out.println("atributo pais: " + request.getParameter("pais") );

         PaisDAO paisDAO = new PaisDAO();
		 GpDAO gpDAO = new GpDAO();
		 
		 Long codigo = Long.parseLong(request.getParameter("codigo"));
		 Gp gp = gpDAO.buscarPeloCodigo(codigo);
		 
		 
		 
		 //buscar o pais e setar na classe Gp
		 gp.setPais(paisDAO.buscarPeloCodigo(codigoPais));
		 
		 gp.setDescricao(request.getParameter("descricao"));
		 System.out.println("atributo descrição: " + request.getParameter("descricao") );
		 
		 
		gpDAO.alterar(gp);
						
		// buscar os Gps no BD
		List<Gp> listaGps = gpDAO.buscarTodos();
				 		
		//O sistema é direcionado para a página 
		//listaGps.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaGps.jsp");
		request.setAttribute("gps", listaGps);
		rd.forward(request, response);

	}

}
