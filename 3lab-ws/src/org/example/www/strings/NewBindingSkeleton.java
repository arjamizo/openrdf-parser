/**
 * NewBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.strings;

public class NewBindingSkeleton implements org.example.www.strings.NewPortType, org.apache.axis.wsdl.Skeleton {
    private org.example.www.strings.NewPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("encode", _params, new javax.xml.namespace.QName("", "out"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.example.org/strings/", "encode"));
        _oper.setSoapAction("http://www.example.org/strings/encode");
        _myOperationsList.add(_oper);
        if (_myOperations.get("encode") == null) {
            _myOperations.put("encode", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("encode")).add(_oper);
    }

    public NewBindingSkeleton() {
        this.impl = new org.example.www.strings.NewBindingImpl();
    }

    public NewBindingSkeleton(org.example.www.strings.NewPortType impl) {
        this.impl = impl;
    }
    public java.lang.String[] encode(java.lang.String in, java.lang.String[] in1) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.encode(in, in1);
        return ret;
    }

}
