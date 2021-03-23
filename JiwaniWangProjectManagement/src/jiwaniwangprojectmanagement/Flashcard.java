/*
    Class that represents a flash card
 */
package jiwaniwangprojectmanagement;

/**
 *
 * @author edwan2505
 */
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
    
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public boolean getReverse() {
        return reverse;
    }
    
    public void setReverse(boolean newReverse) {
        reverse = newReverse;
    }
    
    public Flashcard clone () {
        Flashcard f2 = new Flashcard(question, answer, reverse);
        return f2;
    }
    public boolean equals(Flashcard f) {
        if (this.question!=null && this.answer!=null) {
            return this.question.equals(f.question) && this.answer.equals(f.answer) && this.reverse==f.reverse;
        } else {
            //might cause an error if something is null
            return false;
        }
    }
    public String toString() {
        return "Question: " + question + 
                "\nAnswer: " + answer +
                "\nReverse: " + reverse;
    }
}
