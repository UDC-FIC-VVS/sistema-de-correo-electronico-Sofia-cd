package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Mensaje.
 * Todos los métodos que no pertenezcan a la clase Mensaje serán probados en su
 * correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class MensajeTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto texto = new Texto(nombre, contenido);
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	private final String busquedaNotMatch = "-1";

	/**
	 * Comprobamos que el método obtener no leidos devuelve 1 cuando el mensaje no
	 * ha sido leído.
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
	public void ObtenerNoLeidosCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		assertEquals(1, msg.obtenerNoLeidos());

	}

	/**
	 * Comprobamos que al establecer un mensaje como leído el método obtener leídos
	 * decuelve 0.
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
	public void establecerLeidoAndObtenerNoLeidosCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		msg.establecerLeido(true);

		assertEquals(0, msg.obtenerNoLeidos());

	}

	/**
	 * Comprobamos que el método obtener tamaño devuelve el tamaño del texto
	 * contenido en el mensaje.
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

		int tamañoExpected = texto.obtenerTamaño();

		assertEquals(tamañoExpected, msg.obtenerTamaño());

	}

	/**
	 * Comprobamos que el método obtener icono devuelve el icono correspondiente a
	 * mensaje no leído cuando este todavía no se ha marcado como leído.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 */
	@Test
	public void ObtenerIconoNOLeidoCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, msg.obtenerIcono());

	}

	/**
	 * Comprobamos que el método obtener icono devuelve el icono correspondiente a
	 * mensaje leído cuando este se ha marcado como leído.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 */
	@Test
	public void ObtenerIconoLeidoCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		msg.establecerLeido(true);

		assertEquals(Correo.ICONO_MENSAJE, msg.obtenerIcono());

	}

	/**
	 * Comprobamos que el método obtener previsualización devuelve el trozo de texto
	 * del mensaje que se puede mostrar según el tamaño de previsualización más unos
	 * puntos supensivos.
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
	public void ObtenerPreVisualizacionCorrectly() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		String visualizacion = texto.obtenerContenido();

		String result = visualizacion.substring(0, Math.min(visualizacion.length(), TAMAÑO_PREVISUALIZACION)) + "...";

		assertEquals(result, msg.obtenerPreVisualizacion());

	}

	/**
	 * Comprobamos que el método obtener visualización devuelve el texto contenido
	 * en el mensaje.
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

		String visualizacion = texto.obtenerContenido();

		assertEquals(visualizacion, msg.obtenerVisualizacion());

	}

	/**
	 * Comprobamos que el método buscar no devuelve nada cuando el criterio de
	 * búsqueda no coincide con el texto del mensaje.
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
	public void buscarNotFound() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		Collection result = msg.buscar(busquedaNotMatch);

		assertTrue(result.isEmpty());

	}

	/**
	 * Comprobamos que el método buscar devuelve el mensaje cuando el criterio de
	 * búsqueda coincide parcialmente con el texto del mensaje.
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
	public void buscarPartialSearch() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		Collection result = msg.buscar("ont");

		assertTrue(result.contains(msg));

	}

	/**
	 * Comprobamos que el método buscar devuelve el mensaje cuando el criterio de
	 * búsqueda coincide totalmente con el texto del mensaje.
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
	public void buscarFullSearch() throws OperacionInvalida {
		Mensaje msg = new Mensaje(texto);

		Collection result = msg.buscar(contenido);

		assertTrue(result.contains(msg));

	}
}
