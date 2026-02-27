package multimedia.project;

public class QuestionModel {
    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private int triggerTime;

    public QuestionModel(String q, String[] opts, int index, int time) {
        this.question = q;
        this.options = opts;
        this.correctAnswerIndex = index;
        this.triggerTime = time;
    }

    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
    public int getTriggerTime() { return triggerTime; }
}