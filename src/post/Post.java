package post;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storefile.Store;
import transaction.TextReceipt;
import transaction.Transaction;
import transaction.TransactionReader;

public class Post {
    
    List<Transaction> trs;
    
    public void startProcessingTransactions(Store store) {
        
        trs = new ArrayList();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("transactions.txt")));
            TransactionReader tr = new TransactionReader(br, store.getCatalog());
            
            Transaction temp;
            while((temp = tr.getNext()) != null)
                trs.add(temp);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Writer w = new PrintWriter(System.out);
        
        System.out.println("\n\n" + trs.size() + "\n");
        
        for(Transaction t : trs)
        {
            TextReceipt trc = new TextReceipt(t);
            trc.writeTransaction(w);
        }
        
    }
}
