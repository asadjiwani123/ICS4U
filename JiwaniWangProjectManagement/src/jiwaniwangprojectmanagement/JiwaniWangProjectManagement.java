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
    
    //create global variable
    //make two array lists, one for quiz and one for flashcards
    static  ArrayList<MCQuestion> quiz = new ArrayList();
    static ArrayList<Flashcard> cards = new ArrayList();
    
    public static void main(String[] args){
        //create a variable which will be used to determine when to end a loop
        boolean end = false;
        try {
            //set up connection to data files
            //create two scanner to read input from data files
            File fFile = new File ("src\\jiwaniwangprojectmanagement\\flashcards.txt");
            File qFile = new File ("src\\jiwaniwangprojectmanagement\\quiz.txt");
            Scanner fSc = new Scanner(fFile);
            Scanner qSc = new Scanner(qFile);
            //declare variables for the field in data file
            String question, answer;
            //hile the flashcard data file has data
            while (fSc.hasNextLine()) {
                //read in question from data file
                question = fSc.nextLine();
                //read in answer from data file
                answer = fSc.nextLine();
                //create a new flashcard object using question and answer
                Flashcard temp = new Flashcard(question, answer);
                //add flashcard object to the flashcard array
                cards.add(temp);
            }
            //declare variables for the fields in second data file
            String qQuestion, correct, tempAns;
            //initialize the tempans variable to blank
            tempAns = "";
            //initialize the correct variable to blank
            correct = "";    
            //create an array for the correct answers
            String[]tempArr;
            //while the quiz data file has data
            while(qSc.hasNextLine()) {
                
                //create an array list of answers
                ArrayList<String> answers = new ArrayList<>();
  
                //read in question from data file
                qQuestion = qSc.nextLine();
                //read in choice from data file
                tempAns = qSc.nextLine();
                //split the choice read in from data file by a space
                //assign the split answer to the correct answers array
                tempArr = tempAns.split(" ");
                //if the length of the answers array is greater than 2
//                if (tempArr.length >2) {
                    //the correct answer will always start with "Correct Answer: "
                    //repeat until we get to it
                    while (!tempArr[0].equals("Correct_Answer:")) {
                        //add the choice read in from data file to the array list of answers
                        answers.add(tempAns);
                        //if the data file has more data
                        if (qSc.hasNextLine()) {
                            //read in choice from data file
                            tempAns = qSc.nextLine(); 
                            //split the choice read in from data file by a space
                            //assign the split answer to the correct answers array
                            tempArr = tempAns.split(" ");
                        }
                    }
//                }
                //assign the choice from data file as the correct answer
                correct = tempAns;
                //create an Array that contains the choice of answers
                String[] sAnswers = answers.toArray(new String[answers.size()]);
                //create a new MCQuestion object by using the question, the correct answer, and the choice of answers
                MCQuestion q = new MCQuestion(qQuestion, correct, sAnswers);
                //add that question to the quiz
                quiz.add(q);
            }
        } catch (FileNotFoundException e) { //if file not found
            System.out.println(e);
        }
        
        for (int i = 0; i < quiz.size(); i++) { //loop through the quiz array list
            System.out.println(quiz.get(i)); //print out a blank line
        }
        
        int option; //create variable for the user's option in main menu
        
        //while the user does not choose to exit
//        loops:
        while (end == false) {
            //ask user what thy would like to do
            option = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?\n1. Look at flashcards"
                + "\n2. Do a multiple choice quiz\n3. Exit"));
            
            quizLoop:
            //if the user chose to do a quiz
            if (option == 2) {
                ArrayList<Integer> finishedQ = new ArrayList();
                int rand, ans, numCorrect;
                String qQuestion, qCorrect, ask, sAns;
                String[] qAnswers;
                numCorrect = 0;
                ans = 0;
                while (finishedQ.size() < quiz.size()) {
                    rand = (int) (Math.random() * quiz.size());
                    if (!finishedQ.contains(rand)) {
                        finishedQ.add(rand);
                        qQuestion = quiz.get(rand).getQuestion();
                        qAnswers = quiz.get(rand).getAnswers();
                        qCorrect = quiz.get(rand).getCorrect();
                        ask = qQuestion + "\n";
                        for (int i = 0; i < qAnswers.length; i++) {
                            ask += (i+1) + ": " + qAnswers[i] + "\n";
                        }
                        String output = "Current Score: " + numCorrect + "/" + (finishedQ.size()-1) + " (" + quiz.size() + " questions total)\n" + ask + "\nInput which question you think is right (by number)\nTYPE x or q TO EXIT";
                        sAns = JOptionPane.showInputDialog(null, output);
                        if (sAns.toLowerCase().equals("x")||sAns.toLowerCase().equals("q")) {
                            JOptionPane.showMessageDialog(null, "Congrats! You got " + numCorrect + "/" + (finishedQ.size()-1 )+ " right!");
                            break quizLoop;
                        }
                        while (sAns.equals("") || !sAns.matches("[0-9]+") || Integer.parseInt(sAns) > qAnswers.length) {
                            sAns = JOptionPane.showInputDialog(null, "PLEASE INPUT A VALID ANSWER\n\n" + output);
                        }
                        ans = Integer.parseInt(sAns);
                        
                        if (qAnswers[ans-1].equals(qCorrect)) {
                            numCorrect++;
                            JOptionPane.showMessageDialog(null,"You were right!");
                        } else {
                            JOptionPane.showMessageDialog(null,"You were wrong :(");
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Congrats! You got " + numCorrect + "/" + quiz.size() + " right!");
            }
            //if the user chose to do the flashcards
            else if (option == 1) {
                String flashcardChoice = null; //create variable for the user's option in submenu

                for (int i = 0; i < cards.size(); i++) { //loop through the array list containing the flash cards
                    //show user flashcard and ask user what they would like to do with flashcard
                    flashcardChoice = JOptionPane.showInputDialog("Type 'b' to go to the previous flashcard. Type 'f' to "
                        + "see the answer for the current flashcard. Type 'n' for the next flashcard."
                        + "\nType x or q to escape\n" + cards.get(i).getQuestion()).toLowerCase();
                    //if the user chose to see the answer for the flashcard
                    if (flashcardChoice.equals("f")) {
                        //get the answer for the current flashcard and display it
                        JOptionPane.showMessageDialog(null, cards.get(i).getAnswer());
                    //if the user chose to go to the previous flashcard
                    } else if (flashcardChoice.equals("b")){
                        if (i - 2 >= 0){ //check to see if there are previous questions
                            i = i - 2; //if there are, then go to the previous flashcard y subtracting 2 from the i val
                        }else{ //if there are not previous questions
                            i = i; //do nothing
                        }
                    } else if (flashcardChoice.toLowerCase().equals("n")){ //if the user chose to view the next flashcard
                        i = i;//do nothing
                    } else if (flashcardChoice.equals("x") || flashcardChoice.equals("q")) {
                        break;
                    } else{ //if the user entered an incorrect option, error check user input
                        JOptionPane.showMessageDialog(null, "Error: Enter appropriate option"); //tell user to select proper option
                    }
                }
            } else if (option == 3){ //if the user chose to exit
                JOptionPane.showMessageDialog(null, "Goodbye!"); //end program
                end = true; //set the end variable to true in order to end the while loop
            }else{ //if the user entered an incorrec toption, error check user input
                JOptionPane.showMessageDialog(null, "Error: Enter appropriate option"); //tell user to select proper option
            }
        }
        
        
        
    }
}
