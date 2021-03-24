/*
    Class that holds the data for a multiple choice question
 */
package jiwaniwangprojectmanagement;

import java.util.Arrays;

public class MCQuestion {
    //declare attributes of the MCQuestion
    private String question, correct;
    private String[] answers;
    
    /**
     * Primary constructor - accept new values for all attributes of a MCQuestion
     * @param question - the question
     * @param correct - the correct answer
     * @param answers - an array containing possible answers
     */
    public MCQuestion (String question, String correct, String[] answers) {
        //set the question and answer to the parameter
        this.question = question; 
        this.answers = answers;
        //take away "Correct_Answer: " from the string
        this.correct = correct.substring(16);
    }
    
    /**
     * Getter method for the MC question 
     * @return the MC question
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * Getter method for the possible MC answers 
     * @return the possible MC answers
     */
    public String[] getAnswers() {
        return answers;
    }
    
    /**
     * Getter method for the correct answer 
     * @return the correct answer
     */
    public String getCorrect() {
        return correct;
    }

    //NO SETTER METHODS, QUESTIONS/ANSWERS SHOULD BE CHANGED IN DATA FILES
    
    /**
     * Clone method- create new MC Question with same attributes
     * @return new MC Question with same attributes
     */
    public MCQuestion clone() {
        MCQuestion q = new MCQuestion(question, correct, answers);
        return q;
    }
    
    /**
     * Equals method - check if another MC question is equal to the question in this class
     * @param q - the other MC question to check
     * @return true or false depending on if the question is equal
     */
    public boolean equals(MCQuestion q) {
        //if all attributes have values
        if (this.question!=null && this.correct!=null && this.answers!=null) {
            //return true
            return this.question.equals(q.question) && Arrays.equals(this.answers, q.answers) && this.correct.equals(q.correct);
        } 
        //if both questions are null
        return false;
        
    }
    
    public String toString() {
        //string to hold all answers
        String ans = "";
        //iterate through answers and add them together
        for (int i = 0; i < answers.length; i++) {
            if (i != answers.length-1) {
                ans += answers[i] + "\n";
            } else {
                //don't add a newline on last line
                ans += answers[i];
            }
        }
        return "Question: " + question + "\nAnswers: " + ans + "\nCorrect Answer: " + correct;
    }
}
