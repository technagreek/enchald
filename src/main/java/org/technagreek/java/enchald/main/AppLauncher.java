package org.technagreek.java.enchald.main;

import javafx.application.Application;
import org.technagreek.java.enchald.core.module.MainModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class AppLauncher {
  private static final Logger logger = Logger.getLogger(AppLauncher.class.getName());
  private static MainModule mainModule;

  public static void main(final String[] args) {
    try {
      InputStream in =
              Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties");
      LogManager.getLogManager().readConfiguration(in);
    } catch (SecurityException | IOException e1) {
      e1.printStackTrace();
    }

    logger.info("Starting GUI");
    Application.launch(MainApplication.class, args);
  }

  public static MainModule getMainModule() {
    return mainModule;
  }

  public static void setMainModule(MainModule mainModule) {
    AppLauncher.mainModule = mainModule;
  }
}
