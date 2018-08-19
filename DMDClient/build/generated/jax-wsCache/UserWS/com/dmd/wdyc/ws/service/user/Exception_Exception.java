
package com.dmd.wdyc.ws.service.user;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://user.service.ws.wdyc.dmd.com/")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.dmd.wdyc.ws.service.user.Exception faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public Exception_Exception(String message, com.dmd.wdyc.ws.service.user.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public Exception_Exception(String message, com.dmd.wdyc.ws.service.user.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.dmd.wdyc.ws.service.user.Exception
     */
    public com.dmd.wdyc.ws.service.user.Exception getFaultInfo() {
        return faultInfo;
    }

}
