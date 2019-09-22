package com.facade.impl;

import com.concurrent.UrlRequestjobExecutor;
import com.datatype.UrlRequestCall;
import com.facade.UrlRequestCallFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlRequestCallFacadeImpl implements UrlRequestCallFacade
{
    public Long computeTimeForRequests(List<UrlRequestCall> urlRequestCallList)
    {

        Long timeElapsed = 0L;
        Long startTime = System.currentTimeMillis();
        for (UrlRequestCall call : urlRequestCallList)
        {
            try {
                UrlRequestjobExecutor urlRequestjobExecutor = UrlRequestJobManager.fetchUrlRequestJobExecutor(call);
                urlRequestjobExecutor.execute(call);
                timeElapsed += urlRequestjobExecutor.getEndTime() - startTime;
            }catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        }
        return timeElapsed;
    }

}
