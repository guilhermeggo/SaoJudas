package service;

import java.io.IOException;
import java.util.ArrayList;

import model.Cliente;
import dao.ClienteDAO;

public class VendedorService {
	ClienteDAO dao;
	
	public VendedorService(){
		dao = new ClienteDAO();
	}
	public ArrayList<Cliente> listarClientes() throws IOException{
		return dao.listarClientes();
	}
	public ArrayList<Cliente> listarClientes(String chave) throws IOException{
		return dao.listarClientes(chave);
	}

}
