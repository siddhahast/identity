package com.mvc;

import com.observer.ObservableEventQueue;
import com.observer.ObserverManager;
import com.observer.ObserverPhase;
import org.springframework.beans.factory.annotation.Autowired;

public class ObserverParser implements Parser {

    @Autowired
    private ObserverManager observerManager;

    @Override
    public void parse()
    {
        ObservableEventQueue.consume(observerManager, ObserverPhase.POST_REQUEST);
    }
}
