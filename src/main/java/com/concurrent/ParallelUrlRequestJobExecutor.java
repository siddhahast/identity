package com.concurrent;

import com.datatype.UrlRequestCall;

public class ParallelUrlRequestJobExecutor extends UrlRequestjobExecutor {

    private JobManager jobManager;
    private Job[] submitJobs;

    @Override
    public void executeWithStrategy() throws JobException
    {
        jobManager = new JobManager();
        jobManager.submitForeground(submitJobs);
        endTime = jobManager.getEndTime();
    }

    @Override
    public void fetchJobsToSubmit(UrlRequestCall urlRequestCall) {
        RequestJobManager manager = new RequestJobManager();
        submitJobs = manager.createJobs(urlRequestCall);
    }
}
