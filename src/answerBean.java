package workbook;

import java.io.Serializable;

public class answerBean implements Serializable {
	private int answer_id;
	private String answer;

	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
