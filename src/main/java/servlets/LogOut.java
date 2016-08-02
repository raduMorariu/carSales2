package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.UserBean;
import entities.UserDAO;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			UserBean user = new UserBean();
			//user.setUsername(request.getParameter("un"));
			//
			user.setPassword(request.getParameter("pw"));
			if (user.isValid()) {
				Cookie[] cookies = request.getCookies();
				for (Cookie c: cookies) {
					if ("loggedUser".equals(c.getName())){
						c.setMaxAge(0);
						response.addCookie(c);
						response.sendRedirect("logOut.jsp");
					} else {
						response.sendRedirect("invalidLogin.jsp");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
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
