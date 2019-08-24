package com.concurrent;

import java.util.List;


public interface JobFacade
{
    public List<JobDetails> filter(JobFilter filter);

    public BatchProcess readBatchProcess(String id);
    public BatchProcess batchCreate(List<Job<?>> jobs);

    public void update(Job<?> job);
}
