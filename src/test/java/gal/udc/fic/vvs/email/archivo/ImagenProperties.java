package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Imagen.
 * 
 * @author sofia
 *
 */
@RunWith(JUnitQuickcheck.class)
public class ImagenProperties {

	private final String nombre = "Imagen";
	private final String contenido = "12345";
	private final String mimeType = "image/png";

	/**
	 * Comprobamos que el método devuelve el MimeTipe correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria
	 */
	@Property
	public void obtenerMimeTypeImgen(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(mimeType, imagen.obtenerMimeType());
	}

	/**
	 * Comprobamos que el método devuelve el nombre correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria
	 */
	@Property
	public void audioObtenerNombreCorrectly(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(nombre, imagen.obtenerNombre());
	}

	/**
	 * Comprobamos que el método devuelve el contenido correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria
	 */
	@Property
	public void audioObtenerContenidoCorrectly(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(contenido, imagen.obtenerContenido());
	}

	/**
	 * Comprobamos que el método devuelve el tamaño correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria
	 */
	@Property
	public void audioObtenerTamañoCorrectly(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(contenido.length(), imagen.obtenerTamaño());
	}

	/**
	 * Comprobamos que el método devuelve la previsualización correcta.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria
	 */
	@Property
	public void audioObtenerPreVisualizacionCorrectly(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", imagen.obtenerPreVisualizacion());
	}
}
