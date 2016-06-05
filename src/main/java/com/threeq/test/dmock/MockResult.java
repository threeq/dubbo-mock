package com.threeq.test.dmock;

import com.alibaba.dubbo.rpc.Result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 16/5/26
 * @User three
 */
public class MockResult implements Result, Serializable {

    private static final long        serialVersionUID = -6925924956850004727L;

    private Object                   result;

    private Throwable                exception;

    private Map<String, String> attachments = new HashMap<String, String>();

    public MockResult(){
    }

    public MockResult(Object result){
        this.result = result;
    }

    public MockResult(Throwable exception){
        this.exception = exception;
    }

    public Object recreate() throws Throwable {
        if (exception != null) {
            throw exception;
        }
        return result;
    }

    /**
     * @deprecated Replace to getValue()
     * @see com.alibaba.dubbo.rpc.RpcResult#getValue()
     */
    @Deprecated
    public Object getResult() {
        return getValue();
    }

    /**
     * @deprecated Replace to setValue()
     */
    @Deprecated
    public void setResult(Object result) {
        setValue(result);
    }

    public Object getValue() {
        return result;
    }

    public void setValue(Object value) {
        this.result = value;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable e) {
        this.exception = e;
    }

    public boolean hasException() {
        return exception != null;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public String getAttachment(String key) {
        return attachments.get(key);
    }

    public String getAttachment(String key, String defaultValue) {
        String result = attachments.get(key);
        if (result == null || result.length() == 0) {
            result = defaultValue;
        }
        return result;
    }

    public void setAttachments(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            attachments.putAll(map);
        }
    }

    public void setAttachment(String key, String value) {
        attachments.put(key, value);
    }

    @Override
    public String toString() {
        return "RpcResult [result=" + result + ", exception=" + exception + "]";
    }
}
