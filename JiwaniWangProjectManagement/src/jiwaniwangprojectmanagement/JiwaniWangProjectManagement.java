/*
Asad Jiwani and Edward Wang
March 23rd, 2021
You will be creating a Java program which will help your sister study for her SDLC test.
Your system must include points to study from, as well as a multiple choice quiz 
(10 questions) for practice, which will be automatically graded and feedback given.
 */
package jiwaniwangprojectmanagement;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class JiwaniWangProjectManagement {
    
    static  ArrayList<MCQuestion> quiz = new ArrayList();
    static ArrayList<Flashcard> cards = new ArrayList();
    
    public static void main(String[] args){
        
        try {
            File fFile = new File ("src\\jiwaniwangprojectmanagement\\flashcards.txt");
            File qFile = new File ("src\\jiwaniwangprojectmanagement\\quiz.txt");
            Scanner fSc = new Scanner(fFile);
            Scanner qSc = new Scanner(qFile);
            while (fSc.hasNextLine()) {
                String question, answer;
                boolean reverse;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
        int option;
        option = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?\n1. Look at study notes"
                + "\n2. Do a multiple choice quiz\n3. Exit"));
        
        if (option == 1) {
            JOptionPane.showMessageDialog(null, "For all the flashcards, hit the spacebar to show the answer for the question, and enter 'esc' to exit");
            
        }
    }
}
