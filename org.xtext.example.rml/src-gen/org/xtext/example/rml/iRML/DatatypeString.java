/**
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.iRML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.rml.iRML.DatatypeString#getQutoedString <em>Qutoed String</em>}</li>
 *   <li>{@link org.xtext.example.rml.iRML.DatatypeString#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.rml.iRML.IRMLPackage#getDatatypeString()
 * @model
 * @generated
 */
public interface DatatypeString extends EObject
{
  /**
   * Returns the value of the '<em><b>Qutoed String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qutoed String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qutoed String</em>' attribute.
   * @see #setQutoedString(String)
   * @see org.xtext.example.rml.iRML.IRMLPackage#getDatatypeString_QutoedString()
   * @model
   * @generated
   */
  String getQutoedString();

  /**
   * Sets the value of the '{@link org.xtext.example.rml.iRML.DatatypeString#getQutoedString <em>Qutoed String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qutoed String</em>' attribute.
   * @see #getQutoedString()
   * @generated
   */
  void setQutoedString(String value);

  /**
   * Returns the value of the '<em><b>Resource</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resource</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource</em>' containment reference.
   * @see #setResource(iResource)
   * @see org.xtext.example.rml.iRML.IRMLPackage#getDatatypeString_Resource()
   * @model containment="true"
   * @generated
   */
  iResource getResource();

  /**
   * Sets the value of the '{@link org.xtext.example.rml.iRML.DatatypeString#getResource <em>Resource</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource</em>' containment reference.
   * @see #getResource()
   * @generated
   */
  void setResource(iResource value);

} // DatatypeString
