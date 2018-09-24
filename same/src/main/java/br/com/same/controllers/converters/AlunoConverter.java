package br.com.same.controllers.converters;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import br.com.same.models.Aluno;
import br.com.same.services.AlunoService;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	private AlunoService alunoService;

	public AlunoConverter() {
		alunoService = BeanProvider.getContextualReference(AlunoService.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno aluno = null;
		if (isNotBlank(value)) {
			aluno = alunoService.buscarPorId(new Long(value));
		}
		return aluno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (nonNull(value)) {
			Aluno aluno = (Aluno) value;
			return isNull(aluno.getId()) ? null : aluno.getId().toString();
		}
		return "";
	}

}
