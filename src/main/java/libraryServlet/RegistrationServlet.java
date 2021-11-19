package libraryServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String cid = request.getParameter("college id");
		String cname = request.getParameter("uname");
		String cpass = request.getParameter("pass");
		
		LibUserInput inp = new LibUserInput(cid,cname,cpass);
		LibDatabase db = new LibDatabase();
		try {
			db.getConnection();
			db.createDatabase();
			
			db.createAuthtable();
			db.insertAuth(inp);
		}catch (SQLException e) {
			System.out.println("servlet problem");
		}
		
		 // It sets the content in html 
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		out.print("<html>"
				+"<head>"
				+"<style>"
				+ "div {"
				+ "  background-color: #F8F8FF;"
				+ "  width: 840px;"
				+ "  height: 350px;"
				+ "  border: 10px solid 	#191970;"
				+ "  padding: 100px;"
				+ "  margin-left: 300px;"
				+ "  margin-right: 300px;"
				+ "  margin-top: 80px;"
				+ "  margin-bottom: 20px;"
				+ "}"
				+ "</style>"
				+"<title>"
				+"Address"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<div>"
				+"<p><center><font size = 2000px; color = #8B4513><h2>You are now registered user...</h2></font>"
				+"<h2>Welcome "+cname+"</h2></center></p>"
				+"<h2 align = 'center'><a href = 'Login.jsp'>Please Sign in again to proceed!!</a></h2>"
				+"</div>"
				+"</body>"
				+"</html>");
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
		 

