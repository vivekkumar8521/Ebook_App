package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.entity.Book_Order;

public class BookOrderImpl implements BookOrderDAO {

    private Connection conn;

    public BookOrderImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public int getOrderNo() {
        int i = 1;
        try {
            String sql = "select * from book_order";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean saveOrder(List<Book_Order> blist) {
        boolean f = false;

        try {
            String sql = "insert into book_order(order_id,username,email,address,phno,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";

            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (Book_Order b : blist) {
                ps.setString(1, b.getOrderId());
                ps.setString(2, b.getUserName());
                ps.setString(3, b.getEmail());
                ps.setString(4, b.getFulladd());
                ps.setString(5, b.getPhno());
                ps.setString(6, b.getBookName());
                ps.setString(7, b.getAuthor());
                ps.setString(8, b.getPrice());
                ps.setString(9, b.getPaymentType());
                ps.addBatch();
            }

            int[] count = ps.executeBatch(); // ✅ Semicolon fixed
            conn.commit();
            f = true;
            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return f;  // ✅ Corrected return value
    }
}
