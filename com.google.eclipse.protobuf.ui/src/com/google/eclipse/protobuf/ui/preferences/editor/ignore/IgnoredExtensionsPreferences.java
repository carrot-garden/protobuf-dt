/*
 * Copyright (c) 2012 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.preferences.editor.ignore;

import static com.google.eclipse.protobuf.ui.preferences.editor.ignore.PreferenceNames.IGNORED_EXTENSIONS;
import static com.google.eclipse.protobuf.ui.util.CommaSeparatedValues.splitCsv;

import com.google.eclipse.protobuf.preferences.DefaultPreservingInitializer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

/**
 * @author alruiz@google.com (Alex Ruiz)
 */
public class IgnoredExtensionsPreferences {
  private final IPreferenceStore store;

  public IgnoredExtensionsPreferences(IPreferenceStoreAccess storeAccess) {
    store = storeAccess.getWritablePreferenceStore();
  }

  public String[] extensions() {
    String value = store.getString(IGNORED_EXTENSIONS);
    return splitCsv(value);
  }

  public static class Initializer extends DefaultPreservingInitializer {
    @Override
    public void setDefaults() {
      setDefault(IGNORED_EXTENSIONS, ".ascii.proto,.binary.proto,.xml.proto");
    }
  }
}
