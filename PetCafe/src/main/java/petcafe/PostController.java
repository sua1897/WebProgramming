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
		String option = request.getParameter("option");
		String view = "";
		
		if (request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/postControl?action=listByMain").forward(request, response);
		} else {
			switch(action) {
			case "listByPb":
				view = listByPostboard(option, request, response);
				break;
			case "listByBk":
				view = listByBookmark(request, response);
				break;
			case "listByMain":
				view = listByMain(request, response);
				break;
			case "search":
				view = search(request, response);
				break;
			case "postView":
				view = viewPost(option, request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/petcafe/"+view).forward(request, response);
		}
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Post new_post = new Post();
		
		try {
			BeanUtils.populate(new_post, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		new_post.setMember_id((String)session.getAttribute("mem_id"));
		
		/* 서버에 이미지 업로드하는 코드 필요 */
		boolean is_success = dao.insert_image(new_post);
		if (!is_success ) {
			return "view/post_write.jsp";
		}
		
		is_success = dao.insert(new_post);
		if (is_success) {
			String pb = new_post.getPostboard();
			return listByPostboard(pb, request, response);
		} else {
			return "view/post_write.jsp";
		}
	}
	
	public String listByPostboard(String pb, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		boolean is_member = false;
		String mem_id = (String)session.getAttribute("mem_id");
		if (mem_id != null) {
			is_member = true;
		}
		
		request.setAttribute("posts", dao.getByPostboard(pb, is_member));
		session.setAttribute("now_pb", pb);
		
		return "view/postboard_view.jsp";
	}
	
	public String listByBookmark(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		request.setAttribute("posts", dao.getByBookmark(mem_id));
		session.setAttribute("now_pb", "bookmark");
		
		return "view/postboard_view.jsp";
	}
	
	public String listByMain(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		boolean is_member = false;
		String mem_id = (String)session.getAttribute("mem_id");
		if (mem_id != null) {
			is_member = true;
		}
		
		request.setAttribute("posts_free", dao.getByPostboard("free", is_member));
		request.setAttribute("posts_ask", dao.getByPostboard("ask", is_member));
		
		session.setAttribute("now_pb", "");
		
		return "view/mainpage.jsp";
	}
	
	public String search(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String now_pb = (String)session.getAttribute("now_pb");
		
		String view = "/postControl?action=listByMain";
		
		String search_option = request.getParameter("search_option");
		String search_text = request.getParameter("search_text");
		
		switch(search_option) {
		case "title":
			view = searchByTitle(search_text, now_pb, request, response);
			break;
		case "body":
			view = searchByBody(search_text, now_pb, request, response);
			break;
		case "writer":
			view = searchByWriter(search_text, now_pb, request, response);
			break;
		}
		
		return view;
	}
	
	
	public String searchByTitle(String title, String pb, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		boolean is_member = false;
		String mem_id = (String)session.getAttribute("mem_id");
		if (mem_id != null) {
			is_member = true;
		}
		
		request.setAttribute("posts", dao.searchByTitle(title, pb, is_member));
		
		return "view/postboard_view.jsp";
		
	}
	
	public String searchByBody(String body, String pb, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		boolean is_member = false;
		String mem_id = (String)session.getAttribute("mem_id");
		if (mem_id != null) {
			is_member = true;
		}
		
		request.setAttribute("posts", dao.searchByBody(body, pb, is_member));
		
		return "view/postboard_view.jsp";
		
	}
	
	public String searchByWriter(String writer_name, String pb, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		boolean is_member = false;
		String mem_id = (String)session.getAttribute("mem_id");
		if (mem_id != null) {
			is_member = true;
		}
		
		request.setAttribute("posts", dao.searchByWriter(writer_name, pb, is_member));
		
		return "view/postboard_view.jsp";
		
	}
	
	public String viewPost(String idx_str, HttpServletRequest request, HttpServletResponse response) {
		int idx_int = Integer.parseInt(idx_str);
		
		// post 기본 정보
		Post post = dao.getByPostIdx(idx_int);
		
		// postboard 한글이름
		post.setPostboard_kr();
		
		// 작성자 아이디
		String writer_id = post.getMember_id();
		request.setAttribute("now_post_writer_id", writer_id);
		
		// 작성자 이름
		MemberDAO mem_dao = new MemberDAO();
		String writer_name = mem_dao.getName(writer_id);
		post.setMember_name(writer_name);
		
		// 첨부 이미지
		/*
		String img_str = post.getImage();
		if (img_str == null) {
			img_str = "";
		}
		request.setAttribute("now_post_img", img_str);
		*/
		request.setAttribute("now_post_img", "");
		
		// 좋아요 수
		
		// 북마크 수
		
		request.setAttribute("post", post);
		return "view/post_view.jsp";
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
