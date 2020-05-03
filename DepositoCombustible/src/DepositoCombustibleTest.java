import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


class DepositoCombustibleTest {
	
	@Test
	void testdepositonivel() {
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,0.0);
		Double getDepositoNivel = miDeposito.getDepositoNivel();
		assertEquals(0.0, getDepositoNivel);
	}

	@Test
	void testdepositomaxnivel() {
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,0.0);
		Double getDepositoMax = miDeposito.getDepositoMax();
		assertEquals(40.0, getDepositoMax);
	}

	@Test
	void testdepositovacio() {
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,0.0);
		boolean vacio = miDeposito.estaVacio();
		assertTrue(vacio);
	}
	
	@Test
	void testmitaddepositolleno() {
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,0.0);
		miDeposito.fill(20);
		boolean lleno = miDeposito.estaLleno();
		assertFalse(lleno);
		
	}
	
	// Para los siguientes tests hay que tener en cuenta que el depósito está a 0 litros
	// por eso, declaramos valores nuevos de cantidad del depósito únicamente para testear
	@Test
	void testcantidadgrande() {
		double cantidaddeposito = 30;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.consumir(29);
		assertEquals(1, miDeposito.getDepositoNivel());
		
	}
	
	@Test
	void testcantidadpequeña() {
		double cantidaddeposito = 30;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.consumir(1);
		assertEquals(29, miDeposito.getDepositoNivel());
		
	}
	
	@Test
	void testcantidadnegativa() {
		double cantidaddeposito = 30;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.consumir(40);
		assertEquals(-10, miDeposito.getDepositoNivel());
		
	}
	
	@Test
	void testcantidadgrandefill() {
		double cantidaddeposito = 10;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.fill(30);
		assertEquals(40, miDeposito.getDepositoNivel());
		
	}
	
	@Test
	void testcantidadpequeñafill() {
		double cantidaddeposito = 30;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.fill(2);
		assertEquals(32, miDeposito.getDepositoNivel());
		
	}
	
	@Test
	void testcantidadnegativafill() {
		double cantidaddeposito = 40;
		DepositoCombustible miDeposito=new DepositoCombustible(40.0,cantidaddeposito);
		miDeposito.fill(20);
		assertEquals(60, miDeposito.getDepositoNivel());
		
	}
	
	
	
}
