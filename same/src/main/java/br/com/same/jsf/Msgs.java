package br.com.same.jsf;

import javax.inject.Named;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

@Named
@MessageBundle
public interface Msgs {

	@MessageTemplate("{cadastrado.sucesso}")
	String cadastradoComSucesso();
}