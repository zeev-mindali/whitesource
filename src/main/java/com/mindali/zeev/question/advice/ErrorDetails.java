package com.mindali.zeev.question.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    //key and value for sending error in rest JSON format
    private String key;
    private String value;
}
