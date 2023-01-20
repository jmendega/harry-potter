//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.17 a las 06:05:36 PM COT 
//


package com.telefonica.schemas.unica.soap.payment.v2.types;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Charge Amount response
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
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transactionOperationStatus" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}TransactionOperationStatusType"/&gt;
 *         &lt;element name="totalAmountCharged" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
    "transactionId",
    "transactionOperationStatus",
    "totalAmountCharged"
})
@XmlRootElement(name = "chargeAmountResponse")
public class ChargeAmountResponse {

    @XmlElement(required = true)
    protected String transactionId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionOperationStatusType transactionOperationStatus;
    @XmlElement(required = true)
    protected BigDecimal totalAmountCharged;

    /**
     * Obtiene el valor de la propiedad transactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Define el valor de la propiedad transactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionOperationStatus.
     * 
     * @return
     *     possible object is
     *     {@link TransactionOperationStatusType }
     *     
     */
    public TransactionOperationStatusType getTransactionOperationStatus() {
        return transactionOperationStatus;
    }

    /**
     * Define el valor de la propiedad transactionOperationStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionOperationStatusType }
     *     
     */
    public void setTransactionOperationStatus(TransactionOperationStatusType value) {
        this.transactionOperationStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad totalAmountCharged.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmountCharged() {
        return totalAmountCharged;
    }

    /**
     * Define el valor de la propiedad totalAmountCharged.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmountCharged(BigDecimal value) {
        this.totalAmountCharged = value;
    }

}
