package com.DAO;

import java.util.List;
import com.entity.Book_Order;

public interface BookOrderDAO {

    // Get the next order number
    public int getOrderNo();

    // Save order (main method to implement)
    public boolean saveOrder(List<Book_Order> blist);
    
    
}
