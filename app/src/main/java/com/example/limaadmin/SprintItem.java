package com.example.limaadmin;

public class SprintItem{
    private String mSprint;
    private String mTanggal;
    private String mKelompok;

    public SprintItem(String sprint, String tanggal, String kelompok) {
        mSprint = sprint;
        mTanggal = tanggal;
        mKelompok = kelompok;
    }

    public String getSprint() { return mSprint; }
    public String getTanggal() { return mTanggal; }
    public String getKelompok() { return mKelompok; }
}
