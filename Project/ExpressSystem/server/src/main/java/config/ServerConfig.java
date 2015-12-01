package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by kylin on 15/11/28.
 */
public class ServerConfig {

    private static DatabaseConfig DATABASE_CONFIG = null;

    private static ConnectionConfig CONNECTION_CONFIG = null;

    private static final boolean IS_DEBUG = true;

    static {
        try {
            if (IS_DEBUG) {
                SAXReader reader = new SAXReader();
                Document document = reader.read("/Users/kylin/Desktop/sec2/Project/ExpressSystem/server/src/main/java/config/config.xml");
                Element server = document.getRootElement();
                DATABASE_CONFIG = new DatabaseConfig(server.element("database"));
                CONNECTION_CONFIG = new ConnectionConfig(server.element("connection"));
            }else{
                ObjectInputStream obj = new ObjectInputStream(
                        new FileInputStream("config/databaseConfig.dat"));
                DATABASE_CONFIG = (DatabaseConfig) obj.readObject();
                obj = new ObjectInputStream(
                        new FileInputStream("config/connectionConfig.dat"));
                CONNECTION_CONFIG = (ConnectionConfig) obj.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConfig getDatabaseConfig() {
        return DATABASE_CONFIG;
    }

    public static ConnectionConfig getConnectionConfig() {
        return CONNECTION_CONFIG;
    }

    public static void main(String[] args) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("config/databaseConfig.dat"));
		oos.writeObject(DATABASE_CONFIG);
		 oos = new ObjectOutputStream(new FileOutputStream("config/connectionConfig.dat"));
		oos.writeObject(CONNECTION_CONFIG);
		oos.close();
	}

}
