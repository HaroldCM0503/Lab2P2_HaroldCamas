package lab2p2_haroldcamas;

public class Mesa {
    int platos;
    int utensilios;
    int precioT;

    public Mesa(int platos, int utensilios, int precioT) {
        this.platos = platos;
        this.utensilios = utensilios;
        this.precioT = precioT;
    }

    public Mesa() {
    }

    public int getPlatos() {
        return platos;
    }

    public int getUtensilios() {
        return utensilios;
    }

    public int getPrecioT() {
        return precioT;
    }

    public void setPlatos(int platos) {
        this.platos = platos;
    }

    public void setUtensilios(int utensilios) {
        this.utensilios = utensilios;
    }

    public void setPrecioT(int precioT) {
        this.precioT = precioT;
    }

    @Override
    public String toString() {
        return "Platos:" + platos + "\nUtensilios:" + utensilios + "\nPrecio:" + precioT + "\n";
    }
}
