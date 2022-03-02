package es.carlossc212.concesionario;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {


    private final String user = "u5quntamrdodaqir";
    private final String pass = "0oeOb6PLBnfenSSHHq94";
    private final String url = "jdbc:mysql://bitfxnkmpzkpwuktdpwt-mysql.services.clever-cloud.com:3306/bitfxnkmpzkpwuktdpwt";

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pass);

            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM coches");

            rs.beforeFirst();
            Anuncio a = new Anuncio();
            while (rs.next()){
                a.titulo = rs.getString(2);
                a.precio = rs.getInt(3);
                a.lugar = rs.getString(4);
                a.caracteristicas = rs.getString(5);
                a.descripcion = rs.getString(6);

                Anuncio.anuncios.add(a);
            }


        }

        catch(Exception e) {
            System.out.println("Error");
        }
    }

}
