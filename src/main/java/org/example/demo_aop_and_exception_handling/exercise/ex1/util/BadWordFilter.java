package org.example.demo_aop_and_exception_handling.exercise.ex1.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BadWordFilter {
    private List<String> badWords = Arrays.asList("ngu", "xấu", "đần", "ngu ngốc");

    public void validate(String feedback) {
        for(String badWord : badWords){
            if(feedback.contains(badWord)){
                throw new RuntimeException("Feedback chứa ngôn từ không phù hợp !");
            }
        }
    }
}
