
package proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCompte complex type.
 *
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="getCompte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompte", propOrder = {
        "code"
})
public class GetCompte {

    protected Long code;

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

}
