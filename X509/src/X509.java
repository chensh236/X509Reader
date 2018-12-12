import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;

public class X509 {
    public static void main(String args[]) {
        try
        {
            String filePath = "sample/jd.cer";
            FileIO fio = new FileIO(filePath);
            // 检查合法性
            fio.getX().checkValidity();
            // 获得版本号
            System.out.println("版本: " + fio.getX().getVersion());
            // 获得序列号
            System.out.println("序列号: " + fio.getX().getSerialNumber());
            // 证书发布方的值
            System.out.println("发布方的标识: " + fio.getX().getIssuerX500Principal().toString());
            System.out.println("发布方的唯一标识: " + fio.getX().getIssuerUniqueID());
            //证书有效期
            System.out.println("证书有效期的 notBefore 日期: "+ fio.getX().getNotBefore());
            System.out.println("证书有效期的 notAfter 日期: "+ fio.getX().getNotAfter());
            //证书的签名
            System.out.println("签名算法: "+ fio.getX().getSigAlgName());
            System.out.println("主体唯一标识: "+ fio.getX().getSubjectUniqueID());
            //主体
            System.out.println("主体名: "+ fio.getX().getSubjectX500Principal());
            //主题的签名
            System.out.println("签名: "+ fio.getX().getSignature().toString());
            // 从此证书中获得公钥
            byte [] encode = fio.getX().getPublicKey().getEncoded();
            System.out.println("公钥:");
            String key = "[";
            for(int i = 0 ; i < encode.length ; i++)
            {
                int index = encode[i] & 0xff;
                key += Integer.toString(index);
                if(i < encode.length - 1) key += ", ";
                if(i % 40 == 0 && i != 0){
                    key += "\n";
                }
            }
            System.out.println(key + "]\n");
        }
        catch (CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
};