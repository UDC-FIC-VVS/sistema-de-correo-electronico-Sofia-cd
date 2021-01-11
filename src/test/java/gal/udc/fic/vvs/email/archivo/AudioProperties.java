package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Audio.
 * 
 * @author sofia
 *
 */
@RunWith(JUnitQuickcheck.class)
public class AudioProperties {

	private final String mimeType = "audio/ogg";

	/**
	 * Comprobamos que el método devuelve el MimeTipe correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */

	@Property
	public void obtenerMimeTypeAudio(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(mimeType, audio.obtenerMimeType());
	}

	/**
	 * Comprobamos que el método devuelve el nombre correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerNombreAudio(String nombre, String contenido) {
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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerContenidoAudio(String nombre, String contenido) {
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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerTamañoAudio(String nombre, String contenido) {
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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerPreVisualizacionAudio(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());

	}

}
