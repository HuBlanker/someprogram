package daily;

import com.github.jfasttext.JFastText;

/**
 * Created by pfliu on 2019/11/17.
 */
public class FastTextDemo {

    public static void main(String [] args){
        JFastText jt = new JFastText();
        jt.loadModel("/tmp/ft_model_5.bin");

        String ret = jt.predict("呼 延 十");
        System.out.println(ret);

    }
}
