package pk_modulConnect2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;

public class Manteniment {
	Scanner lector = new Scanner(System.in);

	public Connection getConnection() {
		// Connection con1=null;
		Connection databaseConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Define the data source for the driver
			String sourceURL = "jdbc:mysql://localhost/personas";
			// Create a connection through the DriverManager
			databaseConnection = DriverManager.getConnection(sourceURL, "root", "");
			// con1= DriverManager.getConnection(sourceURL, "root", "");
			/*
			 * Statement statement = databaseConnection.createStatement(); statement.
			 * executeUpdate("INSERT INTO prueba values ('667755','SimonPerezJr',2)");
			 * statement.close();
			 */
			// databaseConnection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return databaseConnection;
	}// final getConnection

	public void insertar() {
		Manteniment m2 = new Manteniment();
		Persona Ptemp = m2.usuariEntraDades();
		String dni = Ptemp.getDni();
		String nom = Ptemp.getNom();
		int edat = Ptemp.getEdat();

		Connection c1 = getConnection();
		Statement statement;
		try {
			// System.out.println("Hola txorra");
			statement = c1.createStatement();
			// statement.executeUpdate("INSERT INTO prueba values
			// ('887755','SimonPerezJrrrrrr',1)");
			// statement.executeUpdate("INSERT INTO prueba values
			// ('"+dni+"','"+nom+"',"+edat+")");//*****
			statement.executeUpdate("INSERT INTO prueba values ('" + dni + "','" + nom + "'," + edat + ")");
			statement.close();
			c1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		// System.out.println("Hola txorra");
	}

	public Persona usuariEntraDades() {
		Persona p1 = new Persona(null, null, 0);// creo instància de tipus persona
		System.out.println("Escriu el teu dni");
		p1.setDni(lector.next());// al escriure l'usuari, li dóna a l'instancia p1 de tipus persona el que ha
									// escrit
		System.out.println("Escriu el teu nom ");
		p1.setNom(lector.next());
		System.out.println("Escriu la teva edat ");
		p1.setEdat(lector.nextInt());

		System.out.println("dni [" + p1.getDni() + "]");// a mode de comprovar si he entrat les dades a l'objecte
		System.out.println("nom [" + p1.getNom() + "]");
		System.out.println("nom [" + p1.getEdat() + "]");

		return p1;// retorna l'objecte p1 de tipus persona
	}// final mètode usuariEntrarDades

	public void consultar() {
		Connection databaseConnection = getConnection();
		Statement statement;
		String dniTemp, nomTemp;
		int edatTemp;
		Persona persTemp;// declaració objecte
		try {
			List<Persona> llistPerson = new ArrayList<Persona>();
			statement = databaseConnection.createStatement();
			ResultSet personas = statement.executeQuery("SELECT * FROM prueba");
			// ResultSet personas = statement.executeQuery("SELECT * FROM prueba where
			// nombre like 'Sil%'");
			while (personas.next()) {
				persTemp = new Persona("", "", 0);// instancio objecte persona
				// System.out.println(personas.getString("nombre"));
				// llistPerson.add((Persona) personas);
				dniTemp = personas.getString("dni");// li dono al string dniTemp el valor dni del registre
				nomTemp = personas.getString("nombre");
				edatTemp = personas.getInt("edad");

				persTemp.setDni(dniTemp);// assigno al atribut dni de l'objecte persona el registre dni tret del
											// resultset
				persTemp.setNom(nomTemp);
				persTemp.setEdat(edatTemp);

				llistPerson.add(persTemp);// afegeixo 1 persona al arraylist

			}
			Iterator<Persona> it = llistPerson.listIterator();// passo tot l'arraylist(amb tots els elements al
																// iterador)
			while (it.hasNext()) {// recorre l'iterador que acabo de crear
				Persona elemento = it.next();// cada registre de l'iterador va a elemento

				System.out.println(elemento.getNom() + " té dni [" + elemento.getDni() + "] i té " + elemento.getEdat()
						+ " anys.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// final mètode consultar

	public String menuCriteris() {
		String nomColumna = "", valorCriteri = "";
		String sentencia="";
		String sentenciaStringIgual = "select from prova where " + nomColumna + "='"+valorCriteri+"';";
		String sentenciaStringComenz =null;
		//sentenciaStringComenz ="select from prova where " + nomColumna + " like'"+valorCriteri+"%';";
		// Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion=0; // Guardaremos la opcion del usuario

		//while (!salir) {
		while (opcion<1 ||opcion>7 ) {

			System.out.println("1. filtrar DNI igual");
			System.out.println("2. filtrar DNI començat per");
			System.out.println("3. filtrar nom igual");
			System.out.println("4. filtrar nom començat per");
			System.out.println("5. filtrar edat igual ");
			System.out.println("6. filtrar edat major ");
			System.out.println("7. filtrar edat menor ");
			System.out.println("8. Salir");

			System.out.println("Escribe una de las opciones");
			opcion = lector.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Escriu quin dni vols filtrar");
				break;
			case 2:
				System.out.println("Has seleccionado la opcion 2");
				break;
			case 3:
				System.out.println("Has seleccionado la opcion 3");
				break;
			case 4:
				nomColumna="nombre";
				
				System.out.println("Escriu per com vols que comenci el nom");
				valorCriteri=lector.next();
				//sentencia ="select * from prova where " + nomColumna + " like'"+valorCriteri+"%';";//*****
				sentencia ="select * from prova;";
				System.out.println("La sentencia queda aixi ["+sentencia+"]");
				//return sentencia;
				break;
			case 5:
				System.out.println("Has seleccionado la opcion 5");
				break;
			case 6:
				System.out.println("Has seleccionado la opcion 6");
				break;
			case 7:
				System.out.println("Has seleccionado la opcion 7");
				
				break;
			case 8:
				salir = true;
				
				break;
			default:
				System.out.println("Solo números entre 1 y 8");
			}

		}
		return sentencia ;
	}//final mètode menú criteris
	public void consultaFiltrada() {
		Connection databaseConnection = getConnection();
		Statement statement;
		String dniTemp, nomTemp;
		int edatTemp;
		Persona persTemp;// declaració objecte
		String sentenciaFiltr=menuCriteris();
		try {
			List<Persona> llistPerson = new ArrayList<Persona>();
			statement = databaseConnection.createStatement();
			ResultSet personas = statement.executeQuery("sentenciaFiltr");//***aqui puc cridar a mètode menucriteris
			// ResultSet personas = statement.executeQuery("SELECT * FROM prueba where
			// nombre like 'Sil%'");
			while (personas.next()) {
				persTemp = new Persona("", "", 0);// instancio objecte persona
				// System.out.println(personas.getString("nombre"));
				// llistPerson.add((Persona) personas);
				dniTemp = personas.getString("dni");// li dono al string dniTemp el valor dni del registre
				nomTemp = personas.getString("nombre");
				edatTemp = personas.getInt("edad");

				persTemp.setDni(dniTemp);// assigno al atribut dni de l'objecte persona el registre dni tret del
											// resultset
				persTemp.setNom(nomTemp);
				persTemp.setEdat(edatTemp);

				llistPerson.add(persTemp);// afegeixo 1 persona al arraylist

			}
			Iterator<Persona> it = llistPerson.listIterator();// passo tot l'arraylist(amb tots els elements al
																// iterador)
			while (it.hasNext()) {// recorre l'iterador que acabo de crear
				Persona elemento = it.next();// cada registre de l'iterador va a elemento

				System.out.println(elemento.getNom() + " té dni [" + elemento.getDni() + "] i té " + elemento.getEdat()
						+ " anys.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//final mètode  consultaFiltrada
}//final de la class
