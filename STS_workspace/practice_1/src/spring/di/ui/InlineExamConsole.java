package spring.di.ui;

import spring.di.Exam;

public class InlineExamConsole implements ExamConsole {
	private Exam exam;
	public InlineExamConsole() {}
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}
	@Override
	public void print() {
		System.out.println("inline �޼���");
		System.out.printf("total is %d, avg is %f\n",exam.total() , exam.avg());
	}
}
