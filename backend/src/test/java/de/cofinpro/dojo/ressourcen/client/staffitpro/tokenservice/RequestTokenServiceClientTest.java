package de.cofinpro.dojo.ressourcen.client.staffitpro.tokenservice;

import org.junit.Test;

public class RequestTokenServiceClientTest {
    @Test
    public void testRequestToken() throws Exception {
        new RequestTokenServiceClient().requestToken();
    }
}
