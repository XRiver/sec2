package config;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kylin on 15/11/28.
 */
public class DatabaseConfig {

    private final HashMap<String,String> params;

    public DatabaseConfig(Element element){
        this.params = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        List<Element> elements = element.elements("param");
        for (Element e : elements){
            this.params.put(e.attributeValue("key"),e.attributeValue("value"));
        }
    }

    public HashMap<String, String> getParams() {
        return params;
    }

}
