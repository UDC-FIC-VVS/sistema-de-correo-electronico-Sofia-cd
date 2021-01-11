package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Reenvio.
 * Todos los métodos que no pertenezcan a la clase Reenvio serán probados en su
 * correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class ReenvioTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto texto = new Texto(nombre, contenido);
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	private final String busquedaNotMatch = "-1";

	/**
	 * Comprobamos que el método obtener tamaño devuelve suma del tamaño del mesage
	 * reenviado y el nuevo mensage.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void ObtenerTamañoCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);
		Mensaje msgReenvio = new Mensaje(texto);
		Reenvio reenvio = new Reenvio(msg, msgReenvio);

		int expected = msg.obtenerTamaño() + msgReenvio.obtenerTamaño();

		assertEquals(expected, reenvio.obtenerTamaño());

	}

	/**
	 * Comprobamos que el método obtener visualizacion devuelve el mensage actual y
	 * el reenviado.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void ObtenerVisualizacionCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);
		Mensaje msgReenvio = new Mensaje(texto);
		Reenvio reenvio = new Reenvio(msg, msgReenvio);

		String expected = msg.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ msgReenvio.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";

		assertEquals(expected, reenvio.obtenerVisualizacion());

	}

}
