package com.def;

import com.datatype.YesNo;
import com.http.HttpOperationType;
import com.util.ThreadLocalUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public enum ThreadLocalKey implements ThreadLocalKeyDef{

    REQUEST_START_MILLIS(Long.class),
    OBSERVABLE_EVENT(List.class),
    BYPASS_READ_REPLICA(null, null, Boolean.class, Boolean.FALSE), //
    PAGE_START("pageStart", null, Integer.class, null), //
    PAGE_SIZE("pageSize", null, Integer.class, null), //
    TOTAL_RESULTS(Long.class), //
    FIELDS("fields", null, String[].class, null), //
    INTERNAL_REQUEST(Boolean.class, Boolean.FALSE), //
    TRACE_GUID("traceGuid", "traceGuid", String.class, null),
    SERVICE_EXCEPTION(Throwable.class), //
    HTTP_REQUEST_OPERATION_TYPE(null, "httpOperationType" , HttpOperationType.class, null),
    REFRESH_CACHE("refreshCache", null,YesNo .class, YesNo.N), //
    BYPASS_CACHE("bypassCache", "bypasscache", null, YesNo.class, YesNo.N), //
    CACHE_KEYS("cacheKeys", null, String[].class, null), //
    ;


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

    private ThreadLocalKey()
    {
    }

    private <X> ThreadLocalKey(String queryParameter, String header, String mdcKey, Class<X> valueType, X defaultValue)
    {
        this.queryParameter = queryParameter;
        this.header = header;
        this.mdcKey = mdcKey;
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }
    private <X> ThreadLocalKey(Class<X> valueType)
    {
        this.valueType = valueType;
    }
    private <X> ThreadLocalKey(Class<X> valueType, X defaultValue)
    {
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }

    private <X> ThreadLocalKey(String queryParameter, String mdcKey, Class<?> valueType, Object defaultValue) {
        this.queryParameter = queryParameter;
        this.mdcKey = mdcKey;
        this.valueType = valueType;
        this.defaultValue = defaultValue;
    }
}
