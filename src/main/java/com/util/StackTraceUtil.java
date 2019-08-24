package com.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StackTraceUtil
{
    public static Map<Object, Object> THREAD_LOCAL_KEY = ThreadLocalUtil.THREAD_LOCAL.get();

    public static void addToThreadLocal(StackTraceElement[] parentStackTrace)
    {
        if(parentStackTrace!=null || parentStackTrace.length==0) {
            ThreadLocalUtil.THREAD_LOCAL.set(Arrays.stream(parentStackTrace).collect(Collectors.toMap(s -> "__stack__" + s.getClassName(), s -> s)));
        }
    }

    public static StackTraceElement[] buildStackTrace()
    {
        List<StackTraceElement> stackTraceElements = ThreadLocalUtil.getAll().entrySet()
                .stream().map(s->prepareFunction.apply(s)).collect(Collectors.toList());
        return stackTraceElements.toArray(new StackTraceElement[stackTraceElements.size()]);
    }

    private static Function<Map.Entry<Object, Object>, StackTraceElement> prepareFunction = new Function< Map.Entry<Object, Object>, StackTraceElement>() {

        @Override
        public StackTraceElement apply(Map.Entry<Object, Object> entry)
        {
            if(entry.toString().startsWith("__stack__"))
            {
                return (StackTraceElement) entry.getValue();
            }
            return null;
        }
    };
}
