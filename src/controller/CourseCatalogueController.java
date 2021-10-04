package controller;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Course;
import model.CourseCat;

import view.StudentCatalogueView;

public class CourseCatalogueController {

	private CourseCat CourseCat;
	private StudentCatalogueView theView;
	
	public CourseCatalogueController(StudentCatalogueView theView, CourseCat theCourseCatModel) {
		this.CourseCat =theCourseCatModel;
		this.theView = theView;
		
		theView.addActionListener(new CourseCatListener ());
	}

	
	class CourseCatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.option1) {
				String courseName;
				ArrayList <Course> courseList = new ArrayList<Course>();
				courseName = theView.getCourseName();
				courseList = CourseCat.searchCat(courseName); //returns Arraylist
				theView.returnCourseList(courseList); //View calls for the coureseList
			}
			
			
			if(e.getSource() == theView.option4) {
				ArrayList <Course> courseList = new ArrayList<Course>();
				courseList = CourseCat.getCourseList(); //returns Arraylist
				theView.returnCourseList(courseList); //View calls for the coureseList
			}
			
			//Clears the JTextArea
			if(e.getSource() == theView.option6) { 
				theView.clearTextArea();
			}
			
			//Exits the program.
			if(e.getSource() == theView.option7) { 
				System.exit(0);
			}
			
		
		
}
	}
}
