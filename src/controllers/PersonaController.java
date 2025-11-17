package controllers;

import models.Persona;

public class PersonaController {
    public void bubbleSortbyname(Persona[] people){
        for(int i = 0; i < people.length; i++){
            boolean swapped = true;
            for(int j = 0; j < people.length-1-i; j++){
                if(people[j].getNombre().compareTo(people[j+1].getNombre()) > 0){
                    Persona temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public Integer findPersonaByName(Persona[] people, String nombre){
        int izq = 0;
        int der = people.length - 1;

        while(izq <= der){
            int mid = izq + (der - izq) / 2;
            int comparison = people[mid].getNombre().compareTo(nombre);

            if(comparison ==0){
                return mid;
            }else if (comparison < 0) {
                izq = mid+1;
            }else{
                der = mid - 1;
            }
        }
    return null;
    }
}

