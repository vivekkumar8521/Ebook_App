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

### 4. Create Model Classes

#### Example: `Book.java`
```java
public class Book {
    private int id;
    private String title, author, category, image;
    private double price;
    private String description;
    // Getters and Setters
}
```

---

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

## 📄 License

This project is for educational purposes only. Not intended for commercial use.

