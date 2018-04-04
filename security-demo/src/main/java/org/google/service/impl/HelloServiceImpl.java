package org.google.service.impl;

import org.google.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by wbcaoa on 2018/3/26.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void greeting(String o) {
        System.out.println("hello " + o);
    }

}
