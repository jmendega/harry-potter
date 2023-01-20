//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.17 a las 06:05:36 PM COT 
//


package com.telefonica.schemas.unica.soap.payment.v2.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransactionOperationStatusType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionOperationStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Processing"/&gt;
 *     &lt;enumeration value="AuthorizationInProgress"/&gt;
 *     &lt;enumeration value="Authorized"/&gt;
 *     &lt;enumeration value="Charged"/&gt;
 *     &lt;enumeration value="Refunded"/&gt;
 *     &lt;enumeration value="Credited"/&gt;
 *     &lt;enumeration value="Reserved"/&gt;
 *     &lt;enumeration value="Released"/&gt;
 *     &lt;enumeration value="Denied"/&gt;
 *     &lt;enumeration value="Refused"/&gt;
 *     &lt;enumeration value="Unauthorized"/&gt;
 *     &lt;enumeration value="Terminated"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransactionOperationStatusType")
@XmlEnum
public enum TransactionOperationStatusType {

    @XmlEnumValue("Processing")
    PROCESSING("Processing"),
    @XmlEnumValue("AuthorizationInProgress")
    AUTHORIZATION_IN_PROGRESS("AuthorizationInProgress"),
    @XmlEnumValue("Authorized")
    AUTHORIZED("Authorized"),
    @XmlEnumValue("Charged")
    CHARGED("Charged"),
    @XmlEnumValue("Refunded")
    REFUNDED("Refunded"),
    @XmlEnumValue("Credited")
    CREDITED("Credited"),
    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),
    @XmlEnumValue("Released")
    RELEASED("Released"),
    @XmlEnumValue("Denied")
    DENIED("Denied"),
    @XmlEnumValue("Refused")
    REFUSED("Refused"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated");
    private final String value;

    TransactionOperationStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionOperationStatusType fromValue(String v) {
        for (TransactionOperationStatusType c: TransactionOperationStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
