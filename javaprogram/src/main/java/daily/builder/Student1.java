package daily.builder;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Created by pfliu on 2019/04/21.
 */
@Builder
@Data
public class Student1 {

    // 必选
    private String name;
    // 可选
    private int age;
    private String title;

}
