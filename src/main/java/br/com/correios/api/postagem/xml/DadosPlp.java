//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.03.07 at 04:22:37 PM BRT
//


package br.com.correios.api.postagem.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlMarshalNullRepresentation;
import org.eclipse.persistence.oxm.annotations.XmlNullPolicy;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}id_plp"/>
 *         &lt;element ref="{}valor_global"/>
 *         &lt;element ref="{}mcu_unidade_postagem"/>
 *         &lt;element ref="{}nome_unidade_postagem"/>
 *         &lt;element ref="{}cartao_postagem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idPlp",
    "valorGlobal",
    "mcuUnidadePostagem",
    "nomeUnidadePostagem",
    "cartaoPostagem"
})
@XmlRootElement(name = "plp")
public class DadosPlp {

    @XmlElement(name = "id_plp", required = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    protected String idPlp;
    @XmlElement(name = "valor_global", required = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    protected String valorGlobal;
    @XmlElement(name = "mcu_unidade_postagem", required = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    protected String mcuUnidadePostagem;
    @XmlElement(name = "nome_unidade_postagem", required = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    protected String nomeUnidadePostagem;
    @XmlElement(name = "cartao_postagem", required = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    protected String cartaoPostagem;

    /**
     * Gets the value of the idPlp property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdPlp() {
        return idPlp;
    }

    /**
     * Sets the value of the idPlp property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdPlp(String value) {
        this.idPlp = value;
    }

    /**
     * Gets the value of the valorGlobal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValorGlobal() {
        return valorGlobal;
    }

    /**
     * Sets the value of the valorGlobal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValorGlobal(String value) {
        this.valorGlobal = value;
    }

    /**
     * Gets the value of the mcuUnidadePostagem property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMcuUnidadePostagem() {
        return mcuUnidadePostagem;
    }

    /**
     * Sets the value of the mcuUnidadePostagem property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMcuUnidadePostagem(String value) {
        this.mcuUnidadePostagem = value;
    }

    /**
     * Gets the value of the nomeUnidadePostagem property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNomeUnidadePostagem() {
        return nomeUnidadePostagem;
    }

    /**
     * Sets the value of the nomeUnidadePostagem property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNomeUnidadePostagem(String value) {
        this.nomeUnidadePostagem = value;
    }

    /**
     * Gets the value of the cartaoPostagem property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCartaoPostagem() {
        return cartaoPostagem;
    }

    /**
     * Sets the value of the cartaoPostagem property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCartaoPostagem(String value) {
        this.cartaoPostagem = value;
    }

}
