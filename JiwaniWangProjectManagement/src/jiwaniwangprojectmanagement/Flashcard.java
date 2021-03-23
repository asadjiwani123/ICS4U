/*
    Class that represents a flash card
 */
package jiwaniwangprojectmanagement;

public class Flashcard {
    private String question, answer;
    private boolean reverse;
    
    /**
     * instantiate flashcard without reverse
     * @param question - the question to ask
     * @param answer - the answer to the question
     */
    public Flashcard (String question, String answer) {
        this.question = question;
        this.answer = answer;
        reverse = false;
    }
    
    /**
     * instantiate flashcard with explicit reverse or not
     * @param question - the question to ask
     * @param answer - the answer to the question
     * @param reverse - whether they will be displayed in reverse or not
     */
    public Flashcard (String question, String answer, boolean reverse) {
        this(question, answer);
        this.reverse = reverse;
    }
    
    /**
     * Getter method for the question on flashcard
     * @return the question on the flashcard
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * Getter method for the answer on flashcard
     * @return the answer on the flashcard
     */
    public String getAnswer() {
        return answer;
    }
    
    /**
     * Getter method to check if the flashcard is reversed (you see answer and you have to come up with question)
     * @return true or false depending on if flashcard is reversed
     */
    public boolean getReverse() {
        return reverse;
    }
    
    /**
     * Set the reversed value of flashcard
     * @param newReverse - the reversed value of flashcard
     */
    public void setReverse(boolean newReverse) {
        reverse = newReverse;
    }
    
    /**
     * Clone method- create new flashcard with same attributes as this one
     * @return new flashcard with same attributes
     */
    public Flashcard clone () {
        Flashcard f2 = new Flashcard(question, answer, reverse);
        return f2;
    }
    /**
     * Equals method - check if another flashcard is equal to flashcard in this class
     * @param f - the other flashcard to check
     * @return true or false depending on if flashcard is equal
     */
    public boolean equals(Flashcard f) {
        if (this.question!=null && this.answer!=null) {
            return this.question.equals(f.question) && this.answer.equals(f.answer) && this.reverse==f.reverse;
        } else {
            //might cause an error if something is null
            return false;
        }
    }
    /**
     * Create a String representation of all the flashcard attributes
     * @return a String representation of all the flashcard attributes
     */
    public String toString() {
        return "Question: " + question + 
                "\nAnswer: " + answer +
                "\nReverse: " + reverse;
    }
}
