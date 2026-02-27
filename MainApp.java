package multimedia.project;

public class MainApp {
    public static void main(String[] args) {
        // إعداد البيانات (Model)
        String[] options = {"220221515", "2026", "جافا"};
        QuestionModel quiz = new QuestionModel("ما هي لغة البرمجة المستخدمة في هذا المشروع؟", options, 2, 4);

        // إعداد الواجهة (View)
        VideoPlayerView gui = new VideoPlayerView();

        // ربط الكل بالمتحكم (Controller)
        new VideoController(gui, quiz);

        gui.setVisible(true);
    }
}