package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBruta() {
	   
	}


	@Test
	void testCalculoNominaNeta() {
		
	}
	
	@Test
	void testCalculoNominaBrutaEncargado() {
	    Empleado empleado = new Empleado();
	    float ventasMes = 800; // Ventas del mes para el encargado
	    float horasExtra = 5; // Horas extras
	    float resultadoEsperado = 2650; // Corregido el valor esperado

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMes, horasExtra);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}

	
	@Test
	void testCalculoNominaBrutaVendedor() {
		 Empleado empleado = new Empleado();
		 float ventasMes = 999; // Ventas del mes para el vendedor
		 float horasExtra = 0; // Horas extras
		 float resultadoEsperado = 2000; 

		 float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, ventasMes, horasExtra);
		 assertEquals(resultadoEsperado, nominaBruta, 0.01); 
	}
	
	void testCalculoNominaBrutaVentaMesMayor2500() {
		Empleado empleado = new Empleado();
		float ventasMesMayor2500 = 2600; // Ventas del mes mayores a 2500 euros
		float horasExtra = 5;
		float resultadoEsperado = 2500 + 200 + (5 * 30);

		float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMesMayor2500, horasExtra);
		assertEquals(resultadoEsperado, nominaBruta, 0.01);

		}
	
	@Test
	void testCalculoNominaBrutaVentaMesNegativa() {
		Empleado empleado = new Empleado();
	    float ventasMesNegativas = -500; // Ventas del mes en formato negativo
	    float horasExtra = 5; // Horas extras para el ejemplo
	    float resultadoEsperado = 2650; 

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMesNegativas, horasExtra);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}
	
	@Test
	void testCalculoNominaBrutaVentaMesMenorMil() {
		Empleado empleado = new Empleado();
	    float ventasMesMenorMil = 800; // Ventas del mes menor a 1000 euros
	    float horasExtra = 5; // Horas extras para el ejemplo
	    float resultadoEsperado = 2650; 

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMesMenorMil, horasExtra);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}
	
	@Test
	void testCalculoNominaBrutaVentaMesEntre1000y1500() {
		Empleado empleado = new Empleado();
	    float ventasMesEntre1000y1500 = 1200; // Ventas del mes en el rango de 1000 a 1500 euros
	    float horasExtra = 5; 
	    float resultadoEsperado = 2500 + 100 + (5 * 30); 

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMesEntre1000y1500, horasExtra);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}
	
	
	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		Empleado empleado = new Empleado();
	    float ventasMes = 1500; // Ventas del mes para el ejemplo
	    float horasExtrasPositivas = 5; // Horas extras positivas
	    float resultadoEsperado = 2500 + 200 + (5 * 30); 

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMes, horasExtrasPositivas);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		Empleado empleado = new Empleado();
	    float ventasMes = 1500; // Ventas del mes para el ejemplo
	    float horasExtraNegativas = -5; // Horas extras negativas
	    float resultadoEsperado = 2500+200; 

	    float nominaBruta = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventasMes, horasExtraNegativas);
	    assertEquals(resultadoEsperado, nominaBruta, 0.01);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		Empleado empleado = new Empleado();
	    float nominaBruta = -100; // Ejemplo de nómina bruta negativa
	    float resultadoEsperado = 0; // La nómina neta no puede ser negativa

	    float nominaNeta = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(resultadoEsperado, nominaNeta, 0.01);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		Empleado empleado = new Empleado();
	    float nominaBruta = 2000; // Ejemplo de nómina bruta menor de 2100 euros
	    float resultadoEsperado = nominaBruta; // No retención

	    float nominaNeta = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(resultadoEsperado, nominaNeta, 0.01);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		Empleado empleado = new Empleado();
	    float nominaBruta = 2200; // Ejemplo de nómina bruta en el rango de 2100 a 2500 euros
	    float resultadoEsperado = (float) (nominaBruta * (1 - 0.15)); // Retención del 15%

	    float nominaNeta = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(resultadoEsperado, nominaNeta, 0.01);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		Empleado empleado = new Empleado();
	    float nominaBruta = 2600; // Ejemplo de nómina bruta mayor o igual a 2500 euros
	    float resultadoEsperado = (float) (nominaBruta * (1 - 0.18)); // Retención del 18%

	    float nominaNeta = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(resultadoEsperado, nominaNeta, 0.01);
	}


}
