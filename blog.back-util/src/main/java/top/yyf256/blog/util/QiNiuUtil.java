package top.yyf256.blog.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QiNiuUtil {

    private static Logger logger = LogManager.getLogger(QiNiuUtil.class);

    //...生成上传凭证，然后准备上传
    public static String accessKey = "d1JEsIHfTxY7GbDOsJdqBVEUuXcJRkZTkdPZ0kZt";
    public static String secretKey = "FfGkV-850xbKoU9IKItmtiZ5UvYwdLEJ6_vL2Ue0";
    public static String bucket = "blogpicturespublic";
    public static String URL_PREFIX = "http://image.public.yyf256.top/";

    /**
     * 七牛图片上传
     *
     * @param file
     * @param dir
     * @return
     */
    public static String uploadImg(byte[] file, String dir) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);

        String picId = new Date().getTime() + "";

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = dir + "/" + getDate() + "/" + picId;

        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(file);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                logger.info(putRet.key);
                logger.info(putRet.hash);
                return URL_PREFIX + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                logger.info(r.toString());
                try {
                    logger.info(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }
}
