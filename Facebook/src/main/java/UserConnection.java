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
    static User me;
    static Connection<User> myFriends;
    static Connection<Page> myPage;


    public UserConnection() {
        me = connectionFb.facebookClient.fetchObject("me", User.class);
        myFriends = connectionFb.facebookClient.fetchConnection("me/friends", User.class);
        //myPage = connectionFb.facebookClient.fetchConnectionPage("Bibune", Page.class);

    }

    public static void main (String[] argv) {

        List<Post.Likes> idLiked = new ArrayList<Post.Likes>();



        UserConnection userCoMe = new UserConnection();
        System.out.println(userCoMe.me.getId());
        /*for(List<Page> pages : myPage) {
            for(Page page : pages) {
                page.
            }
        }*/
        String idBibune = connectionFb.facebookClient.fetchObject("Bibune", Page.class).getId();
        Connection<Post> pagePost = connectionFb.facebookClient.fetchConnection("Bibune/posts", Post.class);
        System.out.println("Connection établi");
        System.out.println("On commence par les posts");
        for(List<Post> posts : pagePost)
        {
            for(Post post : posts)
            {
                System.out.println("    on doit like " + post.getName());
                userCoMe.connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class);
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
                userCoMe.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
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
                userCoMe.connectionFb.facebookClient.publish(photo.getId()+"/likes", Boolean.class);
                System.out.println("    C'est fait");
            }
        }

        /*for (List<User> friends : myFriends)
        {
            for(User friend : friends)
            {

                if(friend.getName().contains("Antonin")) {
                    System.out.println(friend.getName());
                    System.out.println("    J'ai trouvé. Id : " + friend.getId());
                    Connection<Post> yourPosts = userCoMe.connectionFb.facebookClient.fetchConnection(friend.getId() + "/posts", Post.class);
                    System.out.println("        La connection est etabli");
                    for(List<Post> posts : yourPosts)
                    {
                        System.out.println("Il y a " + posts.size() + " post dispos");
                        for(Post post : posts)
                        {
                            System.out.println(post.getMessage());
                            userCoMe.connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class);
                            idLiked.add(post.getLikes());
                            userCoMe.connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class);
                            break;
                        }
                        break;
                    }


                   *//* try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*//*
                   *//* for(Post.Likes likes : idLiked)
                    {
                        for(NamedFacebookType likeses : likes.getData())
                        {
                            userCoMe.connectionFb.facebookClient.publish(post.getId()+"/likes", Boolean.class)
                        }
                    }*//*

                }


            }
        }*/



    }
}
