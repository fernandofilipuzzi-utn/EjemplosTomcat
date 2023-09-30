

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductoSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductoSrvlt() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.getWriter().println( "<html>");
		response.getWriter().println( "<body>");
		response.getWriter().println( "<p>nombre: "+request.getParameter("nombre")+"</p>");
		response.getWriter().println( "<p>comando a ejecutar: "+request.getParameter("comando")+"</p>");
		response.getWriter().println( "<p>[<a href=\"productos.html\">Volver a la página anterior]</a></p>");
		response.getWriter().println( "</body>");
		response.getWriter().println( "</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}


