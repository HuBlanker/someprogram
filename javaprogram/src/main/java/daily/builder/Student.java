package daily.builder;

import lombok.Getter;
import lombok.NonNull;


/**
 * Created by pfliu on 2019/04/21.
 * test builder , Student is a random class. don't care it.
 */
@Getter
public class Student {


    // 必选
    private String name;
    // 可选
    private int age;
    private String title;

    private static class Builder {
        // 必选
        private String name;
        // 可选
        private int age;
        private String title;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder title(String s) {
            this.title = s;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

    private Student(Builder builder) {
        name = builder.name;
        age = builder.age;
        title = builder.title;
    }


    public static void main(String[] args) {
        Student s = new Builder("huyan").age(11).title("888").build();
    }

}
