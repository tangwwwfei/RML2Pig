/**
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.iRML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.rml.iRML.IRMLPackage;
import org.xtext.example.rml.iRML.ItemList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.rml.iRML.impl.ItemListImpl#getObjects <em>Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemListImpl extends MinimalEObjectImpl.Container implements ItemList
{
  /**
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<org.xtext.example.rml.iRML.Object> objects;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ItemListImpl()
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
    return IRMLPackage.Literals.ITEM_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<org.xtext.example.rml.iRML.Object> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<org.xtext.example.rml.iRML.Object>(org.xtext.example.rml.iRML.Object.class, this, IRMLPackage.ITEM_LIST__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case IRMLPackage.ITEM_LIST__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case IRMLPackage.ITEM_LIST__OBJECTS:
        return getObjects();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IRMLPackage.ITEM_LIST__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends org.xtext.example.rml.iRML.Object>)newValue);
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
      case IRMLPackage.ITEM_LIST__OBJECTS:
        getObjects().clear();
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
      case IRMLPackage.ITEM_LIST__OBJECTS:
        return objects != null && !objects.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ItemListImpl
