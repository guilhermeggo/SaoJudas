package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;


/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		
		//instanciar o service
		PaisService cs = new PaisService();
		cs.criar(pais);
		pais = cs.carregar(pais.getId());
		
		/*PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+pais.getId()+"<br>");
		out.println(	"nome: "+pais.getNome()+"<br>");
		out.println(	"população: "+pais.getPopulacao()+"<br>");
		out.println(	"area: "+pais.getArea()+"<br>");
	    out.println("</body></html>");*/
		
       //dispatcher no servlet(controller)
		request.setAttribute("pais", pais);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);

	}


}
