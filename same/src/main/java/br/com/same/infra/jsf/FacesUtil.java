package br.com.same.infra.jsf;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

//import org.primefaces.PrimeFaces;

public class FacesUtil implements Serializable {

	private static final long serialVersionUID = -4864113349154248550L;

	@Inject
	private FacesContext context;

	@Inject
	private ExternalContext external;

	@Inject
	private HttpServletRequest request;

	public boolean isPostBack() {
		return context.isPostback();
	}

	public boolean isNotPostBack() {
		return !isPostBack();
	}

	public void redirect(String page) {
		try {
			String contextPath = external.getRequestContextPath();

			external.redirect(contextPath + page);
			context.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

	public String getParamName(String paramName) {
		return request.getParameter(paramName);
	}

	public String buscaArquivo(String path) {
		return external.getRealPath(path);
	}

	public String getUrl() {
		return context.getViewRoot().getViewId();
	}
	
	public String getParameterValue(String parametro) {
		return external.getRequestParameterMap().get(parametro);
	}
	
	public String[] getParameterValues(String paramName) {
		return external.getRequestParameterValuesMap().get(paramName);
	}

	public boolean hasParameters() {
		return external.getRequestParameterMap().size() > 0;
	}

	public void updateComponent(String idComponent) {
		//PrimeFaces.current().ajax().update(idComponent);
	}

	public void updateComponents(String... idsComponent) {
		for (String id : idsComponent) {
			updateComponent(id);
		}
	}
	
	public void executeJS(String javascript) {
		//PrimeFaces.current().executeScript(javascript);
	}
	
	public FacesContext getContext() {
		return context;
	}
	
	public void openDialog(String dialog) {
		executeJS("PF('" + dialog + "').show();");
		updateComponents(dialog);
	}
	
	public void closeDialog(String dialog) {
		executeJS("PF('" + dialog + "').hide();");
	}
}