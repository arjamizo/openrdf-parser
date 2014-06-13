/**
 * WsdlSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.wsdl;

public class WsdlSOAPImpl implements org.example.www.wsdl.Wsdl_PortType{
    public java.lang.String newOperation(java.lang.String[] in) throws java.rmi.RemoteException {
        return in[0]+in[1];
    }

    public java.lang.String newOperation1(java.lang.String[] in) throws java.rmi.RemoteException {
        if(in[0].substring(0, in[1].length()).compareTo(in[1])==0) return "true";
        else return "false";
    }

}
