package hu.citec.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hu.citec.config.TemplateEngineUtil;
import hu.citec.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private User user;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
	
        String parameter = request.getParameter("wrong");
        engine.process("login.html", context, response.getWriter());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("username");
		String userPass = request.getParameter("password");
		
		String redirectUrl;
		
		if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPass)) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userName);
			session.setMaxInactiveInterval(10);
			
			redirectUrl = "/HarmadikBlokkzaro/index";
		} else {
			redirectUrl = "/HarmadikBlokkzaro/login?wrong=" + true;
		}
		
		response.sendRedirect(redirectUrl);
		
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
		WebContext context = new WebContext(request, response, request.getServletContext());

	     engine.process("login.html", context, response.getWriter());
	}
}