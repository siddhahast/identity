package com.concurrent;

import com.datatype.UrlRequestCall;

public abstract class UrlRequestjobExecutor
{

    protected Long endTime;

    public abstract void executeWithStrategy() throws JobException;

    public abstract void fetchJobsToSubmit(UrlRequestCall urlRequestCall);

    public void execute(UrlRequestCall urlRequestCall) throws JobException
    {
        fetchJobsToSubmit(urlRequestCall);
        executeWithStrategy();
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
