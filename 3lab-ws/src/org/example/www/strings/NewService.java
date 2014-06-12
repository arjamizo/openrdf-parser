/**
 * NewService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.strings;

public interface NewService extends javax.xml.rpc.Service {
    public java.lang.String getNewPort1Address();

    public org.example.www.strings.NewPortType getNewPort1() throws javax.xml.rpc.ServiceException;

    public org.example.www.strings.NewPortType getNewPort1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
