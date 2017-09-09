package de.cofinpro.dojo.ressourcen.client.staffitpro.tokenservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RequestSecurityToken",namespace = "http://schemas.staffitpro.com/rest/2011/01/trust")
public class RequestTokenRequest {
    private final static String DEFAULT_TOKEN_TYPE = "http://staffITpro.com/tokens/staffITproSecurityToken/type";

    @XmlElement//(name = "AppliesTo")
    private String appliesTo;
    @XmlElement//(name = "TokenType")
    private String tokenType;

    public RequestTokenRequest() {
        this.tokenType = DEFAULT_TOKEN_TYPE;
    }

    public RequestTokenRequest(String appliesTo) {
        this();
        this.appliesTo = appliesTo;
    }
//
//    public String getAppliesTo() {
//        return appliesTo;
//    }
//
//    public void setAppliesTo(String appliesTo) {
//        this.appliesTo = appliesTo;
//    }
//
//    public String getTokenType() {
//        return tokenType;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.tokenType = tokenType;
//    }
}
