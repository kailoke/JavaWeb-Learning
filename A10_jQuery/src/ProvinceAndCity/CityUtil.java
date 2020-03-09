package ProvinceAndCity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 工具类，获取省份和城市信息
 */

public class CityUtil {
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("黑龙江", "哈尔滨,大庆,齐齐哈尔");
        map.put("吉林", "长春,吉林,四平");
        map.put("辽宁", "沈阳,大连,葫芦岛");
    }

    // 获取省份信息
    static String getProvince() {
        Set<String> strings = map.keySet();
        StringBuilder provinces = new StringBuilder();
        for (String city : strings) {
            provinces.append(city).append(",");
        }
        return provinces.substring(0, provinces.length() - 1);
    }

    static String getCity(String province) {
        return map.get(province);
    }

    public static void main(String[] args) {
        System.out.println(CityUtil.getProvince());
        System.out.println(CityUtil.getCity("黑龙江"));
    }
}
