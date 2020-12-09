package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Adjunto.
 * Todos los métodos que no pertenezcan a la clase Adjunto serán probados en su
 * correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class AdjuntoTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombre, contenido);
	private final Mensaje msg = new Mensaje(archivo);

	/**
	 * Comprobamos que el método devuelve el tamaño correcto. Este debe ser el
	 * resultado de la suma del tamaño del mensaje y el tamaño del adjunto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerTamañoCorrectly() {
		Adjunto adj = new Adjunto(msg, archivo);
		int t = msg.obtenerTamaño() + archivo.obtenerTamaño();

		assertEquals(t, adj.obtenerTamaño());

	}

	/**
	 * Comprobamos que el método devuelve la visualización correcta.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerVisualizacionCorrectly() {
		Adjunto adj = new Adjunto(msg, archivo);
		String visualizacion = msg.obtenerVisualizacion() + "\n\nAdxunto: " + archivo.obtenerPreVisualizacion();

		assertEquals(visualizacion, adj.obtenerVisualizacion());

	}

}
