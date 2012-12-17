package org.company.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.company.model.SignupRequest;
import org.company.service.SignupRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Register a Signup request.
 * 
 * @author hantsy
 */
@Named("registerAction")
@ConversationScoped
// @Stateful
public class RegisterAction implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -7123511030910501473L;

	private static final Logger log = LoggerFactory
			.getLogger(RegisterAction.class);

	@Inject
	private SignupRequestService requestService;

	@Inject
	Conversation convesation;

	private SignupRequest currentRequest;

	public String register() {
		log.info("Registering " + currentRequest.getName());
		requestService.register(currentRequest);

		if (!convesation.isTransient()) {
			convesation.end();
		}

		return "/ok?faces-redirect=true";

	}

	@PostConstruct
	public void initNewRequest() {
		if (convesation.isTransient()) {
			convesation.begin();
		}

		currentRequest = new SignupRequest();
	}

	public SignupRequest getCurrentRequest() {
		return currentRequest;
	}

	public void setCurrentRequest(SignupRequest currentRequest) {
		this.currentRequest = currentRequest;
	}
}
