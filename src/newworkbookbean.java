package workbook;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class newworkbookbean implements Serializable{
	private String title;
	private int No;
	private String problem;
	private String answer;
	private int score;
	private int totalscore;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}

	public static void insertData(newworkbookbean newworkbookBean) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("INSERT INTO newworkbook(No,title,problem,answer,score) VALUES(?,?,?,?,?)");
			st.setInt(1, newworkbookBean.getNo());
			st.setString(2, newworkbookBean.getTitle());
			st.setString(3, newworkbookBean.getProblem());
			st.setString(4, newworkbookBean.getAnswer());
			st.setInt(5, newworkbookBean.getScore());
			st.executeUpdate();
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean Checktitle(String title) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT title FROM newworkbook group by title");
			while (rs.next()) {
				if (title.equals(rs.getString("title"))) {
					check = true;
				}
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	public static ArrayList<newworkbookbean> selecttitle(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<newworkbookbean> titlelist = new ArrayList<newworkbookbean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT title FROM newworkbook group by title");
			while(rs.next()) {
				newworkbookbean newworkbookBean = new newworkbookbean();
				newworkbookBean.setTitle(rs.getString("title"));
				titlelist.add(newworkbookBean);
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return titlelist;
	}

	public static ArrayList<newworkbookbean> selectproblem(String title){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<newworkbookbean> problemlist = new ArrayList<newworkbookbean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("SELECT problem FROM newworkbook where title=?");
			st.setString(1, title);
			rs = st.executeQuery();
			while(rs.next()) {
				newworkbookbean newworkbookBean = new newworkbookbean();
				newworkbookBean.setProblem(rs.getString("problem"));
				problemlist.add(newworkbookBean);
			}
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return problemlist;
	}

	public static ArrayList<newworkbookbean> selectanswer(String title){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<newworkbookbean> newworkbooklist = new ArrayList<newworkbookbean>();
		try {
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("select No, answer, score from newworkbook where title=?");
			st.setString(1, title);
			rs = st.executeQuery();
			while(rs.next()) {
				newworkbookbean workbookbean = new newworkbookbean();
				workbookbean.setNo(rs.getInt("No"));
				workbookbean.setAnswer(rs.getString("answer"));
				workbookbean.setScore(rs.getInt("score"));
				newworkbooklist.add(workbookbean);
			}

			if(newworkbooklist.size()<50) {
				int No = newworkbooklist.size()+1;
				String answer = "";
				int score = 0;
				for(int i = newworkbooklist.size()+1; i <= 50; i++) {
					newworkbookbean workbookbean = new newworkbookbean();
					workbookbean.setNo(No);
					workbookbean.setAnswer(answer);
					workbookbean.setScore(score);
					newworkbooklist.add(workbookbean);
				}
			}

			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newworkbooklist;
	}

	public static void deletelist(String title) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = new ResourceFinder().getConnectionpuser();
				st = conn.prepareStatement("DELETE FROM newworkbook where title = ?");
				st.setString(1, title);
				st.executeUpdate();
				st.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
