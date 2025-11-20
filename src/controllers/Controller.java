package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] persons;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start() {
        int option = 0;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    // El controller le pasa los datos a la vista, no al revés
                    view.displayPersons(persons);
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 100:
                    view.showMessage("Adiós.");
                    break;
                default:
                    view.showMessage("Opción inválida.");
            }
        } while (option != 100);
    }

    public void inputPersons() {
        view.showMessage("¿Cuántas personas vas a ingresar?");
        int n = view.inputInt(); // Reutilizamos inputAge para leer el entero
        persons = new Person[n];

        for (int i = 0; i < n; i++) {
            view.showMessage("Persona " + (i + 1) + ":");
            persons[i] = view.inputPerson();
        }
    }

    public void sortPersons() {
        if (persons == null) {
            view.showMessage("No hay personas registradas.");
            return;
        }

        // Usamos el método corregido según UML
        int method = view.selectSortingMethod();

        switch(method) {
            case 1:
                sortingMethods.sortByNameWithBubble(persons);
                view.showMessage("Ordenado por Nombre (Burbuja).");
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDes(persons);
                view.showMessage("Ordenado por Nombre (Selección Descendente).");
                break;
            case 3:
                sortingMethods.sortByNameWithInsertion(persons);
                view.showMessage("Ordenado por Nombre (Inserción).");
                break;
            case 4:
                sortingMethods.sortByAgeWithInsertion(persons);
                view.showMessage("Ordenado por Edad (Inserción).");
                break;
            default:
                view.showMessage("Opción no válida.");
        }
    }

    public void searchPerson() {
        if (persons == null) {
            view.showMessage("No hay personas registradas.");
            return;
        }

        int criterion = view.selectSearchCriterion();

        if (criterion == 1) { // Por Nombre
            // Verificamos si está ordenado por nombre
            if (!searchMethods.isSortedByName(persons)) {
                view.showMessage("Lista no ordenada por nombre. Ordenando automáticamente...");
                sortingMethods.sortByNameWithBubble(persons); 
            }
            String name = view.inputName();
            Person result = searchMethods.binarySearchByName(persons, name);
            view.displaySearchResult(result);

        } else if (criterion == 2) { // Por Edad
            // Verificamos si está ordenado por edad
            if (!searchMethods.isSortedByAge(persons)) {
                view.showMessage("Lista no ordenada por edad. Ordenando automáticamente...");
                sortingMethods.sortByAgeWithInsertion(persons);
            }
            int age = view.inputAge();
            Person result = searchMethods.binarySearchByAge(persons, age);
            view.displaySearchResult(result);
        }
    }
}