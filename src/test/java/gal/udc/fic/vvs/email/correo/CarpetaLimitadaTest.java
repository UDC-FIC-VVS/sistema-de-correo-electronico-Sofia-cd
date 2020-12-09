package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase
 * CarpetaLimitada. Todos los métodos que no pertenezcan a la clase
 * CarpetaLimitada serán probados en su correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class CarpetaLimitadaTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombre, contenido);
	private final String nombreCarpeta = "nombreCarpeta";
	private final String busquedaNotMatch = "-1";
	private final int tamaño = 50;
	private final int tamañoReducido = 2;

	/**
	 * Comprobamos si añaden correos correctamente. Para aseguranos de que se
	 * realiza correctamente comprobamos que el padre del nuevo mensaje introducido
	 * es la carpeta contenida en la carpeta limitada.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void añadirCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Mensaje msg = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);

		assertEquals(carpeta, msg.obtenerPadre());

	}

	/**
	 * Comprobamos si elimina correctamente. Para aseguranos de que se realiza
	 * correctamente nos aseguramos de que el padre del correo eliminado sea null.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void eliminarCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);

		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		carpeta.eliminar(msg);

		assertEquals(null, msg.obtenerPadre());
		assertEquals(carpeta, msg1.obtenerPadre());

	}

	/**
	 * Comprobamos si se obtiene el hijo correctamente. Comprobamos que el hijo
	 * devuelto sea corresponda con el esperado.
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
	public void obtenerHijoCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);

		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		assertEquals(msg, carpeta.obtenerHijo(0));
		assertEquals(msg1, carpeta.obtenerHijo(1));

	}

	/**
	 * Comprobamos si se obtiene el padre correctamente. No establecemos padre a la
	 * carpeta contenida en la carpeta limitada, y por lo tanto, el resultado tiene
	 * que ser null.
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
	public void obtenerPadreNull() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(null, carpetaLimitada.obtenerPadre());

	}

	/**
	 * Comprobamos si se obtiene el padre correctamente. Establecemos un padre a la
	 * carpeta contenida en la carpeta limitada, y por lo tanto, el resultado tiene
	 * que dicho padre.
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
	public void obtenerPadreNotNull() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaP = new Carpeta(nombreCarpeta + "P");
		carpetaP.añadir(carpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpetaP, carpetaLimitada.obtenerPadre());

	}

	/**
	 * Comprobamos si la búsqueda con límite funciona. Se establece un tamaño
	 * inferior al número de mensajes contenido.
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
	public void buscarlimitadoCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoReducido);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		Mensaje msg2 = new Mensaje(archivo);
		Mensaje msg3 = new Mensaje(archivo);

		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);
		carpetaLimitada.añadir(msg2);
		carpetaLimitada.añadir(msg3);

		Vector vector = new Vector();
		vector.add(msg);
		vector.add(msg1);
		vector.add(msg2);

		Collection result = carpetaLimitada.buscar(contenido);

		assertEquals(3, result.size());
		assertEquals(vector, result);

	}

	/**
	 * Comprobamos si se encuentran los mensages que coinciden con el mensaje de
	 * busqueda especificado.
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
	public void buscarCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		Mensaje msg2 = new Mensaje(archivo);
		Mensaje msg3 = new Mensaje(archivo);

		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);
		carpetaLimitada.añadir(msg2);
		carpetaLimitada.añadir(msg3);

		Vector vector = new Vector();
		vector.add(msg);
		vector.add(msg1);
		vector.add(msg2);
		vector.add(msg3);

		Collection result = carpetaLimitada.buscar(contenido);

		assertEquals(4, result.size());
		assertEquals(vector, result);

	}

	/**
	 * Comprobamos si al especificar un criterio de búsqueda que no coincide con el
	 * texto de alguno de los mensajes el método buscar devuelve un collection
	 * vacío.
	 * 
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
	public void buscarNotFound() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);

		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		Collection result = carpetaLimitada.buscar(busquedaNotMatch);

		assertTrue(result.isEmpty());

	}

	/**
	 * Comprobamos si el método explorar devuelve los mensajes contenidos en la
	 * carpeta.
	 * 
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
	public void explorarCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);

		carpeta.añadir(msg);
		carpeta.añadir(msg1);

		Vector vector = new Vector();
		vector.add(msg);
		vector.add(msg1);

		Collection result = carpetaLimitada.explorar();

		assertEquals(2, result.size());
		assertEquals(vector, result);

	}

	/**
	 * Comprobamos si el método explorar devuelve los mensajes contenidos en la
	 * carpeta.En este caso no puede devolver ningún mesaje dado que no se introdujo
	 * ninguno en la carpeta.
	 * 
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
	public void explorarEmptyCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertTrue(carpetaLimitada.explorar().isEmpty());

	}

	/**
	 * Comprobamos si el método obtnerRuta devuelve la ruta correctamente. En este
	 * caso la carpeta de la que queremos obtener la ruta está dentro de otra, por
	 * lo tanto, en la ruta deben aparecer ambas.
	 * 
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
	public void obtenerRutaWithPadreCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaP = new Carpeta(nombreCarpeta + "P");
		carpeta.establecerPadre(carpetaP);

		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		String resultado = carpetaP.obtenerPreVisualizacion() + " > " + carpeta.obtenerPreVisualizacion();

		assertEquals(resultado, carpetaLimitada.obtenerRuta());

	}

	/**
	 * Comprobamos si el método obtenerRuta devuelve la ruta correctamente. En este
	 * caso la carpeta no tiene una carpeta padre.
	 * 
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
	public void obtenerRutaCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		String resultado = carpeta.obtenerPreVisualizacion();

		assertEquals(resultado, carpetaLimitada.obtenerRuta());

	}

	/**
	 * Comprobamos si el método obtener visualización devuelve la visualización
	 * correcta.
	 *
	 * 
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
	public void obtenerVisualizacionWithLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		msg.establecerLeido(true);
		msg1.establecerLeido(true);

		assertEquals(carpeta.obtenerVisualizacion(), carpetaLimitada.obtenerVisualizacion());

	}

	/**
	 * Comprobamos si el método obtener visualización devuelve la visualización
	 * correcta.
	 *
	 * 
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
	public void obtenerVisualizacionWithNoLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		assertEquals(carpeta.obtenerVisualizacion(), carpetaLimitada.obtenerVisualizacion());

	}

	/**
	 * Comprobamos si el método obtener previsualización devuelve la
	 * previsualización correcta.
	 *
	 * 
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
	public void obtenerPreVisualizacionCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		assertEquals(carpeta.obtenerPreVisualizacion(), carpetaLimitada.obtenerPreVisualizacion());

	}

	/**
	 * Comprobamos si el método obtener icono devuelve el icono correcto.
	 *
	 * 
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
	public void obtenerIconoCorrectly() {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpeta.obtenerIcono(), carpetaLimitada.obtenerIcono());
	}

	/**
	 * Comprobamos que el método devuelve el tamaño correcto. Este debe ser el
	 * tamaño de la carpeta contenida.
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
	public void obtenerTamañoCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		assertEquals(carpeta.obtenerTamaño(), carpetaLimitada.obtenerTamaño());

	}

	/**
	 * Comprobamos que el método devuelve el numero correcto de mensajes no leidos.
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
	public void obtenerNoLeidosCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);

		int noLeidos = carpeta.obtenerNoLeidos();

		assertEquals(noLeidos, carpetaLimitada.obtenerNoLeidos());

	}

	/**
	 * Comprobamos que el método establecer leidos marca bien los correos como no
	 * leídos.
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
	public void establecerLeidosCorrectly() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Mensaje msg = new Mensaje(archivo);
		Mensaje msg1 = new Mensaje(archivo);
		carpetaLimitada.añadir(msg);
		carpetaLimitada.añadir(msg1);
		carpetaLimitada.establecerLeido(true);

		assertEquals(0, msg.obtenerNoLeidos());
		assertEquals(0, msg1.obtenerNoLeidos());

	}

}
