
package com.dmd.wdyc.ws.service.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dmd.wdyc.ws.service.user package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "Exception");
    private final static QName _Login_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "loginResponse");
    private final static QName _Register_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "register");
    private final static QName _RegisterResponse_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "registerResponse");
    private final static QName _UserEntity_QNAME = new QName("http://user.service.ws.wdyc.dmd.com/", "userEntity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dmd.wdyc.ws.service.user
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link UserEntity }
     * 
     */
    public UserEntity createUserEntity() {
        return new UserEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.service.ws.wdyc.dmd.com/", name = "userEntity")
    public JAXBElement<UserEntity> createUserEntity(UserEntity value) {
        return new JAXBElement<UserEntity>(_UserEntity_QNAME, UserEntity.class, null, value);
    }

}
