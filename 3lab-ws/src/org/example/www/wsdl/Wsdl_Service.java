/**
 * Wsdl_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.wsdl;

public interface Wsdl_Service extends javax.xml.rpc.Service {
    public java.lang.String getwsdlSOAPAddress();

    public org.example.www.wsdl.Wsdl_PortType getwsdlSOAP() throws javax.xml.rpc.ServiceException;

    public org.example.www.wsdl.Wsdl_PortType getwsdlSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
