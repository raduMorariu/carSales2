package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.UserBean;
import entities.UserDAO;
import services.TransactionManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
			TransactionManager transMng = new TransactionManager();
			
			try{
				transMng.beginTransaction();
				
				UserDAO userDAO = new UserDAO();
				UserBean userFromDB = userDAO.getUserByUsername(UserBean.getUsername());
				UserBean newUser = new UserBean();
				newUser.setUsername(request.getParameter("un"));
				newUser.setPassword(request.getParameter("ps"));

				if (userFromDB == null) {
					System.out.println("User does not exist. Start registering");
					userDAO.userRegister(newUser);
					transMng.commit();
//					return true;
				} else {
					System.out.println("User already in DB!");
					transMng.rollback();
//					return false;
				}		
			} catch (Exception e){
				transMng.rollback();
				System.out.println(e.getMessage());
//				return false;
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
