package controller;

import view.StudentCatalogueView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Course;
//import CalculatorController.CalculateListener;
import model.CourseCat;
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
			
			Student st1 = new Student ("Sara", 1);
			Student st2 = new Student ("Joe", 2);		
			Student st3 = new Student ("Bob", 3);
			Student st4 = new Student ("Lisa", 4);
			
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
				
				int studentId, courseNum, section;
				String courseName;
				studentId = theView.getStudentId();
				courseName = theView.getCourseName();
				courseNum = theView.getCourseNum();
				section = theView.getSection();

				studentModel.get(studentId-1).registerForCourse(theCourseCatModel,courseName, courseNum, section);
			}
			
			
			//Deregister student for course
			if (e.getSource() == theView.option3) {
				
			int studentId, courseNum, section;
			String courseName;
			studentId = theView.getStudentId();
			courseName = theView.getCourseName();
			courseNum = theView.getCourseNum();
			section = theView.getSection();

			studentModel.get(studentId-1).deregisterForCourse(theCourseCatModel,courseName, courseNum, section);
		}
			
			
			//View all courses taken by student
			if (e.getSource() == theView.option5) {
				int studentId;
				ArrayList <Course> courseList = new ArrayList<Course>();
				studentId = theView.getStudentId();
				
				for (int i = 0; i < studentModel.get(studentId-1).getRegList().size(); i++) 
					courseList.add(studentModel.get(studentId-1).getRegList().get(i).getTheOffering().getTheCourse());
			
				theView.returnCourseList(courseList); //View calls for the coureseList
			
			
	
			}
	}
	

	
	}
}
