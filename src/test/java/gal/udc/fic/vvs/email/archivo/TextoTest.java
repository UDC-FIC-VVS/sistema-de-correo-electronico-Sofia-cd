package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Texto.
 * 
 * @author sofia
 *
 */

@RunWith(JUnitQuickcheck.class)
public class TextoTest {
	private final String mimeType = "text/plain";

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
	public void audioObtenerMimeTypeCorrectly(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(mimeType, texto.obtenerMimeType());
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
	public void audioObtenerNombreCorrectly(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(nombre, texto.obtenerNombre());
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
	public void audioObtenerContenidoCorrectly(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(contenido, texto.obtenerContenido());
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
	public void audioObtenerTamañoCorrectly(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(contenido.length(), texto.obtenerTamaño());
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
	public void audioObtenerPreVisualizacionCorrectly(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", texto.obtenerPreVisualizacion());
	}

}
