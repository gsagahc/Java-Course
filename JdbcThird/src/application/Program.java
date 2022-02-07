package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf =new  SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		String sql = "insert into seller "+
				  "(Name, Email, BirthDate,"+
				  "BaseSalary, DepartmentId)"+
				  " values "+
				  "(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("Deseja inserir quantos sellers:");
			int num = sc.nextInt();
			int rows=0;
			for (int i=0; i<num ; i++) {
				
				System.out.println("Nome:");
				String nome = sc.next();
				System.out.println("Email:");
				String email = sc.next();
				System.out.println("Birth date :");
				Date dt = sdf.parse(sc.next());
				System.out.println("Base salary :");
				Double bs =sc.nextDouble();
				System.out.println("Department id :");
				int id =sc.nextInt();
				
				ps.setString(1, nome);
				ps.setString(2, email);
				ps.setDate(3,new java.sql.Date(dt.getTime()));
				ps.setDouble(4, bs);
				ps.setInt(5, id);
				
				ps.executeUpdate();
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
			
		
		}
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
			
				  
	}

}
