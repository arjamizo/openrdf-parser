/**
 * Wsdl_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.wsdl;

public interface Wsdl_PortType extends java.rmi.Remote {

    /**
     * This operation concatenat two strings and return them
     */
    public java.lang.String newOperation(java.lang.String[] in) throws java.rmi.RemoteException;

    /**
     * This operation compares if the first string starts with the
     * second string and return true or fals
     */
    public java.lang.String newOperation1(java.lang.String[] in) throws java.rmi.RemoteException;
}
