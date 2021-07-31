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
 * Servlet implementation class workbook_Controller
 */
@WebServlet("/workbook_Controller")
public class workbook_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public workbook_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			ArrayList<String> answerlist = new ArrayList<String>();
			String title = request.getParameter("title");
			int No = Integer.parseInt(request.getParameter("No"));

			newworkbookbean newworkbookBean = new newworkbookbean();
			ArrayList<newworkbookbean> problemlist = newworkbookbean.selectproblem(title);
			newworkbookBean.setTitle(title);
			newworkbookBean.setNo(No);
			session.setAttribute("title", title);
			session.setAttribute("No", No);
			session.setAttribute("problemlist", problemlist);

			for(int i=0; i<=50; i++) {
				String answer = "";
				answerlist.add(answer);
			}
			session.setAttribute("answerlist", answerlist);

		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/workbook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path= null;
		try{
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();

			if(Integer.parseInt(request.getParameter("No"))==50) {
				int No = Integer.parseInt(request.getParameter("No"));
				String title = request.getParameter("title");
				String answer = request.getParameter("answer");
				ArrayList<String> answerlist = (ArrayList<String>)session.getAttribute("answerlist");
				ArrayList<newworkbookbean> problemlist = (ArrayList<newworkbookbean>)session.getAttribute("problemlist");
				answerlist.set(No, answer);
				session.setAttribute("answerlist", answerlist);
				newworkbookbean newworkbookBean = new newworkbookbean();
				newworkbookBean.setTitle(title);
				newworkbookBean.setNo(No);
				newworkbookBean.setAnswer(answer);
				session.setAttribute("title", title);
				session.setAttribute("No", No);
				session.setAttribute("problemlist", problemlist);
				path="/jsp/workbook.jsp";

			}else {
				int No = Integer.parseInt(request.getParameter("No"))+1;
				String title = request.getParameter("title");
				String answer = request.getParameter("answer");
				ArrayList<String> answerlist = (ArrayList<String>)session.getAttribute("answerlist");
				ArrayList<newworkbookbean> newworkbooklist = (ArrayList<newworkbookbean>)session.getAttribute("newworkbooklist");
				ArrayList<newworkbookbean> problemlist = (ArrayList<newworkbookbean>)session.getAttribute("problemlist");
				answerlist.set(No-1, answer);
				session.setAttribute("answerlist", answerlist);
				newworkbookbean newworkbookBean = new newworkbookbean();
				newworkbookBean.setTitle(title);
				newworkbookBean.setNo(No);
				newworkbookBean.setAnswer(answer);

				session.setAttribute("title", title);
				session.setAttribute("No", No);
				session.setAttribute("problemlist", problemlist);
				if(No-1>=problemlist.size()) {
					path="/jsp/workbooknone.jsp";
				}else {
					path="/jsp/workbook.jsp";
				}
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
