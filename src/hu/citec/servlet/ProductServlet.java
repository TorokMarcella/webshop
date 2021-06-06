package hu.citec.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import hu.citec.config.TemplateEngineUtil;
import hu.citec.repository.Repository;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	
	private Repository repo;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
	
        engine.process("product.html", context, response.getWriter());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
//		System.out.println("N�v: " + request.getParameter("age"));
//		System.out.println("T�pus: " + request.getParameter("weight"));
//		System.out.println("�r: " + request.getParameter("height"));
		
		 TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
	     WebContext context = new WebContext(request, response, request.getServletContext());
	     
	     // kiszedj�k a requestb�l az elemeket, pl request.getParameter("weight")
	     // megh�vj�k a bmiService met�dus�t az �rt�kekkel
	     // a visszat�rt String-et k�lj�k vissza mint bmiResult objektum
	     context.setVariable("listByProducts", repo.listByProduct());

	     engine.process("product.html", context, response.getWriter());
	}

}
