package a2_Json;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * FastJson工具类：JSONObject
 */
public class HelloJson {
    public static void main(String[] args) {
        toJsonString();
        jsonArr();
    }
    // javaObject to jsonString
    private static void toJsonString() {
        Product product = new Product();
        product.setId(1);
        product.setName("电视机");
        product.setCount(100);
        product.setPrice(4000);

        String jsonString = JSONObject.toJSONString(product);
        System.out.println("toJSONString: " + jsonString);
    }

    private static void jsonArr(){
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("电视机");
        product1.setCount(100);
        product1.setPrice(4000);
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("洗衣机");
        product2.setCount(50);
        product2.setPrice(2000);

        List<Product> list = new ArrayList<Product>();
        list.add(product1);
        list.add(product2);

        String JsonArr = JSONObject.toJSONString(list);
        System.out.println(JsonArr);
    }
}
