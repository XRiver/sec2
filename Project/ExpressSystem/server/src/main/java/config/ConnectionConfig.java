package config;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kylin on 15/11/28.
 */
public class ConnectionConfig {

    private final HashMap<String,String> params;

    private final String serverIP;
    private final String port;

    public ConnectionConfig(Element element){
        params = new HashMap<>();
        @SuppressWarnings("unchecked")
        List<Element> elements = element.elements("param");
        for (Element e : elements){
            params.put(e.attributeValue("key"),e.attributeValue("value"));
        }
        serverIP = params.get("serverIP");
        port =  params.get("port");
    }

    public String getServerIP() {
        return serverIP;
    }

    public String getPort() {
        return port;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
