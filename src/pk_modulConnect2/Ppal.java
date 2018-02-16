package pk_modulConnect2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class Ppal {

	public static void main(String[] args) {
		Manteniment m1=new Manteniment();
		
		//Persona p1=new Persona(null, null, 0);
		//m1.getConnection();
		//m1.usuariEntraDades();
		//m1.insertar();
		//m1.usuariEntraDades();
		//m1.insertar();//********
		//m1.consultar();//******
		//m1.menuCriteris();
		m1.consultaFiltrada();
		/*Iterator <Persona> it=llistPerson.listIterator();
		while(it.hasNext()) {
			Persona elemento=it.next();
			
			
			System.out.println(elemento.getNom()+" té dni ["+elemento.getDni()+"] i té "+elemento.getEdat()+" anys.");
		}*/
		
		

	}

}
