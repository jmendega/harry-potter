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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Transaction status data information (managed by
 * 				server)
 * 			
 * 
 * <p>Clase Java para TransactionStatusDataType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransactionStatusDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transactionOperationStatus" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}TransactionOperationStatusType"/&gt;
 *         &lt;element name="transactionOperationStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="clientException" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}ClientExceptionType" minOccurs="0"/&gt;
 *         &lt;element name="serverException" type="{http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types}ServerExceptionType" minOccurs="0"/&gt;
 *         &lt;element name="serverReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalAmountCharged" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="totalAmountRefunded" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="totalAmountCredited" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="amountReserved" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="expirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionStatusDataType", propOrder = {
    "transactionId",
    "transactionOperationStatus",
    "transactionOperationStatusDescription",
    "paymentId",
    "clientException",
    "serverException",
    "serverReferenceCode",
    "totalAmountCharged",
    "totalAmountRefunded",
    "totalAmountCredited",
    "amountReserved",
    "expirationDate"
})
public class TransactionStatusDataType {

    @XmlElement(required = true)
    protected String transactionId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionOperationStatusType transactionOperationStatus;
    protected String transactionOperationStatusDescription;
    protected String paymentId;
    protected ClientExceptionType clientException;
    protected ServerExceptionType serverException;
    protected String serverReferenceCode;
    protected BigDecimal totalAmountCharged;
    protected BigDecimal totalAmountRefunded;
    protected BigDecimal totalAmountCredited;
    protected BigDecimal amountReserved;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;

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
     * Obtiene el valor de la propiedad transactionOperationStatusDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionOperationStatusDescription() {
        return transactionOperationStatusDescription;
    }

    /**
     * Define el valor de la propiedad transactionOperationStatusDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionOperationStatusDescription(String value) {
        this.transactionOperationStatusDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Define el valor de la propiedad paymentId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * Obtiene el valor de la propiedad clientException.
     * 
     * @return
     *     possible object is
     *     {@link ClientExceptionType }
     *     
     */
    public ClientExceptionType getClientException() {
        return clientException;
    }

    /**
     * Define el valor de la propiedad clientException.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientExceptionType }
     *     
     */
    public void setClientException(ClientExceptionType value) {
        this.clientException = value;
    }

    /**
     * Obtiene el valor de la propiedad serverException.
     * 
     * @return
     *     possible object is
     *     {@link ServerExceptionType }
     *     
     */
    public ServerExceptionType getServerException() {
        return serverException;
    }

    /**
     * Define el valor de la propiedad serverException.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerExceptionType }
     *     
     */
    public void setServerException(ServerExceptionType value) {
        this.serverException = value;
    }

    /**
     * Obtiene el valor de la propiedad serverReferenceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerReferenceCode() {
        return serverReferenceCode;
    }

    /**
     * Define el valor de la propiedad serverReferenceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerReferenceCode(String value) {
        this.serverReferenceCode = value;
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

    /**
     * Obtiene el valor de la propiedad totalAmountRefunded.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmountRefunded() {
        return totalAmountRefunded;
    }

    /**
     * Define el valor de la propiedad totalAmountRefunded.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmountRefunded(BigDecimal value) {
        this.totalAmountRefunded = value;
    }

    /**
     * Obtiene el valor de la propiedad totalAmountCredited.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmountCredited() {
        return totalAmountCredited;
    }

    /**
     * Define el valor de la propiedad totalAmountCredited.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmountCredited(BigDecimal value) {
        this.totalAmountCredited = value;
    }

    /**
     * Obtiene el valor de la propiedad amountReserved.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountReserved() {
        return amountReserved;
    }

    /**
     * Define el valor de la propiedad amountReserved.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountReserved(BigDecimal value) {
        this.amountReserved = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

}
