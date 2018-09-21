package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.PeriodoLetivo;
import br.com.same.services.PeriodoLetivoService;

@FacesConverter(forClass = PeriodoLetivo.class)
public class PeriodoLetivoConverter implements Converter {

	private PeriodoLetivoService periodoLetivoService;
	
	public PeriodoLetivoConverter() {
		periodoLetivoService = BeanProvider.getContextualReference(PeriodoLetivoService.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PeriodoLetivo periodoLetivo = null;
		if(isNotBlank(value)) {
			periodoLetivo = periodoLetivoService.buscarPorId(new Long(value));
		}
		return periodoLetivo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(nonNull(value)) {
			PeriodoLetivo periodoLetivo = (PeriodoLetivo) value;
			return isNull(periodoLetivo.getId()) ? null : periodoLetivo.getId().toString();
		}
		return "";
	}

}
