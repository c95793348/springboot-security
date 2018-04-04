package org.google.code;

import org.google.security.core.validate.code.ImageCode;
import org.google.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by wbcaoa on 2018/4/3.
 */
@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {


    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("覆盖原有生成二维码逻辑!");
        return null;
    }
}
