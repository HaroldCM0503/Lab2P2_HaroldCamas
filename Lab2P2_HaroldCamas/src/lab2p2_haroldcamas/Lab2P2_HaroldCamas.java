package lab2p2_haroldcamas;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2P2_HaroldCamas {

    static Scanner leer = new Scanner(System.in);
    static Scanner cadenas = new Scanner(System.in);
    
    public static void main(String[] args) {
        String usuarioGerente = "gerente";
        String contraseñaGerente = "g3r$nt0";
        boolean iniciar = true;
        boolean seguir = true;
        int opcion = 0;
        while(iniciar){
            System.out.println("""
                               
                               1.)Iniciar sesion.
                               2.)Salir.
                               """);
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese su usuario:");
                    String usuario = cadenas.nextLine();
                    System.out.println("Ingrese su contraseña");
                    String contraseña = cadenas.nextLine();
                    if(usuario.equals(usuarioGerente) == false || contraseña.equals(contraseñaGerente) == false){
                        System.out.println("Este usuario no es valido.");
                        break;
                    }
                    
                    ArrayList<Chef> chefs = new ArrayList<>();
                    ArrayList<Mesero> meseros = new ArrayList<>();
                    ArrayList<Bartender> bartenders = new ArrayList<>();
                    ArrayList<Mesa> mesas = new ArrayList<>();
                    while(seguir){
                        System.out.println("""
                                           RESTAURANTE
                                           1.)Chefs
                                           2.)Meseros
                                           3.)Bartenders
                                           4.)Mesas
                                           5.)Salir
                                           """);
                        opcion = leer.nextInt();
                        switch(opcion){
                            case 1:
                                menuChefs(chefs);
                                break;
                                
                            case 2:
                                menuMeseros(meseros);
                                break;
                                
                            case 3:
                                menuBartenders(bartenders);
                                break;
                                
                            case 4:
                                menuMesas(mesas);
                                break;
                                
                            case 5:
                                seguir = false;
                                break;
                                
                            default:
                                System.out.println("Ingrese una opcion valida!");
                                break;
                                
                        }
                    }//Fin menu principal.
                    break;
                    
                case 2:
                    iniciar = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida!");
                    break;
            }
        }//Fin entrar al sistema.
    }//Fin main
    
    public static void menuChefs(ArrayList chefs){
        boolean keep = true;
        int opcion = 0;
        while(keep){
            System.out.println("""
                               MENU CHEFS
                               1.)Crear
                               2.)Modificar
                               3.)Eliminar
                               4.)Listar
                               5.)Salir
                               """);
            opcion = leer.nextInt();
            switch(opcion){
                case 1:{
                    if(chefs.size() == 14){
                        System.out.println("No se puede añadir mas chefs.");
                        break;
                    }
                    
                    System.out.println("Ingrese el nombre del chef: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la edad del chef: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad invalida");
                        break;
                    }
                    
                    System.out.println("Ingrese el turno del trabajador");
                    String turno = cadenas.nextLine().toLowerCase();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el numero de estrellas del chef:");
                    int estrellas = leer.nextInt();
                    if(estrellas < 0){
                        System.out.println("Estrellas invalidas");
                        break;
                    }
                    
                    System.out.println("Ingrese el sueldo del chef:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    Chef chef = new Chef(nombre, edad, turno, estrellas, sueldo);
                    chefs.add(chef);
                    boolean balance = turnosChefs(chefs);
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de chefs en el turno asignado!");
                        chefs.remove(chefs.size() - 1);
                        break;
                    }
                    System.out.println("Añadido con exito.");
                    break;
                }
                    
                case 2:{
                    if(chefs.isEmpty()){
                        System.out.println("Aun no tiene ningun chef");
                        break;
                    }
                    
                    String list = listarChef(chefs);
                    System.out.println(list + "\nIngrese cual quiere modificar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= chefs.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    Chef copia = (Chef) chefs.get(seleccionado);
                    
                    System.out.println("Ingrese el nuevo nombre del chef: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la nueva edad del chef: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad invalida");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo turno del trabajador");
                    String turno = cadenas.nextLine();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo numero de estrellas del chef:");
                    int estrellas = leer.nextInt();
                    if(estrellas < 0){
                        System.out.println("Estrellas invalidas");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo sueldo del chef:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    Chef chef = new Chef(nombre, edad, turno, estrellas, sueldo);
                    chefs.set(seleccionado, chef);
                    boolean balance = turnosChefs(chefs);
                    
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de chefs en el turno asignado!");
                        chefs.set(seleccionado, copia);
                        break;
                    }
                    System.out.println("Modificado con exito");
                    break;
                }
                    
                case 3:{
                    if(chefs.isEmpty()){
                        System.out.println("Aun no tiene ningun chef");
                        break;
                    }
                    String list = listarChef(chefs);
                    System.out.println(list + "\nIngrese cual quiere eliminar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= chefs.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    chefs.remove(seleccionado);
                    System.out.println("Eliminado con exito");
                    break;
                }
                    
                case 4:{
                    if(chefs.isEmpty()){
                        System.out.println("Aun no tiene ningun chef");
                        break;
                    }
                    String list = listarChef(chefs);
                    System.out.println(list);
                    break;
                }
                    
                case 5:
                    keep = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
    }
    
    public static void menuMeseros(ArrayList meseros){
        boolean keep = true;
        int opcion = 0;
        while(keep){
            System.out.println("""
                               MENU MESEROS
                                1.)Crear
                                2.)Modificar
                                3.)Eliminar
                                4.)Listar
                                5.)Salir
                               """);
            opcion = leer.nextInt();
            switch(opcion){
                case 1:{
                    if(meseros.size() == 8){
                        System.out.println("No se puede añadir mas meseros.");
                        break;
                    }
                    
                    System.out.println("Ingrese el nombre del mesero: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la edad del mesero: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad mesero");
                        break;
                    }
                    
                    System.out.println("Ingrese el turno del trabajador");
                    String turno = cadenas.nextLine().toLowerCase();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el sueldo del mesero:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    System.out.println("Ingrese la propina del mesero:");
                    int propina = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Propina invalida");
                        break;
                    }
                    
                    Mesero mesero = new Mesero(nombre, edad, turno, sueldo, propina);
                    meseros.add(mesero);
                    
                    boolean balance = turnosMeseros(meseros);
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de meseros en el turno asignado!");
                        meseros.remove(meseros.size() - 1);
                        break;
                    }
                    System.out.println("Añadido con exito.");
                    break;
                }
                    
                case 2:{
                    if(meseros.isEmpty()){
                        System.out.println("Aun no tiene ningun mesero");
                        break;
                    }
                    
                    String list = listarMesero(meseros);
                    System.out.println(list + "\nIngrese cual quiere modificar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= meseros.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    Mesero copia = (Mesero) meseros.get(seleccionado);
                    System.out.println("Ingrese el nombre del mesero: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la edad del mesero: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad mesero");
                        break;
                    }
                    
                    System.out.println("Ingrese el turno del trabajador");
                    String turno = cadenas.nextLine().toLowerCase();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el sueldo del mesero:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    System.out.println("Ingrese la propina del mesero:");
                    int propina = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Propina invalida");
                        break;
                    }
                    
                    Mesero mesero = new Mesero(nombre, edad, turno, sueldo, propina);
                    meseros.set(seleccionado, mesero);
                    
                    boolean balance = turnosMeseros(meseros);
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de meseros en el turno asignado!");
                        meseros.set(seleccionado, copia);
                        break;
                    }
                    System.out.println("Modificado con exito");
                    break;
                }
                    
                case 3:{
                    if(meseros.isEmpty()){
                        System.out.println("Aun no tiene ningun mesero");
                        break;
                    }
                    String list = listarMesero(meseros);
                    System.out.println(list + "\nIngrese cual quiere eliminar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= meseros.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    meseros.remove(seleccionado);
                    System.out.println("Eliminado con exito");
                    break;
                }
                    
                case 4:{
                    if(meseros.isEmpty()){
                        System.out.println("Aun no tiene ningun mesero");
                        break;
                    }
                    String list = listarMesero(meseros);
                    System.out.println(list);
                    break;
                }
                    
                case 5:
                    keep = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
    }
    
    public static void menuBartenders(ArrayList bartenders){
        boolean keep = true;
        int opcion = 0;
        while(keep){
            System.out.println("""
                               MENU BARTENDERS
                                1.)Crear
                                2.)Modificar
                                3.)Eliminar
                                4.)Listar
                                5.)Salir
                               """);
            opcion = leer.nextInt();
            switch(opcion){
                case 1:{
                    if(bartenders.size() == 4){
                        System.out.println("No se puede añadir mas bartenders.");
                        break;
                    }
                    
                    System.out.println("Ingrese el nombre del bartender: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la edad del bartender: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad invalida");
                        break;
                    }
                    
                    System.out.println("Ingrese el turno del trabajador");
                    String turno = cadenas.nextLine().toLowerCase();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el sueldo del bartender:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    System.out.println("Ingrese los licores del bartender: ");
                    int licores = leer.nextInt();
                    if(licores < 0){
                        System.out.println("Licores invalido");
                        break;
                    }
                    
                    Bartender bartender = new Bartender(nombre, edad, turno, sueldo, licores);
                    bartenders.add(bartender);
                    boolean balance = turnosBartenders(bartenders);
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de chefs en el turno asignado!");
                        bartenders.remove(bartenders.size() - 1);
                        break;
                    }
                    System.out.println("Añadido con exito.");
                    break;
                }
                    
                case 2:{
                    if(bartenders.isEmpty()){
                        System.out.println("Aun no tiene ningun bartender");
                        break;
                    }
                    
                    String list = listarBartender(bartenders);
                    System.out.println(list + "\nIngrese cual quiere modificar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= bartenders.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    Bartender copia = (Bartender) bartenders.get(seleccionado);
                    
                    System.out.println("Ingrese el nombre nuevo del bartender: ");
                    String nombre = cadenas.nextLine();
                    
                    System.out.println("Ingrese la nueva edad del bartender: ");
                    int edad = leer.nextInt();
                    if(edad < 0){
                        System.out.println("Edad invalida");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo turno del trabajador");
                    String turno = cadenas.nextLine().toLowerCase();
                    if(!"matutino".equals(turno) && !"vespertino".equals(turno)){
                        System.out.println("Turnos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo sueldo del bartender:");
                    int sueldo = leer.nextInt();
                    if(sueldo < 0){
                        System.out.println("Sueldo invalido");
                        break;
                    }
                    
                    System.out.println("Ingrese los nuevos licores del bartender: ");
                    int licores = leer.nextInt();
                    if(licores < 0){
                        System.out.println("Licores invalido");
                        break;
                    }
                    
                    Bartender bartender = new Bartender(nombre, edad, turno, sueldo, licores);
                    bartenders.set(seleccionado, bartender);
                    boolean balance = turnosBartenders(bartenders);
                    
                    if(balance == false){
                        System.out.println("Se excedio la cantidad de bartender en el turno asignado!");
                        bartenders.set(seleccionado, copia);
                        break;
                    }
                    System.out.println("Modificado con exito");
                    break;
                }
                    
                case 3:{
                    if(bartenders.isEmpty()){
                        System.out.println("Aun no tiene ningun bartender");
                        break;
                    }
                    String list = listarBartender(bartenders);
                    System.out.println(list + "\nIngrese cual quiere eliminar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= bartenders.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    bartenders.remove(seleccionado);
                    System.out.println("Eliminado con exito");
                    break;
                }
                    
                case 4:
                    if(bartenders.isEmpty()){
                        System.out.println("Aun no tiene ningun bartender");
                        break;
                    }
                    String list = listarBartender(bartenders);
                    System.out.println(list);
                    break;
                    
                case 5:
                    keep = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
    }
    
    public static void menuMesas(ArrayList mesas){
        boolean keep = true;
        int opcion = 0;
        while(keep){
            System.out.println("""
                               MENU MESAS
                                1.)Crear
                                2.)Modificar
                                3.)Eliminar
                                4.)Listar
                                5.)Salir
                               """);
            opcion = leer.nextInt();
            switch(opcion){
                case 1:{
                    if(mesas.size() == 10){
                        System.out.println("No se puede añadir mas mesas.");
                        break;
                    }
                    
                    System.out.println("Ingrese la cantidad de platos: ");
                    int platos = leer.nextInt();
                    if(platos < 0){
                        System.out.println("Platos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el numero de utensilios:");
                    int utensilios = leer.nextInt();
                    if(utensilios < 0){
                        System.out.println("Utensilios invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el precio de la mesa:");
                    int precioT = leer.nextInt();
                    if(precioT < 0){
                        System.out.println("Precio invalido");
                        break;
                    }
                    
                    Mesa mesa = new Mesa(platos, utensilios, precioT);
                    mesas.add(mesa);
                    System.out.println("Añadido con exito.");
                    break;
                }
                    
                case 2:{
                    if(mesas.isEmpty()){
                        System.out.println("Aun no tiene ninguna mesa");
                        break;
                    }
                    
                    String list = listarMesa(mesas);
                    System.out.println(list + "\nIngrese cual quiere modificar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= mesas.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    
                    System.out.println("Ingrese la nueva cantidad de platos: ");
                    int platos = leer.nextInt();
                    if(platos < 0){
                        System.out.println("Platos invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo numero de utensilios:");
                    int utensilios = leer.nextInt();
                    if(utensilios < 0){
                        System.out.println("Utensilios invalidos");
                        break;
                    }
                    
                    System.out.println("Ingrese el nuevo precio de la mesa:");
                    int precioT = leer.nextInt();
                    if(precioT < 0){
                        System.out.println("Precio invalido");
                        break;
                    }
                    
                    Mesa mesa = new Mesa(platos, utensilios, precioT);
                    mesas.add(mesa);
                    System.out.println("Modificado con exito.");
                    break;
                }
                    
                case 3:{
                    if(mesas.isEmpty()){
                        System.out.println("Aun no tiene ninguna mesa");
                        break;
                    }
                    String list = listarMesa(mesas);
                    System.out.println(list + "\nIngrese cual quiere eliminar: ");
                    int seleccionado = leer.nextInt() - 1;
                    if(seleccionado < 0 || seleccionado >= mesas.size()){
                        System.out.println("Objeto fuera de la lista");
                        break;
                    }
                    mesas.remove(seleccionado);
                    System.out.println("Eliminado con exito");
                    break;
                }
                    
                case 4:{
                    if(mesas.isEmpty()){
                        System.out.println("Aun no tiene ninguna mesa");
                        break;
                    }
                    String list = listarMesa(mesas);
                    System.out.println(list);
                    break;
                }
                    
                case 5:
                    keep = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
    }
    
    public static String listarChef(ArrayList chefs){
        String lista = "";
        for (int i = 0; i < chefs.size(); i++) {
            lista += "Chef " + (i + 1) + ":\n";
            lista += ((Chef) chefs.get(i)).toString();
            lista += "\n";
        }
        return lista;
    }
    
    public static String listarMesero(ArrayList mesero){
        String lista = "";
        for (int i = 0; i < mesero.size(); i++) {
            lista += "Mesero " + (i + 1) + ":\n";
            lista += ((Mesero) mesero.get(i)).toString();
            lista += "\n";
        }
        return lista;
    }
    
    public static String listarBartender(ArrayList bartenders){
        String lista = "";
        for (int i = 0; i < bartenders.size(); i++) {
            lista += "Bartender " + (i + 1) + ":\n";
            lista += ((Bartender) bartenders.get(i)).toString();
            lista += "\n";
        }
        return lista;
    }
    
    public static String listarMesa(ArrayList mesas){
        String lista = "";
        for (int i = 0; i < mesas.size(); i++) {
            lista += "Mesa " + (i + 1) + ":\n";
            lista += ((Mesa) mesas.get(i)).toString();
            lista += "\n";
        }
        lista += "Precio total: " + precioTotal(mesas) + "\n";
        return lista;
    }
    
    public static boolean turnosChefs(ArrayList chefs){
        int matutino = 0;
        int vespertino = 0;
        boolean balance = false;
        
        for (int i = 0; i < chefs.size(); i++) {
            if("matutino".equals(((Chef) chefs.get(i)).getTurno())){
                matutino++;
            }
            else{
                vespertino++;
            }
        }
        if(matutino <= 7 && vespertino <= 7){
            balance = true;
        }
        return balance;
    }
    
    public static boolean turnosMeseros(ArrayList meseros){
        int matutino = 0;
        int vespertino = 0;
        boolean balance = false;
        
        for (int i = 0; i < meseros.size(); i++) {
            if("matutino".equals(((Mesero) meseros.get(i)).getTurno())){
                matutino++;
            }
            else{
                vespertino++;
            }
        }
        if(matutino <= 4 && vespertino <= 4){
            balance = true;
        }
        return balance;
    }
    
    public static boolean turnosBartenders(ArrayList bartenders){
        int matutino = 0;
        int vespertino = 0;
        boolean balance = false;
        
        for (int i = 0; i < bartenders.size(); i++) {
            if("matutino".equals(((Bartender) bartenders.get(i)).getTurno())){
                matutino++;
            }
            else{
                vespertino++;
            }
        }
        if(matutino <= 2 && vespertino <= 2){
            balance = true;
        }
        return balance;
    }
    
    public static int precioTotal(ArrayList mesas){
        int total = 0;
        for (int i = 0; i < mesas.size(); i++) {
            total += ((Mesa) mesas.get(i)).getPrecioT();
        }
        return total;
    }
}