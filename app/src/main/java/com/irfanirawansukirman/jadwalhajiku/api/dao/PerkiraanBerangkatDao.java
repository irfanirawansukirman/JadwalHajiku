package com.irfanirawansukirman.jadwalhajiku.api.dao;

/**
 * Created by irfan on 22/09/16.
 */

public class PerkiraanBerangkatDao {

    private String status;

    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String nomor_porsi;
        private String nama;
        private String kabupaten_kota;
        private String provinsi;
        private String kuota_provinsi_kab_kota_khusus;
        private String posisi_porsi_pada_kuota_provinsi_kab_kota_khusus;
        private String perkiraan_berangkat_hijriah;
        private String perkiraan_berangkat_tahun_masehi;

        public String getNomor_porsi() {
            return nomor_porsi;
        }

        public void setNomor_porsi(String nomor_porsi) {
            this.nomor_porsi = nomor_porsi;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getKabupaten_kota() {
            return kabupaten_kota;
        }

        public void setKabupaten_kota(String kabupaten_kota) {
            this.kabupaten_kota = kabupaten_kota;
        }

        public String getProvinsi() {
            return provinsi;
        }

        public void setProvinsi(String provinsi) {
            this.provinsi = provinsi;
        }

        public String getKuota_provinsi_kab_kota_khusus() {
            return kuota_provinsi_kab_kota_khusus;
        }

        public void setKuota_provinsi_kab_kota_khusus(String kuota_provinsi_kab_kota_khusus) {
            this.kuota_provinsi_kab_kota_khusus = kuota_provinsi_kab_kota_khusus;
        }

        public String getPosisi_porsi_pada_kuota_provinsi_kab_kota_khusus() {
            return posisi_porsi_pada_kuota_provinsi_kab_kota_khusus;
        }

        public void setPosisi_porsi_pada_kuota_provinsi_kab_kota_khusus(String posisi_porsi_pada_kuota_provinsi_kab_kota_khusus) {
            this.posisi_porsi_pada_kuota_provinsi_kab_kota_khusus = posisi_porsi_pada_kuota_provinsi_kab_kota_khusus;
        }

        public String getPerkiraan_berangkat_hijriah() {
            return perkiraan_berangkat_hijriah;
        }

        public void setPerkiraan_berangkat_hijriah(String perkiraan_berangkat_hijriah) {
            this.perkiraan_berangkat_hijriah = perkiraan_berangkat_hijriah;
        }

        public String getPerkiraan_berangkat_tahun_masehi() {
            return perkiraan_berangkat_tahun_masehi;
        }

        public void setPerkiraan_berangkat_tahun_masehi(String perkiraan_berangkat_tahun_masehi) {
            this.perkiraan_berangkat_tahun_masehi = perkiraan_berangkat_tahun_masehi;
        }
    }
}
