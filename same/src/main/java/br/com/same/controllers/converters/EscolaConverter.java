package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

@FacesConverter(forClass = Escola.class)
public class EscolaConverter implements Converter {

	private EscolaService escolaService;
	
	public EscolaConverter() {
		escolaService = BeanProvider.getContextualReference(EscolaService.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Escola escola = null;
		if(isNotBlank(value)) {
			escola = escolaService.buscarPorId(new Long(value));
		}
		return escola;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(nonNull(value)) {
			Escola escola = (Escola) value;
			return isNull(escola.getId()) ? null : escola.getId().toString();
		}
		return "";
	}

}
