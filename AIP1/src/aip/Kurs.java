package aip;

import java.util.HashSet;
import java.util.Set;

public class Kurs {
	private long kursId;
	private String titel;
	private Student student;
	private Set<Buch> buecher;

	public Kurs() {
	}

	public Kurs(String titel) {
		this.titel = titel;
	}

	public Set<Buch> getBuecher() {
		return buecher;
	}

	public void setBuecher(Set<Buch> buecher) {
		this.buecher = buecher;
	}

	public long getKursId() {
		return kursId;
	}

	public void setKursId(long kursId) {
		this.kursId = kursId;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void addStudent(Student student) {
		if (this.student == null) {
			student.addKurs(this);
		}
	}

	public void addBuch(Buch buch) {
		if (this.buecher == null) {
			this.buecher = new HashSet<Buch>();
		}
		if (this.buecher.add(buch)) {
			buch.addKurs(this);
		}
	}

	public void removeBuch(Buch buch) {
		if (this.buecher != null) {
			if (this.buecher.remove(buch)) {
				buch.removeKurs(this);
			}
		}
	}

	public void removeStudent(Student student) {
		if (this.student != null) {
			this.student = null;
			student.removeKurs(this);
		}
	}
}
