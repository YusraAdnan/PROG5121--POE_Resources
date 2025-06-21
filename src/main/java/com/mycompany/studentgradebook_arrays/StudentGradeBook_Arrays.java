package com.mycompany.studentgradebook_arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author yusra
 */
public class StudentGradeBook_Arrays {

    public static void main(String[] args) {
        
        //parallel arrays
        final int MAX_LENGTH = 12;
        String[] namesArray = new String[MAX_LENGTH];
        String[] emailsArray = new String[MAX_LENGTH];
        double[] yearAveragesArray = new double[MAX_LENGTH];
        String[] studentNumbersArray = new String[MAX_LENGTH];
       
        // Assign first 4 values manually in the array (hardcoded)
        namesArray[0] = "Tinky";
        namesArray[1] = "John";
        namesArray[2] = "Peter";
        namesArray[3] = "Loren";

        emailsArray[0] = "Tinkyl@email.com";
        emailsArray[1] = "John@email.com";
        emailsArray[2] = "Peter@email.com";
        emailsArray[3] = "Loren@gmail.com";

        yearAveragesArray[0] = 75.2;
        yearAveragesArray[1] = 82.5;
        yearAveragesArray[2] = 68.9;
        yearAveragesArray[3] = 90.0;

        //generate student numbers for every student
        for (int i = 0; i < namesArray.length; i++)
        {
          studentNumbersArray[i] = generateStudentNumber();
        }
        
        boolean userWantsToContinue = true;
        int currentStudentCount = 4;//tracks how many students are currently stored

        while(userWantsToContinue == true)
        {
            String choice = JOptionPane.showInputDialog(
            "Hi! What would you like to do?\n" +
            "1 - Add a new student\n" +
            "2 - Search for a student\n" +
            "3 - Show all students\n" +
            "4 - Exit the program"
        );
        switch (choice) 
        {
            case "1":

                // Ask user how many students they want to add
                String input = JOptionPane.showInputDialog("How many new students to add? You can add Max " + (MAX_LENGTH - currentStudentCount));
                int newStudents = Integer.parseInt(input);

                //prompt user to enter information for the number of student entered by the user  
                for (int i = currentStudentCount; i < currentStudentCount + newStudents && i < MAX_LENGTH; i++) 
                {
                    namesArray[i] = JOptionPane.showInputDialog("Enter name for student" + (i + 1));
                    emailsArray[i] = JOptionPane.showInputDialog("Enter email for student" + (i + 1));
                    String avgStr = JOptionPane.showInputDialog("Enter year average for student" + (i + 1));
                    yearAveragesArray[i] = Double.parseDouble(avgStr);
                    studentNumbersArray[i] = generateStudentNumber();
                }
                //updates the already existing count of elements in the array with the new count of studnets user entered
                //keeps track of the length of the array. 
                currentStudentCount += newStudents;
                break;
            case "2":
                //prompt the user to enter name by which they want to search details by
                String search = JOptionPane.showInputDialog("To find details of a student, Enter the Student Name:");
                //pass the searched name to the method and the actual arrays that have actual data to the method
                searchByStudentName(search, namesArray, studentNumbersArray, emailsArray, yearAveragesArray);
                break;
            case "3":
                // Print all student details
                printAllStudents(namesArray, studentNumbersArray, emailsArray, yearAveragesArray);
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Thanks for using the app! Goodbye!");
                userWantsToContinue = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 4.");
        }
        
        }
      
    }

    // Method to generate unique ID
    public static String generateStudentNumber() 
    {
        String stNumber = "";
         for (int i = 0; i < 5; i++) 
         {
             int digit = (int)(Math.random() * 10); // generates digit between 0–9
             stNumber += digit;
         }

         return stNumber;
     }
        // Method to print all students in a neat format
    public static void printAllStudents(String[] names, String[] studentNumbers, String[] emails, double[] yearAverages)
    {
       String allStudents = "Student Book:\n\n";
        for (int i = 0; i < names.length; i++) 
        {
            if(names[i] != null && !names[i].isEmpty())
            allStudents = allStudents
                    + "Name: " + names[i] + "\n"
                    + "Student Number: " + studentNumbers[i] + "\n"
                    + "Email: " + emails[i] + "\n"
                    + "Year Average: " + yearAverages[i] + "\n"
                    + "---------------------------\n";
        }
        JOptionPane.showMessageDialog(null, allStudents, "All Students", JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    //Method takes in the name the user entered when prompted to, method is also passwed with the populated arrays
    public static void searchByStudentName(String searchedName, String[] name,  String[] studentNumber, String[] emails, double[] yearAverage)
    {
        for (int i = 0; i < name.length; i++)
        {
            //if the searched name is found in the names array store the index and find the related information for that student by using the index
            if(name[i].equalsIgnoreCase(searchedName))
            {
                String details = "Name: " + name[i] +
                     "\nStudent Number: " + studentNumber[i] +
                     "\nEmail: " + emails[i] +
                     "\nYear Average: " + yearAverage[i];
                JOptionPane.showMessageDialog(null, details, "Student Found", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        
        }
    
    }
}
