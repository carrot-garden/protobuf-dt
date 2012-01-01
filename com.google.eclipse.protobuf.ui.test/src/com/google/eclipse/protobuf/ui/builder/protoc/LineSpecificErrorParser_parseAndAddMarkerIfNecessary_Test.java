/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.builder.protoc;

import static org.mockito.Mockito.*;

import org.eclipse.core.runtime.CoreException;
import org.junit.*;

/**
 * Tests for <code>{@link LineSpecificErrorParser#parseAndAddMarkerIfNecessary(String, ProtocMarkerFactory)}</code>.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class LineSpecificErrorParser_parseAndAddMarkerIfNecessary_Test {
  private ProtocMarkerFactory markerFactory;
  private LineSpecificErrorParser outputParser;

  @Before public void setUp() {
    markerFactory = mock(ProtocMarkerFactory.class);
    outputParser = new LineSpecificErrorParser();
  }

  @Test public void should_not_create_IMarker_if_line_does_not_match_error_pattern() throws CoreException {
    String line = "person.proto: File not found.";
    outputParser.parseAndAddMarkerIfNecessary(line, markerFactory);
    verifyZeroInteractions(markerFactory);
  }

  @Test public void should_attempt_to_create_IMarker_if_line_matches_error_pattern() throws CoreException {
    String line = "test.proto:23:21: Expected field name.";
    outputParser.parseAndAddMarkerIfNecessary(line, markerFactory);
    verify(markerFactory).createErrorIfNecessary("test.proto", "Expected field name.", 23);
  }
}
