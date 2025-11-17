
import controllers.BusquedaBnaria;
import controllers.PersonaController;
import models.Persona;
import views.ShowConsole;
import views.ShowConsole;
public class App {
    public static void main(String[] args) throws Exception {
        
        ShowConsole sC = new ShowConsole();
        BusquedaBnaria bB = new BusquedaBnaria();
        int[] arr = new int [] {10, 2, 4, 6, 7, 8, 13, 20};
        bB.bubbleSort(arr);
        Integer result = bB.busquedaBinaria(arr, 10);

        sC.showResult(result);
        PersonaController pC = new PersonaController();
        Persona[] people = new Persona[]{
        new Persona("Juan", 25),
            new Persona("Ana", 30),
            new Persona("Juan", 20),
            new Persona("Juan", 28),
            new Persona("Juan", 22),
            new Persona("Juan", 27),
            new Persona("Juan", 24)
        };

        pC.bubbleSortbyname(people);
        Integer result1 = pC.findPersonaByName(people, "Pedro");
        sC.showResult(result1);
    }
}