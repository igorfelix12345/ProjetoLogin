package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class LoginUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Pegar os parâmetros..
		String email = request.getParameter("email_usuario");
		String senha = request.getParameter("senha_usuario");
		
		// Executar a consulta a partir da Service...
		UsuarioService uService = new UsuarioService();
		Usuario usuario = uService.consultar(email, senha);
		
		// Se o objeto 'usuario' for null, então não existe um usuário com os dados informados:
		if (usuario == null) {
			// Exibir mensagem de erro:
			// Adicionando uma informação à requisição:
			request.setAttribute("mensagem", "Usuário e/ou senha inválidos!");
			try {
				// Redirecionando o usuário: (despachando)
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else { // Se encontrou o usuário, redirecionar para a área restrita,
			// mas antes, adicione a informação à sessão do usuário:
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuario);
			
			// Redirecionar o usuário para a página home.jsp
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect("home.jsp");
		}
		
	}
	
}
