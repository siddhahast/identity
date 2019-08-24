package com.observer;

import com.datatype.User;
import com.datatype.UserEvent;
import com.def.ThreadLocalKey;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class UserObserver implements Observer<User, UserEvent>
{
    private static final Logger LOG = Logger.getLogger(UserObserver.class);

    @Override
    public Class<User> getObservableClass() {
        return User.class;
    }

    public Predicate<UserEvent> getParameterPredicate()
    {
        return p->p.equals(UserEvent.TEST_EVENT);
    }

    public Mode getMode(){
        return Mode.BACKGROUND;
    }

    @Override
    public void update(User observable, UserEvent parameter)
    {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("The email id of the user is - " + observable.getEmail());
    }
}
