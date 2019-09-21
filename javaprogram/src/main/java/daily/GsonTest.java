package daily;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by pfliu on 2019/05/16.
 */
public class GsonTest {


    public static void main(String[] args) {
        Gson gson = new Gson();
        long dayBefore = ((int) (System.currentTimeMillis() / 1000)) - 24 * 60 * 60;
        System.out.println(dayBefore);


//        Map<Integer, Integer> testMap = new HashMap<>();
//        testMap.put(1, 1);
//        Integer i = testMap.get((long)1);
//        System.out.println(i);

//        JsonParser parser = new JsonParser();
//
//        String i1 = "[\"wo\"]";
//
//        JsonArray a = parser.parse(i1).getAsJsonArray();
//        System.out.println(a.get(0).getAsString());
//
//        ConcurrentSkipListMap<String, String> kk = new ConcurrentSkipListMap<>();
//
//        // 从json字符串拿到java对象并且拿到某些字段
//        String input = "{\"name\": \"huyanshi\", \"age_type\": 2}";
//        User user = gson.fromJson(input, User.class);
//        System.out.println(user.name);
//        System.out.println(user.ageType);
//
//        //从json字符串拿到json对象并且获取某些字段
//        JsonObject jo = parser.parse(input).getAsJsonObject();
//        System.out.println(jo.get("name").getAsString());
//        System.out.println(jo.get("age").getAsInt());
//
//        // 从json字符串解析json的list
//        //language=JSON
//        String i2 = "[{\"name\":\"huyanshi\",\"age\":\"12\"},{\"name\":\"huyanshi1\",\"age\":\"122\"}]";
//        List<User> users = gson.fromJson(i1, new TypeToken<List<User>>() {
//        }.getType());
//        System.out.println(users.toString());
//
//        //新建一个json对象并添加某些字段,之后输出字符串
//        JsonObject jo1 = new JsonObject();
//        jo1.addProperty("name", "huyanshi");
//        jo1.addProperty("age", "12");
//        System.out.println(jo1.toString());
//
//        // 将java对象或者数组转换为json字符串
//        String a1 = gson.toJson(user);
//        String a2 = gson.toJson(users);
//        System.out.println(a1);
//        System.out.println(a2);
//
//        //测试注解@SerializedName,
//        User u = new User();
//        u.name = "huyan";
//        u.age = 2;
//        System.out.println(gson.toJson(u));

        DetailPushInfo d = gson.fromJson("{\"job_id\":35567720,}", DetailPushInfo.class);
        System.out.println(d);
    }
    private static class DetailPushInfo {

        @SerializedName("job_id")
        int jobId;
        @SerializedName("push_type")
        int pushType;
        @SerializedName("push_keyword")
        String pushKeyword;


        public DetailPushInfo(int jobId, int pushType, String pushKeyword) {
            this.jobId = jobId;
            this.pushType = pushType;
            this.pushKeyword = pushKeyword;
        }

    }

    class User {
        String name;
        int ageType;
    }


}
