import com.restfb.Connection;
import com.restfb.types.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by chuck on 31/12/13.
 */
public class UserConnection {

    public static ConnectionFb connectionFb = ConnectionFb.getInstance("CAACEdEose0cBAGsbJva91MK9U8dhHUgvZAgZB5C5uskajheAPeRUhGu0W7XRqDu6jmyHMQ7NRvZAanVJPDE53vuNmKdVWJiHZAAyJjRijSwXdruasZCFB6RxlZBo2JlY4XAin0ryt3Q4NJWT0xZAkQcY0KICoIrEBHMxc7h83V6d9O6PeBuHpsdvZBmIxQQRoaYZD");
    static User me = connectionFb.facebookClient.fetchObject("me", User.class);;
    static Connection<User> myFriends = connectionFb.facebookClient.fetchConnection("me/friends", User.class);;
    static Connection<Page> myPage;




    public UserConnection() {


    }


    public void likePage(String pageName) {

        String idBibune = connectionFb.facebookClient.fetchObject("Bibune", Page.class).getId();
        Connection<Post> pagePost = connectionFb.facebookClient.fetchConnection("Bibune/posts", Post.class);
        System.out.println("Connection établi");
        System.out.println("On commence par les posts");
        for(List<Post> posts : pagePost)
        {
            for(Post post : posts)
            {
                System.out.println("    on doit like " + post.getName());
                this.connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class);
                System.out.println("    C'est fait");
            }
        }
        Connection<Photo> pagePicture = connectionFb.facebookClient.fetchConnection("Bibune/photos", Photo.class);
        System.out.println("On continue par les photos");
        for(List<Photo> photos : pagePicture)
        {
            for(Photo photo : photos)
            {
                System.out.println("    on doit like " + photo.getName());
                this.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
                System.out.println("    C'est fait");
            }
        }
        /*Connection<Album> pageAlbum = connectionFb.facebookClient.fetchConnection("Bibune/albums", Album.class);
        System.out.println("On continue par les albums");
        for(List<Album> albums : pageAlbum)
        {
            for(Album album : albums)
            {

                System.out.println("    on doit like " + album.getName());

                if(!album.getName().contains("Timeline") & !album.getName().contains("Profile")) {
                    userCoMe.connectionFb.facebookClient.publish(album.getId()+"/likes", Boolean.class);
                    Connection<Photo> photoConnection = connectionFb.facebookClient.fetchConnection(album.getId()+"/photos", Photo.class);
                    for(List<Photo> photos : pagePicture)
                    {
                        for(Photo photo : photos)
                        {
                            System.out.println("    on doit like " + photo.getName());
                            userCoMe.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
                            System.out.println("    C'est fait");
                        }
                    }
                }


                System.out.println("    C'est fait. Il contient " + album.getCount() + "photos");

               *//*Connection<Photo> photoConnection = connectionFb.facebookClient.fetchConnection(album.getId(), Photo.class);
                for(List<Photo> photos : pagePicture)
                {
                    for(Photo photo : photos)
                    {
                        System.out.println("    on doit like " + photo.getName());
                        userCoMe.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
                        System.out.println("    C'est fait");
                    }
                }*//*

            }
        }*/

        Connection<Post> pagePictures = connectionFb.facebookClient.fetchConnection("Bibune/timeline", Post.class);
        System.out.println("On continue par les photos");
        for(List<Post> photos : pagePictures)
        {
            for(Post photo : photos)
            {
                System.out.println("    on doit like " + photo.getName());
                this.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
                System.out.println("    C'est fait");
            }
        }

    }

    public static void likeUsers(String userName) {
        for (List<User> friends : myFriends)
        {
            for(User friend : friends)
            {

                if(friend.getName().contains(userName)) {
                    System.out.println(friend.getName());
                    System.out.println("    J'ai trouvé. Id : " + friend.getId());
                    Connection<Post> yourPosts = connectionFb.facebookClient.fetchConnection(friend.getId() + "/posts", Post.class);
                    System.out.println("        La connection est etabli");
                    for(List<Post> posts : yourPosts)
                    {
                        System.out.println("Il y a " + posts.size() + " post dispos");
                        for(Post post : posts)
                        {
                            List<Post.Action> testAction = post.getActions();
                            for(Post.Action action : testAction)
                            {
                                System.out.println(action.getName());
                                if(action.getName().equals("Like")) {
                                    System.out.println(post.getMessage());
                                    connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class);
                                }


                            }
                        }
                    }
                }
            }
        }
    }



    public static void main (String[] argv) {

        likeUsers("Yasmine");







    }
}
