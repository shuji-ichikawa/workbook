package workbook;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class newworkbook_Controller
 */
@WebServlet("/newworkbook_Controller")
public class newworkbook_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newworkbook_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int pattern = Integer.parseInt(request.getParameter("pattern"));
		String title = (String)session.getAttribute("title");
		int No = (int)session.getAttribute("No");
		int score = (int)session.getAttribute("score");
		int totalscore = (int)session.getAttribute("totalscore");
		String path = null;

		if(pattern == 1) {
			path = "/jsp/newworkbook_registerdone.jsp";
		}
		if(pattern == 2) {
			newworkbookbean.deletelist(title);
			path = "/jsp/toppage.jsp";
		}
		if(pattern == 3) {
			session.setAttribute("No", No);
			session.setAttribute("score", score);
			session.setAttribute("totalscore", totalscore);
			path = "/jsp/newworkbook2.jsp";
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
		String path = null;
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		newworkbookbean newworkbookBean = new newworkbookbean();
		String title = request.getParameter("title");
		int No = Integer.parseInt(request.getParameter("No"));
		System.out.println(No);
		String problem = request.getParameter("problem");
		String answer = request.getParameter("answer");
		String score = request.getParameter("score");
		int totalscore = Integer.parseInt(request.getParameter("totalscore"));

		Pattern p1 = Pattern.compile("^([0-9]{1,2})$");
		Matcher m1 = p1.matcher(score);

        boolean check = false;

        if(No == 1) {
            if(newworkbookbean.Checktitle(title)) {
    			String msgtitle1 = "・既に作成済みのタイトルです。";
    			request.setAttribute("msgtitle1", msgtitle1);
    			check = true;
            }
            if(title.length() == 0) {
    			String msgtitle2 = "・タイトルが入力されていません。";
    			request.setAttribute("msgtitle2", msgtitle2);
    			check = true;
            }
            if(title.length() > 50) {
    			String msgtitle3 = "・50文字以内で入力してください。";
    			request.setAttribute("msgtitle3", msgtitle3);
    			check = true;
            }
        }
        if(problem.length() == 0) {
			String msgproblem1 = "・問題文が入力されていません。";
			request.setAttribute("msgproblem1", msgproblem1);
			check = true;
        }
        if(problem.length() > 2000) {
			String msgproblem2 = "・2000文字以内で入力してください。";
			request.setAttribute("msgproblem2", msgproblem2);
			check = true;
        }
		if(answer == null || answer.equals("")) {
			String msganswer = "・答えが選択されていません。";
			request.setAttribute("msganswer", msganswer);
			check = true;
		}
		if(!(m1.find())){
			String msgscore = "・半角数字1～2桁で入力してください。";
			request.setAttribute("msgscore", msgscore);
			check = true;
		}
		if(check) {
			if(No == 1) {
				path = "/jsp/newworkbook.jsp";
			}else {
				path = "/jsp/newworkbook2.jsp";
			}
		}else if(No < 50){
			newworkbookBean.setTitle(title);
			newworkbookBean.setNo(No);
			newworkbookBean.setProblem(problem);
			newworkbookBean.setAnswer(answer);
			newworkbookBean.setScore(Integer.parseInt(score));
			newworkbookBean.setTotalscore(totalscore);
			newworkbookbean.insertData(newworkbookBean);
			session.setAttribute("title", title);
			session.setAttribute("No", No+1);
			session.setAttribute("score", Integer.parseInt(score));
			session.setAttribute("totalscore", totalscore);
			path = "/jsp/newworkbook2.jsp";
		}else {
			newworkbookBean.setTitle(title);
			newworkbookBean.setNo(No);
			newworkbookBean.setProblem(problem);
			newworkbookBean.setAnswer(answer);
			newworkbookBean.setScore(Integer.parseInt(score));
			newworkbookBean.setTotalscore(totalscore);
			newworkbookbean.insertData(newworkbookBean);
			session.setAttribute("title", title);
			session.setAttribute("No", No+1);
			session.setAttribute("score", Integer.parseInt(score));
			session.setAttribute("totalscore", totalscore);
			path = "/jsp/newworkbook3.jsp";
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
