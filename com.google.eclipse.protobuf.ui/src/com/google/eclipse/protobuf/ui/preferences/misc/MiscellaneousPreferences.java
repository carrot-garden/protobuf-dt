/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.preferences.misc;

import static com.google.eclipse.protobuf.ui.preferences.misc.PreferenceNames.IS_GOOGLE_INTERNAL;

import com.google.eclipse.protobuf.preferences.DefaultPreservingInitializer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

/**
 * "Miscellaneous" preferences, retrieved from an <code>{@link IPreferenceStore}</code>.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class MiscellaneousPreferences {
  private final IPreferenceStore store;

  public MiscellaneousPreferences(IPreferenceStoreAccess storeAccess) {
    this.store = storeAccess.getWritablePreferenceStore();
  }

  public boolean isGoogleInternal() {
    return store.getBoolean(IS_GOOGLE_INTERNAL);
  }

  public static class Initializer extends DefaultPreservingInitializer {
    @Override
    public void setDefaults() {
      setDefault(IS_GOOGLE_INTERNAL, false);
    }
  }
}
