package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Habilidade;
import br.com.same.services.HabilidadeService;

@FacesConverter(forClass = Habilidade.class)
public class HabilidadeConverter implements Converter {

	private HabilidadeService habilidadeService;

	public HabilidadeConverter() {
		habilidadeService = BeanProvider.getContextualReference(HabilidadeService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Habilidade habilidade = null;
		if (isNotBlank(value)) {
			habilidade = habilidadeService.buscarPorId(new Long(value));
		}
		return habilidade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Habilidade habilidade = (Habilidade) value;
			return isNull(habilidade.getId()) ? null : habilidade.getId().toString();
		}
		return "";
	}

}
