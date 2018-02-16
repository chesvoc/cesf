package pk_primera_connexioBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ppal {
	// String sentencia="";
	public static void main(String[] args) {
		Ppal p1=new Ppal();
		String sentencia = "";
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
		p1.insertarRegistre(dni, nombre, edad);
		// statement.executeUpdate("INSERT INTO prueba VALUES
		// ('"+dni+"','"+nombre+"',"+edad+");");

	}// final del main

	// public static String insertarRegistre(String dni,String nombre,int edad) {
	public static void insertarRegistre(String dni, String nombre, int edad) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/personas";// connecta bbdd(on està la bbdd i nom de la bbdd)
			Connection databaseConnection = DriverManager.getConnection(sourceURL, "root", "");// nom bbdd
			Statement statement = databaseConnection.createStatement();
			statement.executeUpdate("INSERT INTO prueba values('"+dni+"','"+nombre+"',"+edad+");");
			statement.close();
			databaseConnection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} // final try catch

		

	}

}// final de la class
