package com.concurrent;

import com.datatype.UrlRequestCall;

public class SequentialUrlRequestJob extends UrlRequestjobExecutor {

    private Job[] submitJobs;

    @Override
    public void executeWithStrategy() throws JobException {
        for(Job job : submitJobs)
        {
            try
            {
                job.execute();
                endTime = System.currentTimeMillis();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void fetchJobsToSubmit(UrlRequestCall urlRequestCall) {
        RequestJobManager manager = new RequestJobManager();
        submitJobs = manager.createJobs(urlRequestCall);
    }
}
