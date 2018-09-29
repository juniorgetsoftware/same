package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Gabarito;
import br.com.same.services.GabaritoService;

@FacesConverter(forClass = Gabarito.class)
public class GabaritoConverter implements Converter {

	private GabaritoService gabaritoService;

	public GabaritoConverter() {
		gabaritoService = BeanProvider.getContextualReference(GabaritoService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Gabarito gabarito = null;
		if (isNotBlank(value)) {
			gabarito = gabaritoService.buscarPorId(new Long(value));
		}
		return gabarito;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Gabarito gabarito = (Gabarito) value;
			return isNull(gabarito.getId()) ? null : gabarito.getId().toString();
		}
		return "";
	}

}
