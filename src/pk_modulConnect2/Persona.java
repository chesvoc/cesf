package pk_modulConnect2;

public class Persona {
	private String dni;
	private String nom;
	private int edat;
	
	//constructor
	public Persona(String dni, String nom, int edat) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.edat = edat;
	}
	
	//getters setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}
	
	
	
	
}
