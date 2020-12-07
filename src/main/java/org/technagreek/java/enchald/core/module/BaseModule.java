package org.technagreek.java.enchald.core.module;

import java.util.HashMap;

public interface BaseModule {
  String getName();

  HashMap<String, String> getParameterSet();
}
