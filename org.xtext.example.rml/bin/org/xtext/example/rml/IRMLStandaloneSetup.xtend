/*
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class IRMLStandaloneSetup extends IRMLStandaloneSetupGenerated {

	def static void doSetup() {
		new IRMLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
