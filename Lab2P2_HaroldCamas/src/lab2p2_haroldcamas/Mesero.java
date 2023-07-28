package lab2p2_haroldcamas;


public class Mesero {
    String Nombre;
    int edad;
    String turno;
    int sueldo;
    int propina;

    public Mesero(String Nombre, int edad, String turno, int sueldo, int propina) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.turno = turno;
        this.sueldo = sueldo;
        this.propina = propina;
    }
    
    public Mesero(){}

    public String getNombre() {
        return Nombre;
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

    public int getPropina() {
        return propina;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public void setPropina(int propina) {
        this.propina = propina;
    }

    @Override
    public String toString() {
        return "Nombre:" + Nombre + "\nEdad:" + edad + "\nTurno:" + turno + "\nSueldo:" + sueldo + "\nPropina:" + propina + "\n";
    }
     
}
