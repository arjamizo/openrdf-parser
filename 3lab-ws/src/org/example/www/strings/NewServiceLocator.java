/**
 * NewServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.strings;

public class NewServiceLocator extends org.apache.axis.client.Service implements org.example.www.strings.NewService {

    public NewServiceLocator() {
    }


    public NewServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NewServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NewPort1
    private java.lang.String NewPort1_address = "http://www.example.org/";

    public java.lang.String getNewPort1Address() {
        return NewPort1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NewPort1WSDDServiceName = "NewPort1";

    public java.lang.String getNewPort1WSDDServiceName() {
        return NewPort1WSDDServiceName;
    }

    public void setNewPort1WSDDServiceName(java.lang.String name) {
        NewPort1WSDDServiceName = name;
    }

    public org.example.www.strings.NewPortType getNewPort1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NewPort1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNewPort1(endpoint);
    }

    public org.example.www.strings.NewPortType getNewPort1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.example.www.strings.NewBindingStub _stub = new org.example.www.strings.NewBindingStub(portAddress, this);
            _stub.setPortName(getNewPort1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNewPort1EndpointAddress(java.lang.String address) {
        NewPort1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.example.www.strings.NewPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.example.www.strings.NewBindingStub _stub = new org.example.www.strings.NewBindingStub(new java.net.URL(NewPort1_address), this);
                _stub.setPortName(getNewPort1WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("NewPort1".equals(inputPortName)) {
            return getNewPort1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/strings/", "NewService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/strings/", "NewPort1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NewPort1".equals(portName)) {
            setNewPort1EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
