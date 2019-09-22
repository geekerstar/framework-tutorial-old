package com.geekerstar.easyexcel.util;

/**
 * @author geekerstar
 * date: 2019/9/22 13:37
 * description: 捕获相关异常
 */
public class ExcelException extends RuntimeException {
    public ExcelException(String message) {
        super(message);
    }
}
