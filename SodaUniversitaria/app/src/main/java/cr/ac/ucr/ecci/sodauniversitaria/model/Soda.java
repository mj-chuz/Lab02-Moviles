package cr.ac.ucr.ecci.sodauniversitaria.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Soda implements Parcelable {
    private int id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String telefono;
    private String website;
    private String email;
    private String horario;
    private double longitud;
    private double latitud;

    public Soda(int id, String nombre, String direccion, String descripcion, String telefono, String website, String email, String horario, double longitud, double latitud) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.website = website;
        this.email = email;
        this.horario = horario;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Soda(){
        this.id = 1;
        this.nombre = "Soda de Odontologia";
        this.direccion = "Escuela de Odontología, frente a la maestría";
        this.descripcion = "El menú incluye casados, plato vegetariano y opción saludable";
        this.telefono = "25118080";
        this.website = "https://www.fodo.ucr.ac.cr/servicios";
        this.email = "estudiantes.fo@ucr.ac.cr";
        this.horario = "L-V 07:00-19:00";
        this.longitud = -84.051509;
        this.latitud = 9.938035;
    }

    protected Soda(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        direccion = in.readString();
        descripcion = in.readString();
        telefono = in.readString();
        website = in.readString();
        email = in.readString();
        horario = in.readString();
        longitud = in.readDouble();
        latitud = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(direccion);
        dest.writeString(descripcion);
        dest.writeString(telefono);
        dest.writeString(website);
        dest.writeString(email);
        dest.writeString(horario);
        dest.writeDouble(longitud);
        dest.writeDouble(latitud);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Soda> CREATOR = new Creator<Soda>() {
        @Override
        public Soda createFromParcel(Parcel in) {
            return new Soda(in);
        }

        @Override
        public Soda[] newArray(int size) {
            return new Soda[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
