package com.pj.dao;

import java.sql.Connection; //"?"== placeholder is used to dynamic crud operation in prepared statement which is child interface of statement intfac.e
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pj.dto.Book;

public class BookCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String adress = "jdbc:mysql://localhost:3306/bookstore?user=root&password=root";
	 static Connection c;
	public int InsertBook(Book b) {
	

		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setString(3, b.getAuther());
			ps.setInt(4, b.getPage());
			ps.setDouble(5, b.getPrice());
			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return 0;

	}
	
	public int deleteBookById(int id) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(adress);
			PreparedStatement ps= c.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
		
		
	}


		public int updateBookById(int id,Book b) {
			try {
				Class.forName(path);
				c=DriverManager.getConnection(adress);
				PreparedStatement ps= c.prepareStatement("update book set name=?,author=?,pages=?,price=? where id=?");
				ps.setString(1, b.getName());
				ps.setString(2, b.getAuther());
				ps.setInt(3, b.getPage());
				ps.setDouble(4, b.getPrice());
				ps.setInt(5, id);
				return ps.executeUpdate();
				
				

				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
			
		}
		
		public Book GetBookById(int id)
		{
			 Book b=null;
			 try {
				Class.forName(path);
				c=DriverManager.getConnection(adress);
				PreparedStatement ps= c.prepareStatement("select * from book where id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery(); 
				if(rs.next()) {
					b= new Book();
					b.setId(rs.getInt(1));
					b.setName(rs.getString(2));
					b.setAuther(rs.getString(3));
					b.setPage(rs.getInt(4));
					b.setPrice(rs.getDouble(5));
					return b;
					
				}else {
					return b;
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally {
				 try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			return b;
			 
		}
		public ArrayList<Book> getAllBooks() //to return type is multiple object we using collection of arraylist
		{
			ArrayList<Book> bl= new ArrayList<Book>();
			try {
				Class.forName(path);//load the driver
				c=DriverManager.getConnection(adress);//CONNECT HTE DATA BASE
				PreparedStatement ps=c.prepareStatement("select * from book");//CREATE STATEMENT
				ResultSet res= ps.executeQuery();
				while(res.next()) {// .next() will read there is 
					Book b= new Book();
					
					b.setId(res.getInt(1));
					b.setName(res.getString(2));
					b.setAuther(res.getString(3));
					b.setPage(res.getInt(4));
					b.setPrice(res.getDouble(5));
					bl.add(b);
				}
				
				
				return bl;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally {
				 try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			
			return  bl;//return can  be null 
			
		}
		public boolean BatchExecution(ArrayList<Book> books) {
			
			try {
				Class.forName(path);
				c=DriverManager.getConnection(adress);
				PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?,?)");
				for(Book b:books) {
					ps.setInt(1, b.getId());
					ps.setString(2, b.getName());
					ps.setString(3, b.getAuther());
					ps.setInt(4, b.getPage());
					ps.setDouble(5, b.getPrice());
					ps.addBatch();
					
					
				}
				ps.executeBatch();
				return true;
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
			
			
		}
		
}

