package com.mvc;

import com.datatype.YesNo;
import com.def.ThreadLocalKey;
import com.util.ThreadLocalUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadLocalInterceptor implements HandlerInterceptor
{


    private static final Logger LOG = Logger.getLogger(ThreadLocalInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        LOG.info("This is the test version");
        ThreadLocalUtil.put(ThreadLocalKey.BYPASS_CACHE, YesNo.Y);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception
    {
        LOG.info("This is the test version");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        LOG.info("After the request is processed by the controller");
    }


}
