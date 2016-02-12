package storefile;

import transaction.LineItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * TextReader reads the stock text file and build the Stock object.
 */
public class TextReader implements ProductReader{
    private String fileName;

    public TextReader (String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, LineItem> read() {
        try {
            File file = new File (fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            Map<String, LineItem> stock = new HashMap<>();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    //reach EOF
                    break;
                } else {
                    line = line.trim();
                    if (!line.isEmpty()) { //skip empty line
                        //parse line
                        String upc = line.substring(0, 4).trim();
                        String description = line.substring(9, 29).trim();
                        float price = 0f;
                        try {
                            price = Float.valueOf(line.substring(34));
                        }
                        catch (NumberFormatException e) {}

                        Item item = new Item(upc, description, price);
                        LineItem lineItem = new LineItem(item, 10);
                        stock.put(upc, lineItem);
                    }
                }
            }
            return stock;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
