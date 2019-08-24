package com.concurrent;

import java.util.List;

public class JobCancellationException extends JobException {

    public JobCancellationException(List<Job<?>> allJobs, Throwable rootCause) {
        super(allJobs, rootCause);
    }
}