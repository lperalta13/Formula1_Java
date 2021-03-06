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

@WebServlet("/cadPiloto")
public class PilotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Piloto piloto = new Piloto();
		 PilotoDAO pilotoDAO = new PilotoDAO();
		 EquipeDAO equipeDAO = new EquipeDAO();
		 PaisDAO paisDAO = new PaisDAO();
		 
		 
		 Long codigoPais = Long.parseLong(request.getParameter("pais"));
		 System.out.println("atributo pais: " + request.getParameter("pais") );
		 
		 //buscar o pais e setar na classe Piloto
		 piloto.setPais(paisDAO.buscarPeloCodigo(codigoPais));
		 
		 //piloto.setNome(request.getParameter("nome"));
		 //System.out.println("atributo nome: " + request.getParameter("nome") );
////////////////////////////////////////
		 Long codigoEquipe = Long.parseLong(request.getParameter("equipe"));
		 System.out.println("atributo equipe: " + request.getParameter("equipe") );
		 
		 //buscar a equipe e setar na classe Piloto
		 piloto.setEquipe(equipeDAO.buscarPeloCodigo(codigoEquipe));
		 
		 piloto.setNome(request.getParameter("nome"));
		 System.out.println("atributo nome: " + request.getParameter("nome") );
//////////////////////////////////////
		 piloto.setCategoria(Categoria.valueOf
				 (request.getParameter("categoria")));
		 System.out.println("atributo categoria: " + request.getParameter("categoria") );
		 System.out.println("atributo categoria objeto: " 
		 + piloto.getCategoria().getDescricao() );
		 
		 
		 //salvar o Piloto no BD
		 pilotoDAO.salvar(piloto);
		 
		 // buscar os Pilotos no BD
		 List<Piloto> listaPilotos = pilotoDAO.buscarTodos();
			 		
		 //O sistema � direcionado para a p�gina 
		 //listaPilotos.jsp 
		 RequestDispatcher rd = request.getRequestDispatcher("listaPilotos.jsp");
		 request.setAttribute("pilotos", listaPilotos);
		 rd.forward(request, response);

	}

}
