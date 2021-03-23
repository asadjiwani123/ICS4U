/*
    Class that holds the data for a multiple choice question
 */
package jiwaniwangprojectmanagement;

/**
 *
 * @author edwan2505
 */
public class MCQuestion {
    private String question, correct;
    private String[] answers;
    
    public MCQuestion (String question, String correct, String[] answers) {
        this.question = question;
        this.answers = answers;
        boolean flag = false;
        for (int i = 0; i < answers.length; i++) {
            if (correct.equals(answers[i])) {
                flag = true;
                break;
            }
        }
        if (flag) {
            this.correct = correct;
        } else {
            correct = "_ERROR";
        }
    }
    
    public String getQuestion() {
        return question;
    }
    public String[] getAnswers() {
        return answers;
    }
    public String getCorrect() {
        return correct;
    }

    //NO SETTER METHODS, QUESTIONS/ANSWERS SHOULD BE CHANGED IN DATA FILES
    
    public MCQuestion clone() {
        MCQuestion q = new MCQuestion(question, correct, answers);
        return q;
    }
    public boolean equals(MCQuestion q) {
        if (this.question!=null && this.correct!=null && this.answers!=null) {
            return this.question.equals(q.question) && this.answers.equals(q.answers) && this.correct.equals(q.correct);
        } else {
            //might cause an error when something is null
            return false;
        }
    }
}
