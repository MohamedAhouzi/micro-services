
package proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCompteResponse complex type.
 *
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="getCompteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws/}compte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompteResponse", propOrder = {
        "_return"
})
public class GetCompteResponse {

    @XmlElement(name = "return")
    protected Compte _return;

    /**
     * Obtient la valeur de la propri�t� return.
     *
     * @return possible object is
     * {@link Compte }
     */
    public Compte getReturn() {
        return _return;
    }

    /**
     * D�finit la valeur de la propri�t� return.
     *
     * @param value allowed object is
     *              {@link Compte }
     */
    public void setReturn(Compte value) {
        this._return = value;
    }

}
