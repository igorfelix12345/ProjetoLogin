package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public Usuario consultar(String email, String senha) {
		
		String consulta = "SELECT * FROM usuario WHERE email = ? " + 
				" AND senha = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setString(1, email);
			pst.setString(2, senha);
			
			ResultSet resultado = pst.executeQuery();
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				return usuario;
			} else {
				return null;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
}
