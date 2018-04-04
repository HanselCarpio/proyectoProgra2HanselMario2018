/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.GiveMaterialData;
import Domain.GiveMaterial;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author hansel
 */
public class GiveMaterialBusiness {

    //atributos
    GiveMaterialData giveMaterialData;

    //constructor
    public GiveMaterialBusiness() {
        this.giveMaterialData = new GiveMaterialData();
    }

    public void saveObjectMaterial(GiveMaterial giveMaterial) throws IOException, ClassNotFoundException {
        this.giveMaterialData.saveObjectMaterial(giveMaterial);
    }

    public List<GiveMaterial> arrays() throws IOException, ClassNotFoundException {
        return this.giveMaterialData.arrays();
    }
}
