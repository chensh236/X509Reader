import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

// 读取证书
public class FileIO {
    FileIO(String filePath) throws IOException {
        try {
            // 读取证书
            FileInputStream fs = new FileInputStream(filePath);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cer = cf.generateCertificate(fs);
            // 将证书转换为X509证书
            this.x = (X509Certificate)cer;
            fs.close();
        }catch (CertificateException e){
            e.printStackTrace();
        } finally {

        }
    }

    private X509Certificate x;
    public X509Certificate getX(){return this.x;}
}
