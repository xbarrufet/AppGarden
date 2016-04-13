package zOrika;

import java.util.ArrayList;
import java.util.List;

public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NameDTO name=new NameDTO();
		name.setName("Xavi");
		name.setSurname("Barrufet");

		PersonDTO person = new PersonDTO();
		person.setNom(name);
		
		SubjectDTO s1 = new SubjectDTO();
		SubjectDTO s2 = new SubjectDTO();
		List<SubjectDTO> slist = new ArrayList<SubjectDTO>();
		
		s1.setSubjectID(1);
		s2.setSubjectID(2);
		s1.setSubjectName("mates");
		s2.setSubjectName("medi");
		
		
	}

}
