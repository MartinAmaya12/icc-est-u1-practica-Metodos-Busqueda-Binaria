package views;
import models.Persona;
public class ShowConsole {
    public void showResult(Integer result){
        if(result != null){
            System.out.println("Elemento encontreado: " + result);
        }else{
            System.out.println("El elemento " + result + "no se encontro en el arreglo ");
        }
    }

    public void showResult(String message) {
        System.out.println(message);
    }

}
