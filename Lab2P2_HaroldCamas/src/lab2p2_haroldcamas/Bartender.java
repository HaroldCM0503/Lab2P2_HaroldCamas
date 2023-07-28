package lab2p2_haroldcamas;

public class Bartender {
    String nombre;
    int edad;
    String turno;
    int sueldo;
    int licores;

    public Bartender(String nombre, int edad, String turno, int sueldo, int licores) {
        this.nombre = nombre;
        this.edad = edad;
        this.turno = turno;
        this.sueldo = sueldo;
        this.licores = licores;
    }

    public Bartender() {
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

    public int getSueldo() {
        return sueldo;
    }

    public int getLicores() {
        return licores;
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

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setLicores(int licores) {
        this.licores = licores;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + "\nEdad:" + edad + "\nTurno:" + turno + "\nSueldo:" + sueldo + "\nLicores:" + licores + "\n";
    }
}
