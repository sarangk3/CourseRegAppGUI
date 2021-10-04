package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.Course;

public class StudentCatalogueView extends JFrame {

		private JTextField sIdNum = new JTextField (10);
		private JTextField courseName = new JTextField (10);
		private JTextField courseNum = new JTextField (10);
		private JTextField courseSection = new JTextField (10);
		
		private JLabel sIdNumLabel = new JLabel ("Student ID:");
		private JLabel courseNameLabel = new JLabel ("Course Name: ");
		private JLabel courseNumLabel = new JLabel ("Course Number:");
		private JLabel courseSectionLabel = new JLabel ("Course Section:");
	
		public JButton option1 = new JButton ("Search Catalogue of Courses");
		public JButton option2 = new JButton ("Add course to Student Courses");
		public JButton option3 = new JButton ("Remove course from Student Courses");
		public JButton option4 = new JButton ("View all courses in Catalogue");
		public JButton option5 = new JButton ("View all courses taken by Student");
		public JButton option6 = new JButton ("Clear Text Area");
		public JButton option7 = new JButton ("Quit");
	
	
		
		public JTextArea area = new JTextArea(5,50);

		
		public StudentCatalogueView () {
			
			JPanel viewPanel = new JPanel();
			setSize (1000, 300);
			
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
		
		
		
		
		public void clearTextArea() {
			area.setText(null);
		}
		
		public String getCourseName () {
			return courseName.getText();
			//return Integer.parseInt(firstNumber.getText());
		}
		
		public int getStudentId() {
			return Integer.parseInt(sIdNum.getText());
		}
		
		
		public int getCourseNum() {
			return Integer.parseInt(courseNum.getText());
		}
		
		public int getSection() {
			return Integer.parseInt(courseSection.getText());
		}
		
	
		
		public void returnCourseList(ArrayList <Course> courseList) {
			for (int i =0; i<courseList.size(); i++) {
				area.append(courseList.get(i).getCourseName());
				area.append(" ");
				area.append(String.valueOf(courseList.get(i).getCourseNum()));
				area.append("\n");
			}
				
		}
}
