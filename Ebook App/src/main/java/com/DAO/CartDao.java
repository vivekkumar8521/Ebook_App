package com.DAO;

import java.util.List;

import com.entity.Cart;

public interface CartDao {

    // Add item to cart
    public boolean addCart(Cart c);

    // Get all cart items for a user
    public List<Cart> getBookByUser(int userId);

    // Delete cart item by cart id
    public boolean deleteBook(int bid, int uid, int cid);

    // Clear cart for a user
    public boolean clearCart(int userId);
}
