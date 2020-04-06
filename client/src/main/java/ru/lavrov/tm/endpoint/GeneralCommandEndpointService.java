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
 * 2020-04-06T18:22:18.977+03:00
 * Generated source version: 3.3.5
 *
 */
@WebServiceClient(name = "GeneralCommandEndpointService",
                  wsdlLocation = "http://localhost:8090/GeneralCommandEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.lavrov.ru/")
public class GeneralCommandEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.lavrov.ru/", "GeneralCommandEndpointService");
    public final static QName GeneralCommandEndpointPort = new QName("http://endpoint.tm.lavrov.ru/", "GeneralCommandEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/GeneralCommandEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(GeneralCommandEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/GeneralCommandEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public GeneralCommandEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GeneralCommandEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GeneralCommandEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public GeneralCommandEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public GeneralCommandEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public GeneralCommandEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns GeneralCommandEndpoint
     */
    @WebEndpoint(name = "GeneralCommandEndpointPort")
    public GeneralCommandEndpoint getGeneralCommandEndpointPort() {
        return super.getPort(GeneralCommandEndpointPort, GeneralCommandEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GeneralCommandEndpoint
     */
    @WebEndpoint(name = "GeneralCommandEndpointPort")
    public GeneralCommandEndpoint getGeneralCommandEndpointPort(WebServiceFeature... features) {
        return super.getPort(GeneralCommandEndpointPort, GeneralCommandEndpoint.class, features);
    }

}
