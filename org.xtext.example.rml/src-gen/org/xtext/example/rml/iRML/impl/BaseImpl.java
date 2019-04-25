/**
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.iRML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.rml.iRML.Base;
import org.xtext.example.rml.iRML.IRMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.rml.iRML.impl.BaseImpl#getUriRef <em>Uri Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseImpl extends MinimalEObjectImpl.Container implements Base
{
  /**
   * The default value of the '{@link #getUriRef() <em>Uri Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUriRef()
   * @generated
   * @ordered
   */
  protected static final String URI_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUriRef() <em>Uri Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUriRef()
   * @generated
   * @ordered
   */
  protected String uriRef = URI_REF_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BaseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return IRMLPackage.Literals.BASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getUriRef()
  {
    return uriRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUriRef(String newUriRef)
  {
    String oldUriRef = uriRef;
    uriRef = newUriRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IRMLPackage.BASE__URI_REF, oldUriRef, uriRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case IRMLPackage.BASE__URI_REF:
        return getUriRef();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IRMLPackage.BASE__URI_REF:
        setUriRef((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case IRMLPackage.BASE__URI_REF:
        setUriRef(URI_REF_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case IRMLPackage.BASE__URI_REF:
        return URI_REF_EDEFAULT == null ? uriRef != null : !URI_REF_EDEFAULT.equals(uriRef);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (uriRef: ");
    result.append(uriRef);
    result.append(')');
    return result.toString();
  }

} //BaseImpl
