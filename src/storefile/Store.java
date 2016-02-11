package storefile;

import transactionfile.Post;

import java.util.List;

/**
 * Created by Allen Space on 2/10/2016.
 */
public class Store {
    private Stock mStock;
    private Catalog mCatalog;
    List <Post> mPostList;

    public Store(){
        //Default Constructor.
    }

    public Stock getStock(){
        return mStock;
    }

    public Catalog getCatalog(){
        return mCatalog;
    }

    public List<Post> getPosts(){
        return mPostList;
    }


}
