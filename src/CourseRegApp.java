
import java.util.ArrayList;
import java.util.Scanner;


//This is my "FrontEnd!"
public class CourseRegApp {
	
	public static void main (String [] args) {
		
		CourseCat cat = new CourseCat ();  //This loads the courses from our "DB"
		
		//Course myCourse1 = cat.searchCat("ENSF", 592);
		//if (myCourse1 != null) {
		//	cat.createOffering(myCourse1, 1, 40);
		//	cat.createOffering(myCourse1, 2, 40);
		//}
		
		//Course myCourse2 = cat.searchCat("ENSF", 593);
		//if (myCourse2 != null) {
		//	cat.createOffering(myCourse2, 1, 40);
		//	cat.createOffering(myCourse2, 2, 40);
		//}
		
		//Course myCourse3 = cat.searchCat("ENSF", 594);
		//if (myCourse3 != null) {
		//	cat.createOffering(myCourse3, 1, 40);
		//	cat.createOffering(myCourse3, 2, 40);
		//}
		
		Student st1 = new Student ("Sara", 1);
		Student st2 = new Student ("Joe", 2);
		Student st3 = new Student ("Bob", 3);
		Student st4 = new Student ("Lisa", 4);
		
		//st1.registerForCourse(cat, "ENSF", 607, 1);
		//st1.registerForCourse(cat, "ENSF", 593, 1);
		//st1.registerForCourse(cat, "ENSF", 594, 1);
		
		ArrayList <Student> students = new ArrayList <Student> ();
		
		students.add(st1);
		students.add(st2);
		students.add(st3);
		students.add(st4);
		
		String menu_Options = ("Please choose an integer from 1 to 6 which corresponds to the following menu options" + "\n"
				+ "1. Search catalogue courses" + "\n" 
				+ "2. Add Course to student courses" + "\n"
				+ "3. Remove course from student courses" + "\n"
				+ "4. View all courses in catalogue" + "\n"
				+ "5. View all courses taken by student" + "\n"
				+ "6. Quit"
				);
		
		System.out.println(menu_Options);
		Scanner input = new Scanner (System.in);
		int userChoice;
		
		do
		{
			userChoice = input.nextInt();
			switch (userChoice) {
				case 1:
					System.out.println("Please enter a course name (i.e. ENSF)");
					String userCourseSearch = input.next();
					cat.printCourses(userCourseSearch);
					System.out.println(menu_Options);
					break;
				case 2:
					for (Student st: students) {
						System.out.println(st.getStudentName() + " " + st.getStudentId());
					}
					System.out.println("Select student by entering their ID (1, 2, 3, 4)");
					int userStudent2 = input.nextInt();
					Student student2 = null;
					if (userStudent2 == 1) {
						student2 = st1;
					}
					else if (userStudent2 == 2) {
						student2 = st2;
					}
					else if (userStudent2 == 3) {
						student2 = st3;
					}
					else if (userStudent2 == 4) {
						student2 = st4;
					}
					if (student2.getRegList().size() >= 6) {
						System.out.println("Student has already registered for 6 courses.");
					} 
					else if (student2.getRegList().size() < 6) {
						System.out.println("Please enter course name (i.e. ENSF)");
						String courseName = input.next();
						System.out.println("Please enter course number (i.e. 607)");
						int courseNumber = input.nextInt();
						System.out.println("Please enter section number (i.e. 1)");
						int sectionNumber = input.nextInt();
						student2.registerForCourse(cat, courseName, courseNumber, sectionNumber);
					}
					System.out.println(menu_Options);
					break;
				case 3:
					for (Student st: students) {
						System.out.println(st.getStudentName() + " " + st.getStudentId());
					}
					System.out.println("Select student by entering their ID (1, 2, 3, 4)");
					int userStudent3 = input.nextInt();
					Student student3 = null;
					if (userStudent3 == 1) {
						student3 = st1;
					}
					else if (userStudent3 == 2) {
						student3 = st2;
					}
					else if (userStudent3 == 3) {
						student3 = st3;
					}
					else if (userStudent3 == 4) {
						student3 = st4;
					}
					System.out.println("Please enter course name (i.e. ENSF)");
					String courseName = input.next();
					System.out.println("Please enter course number (i.e. 607)");
					int courseNumber = input.nextInt();
					System.out.println("Please enter section number (i.e. 1)");
					int sectionNumber = input.nextInt();
					student3.deregisterForCourse(cat, courseName, courseNumber, sectionNumber);
					System.out.println(menu_Options);
					break;
				case 4:
					System.out.println(cat);
					System.out.println(menu_Options);
					break;
				case 5:
					for (Student st: students) {
						System.out.println(st.getStudentName() + " " + st.getStudentId());
					}
					System.out.println("Select student by entering their ID (1, 2, 3, 4)");
					int userStudent5 = input.nextInt();
					Student student5 = null;
					if (userStudent5 == 1) {
						student5 = st1;
					}
					else if (userStudent5 == 2) {
						student5 = st2;
					}
					else if (userStudent5 == 3) {
						student5 = st3;
					}
					else if (userStudent5 == 4) {
						student5 = st4;
					}
					for (int i = 0; i < student5.getRegList().size(); i++) {
						System.out.println(student5.getRegList().get(i).getTheOffering().getTheCourse());
					}
					System.out.println(menu_Options);
					break;
				case 6:
					break;
				
			}
			
		} while (userChoice < 6);
		
		
		
		
		//Course myCourse = cat.searchCat("ENGG", 233);
		//if (myCourse != null) {
		//	cat.createOffering(myCourse, 1, 200);
		//	cat.createOffering(myCourse, 2, 150);
		//}
	    
		//st1.registerForCourse(cat, "ENGG", 233, 1);
		
		//System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
		
		//System.out.println(myCourse.getOfferingList().get(0).getStudentList().get(0).getTheStudent().getStudentName());
	}

}
