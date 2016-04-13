package zOrika;

import java.util.List;

public class PersonDTO {

	private NameDTO nom;
	private List<SubjectDTO> subjectList;
	
	public PersonDTO() {
		
	}

	public NameDTO getNom() {
		return nom;
	}

	public void setNom(NameDTO name) {
		this.nom = name;
	}

	public List<SubjectDTO> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectDTO> subjectList) {
		this.subjectList = subjectList;
	}
	
	
}
