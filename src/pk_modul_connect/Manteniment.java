package pk_modul_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manteniment {
	private static final Connection Connection = null;

	//metodes
	public Connection getConnection(String rutaHost,String nomUsu,String passw) {
		
		Connection databaseConnection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//String sourceURL = "jdbc:mysql://localhost/personas";
			String sourceURL = rutaHost;
			databaseConnection = DriverManager.getConnection(sourceURL, nomUsu, passw);//nom bbdd
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return databaseConnection;
		
	}
	
	public void demanardades() {
		Scanner lector = new Scanner(System.in);
		int edad = 0;
		String dni = "", nombre = "";
		// sentencia="";
		System.out.println("Escriu el teu dni");
		dni = lector.next();
		System.out.println("Escriu el teu nom ");
		nombre = lector.next();
		System.out.println("Escriu la teva edat ");
		edad = lector.nextInt();
	}
	
	
		
	public void insertarRegistre(Connection databaseConnection) {
		Connection conn=getConnection("jdbc:mysql://localhost/personas", "root", "");
		Statement statement;
		try {
			statement = databaseConnection.createStatement();
			statement.executeUpdate("INSERT INTO prueba values('20000','filomena',100);");
			statement.close();
			databaseConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
		
		
}
