package com.def;

import com.observer.Observer;
import com.util.ThreadLocalUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public enum ThreadLocalRequestMetric implements ThreadLocalKeyDef
{
    OBSERVERS_TRIGGERED(AtomicInteger.class);

    private String queryParameter;
    private String header;
    private String mdcKey;
    private Class<?> valueType;
    private Object defaultValue;

    public <T> T get()
    {
        return ThreadLocalUtil.get(this);
    }

    public <T> T put(T value)
    {
        return ThreadLocalUtil.put(this, value);
    }
    public <T> T putIfAbsent(T value)
    {
        return ThreadLocalUtil.putIfAbsent(this, value);
    }
    public <T> List<T> addToList(T value)
    {
        return ThreadLocalUtil.addToList(this, value);
    }
    public <T> Set<T> addToSet(T value)
    {
        return ThreadLocalUtil.addToSet(this, value);
    }
    public <S, T> Map<S, T> addToMap(S mapKey, T value)
    {
        return ThreadLocalUtil.addToMap(this, mapKey, value);
    }
    @Override
    public String getQueryParameter()
    {
        return queryParameter;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getMdcKey()
    {
        return mdcKey;
    }

    @Override
    public ThreadLocalKeyDef[] getKeys()
    {
        return values();
    }

    @Override
    public Class<?> getValueType()
    {
        return valueType;
    }

    @Override
    public Object getDefaultValue()
    {
        return defaultValue;
    }

    public static Long getRequestDuration()
    {
        Long startMillis = ThreadLocalKey.REQUEST_START_MILLIS.get();
        return startMillis == null ? null : System.currentTimeMillis() - startMillis;
    }

    private ThreadLocalRequestMetric()
    {
    }

    private <X> ThreadLocalRequestMetric(String queryParameter, String header, String mdcKey, Class<X> valueType, X defaultValue)
    {
        this.queryParameter = queryParameter;
        this.header = header;
        this.mdcKey = mdcKey;
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }
    private <X> ThreadLocalRequestMetric(Class<X> valueType)
    {
        this.valueType = valueType;
    }
    private <X> ThreadLocalRequestMetric(Class<X> valueType, X defaultValue)
    {
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }

    private <X> ThreadLocalRequestMetric(String queryParameter, String mdcKey, Class<?> valueType, Object defaultValue) {
        this.queryParameter = queryParameter;
        this.mdcKey = mdcKey;
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }
}
