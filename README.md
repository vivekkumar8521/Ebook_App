# 📚 Ebook_App - Java JSP/Servlet Project

An online eBook store web application built using **JSP + Servlet + JDBC + MySQL**. It allows users to register, log in, view books, and place orders. Admins can manage books and view orders.

---

## ✅ Features

- User Registration & Login
- View Available Books
- Book Detail Page
- Place Orders (Add to Cart / Buy)
- Admin Dashboard (Add/Edit/Delete Books, View Orders)
- Session Handling
- JSP + Servlet (MVC architecture)
- JDBC + MySQL integration

---
🛠 Technology Stack:
Layer | Technology
Frontend | HTML, CSS, JSP
Backend | Java Servlet
Database | MySQL
Connection | JDBC
Server | Apache Tomcat 

## 📁 Project Folder Structure

```
Ebook_App/
│
├── src/
│   ├── dao/             # Interfaces
│   ├── dao/impl/        # DAO Implementations
│   ├── model/           # JavaBeans (Book, User, Order)
│   ├── servlet/         # Controllers (Login, Register, etc.)
│
├── WebContent/
│   ├── css/
│   ├── img/
│   ├── jsp/
│   │   ├── home.jsp
│   │   ├── login.jsp
│   │   ├── register.jsp
│   │   ├── book_detail.jsp
│   │   └── admin/
│   ├── index.jsp
│   └── WEB-INF/web.xml
```

---

## 🛠 Setup Instructions

### 1. Create Project in Eclipse (Dynamic Web Project)
- File → New → Dynamic Web Project
- Project Name: `Ebook_App`
- Target Runtime: Apache Tomcat (8.5+)
- Click Finish

### 2. Create MySQL Database

```sql
CREATE DATABASE ebookdb;

USE ebookdb;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(100),
    category VARCHAR(100),
    price DOUBLE,
    description TEXT,
    image VARCHAR(255)
);

CREATE TABLE cart (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    quantity INT DEFAULT 1,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


```

### 3. Add JDBC Connector
- Download MySQL JDBC Driver
- Add the `.jar` to your project's `lib` folder or Build Path

## 💾 DAO & JDBC Setup

### Interface: `BookDAO.java`
```java
public interface BookDAO {
    boolean addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
}
```

### Implementation: `BookDAOImpl.java`
```java
public class BookDAOImpl implements BookDAO {
    private Connection con;
    public BookDAOImpl(Connection con) { this.con = con; }

    public boolean addBook(Book book) { ... }
    public List<Book> getAllBooks() { ... }
    public Book getBookById(int id) { ... }
}
```

---

## 🌐 JSP Pages

### home.jsp
```jsp
<%
    BookDAOImpl dao = new BookDAOImpl(DBConnection.getConnection());
    List<Book> list = dao.getAllBooks();
%>
<% for(Book b : list) { %>
    <div><h3><%= b.getTitle() %></h3></div>
<% } %>
```

### login.jsp / register.jsp
Forms for user login and registration.

### book_detail.jsp
Shows selected book info with "Buy Now" option.

---

## 🔐 Servlet Controllers

### Example: `LoginServlet.java`
- Gets `email` and `password` from request
- Validates via UserDAO
- If valid, creates session and redirects to `home.jsp`

### Others:
- RegisterServlet.java
- BookDetailServlet.java
- OrderServlet.java

---

## ⚙️ web.xml Configuration

```xml
<web-app>
    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>servlet.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
</web-app>
```

---

## 🧪 Run the Project

1. Start Apache Tomcat
2. Right-click project → Run on Server
3. Access app: [http://localhost:8080/Ebook_App](http://localhost:8080/Ebook_App)

---

## 📦 Admin Panel

- Admin can:
  - Add/Edit/Delete Books
  - View Orders
- Admin authentication via session/login

---

## 💡 Tech Stack

- Java (JSP + Servlet)
- JDBC (MySQL)
- HTML/CSS + Bootstrap (UI)
- Apache Tomcat
- MySQL

---

## Screenshot


1 .Home Page
![Screenshot (7)](https://github.com/user-attachments/assets/c6453eaf-9dad-4863-9145-58862ad9e033)



2. Recent Book
![Screenshot (8)](https://github.com/user-attachments/assets/f5dca248-34ea-4740-82ae-ae2a6c614abf)



3.User Registration
![Screenshot (9)](https://github.com/user-attachments/assets/b33ba8ad-1227-40e0-b2fc-187d9b49bf28)



4.Login
![Screenshot (10)](https://github.com/user-attachments/assets/5a8a99c0-af79-44f2-8109-ad8175780f33)



5.Admin Login
![Screenshot (11)](https://github.com/user-attachments/assets/8338632c-e087-44e6-a68f-d123cc35b872)



6. Add Book
![Screenshot (12)](https://github.com/user-attachments/assets/04663b0e-bb5e-421b-a6fc-79f5028d8e14)



7.All Book // Edit & Delete
![Screenshot (13)](https://github.com/user-attachments/assets/b1ae917c-af4a-4503-bff8-0558d781c673)



8. User Ordered Data Handle/Seen By Admin 
![Screenshot (14)](https://github.com/user-attachments/assets/38c41957-bb64-4d26-9640-d921a51da7c0)



9.Admin Logout
![Screenshot (15)](https://github.com/user-attachments/assets/999103e7-0b78-45d4-a091-3157cbd0f2b1)



10.User Add To Cart
![Screenshot (16)](https://github.com/user-attachments/assets/3b80c560-37fe-4576-b67a-e659cdab5b53)



11. User Setting
![Screenshot (17)](https://github.com/user-attachments/assets/1ae8c5f0-8ce8-4824-9442-310a510606a4)



13. User Edit Profile
![Screenshot (18)](https://github.com/user-attachments/assets/a7eb8d8f-1502-4a45-a3f1-54edd9f598f8)



13.User Ordered By Book
![Screenshot (19)](https://github.com/user-attachments/assets/87ae1200-1690-40c3-a712-4714979ff93f)






## 📄 License

This project is for educational purposes only. Not intended for commercial use.

