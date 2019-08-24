package com.def;

public interface ThreadLocalKeyDef
{
    public ThreadLocalKeyDef[] getKeys();
    public String getQueryParameter();
    public String getHeader();
    public String getMdcKey();
    public Object getDefaultValue();

    public Class<?> getValueType();
}
