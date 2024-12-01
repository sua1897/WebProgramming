package petcafe;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/postControl")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new PostDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String pb = request.getParameter("postboard");
		String view = "";
		
		if (request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/postControl?action=list&postboard=all").forward(request, response);
		} else {
			switch(action) {
			case "list":
				view = list(pb, request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/petcafe/"+view).forward(request, response);
		}
	}
	
	public String list(String pb, HttpServletRequest request, HttpServletResponse response) {
		// request.setAttribute("posts", dao.getAll(pb));
		
		HttpSession session = request.getSession();
		session.setAttribute("now_pb", pb);
		
		return "view/postboard_view.jsp";
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
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
