package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		
		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setNome(pNome);
		cliente.setFone(pFone);
		cliente.setEmail(pEmail);
		
		//instanciar o service
		ClienteService cs = new ClienteService();
		cs.criar(cliente);
		cliente = cs.carregar(cliente.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+cliente.getId()+"<br>");
		out.println(	"nome: "+cliente.getNome()+"<br>");
		out.println(	"fone: "+cliente.getFone()+"<br>");
		out.println(	"e-mail: "+cliente.getEmail()+"<br>");
	    out.println("</body></html>");
		
	}

}
