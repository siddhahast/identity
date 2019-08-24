package com.util;

import org.apache.logging.log4j.message.Message;

public class JsonLog4j2Message implements Message, LoggingConstants {

    public JsonLog4j2Message(String message)
    {

    }


    @Override
    public String getFormattedMessage()
    {
        return null;
    }

    @Override
    public String getFormat()
    {
        return null;
    }

    @Override
    public Object[] getParameters()
    {
        return new Object[0];
    }

    @Override
    public Throwable getThrowable()
    {
        return null;
    }
}
