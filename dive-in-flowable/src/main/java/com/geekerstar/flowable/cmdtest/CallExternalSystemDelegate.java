package com.geekerstar.flowable.cmdtest;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author geekerstar
 * date: 2019/10/22 20:24
 * description:
 */
public class CallExternalSystemDelegate implements JavaDelegate {
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("执行外部逻辑 -> "
                + delegateExecution.getVariable("employee"));
    }
}
