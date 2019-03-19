package util;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Optional;

/**
 * created by huyanshi on 2019/3/14
 */
public class WrongWord {

  public static void main(String[] args) {

    HuYanAsyncHttpCaller caller = new HuYanAsyncHttpCaller();
    JSONObject body = new JSONObject();
    body.put("username", "tester");
    body.put("mode", "advanced");
    body.put("biz_type", "show");
    body.put("content",
        "腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。");

    Optional<AsyncHttpResponse> response = caller
        .post("http://api.cuobiezi.net/spellcheck/url_check/json_phrase", body.toJSONString(),
            new HashMap<>());
    int i =0;
  }
}
