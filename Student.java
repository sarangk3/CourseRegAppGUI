package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList <Registration> regList;    //list of course sections
	
	public Student  (String studentName, int studentId) {
		setStudentName (studentName);
		setStudentId (studentId);
		setRegList(new ArrayList <Registration>());
	}
	public void registerForCourse (CourseCat cat, String courseName, int courseNum, int section) {
		Course myCourse = cat.searchCat(courseName, courseNum);
		//Now the student needs to make sure the section exists. and if it does, register!
		//A student registers by:
		//Creating a registration object
		//and calling the 
		if (myCourse == null)
			return;
		
		Offering theOffering = myCourse.getOfferingList().get(section - 1);//must fix this!!
		//searchForSection();
		
		
		//ArrayList <Offering> theOfferingList = myCourse.getOfferingList();
		
		
		Registration reg = new Registration ();
		reg.register(this, theOffering);
		System.out.println("Registered.");
		
		int counter = 0;
		
		for (int i = 0; i < regList.size(); i++) {
			Registration r = regList.get(i);
			if (r.getTheOffering().equals(reg.getTheOffering()))  {
				counter = counter + 1;
			}
		}
		
		if (counter > 1) {
			System.out.println("Student already registered. 2nd Registration to be deregistered.");
			deregisterForCourse(cat, courseName, courseNum, section);
		}
		
		
		
		
	}

	public void deregisterForCourse (CourseCat cat, String courseName, int courseNum, int section) {
		Course myCourse = cat.searchCat(courseName, courseNum);
		if (myCourse == null)
			return;
		
		ArrayList <Offering> theOfferingList = myCourse.getOfferingList();
		
		Iterator <Registration> iter = regList.iterator();
		
		while (iter.hasNext()) {
			Registration r = iter.next();
			
			if (r.getTheOffering().getTheCourse().getCourseName().equals(courseName) &&
				r.getTheOffering().getTheCourse().getCourseNum() == courseNum &&
				r.getTheOffering().getSectionNum() == section) {
				iter.remove();
				r.deregister(this, r.getTheOffering());
				System.out.println("Deregistered.");
			}
			break;
		}
	}
	
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList <Registration> getRegList() {
		return regList;
	}

	public void setRegList(ArrayList <Registration> regList) {
		this.regList = regList;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		regList.add(registration);
		
	}
	
	public void removeRegistration(Registration registration) {
		regList.remove(registration);
	}
	
	@Override
	public String toString () {
		return studentName;
	}

}
