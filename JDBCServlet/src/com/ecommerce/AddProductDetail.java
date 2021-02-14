package com.ecommerce;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DBConnection;
import com.utils.PropertyReader;

/**
 * Servlet implementation class AddProductDetail
 */
public class AddProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();        
	        DBConnection conn;
			try {
				out.println("<html><body>");
				conn = new DBConnection(PropertyReader.ReadProperty("url"), PropertyReader.ReadProperty("userid"), PropertyReader.ReadProperty("password"));
				CallableStatement stmt = conn.getConnection().prepareCall("{call add_product(?, ?)}");
          stmt.setString(1, "new product");
          stmt.setBigDecimal(2, new BigDecimal(1900.50));
          stmt.executeUpdate();
          //ResultSet rst = stmt.executeQuery();
          out.println("Stored procedure has been executed.<Br>");
          stmt.close();
		        conn.closeConnection();
		        out.println("</body></html>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	        
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
