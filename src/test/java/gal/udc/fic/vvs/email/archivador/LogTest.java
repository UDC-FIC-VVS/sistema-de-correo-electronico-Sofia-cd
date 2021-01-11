package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase Log.
 * Todos los métodos que no pertenezcan a la clase Log serán probados en su
 * correspondiente clase test.
 * 
 * @author sofia
 *
 */
public class LogTest {

	private final String nombreTexto = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombreTexto, contenido);
	private final Mensaje msg = new Mensaje(archivo);
	private final String nombreArchivador = "ArchivadorSimple";
	private final int espacioTotal = 40;
	private final ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioTotal);

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
		Log log = new Log(archivadorSimple);

		boolean result = log.almacenarCorreo(msg);

		assertTrue(result);

	}
}
