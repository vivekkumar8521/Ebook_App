package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.BookOrderImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.Book_Order;
import com.entity.Cart;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            User u = (User) session.getAttribute("userobj");

            if (u == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            int id = u.getId();

            String name = req.getParameter("username");
            String email = req.getParameter("email");
            String phno = req.getParameter("phno");
            String address = req.getParameter("address");
            String landmark = req.getParameter("landmark");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String pincode = req.getParameter("pincode");
            String paymentType = req.getParameter("payment");

            String fullAdd = address + ", " + landmark + ", " + city + ", " + state + " - " + pincode;

            CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
            List<Cart> cartList = dao.getBookByUser(id);

            BookOrderImpl dao2 = new BookOrderImpl(DBConnect.getConn());
            int orderNo = dao2.getOrderNo();

            List<Book_Order> orderList = new ArrayList<>();

            for (Cart c : cartList) {
                Book_Order o = new Book_Order();
                o.setOrderId("BOOK-ORD-00" + orderNo++);
                o.setUserName(name);
                o.setEmail(email);
                o.setPhno(phno);
                o.setFulladd(fullAdd);
                o.setBookName(c.getBookName());
                o.setAuthor(c.getAuthor());
                o.setPrice(String.valueOf(c.getPrice()));
                o.setPaymentType(paymentType);
                o.setUserId(id);
                orderList.add(o);
            }

            if ("noselect".equals(paymentType)) {
                session.setAttribute("failedMsg", "Please choose a payment method");
                resp.sendRedirect("cart.jsp");
            } else {
                boolean saved = dao2.saveOrder(orderList);

                if (saved) {
                    session.setAttribute("orderSuccess", "Order placed successfully");
                    resp.sendRedirect("order_success.jsp");
                } else {
                    session.setAttribute("failedMsg", "Order failed, try again");
                    resp.sendRedirect("cart.jsp");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
