package petcafe;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("/replyControl")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReplyDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new ReplyDAO();
	}
	
	public List<Reply> list(int now_post_idx) {
		return(dao.getAll(now_post_idx));
	}
	
	public void insert(int now_post_idx, HttpServletRequest request, HttpServletResponse response) {
		Reply new_reply = new Reply();
		
		try {
			BeanUtils.populate(new_reply, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		new_reply.setMember_id((String)session.getAttribute("mem_id"));
		new_reply.setPost_idx(now_post_idx);
		
		boolean is_success = dao.insert(new_reply);
		if (is_success) {
		} else {
		}
		
		return;
	}
	
	public void delete(int now_reply_idx) {
		boolean is_success = dao.delete(now_reply_idx);
		
		if (is_success) {
		} else {
		}
		
		return;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyController() {
        super();
        dao = new ReplyDAO();
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
