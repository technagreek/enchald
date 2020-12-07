package org.technagreek.java.enchald.main;


import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import org.technagreek.java.enchald.core.statusbar.StatusBarController;

public class MainController {
  @FXML
  private StatusBarController statusBarController;

  public void setStatusBarText(String StatusText) {
    statusBarController.setStatusBarText(StatusText);
  }

  public void setStatusBarText(String StatusText, Color textColor) {

    statusBarController.setStatusBarText(StatusText, textColor);
  }

  public void setProgressBarPercentage(Double d) {
    statusBarController.updateProgress(d);
  }
}
