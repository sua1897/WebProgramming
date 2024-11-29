package petcafe;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class PostboardController
 */
@WebServlet("/postboardControl")
public class PostboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostboardDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new PostboardDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if (request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/postboardControl?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list":
				view = list(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/petcafe/"+view).forward(request, response);
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("postboards", dao.getAll());
		return "postboard_db_view_test.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Postboard pb = new Postboard();
		
		try {
			BeanUtils.populate(pb, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		dao.insert(pb);
		return list(request, response);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
