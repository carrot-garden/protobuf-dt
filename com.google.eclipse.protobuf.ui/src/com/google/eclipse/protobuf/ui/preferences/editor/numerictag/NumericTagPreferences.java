/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.preferences.editor.numerictag;

import static com.google.eclipse.protobuf.ui.preferences.editor.numerictag.PreferenceNames.NUMERIC_TAG_PATTERNS;

import com.google.eclipse.protobuf.preferences.DefaultPreservingInitializer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import java.util.List;

/**
 * @author alruiz@google.com (Alex Ruiz)
 */
public class NumericTagPreferences {
  private final IPreferenceStore store;

  public NumericTagPreferences(IPreferenceStoreAccess storeAccess) {
    store = storeAccess.getWritablePreferenceStore();
  }

  public List<String> patterns() {
    String value = store.getString(NUMERIC_TAG_PATTERNS);
    return NumericTagPatternSplitter.instance().splitIntoList(value);
  }

  public static class Initializer extends DefaultPreservingInitializer {
    @Override
    public void setDefaults() {
      setDefault(NUMERIC_TAG_PATTERNS, "Next[\\s]+Id:[\\s]+[\\d]+");
    }
  }
}
