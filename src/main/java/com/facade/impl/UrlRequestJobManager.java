package com.facade.impl;

import com.concurrent.ParallelUrlRequestJobExecutor;
import com.concurrent.SequentialUrlRequestJob;
import com.concurrent.UrlRequestjobExecutor;
import com.datatype.UrlRequestCall;

public class UrlRequestJobManager
{

    public static UrlRequestjobExecutor fetchUrlRequestJobExecutor(UrlRequestCall requestCall)
    {
        if(requestCall.isParallel())
        {
            return new ParallelUrlRequestJobExecutor();
        }
        else
        {
            return new SequentialUrlRequestJob();
        }
    }

}
