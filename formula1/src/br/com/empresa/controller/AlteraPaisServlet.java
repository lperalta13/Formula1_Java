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

@WebServlet("/alteraPais")
public class AlteraPaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperando o valor do parametro codigo
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		
		//preciso consultar o codigo na tabela pais
		PaisDAO dao = new PaisDAO();
		//recuperei o objeto a ser editado
		Pais pais = dao.buscarPeloCodigo(codigo);
		//setar o nome editado
		pais.setNome(nome);
		//no PaisDAO fizemos a funcao alterar
		dao.alterar(pais);
		
		List<Pais> listaPaises = dao.buscarTodos();
		
		//manda o request e o response
		RequestDispatcher rd = request.getRequestDispatcher("listaPais.jsp");
		request.setAttribute("paises", listaPaises);
		rd.forward(request, response);
		
	}

}
