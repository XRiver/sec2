package connection;

/**
 * Created by kylin on 15/11/21.
 */
public class ServerMain {

    public static void main(String[] args) {
        if(RMIPublisher.buildConnection()){
            System.out.println("服务器已建立!");
        }
    }
}
