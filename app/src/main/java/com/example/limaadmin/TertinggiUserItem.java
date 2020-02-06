package com.example.limaadmin;

public class TertinggiUserItem {
    private String mKelompok;
    private String mNama;
    private String mSprint;
    private String mJamMulai;
    private String mJamAkhir;
    private String mNilai;

    public TertinggiUserItem(String kelompok, String nama, String sprint, String jam_mulai, String jam_akhir, String nilai) {
        mKelompok = kelompok;
        mNama = nama;
        mSprint = sprint;
        mJamMulai = jam_mulai;
        mJamAkhir = jam_akhir;
        mNilai = nilai;
    }

    public String getKelompok() { return mKelompok; }
    public String getNama() { return mNama; }
    public String getSprint() { return mSprint; }
    public String getJamMulai() { return mJamMulai; }
    public String getJamAkhir() { return mJamAkhir; }
    public String getNilai() { return mNilai; }
}
