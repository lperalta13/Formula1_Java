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
import br.com.empresa.dao.PaisDAO;
import br.com.empresa.dao.PilotoDAO;
import br.com.empresa.model.Categoria;
import br.com.empresa.model.Piloto;

@WebServlet("/alteraPiloto")
public class AlteraPilotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long codigoPais = Long.parseLong(request.getParameter("pais"));
		 System.out.println("atributo pais: " + request.getParameter("pais") );

		 Long codigoEquipe = Long.parseLong(request.getParameter("equipe"));
		 System.out.println("atributo equipe: " + request.getParameter("equipe") );

		 PaisDAO paisDAO = new PaisDAO();
		 EquipeDAO equipeDAO = new EquipeDAO();
		 PilotoDAO pilotoDAO = new PilotoDAO();
		 
		 Long codigo = Long.parseLong(request.getParameter("codigo"));
		 Piloto piloto = pilotoDAO.buscarPeloCodigo(codigo);
		 
		 
		 
		 //buscar o pais e setar na classe Equipe
		 piloto.setPais(paisDAO.buscarPeloCodigo(codigoPais));
		 piloto.setEquipe(equipeDAO.buscarPeloCodigo(codigoEquipe));
		 //pegar o enum de categoria
		 piloto.setCategoria(Categoria.valueOf
				 (request.getParameter("categoria")));
		 System.out.println("atributo categoria: " + request.getParameter("categoria") );
		 System.out.println("atributo categoria objeto: " 
		 + piloto.getCategoria().getDescricao() );
		 
		 piloto.setNome(request.getParameter("nome"));
		 System.out.println("atributo nome: " + request.getParameter("nome") );
		 
		 
		pilotoDAO.alterar(piloto);
						
		// buscar os Pilotos no BD
		List<Piloto> listaPilotos = pilotoDAO.buscarTodos();
				 		
		//O sistema é direcionado para a página 
		//listaPilotos.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaPilotos.jsp");
		request.setAttribute("pilotos", listaPilotos);
		rd.forward(request, response);

	}

}
