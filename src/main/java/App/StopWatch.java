package App;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exampleproject.ProjectController;

public class StopWatch {
    private ProjectController controller;
    private double time = 0;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        public void run() {
            time += 0.1;
            controller.updateTime(time);
        };
    };

    public void start() {
        timer.schedule(task, 100, 100);
    }
    
    public void stop() {
        timer.cancel();
    }

    public String getTime() {
        String komma = String.format("%.1f", time);
        return Stream.of(komma.split(","))
        .collect(Collectors.joining("."));
    }

    public StopWatch(ProjectController controller) {
        this.controller = controller;
    }

    public void reset() {
        time = 0;
    }
}
