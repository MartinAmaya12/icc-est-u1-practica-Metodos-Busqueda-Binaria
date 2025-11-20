package views;

import java.util.Scanner;
import models.Person;

public class View {
    // CORRECCIÓN: Variable en minúscula para evitar conflictos
    private Scanner scanner;

    public View() {
        // CORRECCIÓN: Inicializamos la variable en minúscula
        scanner = new Scanner(System.in);
        
    }
    // Agrega este método en tu archivo View.java
    public int inputInt() {
        // Lee un número entero sin imprimir ningún mensaje previo
        return scanner.nextInt();
    }

    public int showMenu() {
        System.out.println("\n--- SISTEMA DE PERSONAS ---");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Mostrar Personas");
        System.out.println("3. Ordenar Personas");
        System.out.println("4. Buscar Persona (Binaria)");
        System.out.println("100. Salir");
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.println("\n--- Ingresar Nueva Persona ---");
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        // Usamos next() para leer una palabra y evitar problemas con el Enter
        return scanner.next(); 
    }

    public int inputAge() {
        System.out.print("Ingrese la edad: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("\n--- Lista de Personas ---");
        if (persons == null || persons.length == 0) {
             System.out.println("No hay datos.");
             return;
        }
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("¡Persona encontrada!: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    // Este método lo usamos en el Controller para ordenar
    public int selectSortingMethod() {
        System.out.println("\n--- ¿Cómo desea ordenar? ---");
        System.out.println("1. Por Nombre");
        System.out.println("2. Por Edad");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }

    // Este método lo usamos en el Controller para buscar
    public int selectSearchCriterion() {
        System.out.println("\n--- Criterio de Búsqueda ---");
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Edad");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}