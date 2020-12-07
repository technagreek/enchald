package org.technagreek.java.enchald.modules.sample2;

import javafx.event.Event;
import org.technagreek.java.enchald.main.AppLauncher;

public class sample2controller {
  Double d = (double) 0;

  public void onStartButtonClick(Event event) {
    d = d + 0.1;
    AppLauncher.getMainModule().setProgressBarPercentage(d);
  }
}
