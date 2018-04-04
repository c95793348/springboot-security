package org.google.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by wbcaoa on 2018/4/3.
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);

}
