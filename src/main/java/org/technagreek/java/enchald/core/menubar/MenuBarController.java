package org.technagreek.java.enchald.core.menubar;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.technagreek.java.enchald.main.AppLauncher;
import org.technagreek.java.enchald.main.MainApplication;

import java.io.IOException;
import java.net.URL;

public class MenuBarController {
  public void showSample1(Event event) throws IOException {
    BorderPane mainPanel = AppLauncher.getMainModule().getMainPane();
    URL sample1FXML = MenuBarController.class.getResource("/org/technagreek/java/enchald/modules/sample1/sample1.fxml");

    FXMLLoader loader = new FXMLLoader(sample1FXML);

    AnchorPane centerScene = loader.load();
    mainPanel.setCenter(centerScene);
  }

  public void showSample2(Event event) throws IOException {
    BorderPane mainPanel = AppLauncher.getMainModule().getMainPane();
    URL sample1FXML = MenuBarController.class.getResource("/org/technagreek/java/enchald/modules/sample2/sample2.fxml");

    FXMLLoader loader = new FXMLLoader(sample1FXML);

    AnchorPane centerScene = loader.load();
    mainPanel.setCenter(centerScene);
  }

  public void showAbout(Event event) throws IOException {
    MainApplication.showAbout();
  }

  public void onClickCloseMenu(Event event) {
    Platform.exit();
    System.exit(0);
  }
}
