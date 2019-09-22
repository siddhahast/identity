package com.controller;

import com.datatype.UrlRequestCall;
import com.facade.UrlRequestCallFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UrlRequestJobController
{
    @Autowired
    private UrlRequestCallFacade urlRequestCallFacade;

    @RequestMapping(value="/fireRequest", method= RequestMethod.POST)
    @ResponseBody
    public Long computeTime(@RequestBody List<UrlRequestCall> requestCallList)
    {
        Long timeElapsed = urlRequestCallFacade.computeTimeForRequests(requestCallList);
        return timeElapsed;
    }
}
