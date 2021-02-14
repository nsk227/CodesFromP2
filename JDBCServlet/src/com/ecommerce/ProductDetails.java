package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DBConnection;
import com.utils.PropertyReader;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  PrintWriter out = response.getWriter();        
	        DBConnection conn;
			try {
				out.println("<html><body>");
				conn = new DBConnection(PropertyReader.ReadProperty("url"), PropertyReader.ReadProperty("userid"), PropertyReader.ReadProperty("password"));
				Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Great Product', 10000.50, now())");
	            ResultSet rst = stmt.executeQuery("select * from eproduct");            
	            while (rst.next()) {
	                    out.println(rst.getInt("ID") + ", " + rst.getString("name") + ", " +rst.getDouble("price")+ ", "+rst.getDate("date_added")+" <Br>");
	            }            
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
