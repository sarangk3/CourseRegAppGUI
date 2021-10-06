package app;

import view.StudentCatalogueView;
import model.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.CourseCatalogueController;
import controller.StudentController;
import model.CourseCat;


public class App {

	public static void main(String[] args) {
		StudentCatalogueView theView = new StudentCatalogueView();
		CourseCat theCourseCatModel = new CourseCat();
		
		
		CourseCatalogueController ccController = new CourseCatalogueController(theView, theCourseCatModel);
		StudentController sController = new StudentController(theView);
		
	
		theView.setVisible(true);
	}

		
}
