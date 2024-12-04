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
			view = listByMain(request, response);
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
			case "edit":
				view = edit(request, response);
				break;
			case "editPost":
				view = editPost(request, response);
				break;
			case "delete":
				view = delete(request, response);
				break;
			case "insertReply":
				view = insertReply(request, response);
				break;
			case "deleteReply":
				view = deleteReply(option, request, response);
				break;
			case "addBookmark":
				view = addBookmark(request, response);
				break;
			case "deleteBookmark":
				view = deleteBookmark(request, response);
				break;
			case "addLike_it":
				view = addLike_it(request, response);
				break;
			case "deleteLike_it":
				view = deleteLike_it(request, response);
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
		
		boolean is_success = dao.insert(new_post);
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
		HttpSession session = request.getSession();
		String now_mem_id = (String)session.getAttribute("mem_id");
		
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
		request.setAttribute("now_post_img", "");
		
		// 좋아요 수
		Like_itController like_itCont = new Like_itController();
		request.setAttribute("is_like_it_checked", like_itCont.isChecked(idx_int, now_mem_id));
		request.setAttribute("like_it_count", like_itCont.count(idx_int));
		
		// 북마크 수
		BookmarkController bookmarkCont = new BookmarkController();
		request.setAttribute("is_bookmark_checked", bookmarkCont.isChecked(idx_int, now_mem_id));
		request.setAttribute("bookmark_count", bookmarkCont.count(idx_int));
		
		// 댓글 표시
		ReplyController replyCont = new ReplyController();
		request.setAttribute("replys", replyCont.list(idx_int));
		
		session.setAttribute("now_post_idx", idx_int);
		
		request.setAttribute("post", post);
		return "view/post_view.jsp";
	}
	
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		Post ori_post = dao.getByPostIdx(post_idx);
		request.setAttribute("ori_post", ori_post);
		
		return "view/post_edit.jsp";
	}
	
	public String editPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		
		Post new_post = new Post();
		
		try {
			BeanUtils.populate(new_post, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean is_success = dao.update(post_idx, new_post);
		if (is_success) {
			String pb = new_post.getPostboard();
			return listByPostboard(pb, request, response);
		} else {
			request.setAttribute("ori_post", new_post);
			return "view/post_edit.jsp";
		}
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");

		boolean is_success = dao.delete(post_idx);
		if (is_success) {
			return listByMain(request, response);
		} else {
			String idx_str = Integer.toString(post_idx);
			return viewPost(idx_str, request, response);
		}
	}
	
	public String insertReply(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		
		ReplyController replyCont = new ReplyController();
	
		replyCont.insert(post_idx, request, response);
		
		String idx_str = Integer.toString(post_idx);
		return viewPost(idx_str, request, response);
	}
	
	public String deleteReply(String now_reply_idx_str, HttpServletRequest request, HttpServletResponse response) {
		int reply_idx_int = Integer.parseInt(now_reply_idx_str);
		ReplyController replyCont = new ReplyController();
		replyCont.delete(reply_idx_int);
		
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		String post_idx_str = Integer.toString(post_idx);
		return viewPost(post_idx_str, request, response);
	}
	
	public String addBookmark(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		String member_id = (String)session.getAttribute("mem_id");
		
		BookmarkController bookmarkCont = new BookmarkController();
		bookmarkCont.insert(post_idx, member_id);
		
		String post_idx_str = Integer.toString(post_idx);
		return viewPost(post_idx_str, request, response);
	}
	
	public String deleteBookmark(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		String member_id = (String)session.getAttribute("mem_id");
		
		BookmarkController bookmarkCont = new BookmarkController();
		bookmarkCont.delete(post_idx, member_id);
		
		String post_idx_str = Integer.toString(post_idx);
		return viewPost(post_idx_str, request, response);
	}
	
	public String addLike_it(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		String member_id = (String)session.getAttribute("mem_id");
		
		Like_itController like_itCont = new Like_itController();
		like_itCont.insert(post_idx, member_id);
		
		String post_idx_str = Integer.toString(post_idx);
		return viewPost(post_idx_str, request, response);
	}
	
	public String deleteLike_it(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int post_idx = (int)session.getAttribute("now_post_idx");
		String member_id = (String)session.getAttribute("mem_id");
		
		Like_itController like_itCont = new Like_itController();
		like_itCont.delete(post_idx, member_id);
		
		String post_idx_str = Integer.toString(post_idx);
		return viewPost(post_idx_str, request, response);
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
