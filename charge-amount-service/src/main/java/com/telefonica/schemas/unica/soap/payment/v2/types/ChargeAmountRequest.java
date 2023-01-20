//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.17 a las 06:05:36 PM COT 
//


package com.telefonica.schemas.unica.soap.payment.v2.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Charge Amount request
 * 
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endUserIdentifier" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}UserIdType"/&gt;
 *         &lt;element name="chargingInformation" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}ChargingInformationType"/&gt;
 *         &lt;element name="chargingMetaData" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}ChargingMetaDataType" minOccurs="0"/&gt;
 *         &lt;element name="referenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "endUserIdentifier",
    "chargingInformation",
    "chargingMetaData",
    "referenceCode"
})
@XmlRootElement(name = "chargeAmount")
public class ChargeAmountRequest {

    @XmlElement(required = true)
    protected UserIdType endUserIdentifier;
    @XmlElement(required = true)
    protected ChargingInformationType chargingInformation;
    protected ChargingMetaDataType chargingMetaData;
    protected String referenceCode;

    /**
     * Obtiene el valor de la propiedad endUserIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link UserIdType }
     *     
     */
    public UserIdType getEndUserIdentifier() {
        return endUserIdentifier;
    }

    /**
     * Define el valor de la propiedad endUserIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdType }
     *     
     */
    public void setEndUserIdentifier(UserIdType value) {
        this.endUserIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad chargingInformation.
     * 
     * @return
     *     possible object is
     *     {@link ChargingInformationType }
     *     
     */
    public ChargingInformationType getChargingInformation() {
        return chargingInformation;
    }

    /**
     * Define el valor de la propiedad chargingInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingInformationType }
     *     
     */
    public void setChargingInformation(ChargingInformationType value) {
        this.chargingInformation = value;
    }

    /**
     * Obtiene el valor de la propiedad chargingMetaData.
     * 
     * @return
     *     possible object is
     *     {@link ChargingMetaDataType }
     *     
     */
    public ChargingMetaDataType getChargingMetaData() {
        return chargingMetaData;
    }

    /**
     * Define el valor de la propiedad chargingMetaData.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingMetaDataType }
     *     
     */
    public void setChargingMetaData(ChargingMetaDataType value) {
        this.chargingMetaData = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Define el valor de la propiedad referenceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCode(String value) {
        this.referenceCode = value;
    }

}
