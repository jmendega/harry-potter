//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.17 a las 06:05:36 PM COT 
//


package com.telefonica.schemas.unica.soap.payment.v2.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.schemas.unica.soap.payment.v2.types package. 
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

    private final static QName _VodProductAdditionalInfo_QNAME = new QName("http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", "vodProductAdditionalInfo");
    private final static QName _Genre_QNAME = new QName("http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", "genre");
    private final static QName _Producer_QNAME = new QName("http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", "producer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.schemas.unica.soap.payment.v2.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VodProductAdditionalInfoType }
     * 
     */
    public VodProductAdditionalInfoType createVodProductAdditionalInfoType() {
        return new VodProductAdditionalInfoType();
    }

    /**
     * Create an instance of {@link ChargeAmountRequest }
     * 
     */
    public ChargeAmountRequest createChargeAmountRequest() {
        return new ChargeAmountRequest();
    }

    /**
     * Create an instance of {@link UserIdType }
     * 
     */
    public UserIdType createUserIdType() {
        return new UserIdType();
    }

    /**
     * Create an instance of {@link ChargingInformationType }
     * 
     */
    public ChargingInformationType createChargingInformationType() {
        return new ChargingInformationType();
    }

    /**
     * Create an instance of {@link ChargingMetaDataType }
     * 
     */
    public ChargingMetaDataType createChargingMetaDataType() {
        return new ChargingMetaDataType();
    }

    /**
     * Create an instance of {@link ChargeAmountResponse }
     * 
     */
    public ChargeAmountResponse createChargeAmountResponse() {
        return new ChargeAmountResponse();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link ClientExceptionType }
     * 
     */
    public ClientExceptionType createClientExceptionType() {
        return new ClientExceptionType();
    }

    /**
     * Create an instance of {@link ServerExceptionType }
     * 
     */
    public ServerExceptionType createServerExceptionType() {
        return new ServerExceptionType();
    }

    /**
     * Create an instance of {@link AmountRateType }
     * 
     */
    public AmountRateType createAmountRateType() {
        return new AmountRateType();
    }

    /**
     * Create an instance of {@link TransactionStatusDataType }
     * 
     */
    public TransactionStatusDataType createTransactionStatusDataType() {
        return new TransactionStatusDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VodProductAdditionalInfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VodProductAdditionalInfoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", name = "vodProductAdditionalInfo")
    public JAXBElement<VodProductAdditionalInfoType> createVodProductAdditionalInfo(VodProductAdditionalInfoType value) {
        return new JAXBElement<VodProductAdditionalInfoType>(_VodProductAdditionalInfo_QNAME, VodProductAdditionalInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", name = "genre")
    public JAXBElement<String> createGenre(String value) {
        return new JAXBElement<String>(_Genre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types", name = "producer")
    public JAXBElement<String> createProducer(String value) {
        return new JAXBElement<String>(_Producer_QNAME, String.class, null, value);
    }

}
