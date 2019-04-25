/*
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.validation;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;

@SuppressWarnings("restriction")
public class IRMLValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	protected static final String SETTINGS_SECTION_NAME = "IRML";

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		addComboBox(IRMLConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, "Deprecated Model Part", composite, defaultIndent);
	}

	@Override
	public void dispose() {
		storeSectionExpansionStates(getDialogSettings());
		super.dispose();
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings dialogSettings = super.getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
		if (section == null) {
			return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
		}
		return section;
	}
}
