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
 * Servlet implementation class Like_itkController
 */
@WebServlet("/like_itControl")
public class Like_itController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Like_itDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new Like_itDAO();
	}
	
	public int count(int now_post_idx) {
		return (dao.count(now_post_idx));
	}
	
	public void insert(int now_post_idx, String now_member_id) {
		boolean is_success = dao.insert(now_post_idx, now_member_id);
		if (is_success) {
		} else {
		}
		
		return;
	}
	
	public void delete(int now_post_idx, String now_member_id) {
		boolean is_success = dao.delete(now_post_idx, now_member_id);
		
		if (is_success) {
		} else {
		}
		
		return;
	}
	
	public boolean isChecked(int now_post_idx, String now_member_id) {
		return dao.isChecked(now_post_idx, now_member_id);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Like_itController() {
        super();
        dao = new Like_itDAO();
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
