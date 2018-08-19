
package com.dmd.wdyc.ws.service.user;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserWS", targetNamespace = "http://user.service.ws.wdyc.dmd.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserWS {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg8
     * @return
     *     returns com.dmd.wdyc.ws.service.user.UserEntity
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://user.service.ws.wdyc.dmd.com/", className = "com.dmd.wdyc.ws.service.user.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://user.service.ws.wdyc.dmd.com/", className = "com.dmd.wdyc.ws.service.user.RegisterResponse")
    @Action(input = "http://user.service.ws.wdyc.dmd.com/UserWS/registerRequest", output = "http://user.service.ws.wdyc.dmd.com/UserWS/registerResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://user.service.ws.wdyc.dmd.com/UserWS/register/Fault/Exception")
    })
    public UserEntity register(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        String arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        String arg7,
        @WebParam(name = "arg8", targetNamespace = "")
        String arg8)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.dmd.wdyc.ws.service.user.UserEntity
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://user.service.ws.wdyc.dmd.com/", className = "com.dmd.wdyc.ws.service.user.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://user.service.ws.wdyc.dmd.com/", className = "com.dmd.wdyc.ws.service.user.LoginResponse")
    @Action(input = "http://user.service.ws.wdyc.dmd.com/UserWS/loginRequest", output = "http://user.service.ws.wdyc.dmd.com/UserWS/loginResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://user.service.ws.wdyc.dmd.com/UserWS/login/Fault/Exception")
    })
    public UserEntity login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

}
