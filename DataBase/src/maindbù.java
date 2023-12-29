import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class maindb� {
	public static void main() {
		String DB_REL_FILE = "../db/indirizzi.db3";
		 String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		
		try {			
		 Connection conn = DriverManager.getConnection(DB_URL);
		 if (conn != null) {
		   DatabaseMetaData meta = conn.getMetaData();
		   System.out.println("The driver name is " + meta.getDriverName());
		   System.out.println("A new database has been created.");
		 }
		 // controllo che il file esista a questo punto
		 System.out.println("il file esiste? " + new File(DB_REL_FILE).exists());
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
	}
}
