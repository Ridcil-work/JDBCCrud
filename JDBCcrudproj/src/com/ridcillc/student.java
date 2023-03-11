package com.ridcillc;

import java.sql.*;
import java.util.ArrayList;

public class student {


		public static Connection con=null;
		public static Statement s=null;
		public static PreparedStatement ps=null; 
		private static final String url = "jdbc:mysql://localhost:3306/palle";
		public static String admin= "root"; 
		public static String pass="Mypass12@";
		private static ResultSet rs=null;

	public static void creating() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, admin, pass);
			String qry="create table student(sno int primary key auto_increment,sname varchar(50),sub varchar(50),email varchar(50))";
			s=con.createStatement();
			s.executeUpdate(qry);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		try {
			s.close();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	
	public static void inserting(String sname,String subject ,String email)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, admin, pass);
			ps=con.prepareStatement("insert into student (sname,sub,email)values(?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, subject);
			ps.setString(3, email);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	
	
	public static void updating(String sub,String mail,int sno)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, admin, pass);
			ps=con.prepareStatement("update student set sub =?,email=? where sno=?");
			ps.setInt(3, sno);
			ps.setString(1,sub);
			ps.setString(2, mail);
			ps.executeUpdate();
			ps.close();
			con.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	
		public static void delete(int sno){
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, admin, pass);
			String qry="delete from student where sno=?";
			ps=con.prepareStatement(qry);
			ps.setInt(1,sno);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		
		public static ArrayList<Department> read() {
			ArrayList<Department> aldept=new ArrayList<Department>();
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url, admin, pass);
					s=con.createStatement();
					rs=s.executeQuery("select * from student");
					
					
					while(rs.next()) {
					int id=	rs.getInt("sno");
						String name=rs.getString("sname");
						String subject=rs.getString("sub");
						String mail=rs.getString("email");
						System.out.println("name is "+ name);
						System.out.println("subject is "+subject);
						System.out.println("mail is "+mail);
						Department d= new Department(id,name,subject,mail);
						aldept.add(d);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
					finally {
						if(rs!=null) {
							try {
								rs.close();
								if(s!=null) {
									s.close();
									if(con!= null) {
										con.close();
									}
									}
									} 
							catch (SQLException e) {
								e.printStackTrace();
									}
									}	
									}
				
							
						return aldept;
				}
				}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


