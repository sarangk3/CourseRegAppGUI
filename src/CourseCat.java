


import java.util.ArrayList;

public class CourseCat {
	
	private ArrayList <Course> courseList;
	
	public CourseCat () {
		courseList = loadFromDB ();
	}

	private static ArrayList<Course> loadFromDB() {
		//In real life course would be loaded for the database or at least some sort of file
		//on disk. 
		
		//So imagine this is being loaded from the database!
		
		ArrayList <Course> imaginaryDB = new ArrayList <Course> ();
		
		imaginaryDB.add(new Course ("ENSF", 607));
		imaginaryDB.add(new Course ("ENSF", 608));
		imaginaryDB.add(new Course ("ENSF", 611));
		imaginaryDB.add(new Course ("ENSF", 612));
		imaginaryDB.add(new Course ("ENSF", 614));
		imaginaryDB.add(new Course ("ENEL", 645));
		imaginaryDB.add(new Course ("ENGG", 683));
		imaginaryDB.add(new Course ("ENSF", 609));
		imaginaryDB.add(new Course ("ENSF", 610));
		imaginaryDB.add(new Course ("SENG", 641));
		
		for (Course c: imaginaryDB) {
			ArrayList <Course> preReq = new ArrayList <Course> ();
			preReq.add(new Course("ENSF", 592));
			preReq.add(new Course("ENSF", 593));
			preReq.add(new Course("ENSF", 594));
			c.setPreReq(preReq);
		}
		
		for (Course c: imaginaryDB) {
			
			createOffering(c, 1, 40);  
			createOffering(c, 2, 40); 
		}
		
		
		
		return imaginaryDB;
	}
	public ArrayList <Course> searchCat (String courseName) {
		ArrayList <Course> foundCourses = new ArrayList <Course>();
		//search for courses that their name matches courseName and add to the 
		//foundCourses array
		for (Course c: courseList) {
			if (courseName.equals(c.getCourseName())) {
				foundCourses.add(c);
			}
		}
		
		return foundCourses;
	}
	
	public void printCourses (String courseName) {
		ArrayList <Course> foundCourses = new ArrayList <Course>();
		//search for courses that their name matches courseName and add to the 
		//foundCourses array
		for (Course c: courseList) {
			if (courseName.equals(c.getCourseName())) {
				foundCourses.add(c);
			}
		}
		for (Course c: foundCourses) {
			System.out.println(c.getCourseName() + " " + c.getCourseNum());
		}
		
	}
	
	public Course searchCat (String courseName, int courseNum) {
		for (Course c: courseList) {
			if (c.getCourseNum() == courseNum && c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		System.err.println("Course " + courseName + " " + courseNum + " does NOT exist!");
		return null;
	}
	
	
	
	public static void createOffering (Course theCourse, int secNum, int secCap) { 
		if (theCourse != null) {
			Offering theOffering = new Offering (secNum, secCap);
			theOffering.setTheCourse(theCourse);   //I set theCourse object reference in the Course
			theCourse.addOffering(theOffering);
	
		}
	}

	public ArrayList <Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	
	@Override
	public String toString() {
		String temp = "";
		for (Course c: courseList)
			temp += c;
		return temp;
	}

}
