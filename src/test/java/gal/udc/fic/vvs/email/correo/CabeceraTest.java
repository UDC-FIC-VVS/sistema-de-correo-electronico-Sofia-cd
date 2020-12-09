package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase
 * Cabecera. Todos los métodos que no pertenezcan a la clase Cabecera serán
 * probados en su correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class CabeceraTest {

	private final String nombre = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombre, contenido);
	private final Mensaje msg = new Mensaje(archivo);
	private final String nombreCab = "nombreCabecera";
	private final String valor = "valor";

	/**
	 * Comprobamos que el método devuelve el tamaño correcto. Este debe ser el
	 * resultado de la suma del tamaño del mensaje y el tamaño de la cabecera.
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
		Cabecera cab = new Cabecera(msg, nombreCab, valor);
		int t = msg.obtenerTamaño() + nombreCab.length() + valor.length();

		assertEquals(t, cab.obtenerTamaño());

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
		Cabecera cab = new Cabecera(msg, nombreCab, valor);
		String visualizacion = nombreCab + ": " + valor + "\n" + msg.obtenerVisualizacion();

		assertEquals(visualizacion, cab.obtenerVisualizacion());

	}

}
