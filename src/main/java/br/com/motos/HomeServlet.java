package br.com.motos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamou a minha Servlet!"); //Println no console
		
		//Localhost:8080/motos/home?nome=guilherme&idade=35;
				String nome = request.getParameter("nome");
				//int idade = Integer.valueOf(request.getParameter("idade"));
				String senha = request.getParameter("senha");
		
		
		PrintWriter saida = response.getWriter();
		saida.println("<html>"); // Println do navegador
		saida.println("<body>"); 
		
//		saida.println("Aqui esta nossa primeira Servlet!");
//		saida.println("Hora atual: " + LocalTime.now());
		saida.println("Nome: " + nome);
		saida.println("Idade: " + senha);
		
		saida.println("</html>"); 
		saida.println("</body>");

  }
}
