package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        String expected = "tEaN0+n3ulxDkIAbL5sgZpct9Z0GiI5x7tL2MHcRFpS9+A0xgZQX4BC5Tkx7vTI7rF5MpoCI1zTn2UAxi4eqg7ARwFP9UedrHNf0iiZCFHdm/fRXNE7bu41IBbHa7sGSuo4KeJfv9e9rK7cDllkc5m5Z3UnS0Zgp7rE7g6PeQUjDOMyY+S4DtRqLsKow/+ST88WgVnoLhgYybhBYlkV2Nc/OpanIgNVdvl1T8R69sYpuif0X4yl/fMfxTcGZxlqacyUs/3ACst0FB8tpJ4DEDw==";
        assertEquals(expected, actual);
    }

    @DisplayName("Test - Decryption")
    @Test
    void givenEncryptedBase64String_whenDecrypt_thenShouldBeEqualToSourceString() throws Exception {
        // Given
        AES256 sut = new AES256();
        String encrypted = "tEaN0+n3ulxDkIAbL5sgZpct9Z0GiI5x7tL2MHcRFpS9+A0xgZQX4BC5Tkx7vTI7rF5MpoCI1zTn2UAxi4eqg7ARwFP9UedrHNf0iiZCFHdm/fRXNE7bu41IBbHa7sGSuo4KeJfv9e9rK7cDllkc5m5Z3UnS0Zgp7rE7g6PeQUjDOMyY+S4DtRqLsKow/+ST88WgVnoLhgYybhBYlkV2Nc/OpanIgNVdvl1T8R69sYpuif0X4yl/fMfxTcGZxlqacyUs/3ACst0FB8tpJ4DEDw==";
        // When
        String actual = sut.decrypt(encrypted);
        // Then
        assertEquals(src, actual);

    }

}