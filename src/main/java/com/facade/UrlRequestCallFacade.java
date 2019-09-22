package com.facade;

import com.concurrent.UrlRequestjobExecutor;
import com.datatype.UrlRequestCall;
import com.facade.impl.UrlRequestJobManager;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UrlRequestCallFacade
{
    public Long computeTimeForRequests(List<UrlRequestCall> urlRequestCallList);
}
