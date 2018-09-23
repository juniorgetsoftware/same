package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Disciplina;
import br.com.same.services.DisciplinaService;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	private DisciplinaService disciplinaService;

	public DisciplinaConverter() {
		disciplinaService = BeanProvider.getContextualReference(DisciplinaService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Disciplina disciplina = null;
		if (isNotBlank(value)) {
			disciplina = disciplinaService.buscarPorId(new Long(value));
		}
		return disciplina;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Disciplina disciplina = (Disciplina) value;
			return isNull(disciplina.getId()) ? null : disciplina.getId().toString();
		}
		return "";
	}

}
