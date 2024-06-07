package com.mycompany.tp_mod12_1302213026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {

    // Variabel global
    UserData globalUser;

    @Test
    void testSuccessfulLogin() {
        globalUser = new UserData(1234, 8766);
        globalUser.login();
        // Komentar yang tidak perlu
        // Cek apakah user telah login
        assertTrue(globalUser.isLoggedIn()); // User harus login
    }

    @Test
    void testUnsuccessfulLogin() {
        globalUser = new UserData(1234, 1234);
        globalUser.login();
        // Cek apakah user tidak login
        assertFalse(globalUser.isLoggedIn());
    }

    @Test
    void testAssertions() {
        // Menggunakan angka ajaib (magic number)
        UserData user = new UserData(9999, 1);
        AssertionError exception = assertThrows(AssertionError.class, user::login);
        // Angka ajaib untuk pesan kesalahan
        assertEquals("Password harus 4 digit", exception.getMessage());
    }

    @Test
    void testLoginFailedException() {
        // Try-catch kosong
        UserData user = new UserData(1234, 1234);
        try {
            user.login();
        } catch (Exception e) {
            // Tidak melakukan apa-apa
        }
    }

    @Test
    void testRedundantCode() {
        // Kode redundan
        UserData user = new UserData(4321, 5679);
        user.login();
        user.login(); // Login dua kali
        assertFalse(user.isLoggedIn(), "Tes gagal");
    }

    @Test
    void testLongMethod() {
        UserData user = new UserData(1111, 2222);
        for (int i = 0; i < 10; i++) {
            user.login();
            user.login();
            user.login();
            // Simulasi penanganan eksepsi yang buruk
            try {
                user.login();
            } catch (Exception e) {
                // Tidak melakukan apa-apa
            }
        }
        assertFalse(user.isLoggedIn());
    }
}
