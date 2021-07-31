package workbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class workbook_move_Controller
 */
@WebServlet("/workbook_move_Controller")
public class workbook_move_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public workbook_move_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path= null;
		try{
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			int No = Integer.parseInt(request.getParameter("No"));
			String title = request.getParameter("title");
			ArrayList<String> answerlist = (ArrayList<String>)session.getAttribute("answerlist");
			session.setAttribute("answerlist", answerlist);

			newworkbookbean newworkbookBean = new newworkbookbean();
			ArrayList<newworkbookbean> newworkbooklist = (ArrayList<newworkbookbean>)session.getAttribute("newworkbooklist");
			session.setAttribute("newworkbooklist", newworkbooklist);

			newworkbookBean.setTitle(title);
			newworkbookBean.setNo(No);
			ArrayList<newworkbookbean> problemlist = newworkbookbean.selectproblem(title);
			session.setAttribute("title", title);
			session.setAttribute("No", No);
			session.setAttribute("problemlist", problemlist);

			if(No-1>=problemlist.size()) {
				path="/jsp/workbooknone.jsp";
			}else {
				path="/jsp/workbook.jsp";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
