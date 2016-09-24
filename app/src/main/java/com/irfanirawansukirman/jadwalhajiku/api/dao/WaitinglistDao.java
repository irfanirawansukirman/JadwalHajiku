package com.irfanirawansukirman.jadwalhajiku.api.dao;

import java.util.List;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistDao {
    private String status;

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String wilayah;
        private String kuota;
        private String tahun;
        private String pendaftar_akhir;
        private String pendaftaran;
        private String lunas_tunda;

        public String getWilayah() {
            return wilayah;
        }

        public void setWilayah(String wilayah) {
            this.wilayah = wilayah;
        }

        public String getKuota() {
            return kuota;
        }

        public void setKuota(String kuota) {
            this.kuota = kuota;
        }

        public String getTahun() {
            return tahun;
        }

        public void setTahun(String tahun) {
            this.tahun = tahun;
        }

        public String getPendaftar_akhir() {
            return pendaftar_akhir;
        }

        public void setPendaftar_akhir(String pendaftar_akhir) {
            this.pendaftar_akhir = pendaftar_akhir;
        }

        public String getPendaftaran() {
            return pendaftaran;
        }

        public void setPendaftaran(String pendaftaran) {
            this.pendaftaran = pendaftaran;
        }

        public String getLunas_tunda() {
            return lunas_tunda;
        }

        public void setLunas_tunda(String lunas_tunda) {
            this.lunas_tunda = lunas_tunda;
        }
    }
}
