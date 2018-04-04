package Domain;

import java.io.Serializable;
import javax.swing.*;

public class AudioVisual implements Serializable {

    // atributos    
    private String codeAV;
    private String nameAV;
    private String typeAV;
    private int annoAV;
    private String colorAV;

    // constructor vacio
    public AudioVisual() {
    }

    // constructor con parametros
    public AudioVisual(String codeAV, String nameAV, String typeAV, int annoAV, String colorAV) {
        this.codeAV = codeAV;
        this.nameAV = nameAV;
        this.typeAV = typeAV;
        this.annoAV = annoAV;
        this.colorAV = colorAV;
    }

    //setter & getter
    public String getCodeAV() {
        return codeAV;
    }

    public void setCodeAV(String codeAV) {
        this.codeAV = codeAV;
    }

    public String getNameAV() {
        return nameAV;
    }

    public void setNameAV(String nameAV) {
        this.nameAV = nameAV;
    }

    public String getTypeAV() {
        return typeAV;
    }

    public void setTypeAV(String typeAV) {
        this.typeAV = typeAV;
    }

    public int getAnnoAV() {
        return annoAV;
    }

    public void setAnnoAV(int annoAV) {
        this.annoAV = annoAV;
    }

    public String getColorAV() {
        return colorAV;
    }

    public void setColorAV(String colorAV) {
        this.colorAV = colorAV;
    }

    //toString
    @Override
    public String toString() {
        return "AudioVisual{" + "codeAV=" + codeAV + ", nameAV=" + nameAV + ", typeAV=" + typeAV + ", annoAV=" + annoAV + ", colorAV=" + colorAV + '}';
    }

}
