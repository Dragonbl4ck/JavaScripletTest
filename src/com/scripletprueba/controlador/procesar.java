package com.scripletprueba.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scripletprueba.modelo.Usuario;

/**
 * Servlet implementation class procesar
 */
@WebServlet("/procesar")
public class procesar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procesar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nombre = request.getParameter("txtNombre");
		String edad = request.getParameter("txtEdad");
		
		if(nombre.equals("")||edad.equals("")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('User or password incorrect');");
//			out.println("location='index.jsp';");
//			out.println("</script>");
			out.println("Rellena ambos campos!!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else {
			try {
			int ed = Integer.parseInt(edad);
			
			Usuario usuario = new Usuario(nombre,ed);
			
			request.setAttribute("personal", usuario);
			
			RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
			rd.include(request, response);
			}catch(NumberFormatException e){
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Ingresa solo numeros enteros en el campo de edad");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
