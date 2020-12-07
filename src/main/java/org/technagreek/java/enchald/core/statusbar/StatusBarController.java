package org.technagreek.java.enchald.core.statusbar;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;

public class StatusBarController {
  @FXML
  Label statusBarText;
  @FXML
  ProgressBar statusBarProgress;

  public static String convertToHex(final Color color) {
    return String.format(
            "#%02X%02X%02X",
            (int) (color.getRed() * 255),
            (int) (color.getGreen() * 255),
            (int) (color.getBlue() * 255));
  }

  public void setStatusBarText(String StatusText) {
    statusBarText.setText(StatusText);
  }

  public void setStatusBarText(String StatusText, Color textColor) {
    Platform.runLater(
            () -> {
              statusBarText.setText(StatusText);
              statusBarText.setStyle("-fx-text-fill: " + convertToHex(textColor));
            });
  }

  public void updateProgress(Double progressPercentage) {
    statusBarProgress.setProgress(progressPercentage);
  }
}
