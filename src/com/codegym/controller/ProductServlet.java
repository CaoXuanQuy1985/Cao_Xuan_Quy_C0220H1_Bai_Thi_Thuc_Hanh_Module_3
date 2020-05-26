package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.DatabaseServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ProductServlet", urlPatterns ="/products")
public class ProductServlet extends HttpServlet{
    private DatabaseServiceImpl databaseService = new DatabaseServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "listProducts":
                doGet_listProducts(request, response);
                break;
            case "addNew":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                doGet_listProducts(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String sql_query = "delete from  thuc_hanh_module_3.products " +
                " where id_product = ?;";
        try {
            Connection conn = databaseService.setCheckForeignKey();
            PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setInt(1, id_product);
            pstmt.executeUpdate();
            Product oldProduct = null;

       /*     while (rs.next()) {
                id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int id_category = rs.getInt("id_category");

                oldProduct = new Product(id_product, name, price, quantity, color, description, id_category);
            }*/

          /*  request.setAttribute("oldProduct", oldProduct);*/
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("view/list-products.jsp");
            dispatcher.forward(request, response);*/
            doGet_listProducts(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String sql_query = "select id_product, name, price, quantity, color, description, id_category" +
                " from thuc_hanh_module_3.products " +
                "where id_product = ?;";
        try {
            Connection conn = databaseService.setCheckForeignKey();
            PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setInt(1, id_product);
            ResultSet rs = pstmt.executeQuery();
            Product oldProduct = null;

            while (rs.next()) {
                id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int id_category = rs.getInt("id_category");

                oldProduct = new Product(id_product, name, price, quantity, color, description, id_category);
            }

            request.setAttribute("oldProduct", oldProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit-product.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       /* RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit-product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }*/
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String sql_query = "select id_product, name, price, quantity, color, description, id_category" +
                " from thuc_hanh_module_3.products" +
                "where id_product = ?;";
        try {
            Connection conn = databaseService.setCheckForeignKey();
            PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setInt(1, id_product);
            ResultSet rs = pstmt.executeQuery();
            Product oldProduct = null;

            while (rs.next()) {
                id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int id_category = rs.getInt("id_category");

                oldProduct = new Product(name, price, quantity, color, description, id_category);
            }

            request.setAttribute("oldProduct", oldProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit-product.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "search":
                searchProduct(request, response);
                break;
            case "listProducts":
                doGet_listProducts(request, response);
                break;
            case "addNew":
                addNewProduct(request, response);
                break;
            case "editAction":
               /* editForm(request, response);*/
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "editProduct":
                editNewProduct(request, response);
            default:
                doGet_listProducts(request, response);
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("search");
        String query = "select * from thuc_hanh_module_3.products where name = ?;";
        Connection conn = databaseService.setCheckForeignKey();
        ArrayList<Product> productList = new ArrayList<>();
        Product product = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nameSearch);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
               String color = rs.getString("color");
                int id_category = rs.getInt("id_category");

                product = new Product(id_product, name, price, quantity, color, id_category);
                productList.add(product);
            }

            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/search-result.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServletException | IOException ex) {
        ex.printStackTrace();
        }
    }

    private void editNewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name_product");
        float price = Float.parseFloat(request.getParameter("price_product"));
        int quantity = Integer.parseInt(request.getParameter("quantity_product"));
        String color = request.getParameter("color_product");
        String description = request.getParameter("des_product");
        int id_category_product = Integer.parseInt(request.getParameter("id_category_product"));

        Product newProduct = new Product(name, price, quantity, color, description, id_category_product);
        String query = "update thuc_hanh_module_3.products set name = ?, price = ?, quantity = ?, color = ?, description = ?, id_category = ? " +
                " where id_product = ?;";

        Connection conn = databaseService.setCheckForeignKey();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setFloat(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setString(4, color);
            pstmt.setString(5, description);
            pstmt.setInt(6, id_category_product);
            pstmt.setInt(7, id_product);
            pstmt.executeUpdate();
            /*name = request.getParameter("nameProduct");
            float price = Float.parseFloat(request.getParameter("priceProduct"));
            int quantity = Integer.parseInt(request.getParameter("quantiyProduct"));
            String color = request.getParameter("colorProduct");
            String desProuduct = request.getParameter("desProduct");
            int id_category = Integer.parseInt(request.getParameter("categoryProduct"));*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void doGet_listProducts(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = databaseService.setCheckForeignKey();
/*        String query_select_all = "select id_product, name, price, quantity, color, category.category_product from  " +
                " thuc_hanh_module_3.products inner join thuc_hanh_module_3.category using(id_category)";*/

        String query_select_all = "select id_product, name, price, quantity, color, id_category from  " +
                " thuc_hanh_module_3.products;";
        ArrayList<Product> productList = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query_select_all);
            ResultSet rs = pstmt.executeQuery();
            Product product = null;
            int id_product = 0;
            String name = "";
            float price = 0.0f;
            int quantity = 0;
            String color = "";
            int id_category = 0;

            while (rs.next()) {
                id_product = rs.getInt("id_product");
                name = rs.getString("name");
                price = rs.getFloat("price");
                quantity = rs.getInt("quantity");
                color = rs.getString("color");
                id_category = rs.getInt("id_category");

                product = new Product(id_product, name, price, quantity, color, id_category);
                productList.add(product);
            }

            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list-products.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/add-new-form.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = databaseService.setCheckForeignKey();
        String query_add_new = "insert into thuc_hanh_module_3.products(name, price, quantity, color, description, id_category) " +
                " values(?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query_add_new);
            String name = request.getParameter("nameProduct");
            float price = Float.parseFloat(request.getParameter("priceProduct"));
            int quantity = Integer.parseInt(request.getParameter("quantiyProduct"));
            String color = request.getParameter("colorProduct");
            String desProuduct = request.getParameter("desProduct");
            int id_category = Integer.parseInt(request.getParameter("categoryProduct"));

            pstmt.setString(1, name);
            pstmt.setFloat(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setString(4, color);
            pstmt.setString(5, desProuduct);
            pstmt.setInt(6, id_category);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
