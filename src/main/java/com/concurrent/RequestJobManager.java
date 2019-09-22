package com.concurrent;

import com.datatype.UrlRequestCall;

public class RequestJobManager
{

    public Job[] createJobs(UrlRequestCall requestCall)
    {
        Job[] jobs = new Job[requestCall.getCount()];

        for(int i=0;i< requestCall.getCount();i++)
        {
            jobs[i] = new UrlRequestJob(requestCall);
        }
        return jobs;
    }

}
