package br.com.empresa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.PaisDAO;
import br.com.empresa.model.Pais;


@WebServlet("/atualizaPais")
public class AtualizaPaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperando o valor do parametro codigo
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		//preciso consultar o codigo na tabela pais
		PaisDAO dao = new PaisDAO();
		//recuperei o objeto a ser editado
		Pais pais = dao.buscarPeloCodigo(codigo);
		//manda o request e o response
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraPais.jsp");
		request.setAttribute("pais", pais);
		rd.forward(request, response);
		
	}

}
