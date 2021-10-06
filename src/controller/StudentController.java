package controller;

import view.StudentCatalogueView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Course;
//import CalculatorController.CalculateListener;
import model.CourseCat;
import model.Offering;
import model.Student;

public class StudentController {
	
	StudentCatalogueView theView;
	CourseCat theCourseCatModel;
	ArrayList <Student> studentModel;

	

	public StudentController (StudentCatalogueView theView) {
		
		this.theView = theView;
		theCourseCatModel = new CourseCat();
		theView.addActionListener(new StudentListener ());
		studentModel= populateStudentModel();
	}
	
	
		public ArrayList <Student> populateStudentModel() {
			ArrayList <Student> studentModel = new ArrayList <Student>();	
			
			Student st1 = new Student ("John", 1);
			Student st2 = new Student ("William", 2);		
			Student st3 = new Student ("Jane", 3);
			Student st4 = new Student ("Christina", 4);
			
			studentModel.add(st1);
			studentModel.add(st2);
			studentModel.add(st3);
			studentModel.add(st4);
			
			return studentModel;
		
		}
	
		
	class StudentListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
	
			//Register student for course
			if (e.getSource() == theView.option2) {
				theView.clearTextArea();
				
				int studentId, courseNum, section;
				String courseName;
				
				studentId = theView.getStudentId();
				courseName = theView.getCourseName();
				courseNum = theView.getCourseNum();
				section = theView.getSection();

				if (checkStudentId(studentId)==false)
				{
					theView.print("Please Enter Student ID\n");
				}
				
				if (checkCourseName(courseName)==false)
				{
					theView.print("Please Enter Course Name\n");
				}
				if (checkCourseNum(courseNum)==false)
				{
					theView.print("Please Enter Course Number\n");
				}
				
				if (checkCourseSection(section)==false)
				{
					theView.print("Please Enter Course Section\n");
				}
				
				if (checkStudentId(studentId)==false || checkCourseName(courseName)==false || checkCourseNum(courseNum)==false || 
				   (checkCourseSection(section)==false)) {
					theView.print("Registration Unsuccessful\n");
					theView.addEndLine();
				}
				else {
					studentModel.get(studentId-1).registerForCourse(theCourseCatModel,courseName, courseNum, section);
					theView.print("Successfully Registered!\n");
				}
				
			}
			
			
			
			//Deregister student for course
			if (e.getSource() == theView.option3) {
				theView.clearTextArea();
				
				Integer studentId, courseNum, section;
				String courseName;
				studentId = theView.getStudentId();
				courseName = theView.getCourseName();
				courseNum = theView.getCourseNum();
				section = theView.getSection();
				
				if (checkStudentId(studentId)==false)
				{
					theView.print("Please Enter Student ID\n");
				}
				
				if (checkCourseName(courseName)==false)
				{
					theView.print("Please Enter Course Name\n");
				}
				if (checkCourseNum(courseNum)==false)
				{
					theView.print("Please Enter Course Number\n");
				}
				
				if (checkCourseSection(section)==false)
				{
					theView.print("Please Enter Course Section\n");
				}
				
				if (checkStudentId(studentId)==false || checkCourseName(courseName)==false || checkCourseNum(courseNum)==false || 
				   (checkCourseSection(section)==false)) {
					theView.print("Deregistration Unsuccessful\n");
					theView.addEndLine();
				}
				else {
				studentModel.get(studentId-1).deregisterForCourse(theCourseCatModel,courseName, courseNum, section);
				theView.print("Successfully Deregistered!\n");
				theView.addEndLine();
				}
			}
			
			
			//View all courses taken by student
			if (e.getSource() == theView.option5) {
				theView.clearTextArea();
				int studentId;
				ArrayList <Course> courseList = new ArrayList<Course>();
				ArrayList <Offering> offeringList = new ArrayList<Offering>();
				studentId = theView.getStudentId();
				
				for (int i = 0; i < studentModel.get(studentId-1).getRegList().size(); i++) 
					//courseList.add(studentModel.get(studentId-1).getRegList().get(i).getTheOffering());
					courseList.add(studentModel.get(studentId-1).getRegList().get(i).getTheOffering().getTheCourse());
			
				if (courseList.size()==0)
					theView.print("No courses Registered\n");
				
				//theView.returnOfferingList(offeringList);
				theView.returnStudentCourses(courseList); //View calls for the coureseList
				theView.addEndLine();
	
			}
			
		
	}
		
		
		
		
		
		

		private boolean checkStudentId(int studentId) {
			
			boolean found = false;
			for (Student s : studentModel) {
				if (studentId == s.getStudentId()) {
					found = true;
					break; }
			}
			return found;
	
		}
	
		private boolean checkCourseName(String courseName) {
		
			boolean found = false;
			for (int i=0;i < theCourseCatModel.getCourseList().size();i++) {
				if (courseName.equals(theCourseCatModel.getCourseList().get(i).getCourseName())) {
					found=true;	
					break;
				}
			}
			
			return found;
			
		}
		
		
		
		private boolean checkCourseNum(int courseNum) {		
		boolean found = false;
			for (int i=0;i < theCourseCatModel.getCourseList().size();i++) {
				if (courseNum == theCourseCatModel.getCourseList().get(i).getCourseNum()) {
					found = true;
					break;
				}
			}
			
			return found;
			
		}
		//Iterate through all sections and output error if user entered incorrect value 
		private boolean checkCourseSection(int section) {
		boolean found = false;
		for (int i=0;i < theCourseCatModel.getCourseList().get(i).getOfferingList().size();i++) {
			if (section == theCourseCatModel.getCourseList().get(i).getOfferingList().get(i).getSectionNum()){
				found = true;
				break;
			}
		}
		
		return found;
		
		}
}
}
