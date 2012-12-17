package org.company.service;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.company.model.SignupRequest;
import org.company.service.events.Registered;
import org.slf4j.Logger;
/**
 * The dummy implementation of the {@link Notifier}.
 * 
 * @author hantsy
 */
@Named
public class LogNotifier implements Notifier {

    @Inject
    private Logger log;

    @Override
    public void notify(@Observes @Registered SignupRequest signupRequest) {
        log.info( "receiving @"+ signupRequest);
    }
}
