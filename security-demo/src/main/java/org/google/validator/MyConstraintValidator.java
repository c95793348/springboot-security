package org.google.validator;



import org.google.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wbcaoa on 2018/3/26.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        helloService.greeting("校验器 校验");
        System.out.println("校验不通过!");

        return false;
    }
}
