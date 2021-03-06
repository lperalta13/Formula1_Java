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

@WebServlet("/cadGp")
public class GpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Gp gp = new Gp();
		 GpDAO gpDAO = new GpDAO();
		 PaisDAO paisDAO = new PaisDAO();
		 
		 
		 Long codigoPais = Long.parseLong(request.getParameter("pais"));
		 System.out.println("atributo pais: " + request.getParameter("pais") );
		 
		 //buscar o pais e setar na classe Equipe
		 gp.setPais(paisDAO.buscarPeloCodigo(codigoPais));
		 
		 gp.setDescricao(request.getParameter("descricao"));
		 System.out.println("atributo descri��o: " + request.getParameter("descricao") );
		 
		 
		 //salvar o Gp no BD
		 gpDAO.salvar(gp);
		 
		 // buscar os Gps no BD
		 List<Gp> listaGps = gpDAO.buscarTodos();
			 		
		 //O sistema � direcionado para a p�gina 
		 //listaGps.jsp 
		 RequestDispatcher rd = request.getRequestDispatcher("listaGps.jsp");
		 request.setAttribute("gps", listaGps);
		 rd.forward(request, response);

	}

}
