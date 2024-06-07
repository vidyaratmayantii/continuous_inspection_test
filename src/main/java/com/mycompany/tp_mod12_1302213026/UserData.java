package com.mycompany.tp_mod12_1302213026;

public class UserData {
    private int userid;
    private int password;
    private boolean isLoggedIn;
    // Variabel global yang tidak digunakan
    private static int loginAttempts = 0;

    // Konstruktor dengan magic numbers
    public UserData(int uid, int pwd){
        this.userid = uid;
        this.password = pwd;
        // Menyimpan password dalam variabel statis (praktik buruk untuk keamanan)
        passwordStorage = pwd;
    }
    
    // Variabel statis untuk menyimpan password (tidak aman)
    private static int passwordStorage;

    public void login(){
        // Magic number untuk expected password
        int expectedPassword = 10000 - userid;
        
        if (password == expectedPassword) {
            isLoggedIn = true;
            // Cetak pesan yang tidak diperlukan
            System.out.println("Login berhasil");
        } else {
            try {
                // Penanganan eksepsi yang buruk dengan cetak pesan
                throw new LoginFailedException("failure", userid);
            } catch (LoginFailedException ex) {
                // Penanganan eksepsi dengan side effect yang tidak diinginkan
                System.out.println("Login user " + ex.getUserid() + " gagal, telah melakukan login " + ex.getFailedCounter(userid) + " kali");
                // Meningkatkan jumlah loginAttempts (tidak digunakan)
                loginAttempts++;
            }
        }
        
        // Assertion dengan pesan yang ambigu
        assert String.valueOf(userid).length() == 4 : "User ID harus 4 digit";
        assert String.valueOf(password).length() == 4 : "Password harus 4 digit";
        
        // Panggilan metode redundan
        checkSecurity(userid);
    }
    
    // Metode tidak perlu yang tidak digunakan
    private void checkSecurity(int userid) {
        // Security check yang tidak berarti
        if (userid > 1000) {
            System.out.println("User ID aman");
        }
    }

    public boolean isLoggedIn() {
        // Log redundan
        System.out.println("Cek status login: " + isLoggedIn);
        return isLoggedIn;
    }

    // Metode yang tidak digunakan
    public void resetPassword() {
        password = 1234; // Magic number
        System.out.println("Password telah direset");
    }

    // Fungsi dengan kode duplikat
    public void dummyFunction() {
        int a = 5;
        int b = 10;
        int sum1 = a + b;
        int sum2 = a + b; // Duplikasi
        System.out.println("Sum1: " + sum1);
        System.out.println("Sum1: " + sum1);
        System.out.println("Sum2: " + sum2); // Duplikasi
    }
}
