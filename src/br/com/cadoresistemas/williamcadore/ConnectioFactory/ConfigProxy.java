package br.com.cadoresistemas.williamcadore.ConnectioFactory;

public class ConfigProxy {

    public void SetProxySystem(boolean proxySet, String proxyHost, String proxyPort, String proxyUser, String proxyPassword){
        System.getProperties().put("proxySet", proxySet);
        System.getProperties().put("http.proxyHost", proxyHost);
        System.getProperties().put("http.proxyPort", proxyPort);
        System.getProperties().put("http.proxyUser", proxyUser);
        System.getProperties().put("http.proxyPassword", proxyPassword);
    }

}
