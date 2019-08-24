package com.concurrent;

import java.util.List;

public class JobInterruptedException extends JobException {
    public JobInterruptedException(List<Job<?>> allJobs, Throwable rootCause) {
        super(allJobs, rootCause);
    }
}
