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
 * <p>Clase Java para MultipleTransactionOperationStatusType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="MultipleTransactionOperationStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Processing"/&gt;
 *     &lt;enumeration value="Processed"/&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MultipleTransactionOperationStatusType")
@XmlEnum
public enum MultipleTransactionOperationStatusType {

    @XmlEnumValue("Processing")
    PROCESSING("Processing"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Failed")
    FAILED("Failed");
    private final String value;

    MultipleTransactionOperationStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultipleTransactionOperationStatusType fromValue(String v) {
        for (MultipleTransactionOperationStatusType c: MultipleTransactionOperationStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
