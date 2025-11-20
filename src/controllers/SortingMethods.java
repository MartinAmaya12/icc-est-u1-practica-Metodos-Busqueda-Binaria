package controllers;

import models.Person;

public class SortingMethods {

    // 1. Ordenamiento Burbuja por Nombre (Requerido por PDF)
    public void sortByNameWithBubble(Person[] persons) {
        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    // Swap
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    // 2. Ordenamiento Selección Descendente por Nombre (Requerido por PDF)
    public void sortByNameWithSelectionDes(Person[] persons) {
        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                // Busca el mayor para orden descendente
                if (persons[j].getName().compareToIgnoreCase(persons[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            // Swap
            Person temp = persons[maxIdx];
            persons[maxIdx] = persons[i];
            persons[i] = temp;
        }
    }

    // 3. Inserción por Nombre
    public void sortByNameWithInsertion(Person[] persons) {
        int n = persons.length;
        for (int i = 1; i < n; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }
    }

    // 4. Inserción por Edad
    public void sortByAgeWithInsertion(Person[] persons) {
        int n = persons.length;
        for (int i = 1; i < n; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }
    }
}