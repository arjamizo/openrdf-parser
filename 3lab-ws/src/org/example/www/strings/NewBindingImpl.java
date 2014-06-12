/**
 * NewBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.strings;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class NewBindingImpl implements org.example.www.strings.NewPortType{
    public java.lang.String[] encode(java.lang.String in, java.lang.String[] in1) throws java.rmi.RemoteException, NoSuchAlgorithmException {
        List<String> ret=new LinkedList();
        for (String string : in1) {
        	byte[] hash=MessageDigest.getInstance(in).digest(string.getBytes());
			ret.add(String.format("%032x", new BigInteger(1, hash)));
		}
    	return ret.toArray(new String[0]);
    }

}
