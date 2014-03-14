/*******************************************************************************
 * Copyright (c) 2009, 2010 Fabian Steeg. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p/>
 * Contributors: Fabian Steeg
 *******************************************************************************/
package org.eclipse.gef4.zest.tests;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gef4.zest.tests.dot.TestDotExtractor;
import org.eclipse.gef4.zest.tests.dot.TestDotGraph;
import org.eclipse.gef4.zest.tests.dot.TestGraphInstanceDotImport;
import org.eclipse.gef4.zest.tests.dot.TestZestGraphView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Main test suite for all tests.
 * 
 * @author Fabian Steeg (fsteeg)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ GraphTests.class, GraphViewerTests.class,
		GraphSelectionTests.class, IFigureProviderTests.class,
		TestDotGraph.class, TestGraphInstanceDotImport.class,
		/* TestDotDirStore.class, */TestDotExtractor.class,
		TestZestGraphView.class })
public final class AllTests {
	@Before
	public void setup() {
		if (!Platform.isRunning()) {
			Assert.fail("Please run as JUnit Plug-in test"); //$NON-NLS-1$
		}
	}
}
