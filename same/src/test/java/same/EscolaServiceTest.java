package same;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.models.Escola;
import br.com.same.models.tdb.EscolaTDB;
import br.com.service.EscolaService;

@RunWith(MockitoJUnitRunner.class)
public class EscolaServiceTest {

	@Mock
	private EscolaService escolaService;

	private Escola escola;

	@Before
	public void setUp() {
		escola = EscolaTDB.umaEscola().agora();
	}

	@Test
	public void deveChamarMetodoSalvar() {
		escolaService.salvar(escola);
		verify(escolaService, only()).salvar(escola);
		verify(escolaService, atLeastOnce()).salvar(escola);
	}

}
