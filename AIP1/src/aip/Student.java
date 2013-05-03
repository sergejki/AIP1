package aip;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private long studentId;
	private String name;
	private Notenkonto notenkonto;
	private Set<Kurs> kurse;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Notenkonto getNotenkonto() {
		return notenkonto;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotenkonto(Notenkonto notenkonto) {
		this.notenkonto = notenkonto;
	}

	public void addNotenkonto(Notenkonto notenkonto) {
		if (this.notenkonto == null) {
			this.notenkonto = notenkonto;
			notenkonto.setStudent(this);
		}
	}

	public Set<Kurs> getKurse() {
		return kurse;
	}

	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}

	public void addKurs(Kurs kurs) {
		if (kurs.getStudent() == null) {
			if (this.kurse == null) {
				this.kurse = new HashSet<Kurs>();
			}
			if (this.kurse.add(kurs)) {
				kurs.setStudent(this);
			}
		}
	}
	
	public void removeKurs(Kurs kurs) {
		if (this.kurse != null) {
			if (this.kurse.remove(kurs)) {
				kurs.removeStudent(this);
			}
		}
	}

}
