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
import br.com.empresa.model.Equipe;

@WebServlet("/cadEquipe")
public class EquipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Equipe equipe = new Equipe();
		 PaisDAO paisDAO = new PaisDAO();
		 EquipeDAO equipeDAO = new EquipeDAO();
		 
		 
		 Long codigoPais = Long.parseLong(request.getParameter("pais"));
		 System.out.println("atributo pais: " + request.getParameter("pais") );
		 
		 //buscar o pais e setar na classe Equipe
		 equipe.setPais(paisDAO.buscarPeloCodigo(codigoPais));
		 
		 equipe.setDescricao(request.getParameter("descricao"));
		 System.out.println("atributo descri��o: " + request.getParameter("descricao") );
		 
		 
		 //salvar a Equipe no BD
		 equipeDAO.salvar(equipe);
		 
		 // buscar as Equipes no BD
		 List<Equipe> listaEquipes = equipeDAO.buscarTodos();
			 		
		 //O sistema � direcionado para a p�gina 
		 //listaEquipes.jsp 
		 RequestDispatcher rd = request.getRequestDispatcher("listaEquipes.jsp");
		 request.setAttribute("equipes", listaEquipes);
		 rd.forward(request, response);

	}

}
