package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Turma;
import br.com.same.services.TurmaService;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter {

	private TurmaService turmaService;

	public TurmaConverter() {
		turmaService = BeanProvider.getContextualReference(TurmaService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Turma turma = null;
		if (isNotBlank(value)) {
			turma = turmaService.buscarPorId(new Long(value));
		}
		return turma;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Turma turma = (Turma) value;
			return isNull(turma.getId()) ? null : turma.getId().toString();
		}
		return "";
	}

}
