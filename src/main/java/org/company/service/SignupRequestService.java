package org.company.service;

import java.util.List;

import org.company.model.SignupRequest;

public interface SignupRequestService {
	public abstract List<SignupRequest> getAllUnconfirmedRequests();

	public abstract List<SignupRequest> getAllConfirmedRequests();

	public abstract List<SignupRequest> getAllApprovedRequests();

	public abstract List<SignupRequest> getAllDeniedRequests();

	public abstract void register(SignupRequest m);

	public abstract SignupRequest get(String id);

	public abstract void approve(String id);

	public abstract void deny(String id);

	public abstract void confirm(String id);

}