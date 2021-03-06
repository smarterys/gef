/*******************************************************************************
 * Copyright (c) 2016 itemis AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tamas Miklossy (itemis AG) - initial API and implementation (bug #461506)
 *     
 *******************************************************************************/
package org.eclipse.gef.dot.internal.ui.language.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.dot.internal.language.color.DotColors;
import org.eclipse.gef.dot.internal.language.color.StringColor;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
public class DotColorProposalProvider extends
		org.eclipse.gef.dot.internal.ui.language.contentassist.AbstractDotColorProposalProvider {

	/**
	 * Represents the color scheme that is defined in the DOT ast. If this color
	 * scheme is not defined, the default color scheme should be used in the
	 * proposal provider.
	 */
	public static String globalColorScheme = null;

	private final String defaultColorScheme = "x11"; //$NON-NLS-1$

	@Override
	public void completeStringColor_Scheme(EObject model, Assignment assignment,
			ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeStringColor_Scheme(model, assignment, context, acceptor);

		for (String colorScheme : DotColors.getColorSchemes()) {
			acceptor.accept(createCompletionProposal(colorScheme, context));
		}
	}

	@Override
	public void completeStringColor_Name(EObject model, Assignment assignment,
			ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeStringColor_Name(model, assignment, context, acceptor);
		// start with the default color scheme
		String colorScheme = defaultColorScheme;

		if (model instanceof StringColor
				&& ((StringColor) model).getScheme() != null) {
			colorScheme = ((StringColor) model).getScheme();
		} else if (globalColorScheme != null) {
			colorScheme = globalColorScheme;
		}

		for (String colorName : DotColors
				.getColorNames(colorScheme.toLowerCase())) {
			acceptor.accept(createCompletionProposal(colorName, context));
		}
	}
}
