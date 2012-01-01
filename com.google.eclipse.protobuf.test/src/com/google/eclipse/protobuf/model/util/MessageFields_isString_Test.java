/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.model.util;

import static com.google.eclipse.protobuf.junit.core.UnitTestModule.unitTestModule;
import static com.google.eclipse.protobuf.junit.core.XtextRule.overrideRuntimeModuleWith;
import static org.junit.Assert.*;

import org.junit.*;

import com.google.eclipse.protobuf.junit.core.XtextRule;
import com.google.eclipse.protobuf.protobuf.MessageField;

/**
 * Tests for <code>{@link MessageFields#isString(MessageField)}</code>.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class MessageFields_isString_Test {
  @Rule public XtextRule xtext = overrideRuntimeModuleWith(unitTestModule());

  private MessageFields fields;

  @Before public void setUp() {
    fields = xtext.getInstanceOf(MessageFields.class);
  }

  // syntax = "proto2";
  //
  // message Person {
  //   optional string name = 1;
  // }
  @Test public void should_return_true_if_field_is_string() {
    MessageField field = xtext.find("name", MessageField.class);
    assertTrue(fields.isString(field));
  }

  // syntax = "proto2";
  //
  // message Person {
  //   optional double code = 1;
  // }
  @Test public void should_return_false_if_field_is_not_string() {
    MessageField field = xtext.find("code", MessageField.class);
    assertFalse(fields.isString(field));
  }
}
