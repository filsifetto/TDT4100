package exampleproject;

import App.Leaderboard;
import App.StopWatch;
import App.Task;
import App.TaskGenerator;
import fundament.RealMatrix;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProjectController {
    private Task task;
    private StopWatch stopWatch;


    @FXML
    private Text a1;

    @FXML
    private Text a2;
    
    @FXML
    private Text a3;
    
    @FXML
    private Text b1;

    @FXML
    private Text b2;
    
    @FXML
    private Text b3;

    @FXML
    private Text c1;

    @FXML
    private Text c2;
    
    @FXML
    private Text c3;
    
    @FXML
    private TextField sa1;

    @FXML
    private TextField sa2;

    @FXML
    private TextField sa3;

    @FXML
    private TextField sb1;

    @FXML
    private TextField sb2;

    @FXML
    private TextField sb3;

    @FXML
    private TextField sc1;

    @FXML
    private TextField sc2;

    @FXML
    private TextField sc3;

    @FXML
    private Text svarRiktigFeil;

    @FXML
    private Text skrivInnInvers;

    @FXML
    private TextField userName;

    @FXML
    private Text usernameText;

    @FXML
    private Text velgBrukernavn;

    @FXML
    private Text timer;

    @FXML
    private Text timerText;

    @FXML
    private TextArea highScoreArea;

    @FXML
    public void nyRunde() {
    }

    @FXML
    public void startRound() {
        stopWatch = new StopWatch(this);
        highScoreArea.setText(Leaderboard.readAsText());
        if (userName.getText().equals("")) {
            velgBrukernavn.setText("Velg brukernavn før du starter");
            throw new IllegalStateException();
        }
        task = TaskGenerator.generate();
        stopWatch.start();
        // startTime = System.currentTimeMillis();

        a1.setText(String.valueOf(task.getMatrix().getNumberAt(0, 0)));
        a2.setText(String.valueOf(task.getMatrix().getNumberAt(0, 1)));
        a3.setText(String.valueOf(task.getMatrix().getNumberAt(0, 2)));
        b1.setText(String.valueOf(task.getMatrix().getNumberAt(1, 0)));
        b2.setText(String.valueOf(task.getMatrix().getNumberAt(1, 1)));
        b3.setText(String.valueOf(task.getMatrix().getNumberAt(1, 2)));
        c1.setText(String.valueOf(task.getMatrix().getNumberAt(2, 0)));
        c2.setText(String.valueOf(task.getMatrix().getNumberAt(2, 1)));
        c3.setText(String.valueOf(task.getMatrix().getNumberAt(2, 2)));

        sa1.clear();
        sa2.clear();
        sa3.clear();
        sb1.clear();
        sb2.clear();
        sb3.clear();
        sc1.clear();
        sc2.clear();
        sc3.clear();
        svarRiktigFeil.setText(null);
        skrivInnInvers.setText("Finn inversmatrisen: ");
        timerText.setText("Klokke: ");

    }

    @FXML
    public void updateTime(double time) {
        timer.setText(stopWatch.getTime()); 
    }

    @FXML
    public void stop() {
        try {
            RealMatrix svar = new RealMatrix(3,3,
            Integer.valueOf(sa1.getText()), Integer.valueOf(sa2.getText()), Integer.valueOf(sa3.getText()),
            Integer.valueOf(sb1.getText()), Integer.valueOf(sb2.getText()), Integer.valueOf(sb3.getText()), 
            Integer.valueOf(sc1.getText()), Integer.valueOf(sc2.getText()), Integer.valueOf(sc3.getText()));
            System.out.println(svar);
            if (svar.equals(task.getInverse())) {
                svarRiktigFeil.setText("Riktig!");
                Leaderboard.write(userName.getText(), timer.getText());
                // System.out.println(timer.getText());                
            }
            else {
                svarRiktigFeil.setText("Feil");
            }
            stopWatch.stop();
            System.out.println(stopWatch.getTime());
            highScoreArea.setText(Leaderboard.readAsText());
        } catch (Exception e) {
            e.printStackTrace();
            svarRiktigFeil.setText("Ikke gyldig svar");
        }
    }
}