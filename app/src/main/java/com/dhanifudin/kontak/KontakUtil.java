package com.dhanifudin.kontak;

import java.util.ArrayList;

/**
 * Created by dhanifudin on 11/18/17.
 */

public class KontakUtil {

    public static ArrayList<Kontak> getKontak() {
        ArrayList<Kontak> data = new ArrayList<>();
        data.add(new Kontak("Andi", "Male"));
        data.add(new Kontak("Budi", "Male"));
        data.add(new Kontak("Cindy", "Female"));
        data.add(new Kontak("Deni", "Male"));
        data.add(new Kontak("Eka", "Female"));
        data.add(new Kontak("Fani", "Female"));
        return data;
    }
}
