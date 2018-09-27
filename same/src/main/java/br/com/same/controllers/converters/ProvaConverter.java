package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Prova;
import br.com.same.services.ProvaService;

@FacesConverter(forClass = Prova.class)
public class ProvaConverter implements Converter {

	private ProvaService provaService;

	public ProvaConverter() {
		provaService = BeanProvider.getContextualReference(ProvaService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Prova prova = null;
		if (isNotBlank(value)) {
			prova = provaService.buscarPorId(new Long(value));
		}
		return prova;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Prova prova = (Prova) value;
			return isNull(prova.getId()) ? null : prova.getId().toString();
		}
		return "";
	}

}
