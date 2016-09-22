package com.irfanirawansukirman.jadwalhajiku.api.event;

/**
 * Created by irfan on 22/09/16.
 */

public class PerkiraanBerangkatEvent {
    public String nomor_porsi;

    public PerkiraanBerangkatEvent(){
    }

    public void setNomor_porsi(String nomor_porsi) {
        this.nomor_porsi = nomor_porsi;
    }

    public String getNomor_porsi() {
        return nomor_porsi;
    }
}
