package org.technagreek.java.enchald.modules.sample1;

import javafx.event.Event;
import javafx.scene.paint.Color;
import org.technagreek.java.enchald.main.AppLauncher;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class sample1controller {

    public void onStartButtonClick(Event event) {
        Runnable helloRunnable =
                () -> {
                    Random random = new Random();
                    int randomNumber = (random.nextInt(10 - 1 + 1) + 1);
                    if (randomNumber % 2 == 0) {
                        AppLauncher.getMainModule().setStatusBarText(new Date().toString(), Color.RED);
                    } else if (randomNumber % 3 == 0) {
                        AppLauncher.getMainModule().setStatusBarText(new Date().toString(), Color.BLACK);
                    } else if (randomNumber % 5 == 0) {
                        AppLauncher.getMainModule().setStatusBarText(new Date().toString(), Color.GREEN);
                    } else if (randomNumber % 7 == 0) {
                        AppLauncher.getMainModule().setStatusBarText(new Date().toString(), Color.PURPLE);
                    }
                };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
    }
}
