package storefile;

import post.Post;


public class Manager {
    private static Store mStore;

    public Manager(){
        //defualt constructor.
    }

    public void init(String pCatalogFiles){
        mStore = new Store();
    }
    
    // temp: for testing
    public void go() {
        Post post = new Post();
        mStore.addPost(post);
        mStore.mPostList.get(0).startProcessingTransactions(mStore);
    }
}
