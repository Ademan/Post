package post.app;

import storefile.Manager;

public class Main {

    public static void main(String[] args) {
	Manager m = new Manager();
        m.init("products.txt");
        m.go();
    }
}
