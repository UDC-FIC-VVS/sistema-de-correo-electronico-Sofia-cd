package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Carpeta.
 * Todos los métodos que no pertenezcan a la clase Carpeta serán probados en su
 * correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class CarpetaTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombre, contenido);
	private final String nombreCarpeta = "nombreCarpeta";
	private final String busquedaNotMatch = "-1";

	/**
	 * Comprobamos que se añaden bien los mensajes. El padre del mensaje debe de ser
	 * la carpeta en la que hemos introducido el mensaje.
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
	public void añadirCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		carpeta.añadir(msg);

		assertEquals(carpeta, msg.obtenerPadre());

	}

	/**
	 * Comprobamos si se añaden bien los mensajes con padres.
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
	public void añadirCorreoWithPadreCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpeta1 = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta1.añadir(msg1);
		carpeta1.añadir(msg);

		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		assertEquals(carpeta, msg.obtenerPadre());
		assertEquals(carpeta, msg1.obtenerPadre());

	}

	/**
	 * Comprobamos que se elimine correctamente un mensaje de una carpeta. El padre
	 * de dicho mensaje debe pasar a ser null y el vector con los mensajes no debe
	 * contener a dicho mensaje.
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
	public void eliminarCorreoWithPadreCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);

		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		carpeta.eliminar(msg);

		assertFalse(carpeta.explorar().contains(msg));
		assertEquals(null, msg.obtenerPadre());
		assertEquals(carpeta, msg1.obtenerPadre());

	}

	/**
	 * Comprobamos que el método obtener Hijo devuelve bien los mensajes contenidos
	 * en la carpeta.
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
	public void obtenerHijoCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpeta1 = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta1.añadir(msg1);
		carpeta1.añadir(msg);

		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		assertEquals(msg, carpeta.obtenerHijo(0));
		assertEquals(msg1, carpeta.obtenerHijo(1));

	}

	/**
	 * Comprobamos que el método explorar devuelve una colección con todos los
	 * mensajes contenidos en la carpeta.
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
	public void explorarCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		Vector vector = new Vector();
		vector.add(msg);
		vector.add(msg1);

		Collection result = carpeta.explorar();

		assertEquals(2, result.size());
		assertEquals(vector, result);

	}

	/**
	 * Comprobamos que el método explorar, cuando la carpeta no contiene ningún
	 * mensaje, devuelve una colección vacía.
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
	public void explorarEmptyCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		assertTrue(carpeta.explorar().isEmpty());

	}

	/**
	 * Comprobamos que el método buscar devuelve los mensajes cuyo texto coincide
	 * con el criterio de búsqueda.
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
	public void buscarCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		Vector vector = new Vector();
		vector.add(msg);
		vector.add(msg1);

		Collection result = carpeta.buscar(contenido);

		assertEquals(2, result.size());
		assertEquals(vector, result);

	}

	/**
	 * Comprobamos que el método buscar no devuelve ningún mensaje cuando el
	 * criterio de búsqueda no coincide con el contenido de ninguno de los mensajes.
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
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		Collection result = carpeta.buscar(busquedaNotMatch);

		assertTrue(result.isEmpty());

	}

	/**
	 * Comprobamos que la visualización se compone del nombre de la carpeta junto
	 * con el número de mensajes no leídos.
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
	public void obtenerVisualizacionWithNoLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		String expected = nombreCarpeta + " (2)";

		assertEquals(expected, carpeta.obtenerVisualizacion());

	}

	/**
	 * Comprobamos que la visualización se compone sólo del nombre de la carpeta
	 * cuando no existen mensajes no leídos.
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
	public void obtenerVisualizacionWithLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		msg.establecerLeido(true);
		msg1.establecerLeido(true);

		String expected = nombreCarpeta;

		assertEquals(expected, carpeta.obtenerVisualizacion());

	}

	/**
	 * Comprobamos que la previsualización se compone del nombre de la carpeta junto
	 * con el número de mensajes no leídos.
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
	public void obtenerPreVisualizacionWithNoLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		String expected = nombreCarpeta + " (2)";

		assertEquals(expected, carpeta.obtenerPreVisualizacion());

	}

	/**
	 * Comprobamos que la previsualización se compone sólo del nombre de la carpeta
	 * cuando no existen mensajes no leídos.
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
	public void obtenerPreVisualizacionWithLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		msg.establecerLeido(true);
		msg1.establecerLeido(true);

		String expected = nombreCarpeta;

		assertEquals(expected, carpeta.obtenerPreVisualizacion());

	}

	/**
	 * Comprobamos que el método obtener icono devuelve el método que debe de ser.
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 */
	@Test
	public void obtenerIconoCorrectly() {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}

	/**
	 * Comprobamos que el método obtener tamaño devuelve la suma del tamaño de los
	 * mensajes que contiene la carpeta.
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 */
	@Test
	public void obtenerTamañoCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		int tamaño = msg.obtenerTamaño() + msg1.obtenerTamaño();

		assertEquals(tamaño, carpeta.obtenerTamaño());

	}

	/**
	 * Comprobamos que el método obtener no leidos devuelve el número de los
	 * mensajes no leidos que contiene la carpeta.
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void obtenerNoLeidosCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		int noLeidos = 2;

		assertEquals(noLeidos, carpeta.obtenerNoLeidos());

	}

	/**
	 * Comprobamos que el método obtener no leidos devuelve cero cuando no hay
	 * mensajes no leidos en la carpeta.
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void obtenerNoLeidosZero() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		msg.establecerLeido(true);
		msg1.establecerLeido(true);

		int noLeidos = 0;

		assertEquals(noLeidos, carpeta.obtenerNoLeidos());

	}

	/**
	 * Comprobamos que el método establecer leido marca los mensajes como leidos.
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void establecerLeidosCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpeta.añadir(msg);
		carpeta.añadir(msg1);
		carpeta.establecerLeido(true);

		assertEquals(0, msg.obtenerNoLeidos());
		assertEquals(0, msg1.obtenerNoLeidos());

	}
}
