package cr.ac.ucr.ecci.sodauniversitaria.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String identificacion;
    private String correo;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;

    public Persona(String identificacion, String correo, String nombre, String primerApellido, String segundoApellido, String celular) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.celular = celular;
    }

    public Persona(){
        this.identificacion = "B98243";
        this.correo = "maria.vargasmedrano@ucr.ac.cr";
        this.nombre = "Maria Jesus";
        this.primerApellido = "Vargas";
        this.segundoApellido = "Medrano";
        this.celular = "85144152";
    }

    protected Persona(Parcel in) {
        identificacion = in.readString();
        correo = in.readString();
        nombre = in.readString();
        primerApellido = in.readString();
        segundoApellido = in.readString();
        celular = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identificacion);
        dest.writeString(correo);
        dest.writeString(nombre);
        dest.writeString(primerApellido);
        dest.writeString(segundoApellido);
        dest.writeString(celular);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getIdentificacion() {
        return identificacion;
    }


    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString(){
        return nombre + " " + primerApellido + " " + segundoApellido;
    }
}
