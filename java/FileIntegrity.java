package file.hash.integrity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jolie.runtime.JavaService;
import jolie.runtime.Value;

public class FileIntegrity
extends JavaService {
    public Value hashGenerator(Value request) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-384");
        }
        catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        String in = request.getFirstChild("path").strValue();
        try {
            DigestInputStream dis = new DigestInputStream(new FileInputStream(in), md);
            Object object = null;
            try {
                while (dis.read() != -1) {
                }
                md = dis.getMessageDigest();
            }
            catch (Throwable throwable) {
                object = throwable;
                throw throwable;
            }
            finally {
                if (dis != null) {
                    if (object != null) {
                        try {
                            dis.close();
                        }
                        catch (Throwable throwable) {
                            ((Throwable)object).addSuppressed(throwable);
                        }
                    } else {
                        dis.close();
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        StringBuilder result = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        request.getFirstChild("hash").setValue(result.toString());
        return request;
    }
}
