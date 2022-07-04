package spring.di.ui;

import spring.di.Exam;

public class GridExamConsole implements ExamConsole {
	private Exam exam;
	
	public GridExamConsole() {}
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	@Override
	public void print() {
		System.out.println("grid ¸Þ¼­µå");
		System.out.printf("total is %d, avg is %f\n",exam.total() , exam.avg());
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
