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

	public void addInfoMessage(String clientId, String message, String desc) {
		addMessage(clientId, FacesMessage.SEVERITY_INFO, message, desc);
	}

	public void addErrorMessage(String clientId, String message, String desc) {
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, message, desc);
	}

	public void addFlash(String clientId, String message, String desc) {
		context.getExternalContext().getFlash().setKeepMessages(true);
		addInfoMessage(clientId, message, desc);
	}

	public void validationFailed(String clientId, String message, String desc) {
		addErrorMessage(clientId, message, desc);
		context.validationFailed();
	}

	private void addMessage(String clientId, Severity severity, String msg, String desc) {
		FacesMessage facesMessage = new FacesMessage(severity, msg, desc);
		context.addMessage(clientId, facesMessage);
	}

}