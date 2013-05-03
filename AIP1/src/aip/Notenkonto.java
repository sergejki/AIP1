package aip;

public class Notenkonto {
	private double gesamtnote;
	private long studentId;
	private Student student;

	public Notenkonto() {

	}

	public Notenkonto(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}

	public double getGesamtnote() {
		return gesamtnote;
	}

	public void setGesamtnote(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void addStudent(Student student) {
		if (this.student == null) {
			this.student = student;
			student.setNotenkonto(this);
		}
	}
}
