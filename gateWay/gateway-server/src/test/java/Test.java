import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 所在包：PACKAGE_NAME
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-08-22 11:35
 */
public class Test {

    public static void main(String[] args) {
        String[] no_filter = new String [2];
        no_filter[0] = "/chient-a/**";
        no_filter[1] = "/chient-c/**";
        String urls = "/chient-c/asdfsad/asdad/";

        String s = StrUtil.subBetween(urls, "/", "/");

        if (contains(no_filter, s)) {
            System.out.println("返回了？");
        } else {
            System.out.println("我去");
        }
    }


    public static boolean contains(String[] array, String value) {
        return indexOf(array, value) > -1;
    }

    public static int indexOf(String[] array, String value) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].contains(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
