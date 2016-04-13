package zOrika;

import java.util.List;

public class Person {

	private Name nom;
	private List<Subject> subjectList;
	
	public Person() {
		
	}

	public Name getNom() {
		return nom;
	}

	public void setNom(Name nom) {
		this.nom = nom;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
}
