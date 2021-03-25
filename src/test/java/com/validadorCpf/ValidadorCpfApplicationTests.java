package com.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.validadorCpf.models.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("72434467016");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfValidoComDigito() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("724.344.670-16");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoMeio() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("724344 67016");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoComeco() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf(" 72434467016");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComDigito() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("724.344.670-17");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("72434467017");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("7243446");
		assertEquals(false, cliente.validarCpf());
	}

    @Test
	void fazendoTesteDeCpfComCaracteres() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("7243446,,7016");
		assertEquals(false, cliente.validarCpf());
	}

    @Test
	void fazendoTesteDeCpfComLetras() {
        Cliente cliente = new Cliente();
        cliente.setNome("Patricia");
        cliente.setCpf("724344AA016");
		assertEquals(false, cliente.validarCpf());
	}
}
