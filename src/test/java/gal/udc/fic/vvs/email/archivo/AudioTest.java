package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Audio.
 * 
 * @author sofia
 *
 */
public class AudioTest {

	private final String nombre = "Audio";
	private final String contenido = "12345";
	private final String mimeType = "audio/ogg";

	/**
	 * Comprobamos que el método devuelve el MimeTipe correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja
	 * <p>
	 * negra positiva. Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerMimeTypeCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(mimeType, audio.obtenerMimeType());
	}

	/**
	 * Comprobamos que el método devuelve el nombre correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja
	 * <p>
	 * negra positiva. Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerNombreCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(nombre, audio.obtenerNombre());
	}

	/**
	 * Comprobamos que el método devuelve el contenido correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerContenidoCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(contenido, audio.obtenerContenido());
	}

	/**
	 * Comprobamos que el método devuelve el tamaño correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerTamañoCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	/**
	 * Comprobamos que el método devuelve la previsualización correcta.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerPreVisualizacionCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());
	}
}
