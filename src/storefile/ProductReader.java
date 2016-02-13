package storefile;

import transaction.LineItem;

import java.util.Map;

/**
 * Created by hduan on 2/11/2016.
 */
public interface ProductReader {
    public Map <String, LineItem> read();
}
