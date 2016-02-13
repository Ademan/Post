package storefile;

import java.util.ArrayList;
import post.Post;

import java.util.List;

/**
 * Store contains Stock and Catalog as well as a Post list
 */
public class Store {
    //Change path to the stock text file name here
    private final static String stockFile = "products.txt";

    private Stock mStock;
    private Catalog mCatalog;
    List <Post> mPostList;

    public Store(){
        //Default constructor.
        mStock = new Stock(stockFile);
        mCatalog = new Catalog(mStock);
        mPostList = new ArrayList();
    }

    public Stock getStock(){return mStock;}

    public Catalog getCatalog(){ return mCatalog; }

    public List<Post> getPosts(){ return mPostList; }

    public void addPost(Post post) {
        mPostList.add(post);
    }
}
