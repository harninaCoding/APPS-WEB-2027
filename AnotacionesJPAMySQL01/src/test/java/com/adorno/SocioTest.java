package com.adorno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Socio;
import com.adorno.repository.SocioRespository;

@SpringBootTest
class SocioTest {

	@Autowired
	SocioRespository socioRespository;
	@Test
	void test() {
		socioRespository.save(new Socio("Luis", "Chopsuey", 12.34f));
	}

}
