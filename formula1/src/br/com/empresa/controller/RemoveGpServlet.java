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
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Gp;

@WebServlet("/removeGp")
public class RemoveGpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperando o valor do parametro codigo
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		//preciso consultar o codigo na tabela gp
		GpDAO dao = new GpDAO();
		
		try {
			dao.excluir(codigo);
			
		}catch (NegocioException e) {
			e.printStackTrace();
		}

		List<Gp> listaGps = dao.buscarTodos();
		
		//manda o request e o response
		RequestDispatcher rd = request.getRequestDispatcher("listaGps.jsp");
		request.setAttribute("gps", listaGps);
		rd.forward(request, response);
	}

}
