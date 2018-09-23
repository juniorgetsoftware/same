package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Professor;
import br.com.same.services.ProfessorService;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

	private ProfessorService professorService;

	public ProfessorConverter() {
		professorService = BeanProvider.getContextualReference(ProfessorService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Professor professor = null;
		if (isNotBlank(value)) {
			professor = professorService.buscarPorId(new Long(value));
		}
		return professor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Professor professor = (Professor) value;
			return isNull(professor.getId()) ? null : professor.getId().toString();
		}
		return "";
	}

}
