package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public Usuario consultar(String email, String senha) {
		return usuarioDAO.consultar(email, senha);
	}
	
}
