package controllers;

public class BusquedaBinaria {
    public Integer busquedaBinaria(int [] arr, int objetivo){
        int izq = 0;
        int der = arr.length - 1;

        while(izq <= der){
            int medio = izq + (der - izq)/2;
            if(arr[medio] == objetivo){
                return medio;
            }
            if(arr[medio] < objetivo){
                izq = medio + 1;
            }else{
                der = medio - 1;
            }
        }
        return null;
    }

    public void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean swapped =false;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true; 
                }
            }
            if(!swapped){
                break;
            }

        }
        
    }
}
