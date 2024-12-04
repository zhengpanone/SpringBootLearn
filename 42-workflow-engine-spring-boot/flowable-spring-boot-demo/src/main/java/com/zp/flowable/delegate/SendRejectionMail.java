package com.zp.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendRejectionMail implements JavaDelegate {
    /**
     * 这个是Flowable中的触发器
     * @param execution
     */
    @Override
    public void execute(DelegateExecution execution) {
        // 触发器的执行逻辑
        System.out.println("不好意思，你的请假申请被拒绝了。。。安心工作");
    }
}
