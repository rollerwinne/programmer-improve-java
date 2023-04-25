package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TestNull {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("d",2);
        int x = (map.get("d") == null) ? 0 : map.get("d");
        System.out.println(x);
        System.out.println(map.get(""));
    }
}
