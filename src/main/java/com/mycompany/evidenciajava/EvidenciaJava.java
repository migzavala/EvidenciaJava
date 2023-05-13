package com.mycompany.evidenciajava;

import java.util.Scanner;

public class EvidenciaJava {

 public static void main(String[] args) {
     
     
        // ToDo:  segundos nombres en paciente y doctor, crear cita, relacionar doctor con paciente, pulir menu
     
     
     
        Scanner leer = new Scanner(System.in);                                      // Scanner leer para el input del usuario
        int maxDoctores = 5;                                                             // Maximo de doctores y pacientes que se pueden registrar para inicializar el arreglo
        int maxPacientes = 20;                                                           
        doctor[] ListaDoctores = new doctor[maxDoctores];                                // Arreglo de objetos donde se guadrara la informacion de doctores y pacientes,
        paciente[] ListaPacientes = new paciente[maxPacientes];                 
        int contadorDoctores = 0;                                                       //Contador para el for donde se repite dependiendo el numero de veces que se necesite registrar un doctor o paciente
        int contadorPacientes = 0;
        boolean acceso = false;
        
        
        separador();
        System.out.println("Programa de gestion de hospital.");                     
        separador();
        
        while (acceso = false); { 
        String usuarioAdmin = "admin";
        String passwordAdmin = "root";

        System.out.print("Escriba el usuario: ");
        String usuarioTemporal = leer.nextLine();

        System.out.print("Escriba la contraseña: ");
        String passwordTemporal = leer.nextLine();

        if (usuarioTemporal.equals(usuarioAdmin) && passwordTemporal.equals(passwordAdmin)) {
            System.out.println("Bienvenido!");
            acceso = true;
        } else {
            System.out.println("Usuario y contraseña incorrectos.");
        }
        }
        
     
     while (true) {
         separador();
         System.out.println("Presinoe 1 para agregar un doctor, 2 para agregar un paciente, 3 para imprimir los doctores, 4 para imprimir los pacientes o 5 para salir.");  // Menu esta en BETA. 
         int menuOpcion = leer.nextInt();
         separador();
         
         switch (menuOpcion) {                                                                          //Switch para elegir la opcion
             case 1:
                 if (contadorDoctores == maxDoctores) {                                                 //Si el numero de doctores es mayor al de arreglo, no dejara agregar mas
                     System.out.println("Ya no se pueden crear mas doctores.");
                 } else {
                     System.out.println("Introduzca el nombre del doctor:");
                     String nombreDoctor = leer.next();
                     System.out.println("Introduzca la especialidad del doctor:");
                     String especialidadDoctor = leer.next();
                     System.out.println("Introduzca el id del doctor:");
                     int idDoctor = leer.nextInt();
                     ListaDoctores[contadorDoctores] = new doctor(nombreDoctor, especialidadDoctor, idDoctor);      //crea un objeto doctor dentro del arreglo ListaDoctores con la informacion que el usuario acaba de poner ...
                                                                                                                                       // ... el contadorDoctor determina en que espacio del arreglo se va a guardar la informacion, moviendo un espacio ...
                                                                                                                                       // ... en el arreglo cada vez que se crea otro. 
                                                                                                                                       
                                                                                                                                       //EJEMPLO: Dr.Juan va en el espacio 0, el Dr.Pedro ira en el espacio 1 del arreglo ListaDoctores.
                     separador();
                     System.out.print("El doctor " +nombreDoctor);
                     System.out.println(" a sido registrado correctamente.");
                     separador();
                     contadorDoctores++;                                                                   // Aumentar el contador de doctores para que no pase el maximo del arreglo
                 }break;
             case 2:
                 if (contadorPacientes == maxPacientes) {                                               //Si el numero de pacientes es mayor al de arreglo, no dejara agregar mas
                     System.out.println("Ya no se pueden crear mas pacientes.");
                 } else {
                     System.out.println("Introduzca el nombre del paciente:");
                     String nombrePaciente = leer.next();
                     System.out.println("Introduzca el id del paciente:");
                     int idPaciente = leer.nextInt();
                     ListaPacientes[contadorPacientes] = new paciente(nombrePaciente, idPaciente);    // Igual que el arreglo doctor pero con pacientes
                     separador();
                     System.out.print("El paciente " +nombrePaciente);
                     System.out.println(" a sido registrado correctamente.");
                     separador();
                     contadorPacientes++;                                                                    // Aumentar el contador de pacientes para que no pase el maximo del arreglo
                 }break;
             case 3:
                 System.out.println("Lista de todos los doctores:");
                 for (int i = 0; i < contadorDoctores; i++) {                                                                                           //Ciclo para que imprima todos los doctores recorriendo el arreglo e imprimiendo uno por uno
                     System.out.println(ListaDoctores[i].getNombre() + ", " + ListaDoctores[i].getEspecialidad() + ", " + ListaDoctores[i].getId());         //Obtendra la informacion de cada doctor dentro del arreglo con los gets y sets para imprimir
                     separador();
                 }break;
             case 4:
                 System.out.println("Lista de todos los pacientes:");                                                                   //Lo mismo pero con pacientes
                 for (int i = 0; i < contadorPacientes; i++) {
                     System.out.println(ListaPacientes[i].getName() + ", " + ListaPacientes[i].getId());
                     separador();
                 }break;
             case 5:
                 System.out.println("Sesion cerrada.");
                 break;
             default:
                 System.out.println("Opcion invalida.");                                                      // Si opcion > 5, lo regresara al menu                 
                 separador();
                 break;
         }
     }
    }
 
  static void separador() {
        System.out.println("======================================================");                           // Metodo separador para intentar se vea mas ordenado
  } 
 
}

class doctor {                                                                                               // Clase doctor con sus variables
    private String nombre;
    private String especialidad;
    private int id;

    public doctor(String nombre, String especialidad, int id) {                                                  //Metodo constructor para el objeto doctor pueda tener las caracteristicas de nombre, especialidad e id
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id = id;
    }

    public String getNombre() {                                                                                  // Setters y getters para que pueda usarse la clase doctor y regrese su variable mencionada en "return:[VARIABLE]" dentro del main
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getId() {
        return id;
    }
}

class paciente {                                                                                                 // Lo mismo pero con paciente
    private String nombre;
    private int id;

    public paciente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}