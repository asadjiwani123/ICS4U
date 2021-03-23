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
            String question, answer;
            while (fSc.hasNextLine()) {
                question = fSc.nextLine();
                answer = fSc.nextLine();
                Flashcard temp = new Flashcard(question, answer);
                cards.add(temp);
            }
            String qQuestion, correct, tempAns;
            String[]tempArr;
            while(qSc.hasNextLine()) {
                tempAns = "";
                ArrayList<String> answers = new ArrayList<>();
  
                qQuestion = qSc.nextLine();
                tempAns = qSc.nextLine();
                tempArr = tempAns.split(" ");
                if (tempArr.length >2) {
                    while (!tempArr[0].equals("Correct") && !tempArr[1].equals("Answer:")) {
                        answers.add(tempAns);
                        if (qSc.hasNextLine()) {
                            tempAns = qSc.nextLine(); 
                            tempArr = tempAns.split(" ");
                        }
                    }
                }
                correct = tempAns;
                String[] sAnswers = answers.toArray(new String[answers.size()]);
                MCQuestion q = new MCQuestion(qQuestion, correct, sAnswers);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
        for (int i = 0; i < quiz.length; i++) {
            System.out.println("");
        }
        
        int option;
        option = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?\n1. Look at study notes"
                + "\n2. Do a multiple choice quiz\n3. Exit"));
        while (option!= -1) {
            if (option == 1) {
                JOptionPane.showMessageDialog(null, "For all the flashcards, hit the spacebar to show the answer for the question, and enter 'esc' to exit");
                
                
                
                
            } else if (option==2) {
                
            }
            
            
            
            option = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?\n1. Look at study notes"
                + "\n2. Do a multiple choice quiz\n3. Exit"));
        }
        
        
        
    }
}
