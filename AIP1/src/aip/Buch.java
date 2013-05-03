package aip;

import java.util.HashSet;
import java.util.Set;

public class Buch {
	private long buchId;
	private String titel;
	private Set<Kurs> kurse;
	
	public Buch() {}
	
	public Buch(String titel) {
		this.titel = titel;
	}
	
	public long getBuchId() {
		return buchId;
	}
	public void setBuchId(long buchId) {
		this.buchId = buchId;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Set<Kurs> getKurse() {
		return kurse;
	}
	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}
	
	public void addKurs(Kurs kurs) {
		if (this.kurse == null) {
			this.kurse = new HashSet<Kurs>();
		}
		if(this.kurse.add(kurs)) {
			kurs.addBuch(this);
		}
	}

	public void removeKurs(Kurs kurs) {
		if (this.kurse != null) {
			if (this.kurse.remove(kurs)) {
				kurs.removeBuch(this);
			}
		}
	}
}
