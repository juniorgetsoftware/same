package br.com.same.infra.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessagesHelper implements Serializable {

	private static final long serialVersionUID = -7694306678404358097L;

	@Inject
	private FacesContext context;

	public void addInfoMessage(String clientId, String message) {
		addMessage(clientId, FacesMessage.SEVERITY_INFO, message);
	}

	public void addErrorMessage(String clientId, String message) {
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, message);
	}

	public void addFlash(String clientId, String message) {
		context.getExternalContext().getFlash().setKeepMessages(true);
		addInfoMessage(clientId, message);
	}

	public void validationFailed(String clientId, String message) {
		addErrorMessage(clientId, message);
		context.validationFailed();
	}

	private void addMessage(String clientId, Severity severity, String msg) {
		FacesMessage facesMessage = new FacesMessage(severity, msg, msg);
		context.addMessage(clientId, facesMessage);
	}

}