package model;

import java.io.File;
import java.io.Serializable;

import criptografia.CryptoAES;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String RES = "C:\\Users\\Alunos\\eclipse-workspace\\AULA11\\res\\";

	private String username;
	private String password;	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCripto() {
		try {
			CryptoAES caes = new CryptoAES();
			caes.geraCifra(password.getBytes(), new File(RES + "chave.t"));
			return ""+caes.getTextoCifrado();
		} catch (Exception e) {
			System.out.println("Arrume isso aqui!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return "BURRO!";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password
				+ "]";
	}
}
