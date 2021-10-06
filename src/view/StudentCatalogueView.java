package view;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import model.Course;
import model.Student;

//Main View Class that adds contents onto View Panel
public class StudentCatalogueView extends JFrame {
		//Create textField for all 
		private JTextField sIdNum = new JTextField (10);
		private JTextField courseName = new JTextField (10);
		private JTextField courseNum = new JTextField (10);
		private JTextField courseSection = new JTextField (10);
		
		private JLabel sIdNumLabel = new JLabel ("Student ID:");
		private JLabel courseNameLabel = new JLabel ("Course Name: ");
		private JLabel courseNumLabel = new JLabel ("Course Number:");
		private JLabel courseSectionLabel = new JLabel ("Course Section:");
		
		
	
		public JButton option1 = new JButton ("1. Search Catalogue of Courses");
		public JButton option2 = new JButton ("2. Add course to Student Courses");
		public JButton option3 = new JButton ("3. Remove course from Student Courses");
		public JButton option4 = new JButton ("4. View all courses in Catalogue");
		public JButton option5 = new JButton ("5. View all courses taken by Student");
		public JButton option6 = new JButton ("6. Clear Text Area");
		public JButton option7 = new JButton ("Quit");
	
	
		
		public JTextArea area = new JTextArea(5,50);

		
		public StudentCatalogueView () {

			
			addIntro(); //Loads intro panel in JTextArea

			JPanel viewPanel = new JPanel();
			setSize (1000, 400);
			
			
			viewPanel.add(sIdNumLabel);
			viewPanel.add(sIdNum);
			viewPanel.add(courseNameLabel);
			viewPanel.add(courseName);
			viewPanel.add(courseNumLabel);
			viewPanel.add(courseNum);
			viewPanel.add(courseSectionLabel);
			viewPanel.add(courseSection);
			viewPanel.add(courseSection);
			
			
			viewPanel.add(option1);
			viewPanel.add(option2);
			viewPanel.add(option3);
			viewPanel.add(option4);
			viewPanel.add(option5);
			viewPanel.add(option6);
			viewPanel.add(option7);
		
			
			viewPanel.add(area);
			
			add(viewPanel);	
}
		
		public void addActionListener (ActionListener listenForOption) {
			option1.addActionListener(listenForOption);
			option2.addActionListener(listenForOption);
			option3.addActionListener(listenForOption);
			option4.addActionListener(listenForOption);
			option5.addActionListener(listenForOption);
			option6.addActionListener(listenForOption);
			option7.addActionListener(listenForOption);
		}
		
			
		
	
		
		public void print(String textToPrint) {
			area.append(textToPrint);
		}
		
		public void printError() {
			area.append("Value entered does not exist! Please reenter.");	
		}
		
		
		public void addEndLine() {
			area.append("Press Button 6 if you would like to view Instruction Panel");
				
		}
		
	
		public void addIntro() {
			area.setText(
					"Student name and ID number: \n"
					+ "John, 1\n"
					+ "William, 2\n"
					+ "Jane, 3\n"
					+ "Christina, 4\n"
					+ "Please ensure following fields are field prior to button click\n"
					+ "1: Enter Course Name (will seach by Course Name ony)\n"
					+ "2: Enter Student ID,Course Name, Course Number & Section\n"
					+ "3: Enter Student ID,Course Name, Course Number & Section \n"
					+ "4: N/A\n"
					+ "5: Enter Student ID (searches by Student Id only)\n"
					+ "6: N/A");	
		}
		
		public void clearTextArea() {
			area.setText(null);
		}
		
		public String getCourseName () {	
			if (courseName.getText().isEmpty())
				return "";
			return courseName.getText();
			//return Integer.parseInt(firstNumber.getText());
		}
		
		public Integer getStudentId() {
			if (sIdNum.getText().isEmpty())
					return 0;
			return Integer.parseInt(sIdNum.getText());
		}
		
		
		public Integer getCourseNum() {	
			if (courseNum.getText().isEmpty())
				return 0;
			return Integer.parseInt(courseNum.getText());
		}
		
		public Integer getSection() {	
			if (courseSection.getText().isEmpty())
				return 0;
			return Integer.parseInt(courseSection.getText());
		}
		
	
		
		public void returnCourseList(ArrayList <Course> courseList) {
			for (int i =0; i<courseList.size(); i++) {
				area.append(courseList.get(i).getCourseName());
				area.append(" ");
				area.append(String.valueOf(courseList.get(i).getCourseNum()));
				area.append("\n");
				//area.append(String.valueOf(courseList.get(i).getOfferingList().get((getSection()-1))));
	
			}
		}

			public void returnStudentCourses(ArrayList <Course> courseList) {
				for (int i =0; i<courseList.size(); i++) {
					area.append(courseList.get(i).getCourseName());
					area.append(" ");
					area.append(String.valueOf(courseList.get(i).getCourseNum()));
					area.append("\n");
					area.append(String.valueOf(courseList.get(i).getOfferingList().get((getSection()-1))));
				}
				
			
		}
		

		
		
		
		
		
		
		
}
