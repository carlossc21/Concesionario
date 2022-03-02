package es.carlossc212.concesionario;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Anuncio implements Parcelable {

    public String titulo;
    public int precio;
    public String lugar;
    public String caracteristicas;
    public String descripcion;

    public static ArrayList<Anuncio> anuncios = new ArrayList<>();

    public Anuncio(){

    }

    protected Anuncio(Parcel in) {
        titulo = in.readString();
        precio = in.readInt();
        lugar = in.readString();
        caracteristicas = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Anuncio> CREATOR = new Creator<Anuncio>() {
        @Override
        public Anuncio createFromParcel(Parcel in) {
            return new Anuncio(in);
        }

        @Override
        public Anuncio[] newArray(int size) {
            return new Anuncio[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeInt(precio);
        dest.writeString(lugar);
        dest.writeString(caracteristicas);
        dest.writeString(descripcion);
    }
}
