package petcafe;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/memberControl")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new MemberDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if (request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/memberControl?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list":
				view = list(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			case "login":
				view = login(request, response);
				break;
			case "logout":
				view = logout(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("members", dao.getAll());
		return "/petcafe/tmp/member_db_test.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Member mem = new Member();
		
		try {
			BeanUtils.populate(mem, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		dao.insert(mem);
		return list(request, response);
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		Member login_input = new Member();
		String view = "";
		
		try {
			BeanUtils.populate(login_input, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean success = dao.login(login_input);
		if (!success) {
			// 로그인 오류 처리
			// 경고창을 띄우는 기능???
			view = "/petcafe/view/login.jsp";
		} else {
			// mem의 id와 name을 세션에 저장
			HttpSession session = request.getSession();
			
	
			String mem_id = login_input.getId();
			String mem_name = dao.getName(mem_id);
			
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("mem_name", mem_name);
			
			view = "/postControl?action=listByMain";
		}
		
		return view;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("mem_id");
		session.removeAttribute("mem_name");
		
		return "/postControl?action=listByMain";
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
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
