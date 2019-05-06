package service;

import java.util.ArrayList;

import model.Cliente;
import dao.ClienteDAO;

public class VendedorService {
	ClienteDAO dao;
	
	public VendedorService(){
		dao = new ClienteDAO();
	}
	public ArrayList<Cliente> listarClientes(){
		return dao.listarClientes();
	}
	public ArrayList<Cliente> listarClientes(String chave){
		return dao.listarClientes(chave);
	}

}
