package multimedia.project;

import javax.swing.*;

public class VideoController {
    private VideoPlayerView view;
    private QuestionModel question;
    private Timer videoTimer;
    private int currentTime = 0;

    public VideoController(VideoPlayerView view, QuestionModel question) {
        this.view = view;
        this.question = question;
        view.videoProgress.setEnabled(false); // منع التلاعب بالوقت
        view.playButton.addActionListener(e -> startVideo());
    }

    private void startVideo() {
        view.playButton.setEnabled(false);
        videoTimer = new Timer(1000, e -> {
            currentTime++;
            view.videoProgress.setValue(currentTime * 10);
            view.timerLabel.setText("00:0" + currentTime);

            if (currentTime == question.getTriggerTime()) {
                videoTimer.stop();
                showQuestion();
            }
            if (currentTime >= 10) { 
                videoTimer.stop(); 
                JOptionPane.showMessageDialog(view, "انتهى الدرس بنجاح!"); 
            }
        });
        videoTimer.start();
    }

    private void showQuestion() {
        int response = JOptionPane.showOptionDialog(view, 
            question.getQuestion(), "نقطة تفاعل (Checkpoint)",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
            null, question.getOptions(), null);

        if (response == question.getCorrectAnswerIndex()) {
            JOptionPane.showMessageDialog(view, "إجابة صحيحة! أحسنتِ يا دينا.");
            videoTimer.start();
        } else {
            JOptionPane.showMessageDialog(view, "خطأ! سنعيد شرح المقطع لضمان الاستيعاب.");
            currentTime = 0;
            view.videoProgress.setValue(0);
            videoTimer.start();
        }
    }
}