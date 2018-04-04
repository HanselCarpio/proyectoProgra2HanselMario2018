package Domain;
//Declaracion de librerias adicionales

import Domain.AudioVisual;
import java.io.Serializable;
import java.util.ArrayList;

public class ArrayAV implements Serializable {

    //atributos
    private ArrayList<AudioVisual> audioVisualList;

    //constructor
    public ArrayAV() {
        audioVisualList = new ArrayList();
    }

    // agrega un nuevo articuloAV
    public void addAV(AudioVisual audioVisual) {
        audioVisualList.add(audioVisual);
    }

    // obtiene un articuloAV
    public AudioVisual getAV(int i) {
        return audioVisualList.get(i);
    }

    // reemplaza un informacion de un articuloAV
    public void modifiAV(int i, AudioVisual updatedAV) {
        audioVisualList.set(i, updatedAV);
    }

    // elimina un articuloAV
    public void deleteAV(int i) {
        audioVisualList.remove(i);
    }

    // elimina a todos los Articulos
    public void deleteAV() {
        for (int i = 0; i < numAV(); i++) {
            audioVisualList.remove(0);
        }
    }

    // obtiene numero de articulosAV registrados
    public int numAV() {
        return audioVisualList.size();
    }

    // busca un articulo por codigo
    public int SearchAV(String codigo) {
        for (int i = 0; i < numAV(); i++) {
            if (codigo.equalsIgnoreCase(getAV(i).getCodeAV())) {
                return i;
            }
        }
        return -1;
    }
}
