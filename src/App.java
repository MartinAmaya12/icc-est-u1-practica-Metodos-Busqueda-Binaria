
import controllers.PersonaController;
import controllers.BusquedaBinaria;
import models.Persona;
import views.ShowConsole;

public class App {

    public static void main(String[] args) throws Exception {

        ShowConsole sC = new ShowConsole();
        BusquedaBinaria bb = new BusquedaBinaria();

        int[] arr = new int[]{10, 2, 4, 6, 7, 8, 13, 20};
        bb.bubbleSort(arr); // Asegura que el arreglo esté ordenado
        int objetivo = 10;
        
        Integer result = bb.busquedaBinaria(arr, objetivo);
        
        // Muestra el valor encontrado usando el índice devuelto por busquedaBinaria
        if (result != null) {
            sC.showResult("Elemento encontrado: " + arr[result]);
        } else {
            sC.showResult((Integer) null); // Llama a la sobrecarga que maneja null
        }
        
        PersonaController pc = new PersonaController();
        Persona[] people = new Persona[]{
            new Persona("Juan", 25),
            new Persona("Ana", 30),
            new Persona("Pedro", 28),
            new Persona("Maria", 22),
            new Persona("Luis", 22),
            new Persona("Carmen", 27),
            new Persona("Sofia", 24)
        };
        pc.bubbleSortbyname(people);

        Integer result1 = pc.findPersonaByName(people, "Pedro");     
        if (result1 != null) {
            sC.showResult("Persona encontrada: " + people[result1].toString());
        } else {
            sC.showResult("No se encontró la persona");
        }
    }
}