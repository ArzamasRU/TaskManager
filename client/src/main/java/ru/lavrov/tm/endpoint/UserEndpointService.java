package ru.lavrov.tm.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.5
 * 2020-04-12T22:15:46.679+03:00
 * Generated source version: 3.3.5
 *
 */
@WebServiceClient(name = "UserEndpointService",
                  wsdlLocation = "http://localhost:8090/UserEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.lavrov.ru/")
public class UserEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.lavrov.ru/", "UserEndpointService");
    public final static QName UserEndpointPort = new QName("http://endpoint.tm.lavrov.ru/", "UserEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/UserEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/UserEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UserEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UserEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UserEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UserEndpoint
     */
    @WebEndpoint(name = "UserEndpointPort")
    public UserEndpoint getUserEndpointPort() {
        return super.getPort(UserEndpointPort, UserEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserEndpoint
     */
    @WebEndpoint(name = "UserEndpointPort")
    public UserEndpoint getUserEndpointPort(WebServiceFeature... features) {
        return super.getPort(UserEndpointPort, UserEndpoint.class, features);
    }

}
