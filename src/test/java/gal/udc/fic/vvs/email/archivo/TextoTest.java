package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Texto.
 * 
 * @author sofia
 *
 */
public class TextoTest {

	private final String nombre = "Texto";
	private final String contenido = "12345";
	private final String mimeType = "text/plain";

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
		Texto audio = new Texto(nombre, contenido);
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
		Texto audio = new Texto(nombre, contenido);
		assertEquals(nombre, audio.obtenerNombre());
	}

	/**
	 * Comprobamos que el método devuelve el contenido correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja
	 * <p>
	 * negra positiva. Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerContenidoCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(contenido, audio.obtenerContenido());
	}

	/**
	 * Comprobamos que el método devuelve el tamaño correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja
	 * <p>
	 * negra positiva. Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerTamañoCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	/**
	 * Comprobamos que el método devuelve la previsualización correcta.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja
	 * <p>
	 * negra positiva. Mecanismo de selección de datos:
	 */
	@Test
	public void audioObtenerPreVisualizacionCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());
	}

}
