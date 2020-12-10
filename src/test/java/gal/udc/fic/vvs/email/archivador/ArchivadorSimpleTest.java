package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase
 * ArchivadorSimple. Todos los métodos que no pertenezcan a la clase
 * ArchivadorSimple serán probados en su correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class ArchivadorSimpleTest {

	private final String nombreTexto = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombreTexto, contenido);
	private final Mensaje msg = new Mensaje(archivo);
	private final String nombreArchivador = "ArchivadorSimple";
	private final int espacioTotal = 40;
	private final int espacioTotalMin = 12;

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
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertEquals(nombreArchivador, arch.obtenerNombre());
	}

	/**
	 * Comprobamos que el método almacenarCorreo añade correctamente el correo al
	 * archivador.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:
	 */
	@Test
	public void almacenarCorreoCorrectly() {
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertTrue(arch.almacenarCorreo(msg));
	}

	@Test
	public void almacenarCorreoNotEnoughEspace() {
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotalMin);

		assertTrue(arch.almacenarCorreo(msg));
		assertFalse(arch.almacenarCorreo(msg));
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
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertEquals(espacioTotal, arch.obtenerEspacioTotal());
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
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertEquals(espacioTotal, arch.obtenerEspacioDisponible());
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
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);
		arch.almacenarCorreo(msg);

		int espacioDisponible = espacioTotal - msg.obtenerTamaño();

		assertEquals(espacioDisponible, arch.obtenerEspacioDisponible());
	}

	/**
	 * Comprobamos que el método obtenerDelegado devuelve null.
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
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertEquals(null, arch.obtenerDelegado());
	}

}
