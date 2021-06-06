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
    
//		System.out.println("Név: " + request.getParameter("age"));
//		System.out.println("Típus: " + request.getParameter("weight"));
//		System.out.println("Ár: " + request.getParameter("height"));
		
		 TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
	     WebContext context = new WebContext(request, response, request.getServletContext());
	     
	     // kiszedjük a requestbõl az elemeket, pl request.getParameter("weight")
	     // meghívjük a bmiService metódusát az értékekkel
	     // a visszatért String-et küljük vissza mint bmiResult objektum
	     context.setVariable("listByProducts", repo.listByProduct());

	     engine.process("product.html", context, response.getWriter());
	}

}
