package de.cofinpro.dojo.ressourcen.client.staffitpro.tokenservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://schemas.staffitpro.com/rest/2011/01/trust")
public class RequestSecurityTokenResponse {

    @XmlElement(name = "RequestedSecurityToken")
    private String requestedSecurityToken;
    @XmlElement(name = "TokenId")
    private String tokenId;
    @XmlElement(name = "TokenType")
    private String tokenType;
    @XmlElement(name = "ValidFrom")
    private String validFrom;
    @XmlElement(name = "ValidTo")
    private String validTo;
//
//    public String getRequestedSecurityToken() {
//        return requestedSecurityToken;
//    }
//
//    public void setRequestedSecurityToken(String requestedSecurityToken) {
//        this.requestedSecurityToken = requestedSecurityToken;
//    }
//
//    public String getTokenId() {
//        return tokenId;
//    }
//
//    public void setTokenId(String tokenId) {
//        this.tokenId = tokenId;
//    }
//
//    public String getTokenType() {
//        return tokenType;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.tokenType = tokenType;
//    }
//
//    public String getValidFrom() {
//        return validFrom;
//    }
//
//    public void setValidFrom(String validFrom) {
//        this.validFrom = validFrom;
//    }
//
//    public String getValidTo() {
//        return validTo;
//    }
//
//    public void setValidTo(String validTo) {
//        this.validTo = validTo;
//    }
}
