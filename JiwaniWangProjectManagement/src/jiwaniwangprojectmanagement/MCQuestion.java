/*
    Class that holds the data for a multiple choice question
 */
package jiwaniwangprojectmanagement;

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
        //create boolean variable
        boolean flag = false;
        //loop through the possible answers array
        for (int i = 0; i < answers.length; i++) {
            if (correct.equals(answers[i])) { //if the possible answer at the current i value is the same as the correct answer
                flag = true; //set flag to true
                break;
            }
        } //if flag equals true
        if (flag) {
            this.correct = correct; //set correct answer to the answer
        } else {//if flag is false
            correct = "_ERROR"; //set the correct answer to an error message
        }
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
            return this.question.equals(q.question) && this.answers.equals(q.answers) && this.correct.equals(q.correct);
        } else {
            //might cause an error when something is null
            return false;
        }
    }
}
