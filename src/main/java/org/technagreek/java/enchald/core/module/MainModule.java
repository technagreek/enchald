package org.technagreek.java.enchald.core.module;

import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public interface MainModule extends BaseModule {

  BorderPane getMainPane();

  void setStatusBarText(String StatusText);

  void setStatusBarText(String text, Color textColor);

  void displayMessage(String msg);

  void displayMessage(String title, String msg);

  void displayErrorMessage(String msg);

  void displayException(Exception e);

  ButtonType displayConfirmation(String msg, ButtonType... buttonTypes);

  void setProgressBarPercentage(Double i);
}
