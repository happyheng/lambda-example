package com.happyheng.lambda;

import com.happyheng.LambdaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * Created by happyheng on 16/10/17.
 */
@Component
public class RequestHandler {

    @Autowired
    private LambdaController lambdaController;

    @PostConstruct
    public void init() {
        lambdaController.setOnRequestHandler((name, age)->{
            System.out.println("RequestHandler接收到了请求,其中请求的参数为---"+ name +"---"+age);
            if (age >= 18) {
                return true;
            } else {
                return false;
            }
        });

    }
}
