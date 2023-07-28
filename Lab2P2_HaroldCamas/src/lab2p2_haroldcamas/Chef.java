package lab2p2_haroldcamas;

public class Chef {
    String nombre;
    int edad;
    String turno;
    int estrellas;
    int sueldo;
    
    public Chef(){}

    public Chef(String nombre, int edad, String turno, int estrellas, int sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.turno = turno;
        this.estrellas = estrellas;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTurno() {
        return turno;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + "\nEdad:" + edad + "\nTurno:" + turno + "\nEstrellas:" + estrellas + "\nSueldo:" + sueldo +"\n";
    }  
}
