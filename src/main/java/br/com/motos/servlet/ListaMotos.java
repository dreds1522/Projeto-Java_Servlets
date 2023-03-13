package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class ListaMotos extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
		
		MotoDao dao = new MotoDao();
		List<Moto> motos = dao.Lista();
		
		PrintWriter saida = resp.getWriter();
		saida.print("<html><body>");
		
		saida.print("<table>");
		saida.print("<tr>");
		saida.print("<td>id</td>");
		saida.print("<td>marca</td>");
		saida.print("<td>modelo</td>");
		saida.print("<td>ano</td>");
		saida.print("<td></td>");
		saida.print("<td></td>");
		saida.print("</tr>");
		
		for(Moto moto : motos) {
			saida.print("<tr>");
			saida.println("<td><a href='/motos/busca?id=" + moto.getId() + "'>" + moto.getId() + "</a></td>");
			saida.println("<td>" + moto.getMarca() + "</td>");
			saida.println("<td>" + moto.getModelo() + "</td>");
			saida.println("<td>" + moto.getAno() + "</td>");
			saida.println("<td><a href='/motos/deleta?id=" + moto.getId() + "'> deleta </a></td>");
			saida.println("<td><a href='/motos/preparaAtualiza?id=" + moto.getId() + "'> altera </a></td>");
			saida.print("</tr>");
		}
		
			saida.print("</table>");
			saida.print("<ul>");
		    saida.print("</body></html>");
		
		
		
		
		
		
		
		
		
		
		
	}

}
