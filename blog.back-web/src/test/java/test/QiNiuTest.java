package test;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import top.yyf256.blog.util.QiNiuUtil;

import java.io.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=BlogApplication.class)
//@WebAppConfiguration
public class QiNiuTest {


    public static void main(String[] args) throws Exception {
        File file = new File("F:\\桌面\\宋伊人2.jpeg");

        byte[] uploadBytes = getByte(file);
        QiNiuUtil.uploadImg(uploadBytes,"test");
    }

    public void test(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "d1JEsIHfTxY7GbDOsJdqBVEUuXcJRkZTkdPZ0kZt";
        String secretKey = "FfGkV-850xbKoU9IKItmtiZ5UvYwdLEJ6_vL2Ue0";
        String bucket = "blogpicturespublic";

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "宋伊人2.jpeg";

        try {
            File file = new File("F:\\桌面\\宋伊人2.jpeg");

            byte[] uploadBytes = getByte(file);
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * 把一个文件转化为字节
     *
     * @param file
     * @return byte[]
     * @throws Exception
     */
    public static byte[] getByte(File file) throws Exception {
        byte[] bytes = null;
        if (file != null) {
            InputStream is = new FileInputStream(file);
            int length = (int) file.length();
            if (length > Integer.MAX_VALUE) // 当文件的长度超过了int的最大值
            {
                System.out.println("this file is max ");
                return null;
            }
            bytes = new byte[length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            // 如果得到的字节长度和file实际的长度不一致就可能出错了
            if (offset < bytes.length) {
                System.out.println("file length is error");
                return null;
            }
            is.close();
        }
        return bytes;
    }
}
