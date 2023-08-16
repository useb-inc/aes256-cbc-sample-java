package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class AES256Test {
    private final String src = "{\"idType\":\"2\",\"userName\":\"홍길동\",\"driverNo\":\"13-03-123456-11\",\"juminNo1\":\"910101\",\"juminNo2\":\"1001234\",\"_juminNo2\":\"1******\",\"issueDate\":\"20170131\",\"transaction_id\":\"14740463576391927d859b91670484605\"}";

    @DisplayName("Test - Encryption")
    @Test
    void givenPlainText_whenEncrypt_thenShouldGiveBase64EncodedString() throws Exception {
        // Given
        AES256 sut = new AES256();
        // When
        String actual = sut.encrypt(src);
        // Then
        String expected = "Zlgcl/3jVggxBxWjWXC5je/hZ/HBGQ7dvPLQqotjRLCqMTDqIhvOmjg79+NhBj+rlxe0Oo2NWpg3FpxkpqiCKSBJqgduAXp3jZz7O1/Jvw4OgNYLCTNLZaUcI6s33akkUWucv8OHgbl3C1E7HoFSHpQnF/CFMaQGOxVmJWgy2o5AkAeuWSGS4N9SP9KDYZwZPhhcmbcoVGoUxSmMZ5utrlaivu+ASi1CXjsSMFzCVgR82RV297wAEaaJO0JbJqM1ffd3fir0fK2IWTGHskQbqw==";
        assertEquals(expected, actual);
    }

    @DisplayName("Test - Decryption")
    @Test
    void givenEncryptedBase64String_whenDecrypt_thenShouldBeEqualToSourceString() throws Exception {
        // Given
        AES256 sut = new AES256();
        String encrypted = "Zlgcl/3jVggxBxWjWXC5je/hZ/HBGQ7dvPLQqotjRLCqMTDqIhvOmjg79+NhBj+rlxe0Oo2NWpg3FpxkpqiCKSBJqgduAXp3jZz7O1/Jvw4OgNYLCTNLZaUcI6s33akkUWucv8OHgbl3C1E7HoFSHpQnF/CFMaQGOxVmJWgy2o5AkAeuWSGS4N9SP9KDYZwZPhhcmbcoVGoUxSmMZ5utrlaivu+ASi1CXjsSMFzCVgR82RV297wAEaaJO0JbJqM1ffd3fir0fK2IWTGHskQbqw==";
        // When
        String actual = sut.decrypt(encrypted);
        // Then
        assertEquals(src, actual);
    }

    @DisplayName("Test - Encrypted using file IO")
    @Test
    void encryptTest() throws Exception {
        // Given
        AES256 sut = new AES256();
        String plainData = null;
        String expected = null;

        try {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(Paths.get(currentPath, "src", "test", "resources", "plainData.txt").toString());
            byte[] binary = new byte[(int) file.length()];
            InputStream stream = new FileInputStream(file);
            stream.read(binary);
            stream.close();
            plainData = new String(binary);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // When
        assert plainData != null;
        String actual = sut.encrypt(plainData);

        try {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(Paths.get(currentPath, "src", "test", "resources", "encrypted.txt").toString());
            byte[] binary = new byte[(int) file.length()];
            InputStream stream = new FileInputStream(file);
            stream.read(binary);
            stream.close();
            expected = new String(binary);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // Then
        assertEquals(expected, actual);
    }

    @DisplayName("Test - Decryption using file IO")
    @Test
    void decryptTest() throws Exception {
        // Given
        AES256 sut = new AES256();
        String encryptedData = null;
        String expected = null;

        try {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(Paths.get(currentPath, "src", "test", "resources", "encrypted.txt").toString());
            byte[] binary = new byte[(int) file.length()];
            InputStream stream = new FileInputStream(file);
            stream.read(binary);
            stream.close();
            encryptedData = new String(binary);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // When
        String actual = sut.decrypt(encryptedData);

        try {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(Paths.get(currentPath, "src", "test", "resources", "plainData.txt").toString());
            byte[] binary = new byte[(int) file.length()];
            InputStream stream = new FileInputStream(file);
            stream.read(binary);
            stream.close();
            expected = new String(binary);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // Then
        assertEquals(expected, actual);
    }
}