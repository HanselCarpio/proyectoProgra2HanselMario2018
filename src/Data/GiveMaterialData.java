/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.GiveMaterial;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hansel
 */
public class GiveMaterialData {
    
    //atributos
    private String path;

    //constructor
    public GiveMaterialData() {
        this.path = "loan.dat";
    }//const

    //metodo para guardar el objeto libro
    public void saveObjectMaterial(GiveMaterial giveMaterial) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<GiveMaterial> giveMaterialList = new ArrayList<GiveMaterial>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            giveMaterialList = (List<GiveMaterial>) aux;
            objectInputStream.close();
        }
        giveMaterialList.add(giveMaterial);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(giveMaterialList);
        output.close();
    }
    
    //metodo de tipo list para agregar el objeto al una lista e agregar al archivo
    public List<GiveMaterial> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<GiveMaterial> giveMaterialList = new ArrayList<GiveMaterial>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            giveMaterialList = (List<GiveMaterial>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return giveMaterialList;
    }
}
