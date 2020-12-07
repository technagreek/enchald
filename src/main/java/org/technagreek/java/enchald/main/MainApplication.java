package org.technagreek.java.enchald.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.technagreek.java.enchald.core.module.MainModule;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication extends Application implements MainModule {
  static final String ModuleName = "Enchald";
  private static Stage mainStage;
  private static MainController mainController;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public static void showAbout() throws IOException {
    Stage stage = new Stage();
    AnchorPane root = FXMLLoader.load(MainApplication.class.getResource("../core/help/About.fxml"));
    stage.setScene(new Scene(root));
    stage.setTitle("About");
    stage.initModality(Modality.WINDOW_MODAL);
    stage.show();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    AppLauncher.setMainModule(this);
    URL mainFXML = this.getClass().getResource("Main.fxml");

    FXMLLoader loader = new FXMLLoader(mainFXML);

    Scene centerScene = loader.load();
    mainController = loader.getController();

    primaryStage.setTitle(ModuleName);
    primaryStage.setScene(centerScene);
    // primaryStage.setMaximized(true);

    primaryStage.show();
    mainStage = primaryStage;
    setStatusBarText("Application loaded");
  }

  @Override
  public BorderPane getMainPane() {
    return (BorderPane) mainStage.getScene().getRoot();
  }

  @Override
  public void setStatusBarText(String statusText) {
    mainController.setStatusBarText(statusText);
  }

  @Override
  public void setStatusBarText(String statusText, Color textColor) {
    mainController.setStatusBarText(statusText, textColor);
  }

  @Override
  public void displayMessage(String msg) {
    displayMessage("Message:", msg);
  }

  @Override
  public void displayMessage(String titleText, String messageText) {
    Platform.runLater(
            () -> {
              Dialog<ButtonType> dialog = new Dialog<>();
              Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
              dialog.setTitle(titleText);
              dialog.setContentText(messageText);
              dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
              dialog.showAndWait();
            });
  }

  @Override
  public void displayErrorMessage(String msg) {
    displayMessage("Error:", msg);
  }

  @Override
  public void displayException(Exception e) {
    logger.log(Level.SEVERE, e.toString(), e);
    e.printStackTrace();
  }

  @Override
  public String getName() {
    return ModuleName;
  }

  public ButtonType displayConfirmation(String msg, ButtonType... buttonTypes) {
    FutureTask<ButtonType> alertTask =
            new FutureTask<>(
                    () -> {
                      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, msg, buttonTypes);
                      alert.showAndWait();
                      return alert.getResult();
                    });
    try {
      if (Platform.isFxApplicationThread()) alertTask.run();
      else Platform.runLater(alertTask);
      return alertTask.get();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public HashMap<String, String> getParameterSet() {
    return null;
  }

  @Override
  public void setProgressBarPercentage(Double i) {
    mainController.setProgressBarPercentage(i);
  }
}
