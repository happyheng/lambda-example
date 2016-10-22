package com.happyheng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by happyheng on 16/10/17.
 */
@Controller
public class LambdaController {

    private OnJudgeHandler onRequestHandler;

    @ResponseBody
    @RequestMapping(value = "/judgeAge")
    public String testRequest(String name, Integer age){

        boolean isAdults = onRequestHandler.onAdultJudge(name, age);
        if (isAdults) {
            return name+" is adults" +
                    "";
        } else {
            return name+" not adults";
        }
    }

    public void setOnRequestHandler(OnJudgeHandler onRequestHandler) {
        this.onRequestHandler = onRequestHandler;
    }

    public interface OnJudgeHandler {
        boolean onAdultJudge(String name, Integer age);
    }

}
