package de.cofinpro.dojo.ressourcen.client.staffitpro.tokenservice;

import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import de.cofinpro.dojo.ressourcen.service.ResourceService;
//import org.apache.http.conn.scheme.PlainSocketFactory;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;
import java.util.logging.Logger;

public class RequestTokenServiceClient {
//    private static final Logger LOG = Logger.getLogger(RequestTokenServiceClient.class.getName());
//
//    private final static String tokenType = "http://staffITpro.com/tokens/staffITproSecurityToken/type";
//    private final String serviceAddress;
//    private final String databaseName;
//    private final String userName;
//    private final String userPassword;
//    private final String appGuid;
//    private boolean isHttps;
//
//    private Client client;
//
//    private WebTarget baseTarget;
//
//    public RequestTokenServiceClient(String serviceAddress, String databaseName, String userName, String userPassword, String appGuid, boolean isHttps) {
//        client = ClientBuilder.newBuilder().build();
//        baseTarget = client.target(serviceAddress);
//        this.serviceAddress = serviceAddress;
//        this.databaseName = databaseName;
//        this.userName = userName;
//        this.userPassword = userPassword;
//        this.appGuid = appGuid;
//        this.isHttps = isHttps;
//    }
//
//    public RequestTokenServiceClient() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//        TrustStrategy trustStrategy = new TrustStrategy() {
//
//            @Override
//            public boolean isTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
//                return true;
//            }
//        };
//        SSLSocketFactory factory = new SSLSocketFactory(trustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        client = ClientBuilder.newBuilder().hostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String s, SSLSession sslSession) {
//                return true;
//            }
//        }).register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()))
//                .register(new Scheme("https", 443, factory))
//                .build();
//        this.isHttps = true;
//        this.serviceAddress = "www.staffITproCloudDemo.de/staffITproWebApi";
//        baseTarget = client.target(this.isHttps ? "https://" + serviceAddress : "http://" + serviceAddress);
//        this.databaseName = "staffITproWebApiDemo";
//        this.userName = "TEP";
//        this.userPassword = "SIP*2009T";
//        this.appGuid = "462EA3BCFD95444AB4C7B0C4B87EE2252B778E0065AE453C969383D2281F45036FC3B69D044F4997A23F9D1DF96BFF327E23910200E3474C899335E01F1A9EF9";
//        this.isHttps = true;
//    }
//
//    public RequestSecurityTokenResponse requestToken() {
//        RequestTokenRequest request = new RequestTokenRequest(this.serviceAddress);
//        StringBuilder headerAuthorizationBuilder = new StringBuilder();
//        headerAuthorizationBuilder//
//                .append("SIP sip_username=").append(this.userName)//
//                .append(" sip_password=").append(this.userPassword)//
//                .append(" sip_database=").append(this.databaseName)//
//                .append(" app_key=").append(this.appGuid);
//        Response response = baseTarget.path("Token")//
//                .request()//
//
//                .header("Authorization", headerAuthorizationBuilder.toString())//
//                .accept(MediaType.TEXT_XML)
//                .post(Entity.entity(request, MediaType.TEXT_XML));
//        RequestSecurityTokenResponse responseXml = response.readEntity(RequestSecurityTokenResponse.class);
//        response.close();  // You should close connections!
//        return responseXml;
//    }
//
//    public List<ResourceRequest> getAllResourceRequests() {
//        GenericType<List<RequestTokenRequest>> genericType = new GenericType<List<RequestTokenRequest>>() {
//        };
//        Response response = baseTarget.path("requests").request().get();
//        List<ResourceRequest> value = response.readEntity(genericType);
//        response.close();  // You should close connections!
//        return value;
//    }
//
//    public ResourceRequest getResourceRequestById(String id) {
//        Response response = baseTarget.path("requests").path(id).request().get();
//        return response.readEntity(ResourceRequest.class);
//    }
}
