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
 * Servlet implementation class workbook_result_Controller
 */
@WebServlet("/workbook_result_Controller")
public class workbook_result_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public workbook_result_Controller() {
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
			String title = request.getParameter("title");
			ArrayList<String> answerlist = (ArrayList<String>)session.getAttribute("answerlist");
			ArrayList<newworkbookbean> newworkbooklist = newworkbookbean.selectanswer(title);
			session.setAttribute("title", title);
			session.setAttribute("newworkbooklist", newworkbooklist);
			session.setAttribute("answerlist", answerlist);

			String judg;
			ArrayList<String> judglist = new ArrayList<String>();
			int totalscore = 0;
			for(int i = 0; i <= 49; i++) {
				if(answerlist.get(i+1).equals("")) {
					judg = "×";
					judglist.add(judg);
				}else if(answerlist.get(i+1).equals(newworkbooklist.get(i).getAnswer())) {
					judg = "○";
					judglist.add(judg);
					totalscore += newworkbooklist.get(i).getScore();
				}else if(!(answerlist.get(i+1).equals(newworkbooklist.get(i).getAnswer()))) {
					judg = "×";
					judglist.add(judg);
				}
				session.setAttribute("judglist", judglist);
			}
			session.setAttribute("totalscore", totalscore);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/workbookresult.jsp");
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
