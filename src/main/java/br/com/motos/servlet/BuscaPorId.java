package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/busca")
public class BuscaPorId extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Moto moto = new MotoDao().buscaPor(Integer.valueOf(req.getParameter("id")));
		
		PrintWriter saida = resp.getWriter();
		saida.print("");
		saida.print("<html><body>");
		saida.print("<b>Marca: </b> " + moto.getMarca() + "<br />");
		saida.print("<b>Modelo: </b> " + moto.getModelo() + "<br />");
		saida.print("<b>Ano: </b> " + moto.getAno() + "<br />");
		
		saida.print("<a href='/motos/lista'>voltar</a>");
		
		saida.print("</html></body>");
	}

}
