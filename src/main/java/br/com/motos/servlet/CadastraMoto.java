package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastra")
public class CadastraMoto extends HttpServlet {
	
	//String marca, String modelo, Integer ano
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		Integer ano = Integer.valueOf(req.getParameter("ano")); 
		
		Moto moto = new Moto(marca, modelo, ano);
		
		MotoDao motoDao = new MotoDao();
		motoDao.cadastra(moto);
		//System.out.println("Número de motos: " + motoDao.numeroDeMotos());
		
		
		PrintWriter saida = resp.getWriter();
		saida.print("<html>");
		saida.print("<body>");
		
		saida.print("Moto " + modelo + " cadastrada com sucesso!");
		saida.println("<br /><br />");
		saida.println("<a href='/motos/lista'>voltar</a>");
		
		saida.print("</body>");
		saida.print("</html>");
		
	}

}
