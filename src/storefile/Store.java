package storefile;

import transactionfile.Post;

import java.util.List;

public class Store {
    private Stock mStock;
    private Catalog mCatalog;
    List <Post> mPostList;

    public Store(){
        //Default constructor.
    }
    
    public Stock getStock(){return mStock;}

    public Catalog getCatalog(){ return mCatalog; }

    public List<Post> getPosts(){ return mPostList; }


}
