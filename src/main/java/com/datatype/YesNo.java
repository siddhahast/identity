package com.datatype;

import com.def.EnumLookerUpper;
import com.def.FactoryMethod;

public enum YesNo
{

    Y("Yes", 1, Boolean.TRUE),
    N("No", 0, Boolean.FALSE);

    private String code;
    private Integer id;
    private Boolean flag;

    private YesNo(String code, Integer id, Boolean flag)
    {
        this.code = code;
        this.id = id;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public Boolean booleanValue()
    {
        return flag;
    }

    private static final EnumLookerUpper<YesNo> HELPER = new EnumLookerUpper<>(YesNo.class);

    @FactoryMethod
    public static YesNo valueOfCode(String key){
        return HELPER.lookup(key);
    }
}

