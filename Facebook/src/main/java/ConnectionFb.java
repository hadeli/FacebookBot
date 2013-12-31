import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

/**
 * Created by chuck on 31/12/13.
 */
public class ConnectionFb {


    private static ConnectionFb ourInstance;
    public FacebookClient facebookClient;

    private  ConnectionFb (String accesToken) {
        facebookClient = new DefaultFacebookClient(accesToken);
    }

    public static ConnectionFb getInstance (String accesToken) {

        if(ourInstance == null)
            ourInstance = new ConnectionFb(accesToken);
        return ourInstance;
    }


}
