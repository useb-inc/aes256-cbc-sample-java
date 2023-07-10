package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        AES256 AES256 = new AES256();
        String src = "{\"idType\":\"2\",\"userName\":\"홍길동\",\"driverNo\":\"13-03-123456-11\",\"juminNo1\":\"910101\",\"juminNo2\":\"1001234\",\"_juminNo2\":\"1******\",\"issueDate\":\"20170131\",\"transaction_id\":\"14740463576391927d859b91670484605\"}";

        String encrypted = AES256.encrypt(src);
        System.out.println("encrypted = " + encrypted);

        String decrypted = AES256.decrypt(encrypted);
        System.out.println("decrypted = " + decrypted);

        String stringTooLong = null;
        try {
            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(Paths.get(currentPath, "src", "test", "resources", "encrypted.txt").toString());
            byte[] binary = new byte[(int) file.length()];
            InputStream stream = new FileInputStream(file);
            stream.read(binary);
            stream.close();
            stringTooLong = new String(binary);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // When
        String actual = AES256.decrypt(stringTooLong);
        System.out.println("decrypted from file(test/resources/encrypted.txt)" + actual);
    }
}