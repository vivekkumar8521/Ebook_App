package com.user.servlet;

import java.io.IOException;

import com.DAO.BookDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;
import com.entity.Cart;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int bid = Integer.parseInt(req.getParameter("bid"));

            HttpSession session = req.getSession();
            User u = (User) session.getAttribute("userobj");

            if (u == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            int uid = u.getId();

            // Use BookDAOImpl to get book
            BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
            BookDtls b = dao.getBookById(bid);

            if (b == null) {
                resp.sendRedirect("error.jsp");
                return;
            }

            Cart c = new Cart();
            c.setBid(bid);
            c.setUserId(uid);
            c.setBookName(b.getBookName());
            c.setAuthor(b.getAuthor());
            c.setPrice(Double.parseDouble(b.getPrice()));
            c.setTotalPrice(Double.parseDouble(b.getPrice()));

            CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
            boolean f = dao2.addCart(c);

            if (f) {
                session.setAttribute("addCart", "Book added to cart successfully!");
                resp.sendRedirect("all_new_book.jsp");
            } else {
                session.setAttribute("failed", "Something went wrong on server");
                resp.sendRedirect("all_new_book.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
