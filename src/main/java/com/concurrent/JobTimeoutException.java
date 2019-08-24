package com.concurrent;

import java.util.List;


public class JobTimeoutException extends JobException {

    public JobTimeoutException(List<Job<?>> allJobs, Long timeout, Throwable rootCause) {
        super(allJobs, rootCause);
    }
}
