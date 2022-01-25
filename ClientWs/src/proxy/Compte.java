
package proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour compte complex type.
 *
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="compte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dateCreation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="solde" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compte", propOrder = {
        "code",
        "dateCreation",
        "solde"
})
public class Compte {

    protected Long code;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreation;
    protected double solde;

    /**
     * Obtient la valeur de la propri�t� code.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getCode() {
        return code;
    }

    /**
     * D�finit la valeur de la propri�t� code.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCode(Long value) {
        this.code = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateCreation.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDateCreation() {
        return dateCreation;
    }

    /**
     * D�finit la valeur de la propri�t� dateCreation.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDateCreation(XMLGregorianCalendar value) {
        this.dateCreation = value;
    }

    /**
     * Obtient la valeur de la propri�t� solde.
     */
    public double getSolde() {
        return solde;
    }

    /**
     * D�finit la valeur de la propri�t� solde.
     */
    public void setSolde(double value) {
        this.solde = value;
    }

}
