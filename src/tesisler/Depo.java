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
public class Depo extends Tesisler {

    public Depo() {
        super();
    }

    public Depo(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {
        super(ad, odaSayisi, katSayisi, metrekare, kapasite);

    }
    
     @Override
     public String mesaj(){
        return "Depo Eklendi";
    }
}
