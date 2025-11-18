
import controllers.PersonaController;
import controllers.BusquedaBinaria;
import models.Persona;
import views.ShowConsole;

public class App {

    public static void main(String[] args) throws Exception {

        ShowConsole sC = new ShowConsole();
        BusquedaBinaria bb = new BusquedaBinaria();

        int[] arr = new int[]{10, 2, 4, 6, 7, 8, 13, 20};
        bb.bubbleSort(arr);
        int objetivo = 10;
        
        Integer result = bb.busquedaBinaria(arr, objetivo);
        
        if (result != null) {
            sC.showResult("Elemento encontrado: " + arr[result]);
        } else {
            sC.showResult((Integer) null);
        }
        
        PersonaController pc = new PersonaController();
        Persona[] people = new Persona[]{
            new Persona("Pablo", 4),
            new Persona("Maria", 5),
            new Persona("Juan", 18),
            new Persona("David", 60),
            new Persona("Mateo", 25),
            new Persona("Diego", 12),
            new Persona("Ana", 8),
            new Persona("Alicia", 9),
            new Persona("Jaime", 40)
        };
        pc.bubbleSortByAge(people); 
        int edadBuscada = 18; 
        Persona personaEncontrada = pc.findPersonaByAge(people, edadBuscada);

        if (personaEncontrada != null) {
            sC.showResult("\nLa persona con la edad " + edadBuscada + " es " + personaEncontrada.getNombre());
        } else {
            sC.showResult("No se encontró ninguna persona con la edad " + edadBuscada);
        }
    }   
}