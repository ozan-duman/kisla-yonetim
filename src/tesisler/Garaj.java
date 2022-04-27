/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesisler;

/**
 *
 * @author odoza
 */
public class Garaj extends Tesisler {

    public Garaj() {
        super();
    }

    public Garaj(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {
        super(ad, odaSayisi, katSayisi, metrekare, kapasite);

    }
    
     @Override
     public String mesaj(){
        return "Garaj Eklendi";
    }

}
