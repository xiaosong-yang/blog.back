package top.yyf256.blog.util.code;

import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.util.code.DesCodeUtil;
import top.yyf256.util.string.StringUtil;

public class CodeUtil {
    public static void main(String[] args) throws Exception {
//        System.out.println(StringUtil.bytesToHexString(DesCodeUtil.initKey()));
        System.out.println(StringUtil.bytesToHexString(
                DesCodeUtil.encrypt("lovel8023.".getBytes(),StringUtil.hexStringToBytes(SystemConstant.DES_CODE_KEY))));
//        System.out.println(new String(DesCodeUtil.decrypt(StringUtil.hexStringToBytes("d7cd3ef23f19af6aa902fcfba0461d27"),
//                StringUtil.hexStringToBytes("7a3d3b2a6137a470"))));
    }
}
