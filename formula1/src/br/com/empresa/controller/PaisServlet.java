package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.PaisDAO;
import br.com.empresa.model.Pais;

@WebServlet("/paisServlet")
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pais pais = new Pais();
		PaisDAO dao = new PaisDAO();
		
		
		//Pegou o parametro NOME
		pais.setNome(request.getParameter("nome"));
		
		//Enviar para GRAVAR
		dao.salvar(pais);
		
		//Buscar todos os paises
		List<Pais> listaPaises = dao.buscarTodos();
		
		RequestDispatcher rd = request.getRequestDispatcher("listaPais.jsp");
		
		request.setAttribute("paises", listaPaises);
		rd.forward(request, response);
		
		
	}

}
