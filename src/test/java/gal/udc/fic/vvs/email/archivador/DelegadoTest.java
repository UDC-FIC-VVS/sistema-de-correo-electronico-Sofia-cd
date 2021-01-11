package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase
 * Delegado. Todos los métodos que no pertenezcan a la clase Delegado serán
 * probados en su correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class DelegadoTest {

	private final String nombreTexto = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombreTexto, contenido);
	private final Mensaje msg = new Mensaje(archivo);
	private final String nombreArchivador = "ArchivadorSimple";
	private final int espacioTotal = 40;
	private final int espacioTotalMin = 12;
	private final ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioTotal);
	private final ArchivadorSimple archivadorDelegado = new ArchivadorSimple(nombreArchivador, espacioTotal);

	/**
	 * Comprobamos que el método devuelve el nombre correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerNombreCorrectly() {
		Delegado delegado = new Delegado(archivadorSimple);

		assertEquals(nombreArchivador, delegado.obtenerNombre());
	}

	/**
	 * Comprobamos que el método almacenarCorreo añade correctamente el correo al
	 * archivador.En este caso no hace falta utilizar el archivador delegado, dado
	 * que es suficiente con el espacio del archivador principal.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void almacenarCorreoWithDecoradoCorrectly() {
		Delegado delegado = new Delegado(archivadorSimple);

		assertTrue(delegado.almacenarCorreo(msg));
	}

	/**
	 * Comprobamos que el método almacenarCorreo añade correctamente el correo al
	 * archivador. Como el espacio del archivador principal es insuficiente para
	 * almacenar el segundo mensaje, es preciso echar mano del archivador delegado.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void almacenarCorreoWithDelegadoCorrectly() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacioTotalMin);
		Delegado delegado = new Delegado(decorado);
		delegado.establecerDelegado(archivadorDelegado);

		assertTrue(delegado.almacenarCorreo(msg));
		assertFalse(decorado.almacenarCorreo(msg));
		assertTrue(delegado.almacenarCorreo(msg));
	}

	/**
	 * Comprobamos que el método obtenerEspacioTotal devuelve el espacio total
	 * establecido.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerEspacioTotalCorrectly() {
		Delegado delegado = new Delegado(archivadorSimple);

		assertEquals(espacioTotal, delegado.obtenerEspacioTotal());
	}

	/**
	 * Comprobamos que el método obtenerEspacioDisponible, al no haber añadido
	 * ningún correo, sigue siendo igual al espacio total establecido.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerEspacioDisponibleFull() {
		Delegado delegado = new Delegado(archivadorSimple);

		assertEquals(espacioTotal, delegado.obtenerEspacioDisponible());
	}

	/**
	 * Comprobamos que el método obtenerEspacioDisponible devuelve el espacio que
	 * resulta de restarle al espacio total el tamaño del mensaje introducido.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerEspacioDisponibleCorrectly() {
		Delegado delegado = new Delegado(archivadorSimple);
		delegado.almacenarCorreo(msg);

		int espacioDisponible = espacioTotal - msg.obtenerTamaño();

		assertEquals(espacioDisponible, delegado.obtenerEspacioDisponible());
	}

	/**
	 * Comprobamos que el método obtenerDelegado devuelve null cuando no se
	 * establece ninguno.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void obtenerDelegado() {
		Delegado delegado = new Delegado(archivadorSimple);

		assertEquals(null, delegado.obtenerDelegado());
	}

	/**
	 * Comprobamos que el método obtenerDelegado devuelve archivador que
	 * establecemos como delegado.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void establecerDelegadoObtenerDelegadoCorrectly() {
		Delegado delegado = new Delegado(archivadorSimple);
		delegado.establecerDelegado(archivadorDelegado);

		assertEquals(archivadorDelegado, delegado.obtenerDelegado());
	}

}
