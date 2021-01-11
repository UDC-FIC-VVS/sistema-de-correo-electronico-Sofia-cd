package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Esta clase tiene la finalidad de probar la funcionalidad de la clase
 * ArchivadorSimple. Todos los métodos que no pertenezcan a la clase
 * ArchivadorSimple serán probados en su correspondiente clase test.
 * 
 * <p>
 * Para hacer el código más mantenible lo que habría que hacer serían
 * generadores, puesto que si cambia alguno de los parámetros de la clase
 * Archivador Simple habría que cambiar todas las propiedades. De la misma
 * manera, en vez de tener un mensaje fijo habría que tener un generador.
 * 
 * @author sofia
 *
 */
@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimpleTest {

	private final String nombreTexto = "Texto";
	private final String contenido = "contenido";
	private final Texto archivo = new Texto(nombreTexto, contenido);
	private final Mensaje msg = new Mensaje(archivo);
	private final String nombreArchivador = "ArchivadorSimple";
	private final int espacioTotal = 40;
	private final int espacioTotalMin = 12;

	public class ArchivadorSimpleGenerator extends Generator<ArchivadorSimple> {

		public ArchivadorSimpleGenerator() {
			super(ArchivadorSimple.class);

		}

		@Override
		public ArchivadorSimple generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
			return new ArchivadorSimple(sourceOfRandomness.toString(), sourceOfRandomness.nextInt());
		}
	}

	/**
	 * Comprobamos que el método devuelve el nombre correcto.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerNombreCorrectly(String nombreArchivador, int espacioTotal) {
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
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void almacenarCorreoCorrectly(String nombreArchivador, int espacioTotal) {
		boolean espacioSuficiente = false;
		if (msg.obtenerTamaño() <= espacioTotal)
			espacioSuficiente = true;
		assumeTrue(espacioSuficiente);

		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertTrue(arch.almacenarCorreo(msg));
	}

	/**
	 * Comprobamos que el método almacenarCorreo no añade el correo cuando no hay
	 * suficiente espacio.
	 * 
	 * <p>
	 * Nivel de la prueba: Unidad.
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos:Valores frontera y aleatorios
	 */
	@Property
	public void almacenarCorreoNotEnoughEspace(String nombreArchivador) {
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, 0);

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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerEspacioTotalCorrectly(String nombreArchivador, int espacioTotal) {
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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerEspacioDisponibleFull(String nombreArchivador, int espacioTotal) {
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);
		boolean espacioSuficiente = true;
		if (arch.obtenerEspacioDisponible() == espacioTotal)
			espacioSuficiente = false;

		assumeTrue(!espacioSuficiente);

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
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerEspacioDisponibleCorrectly(String nombreArchivador, int espacioTotal) {
		boolean espacioSuficiente = false;
		if (msg.obtenerTamaño() <= espacioTotal)
			espacioSuficiente = true;
		assumeTrue(espacioSuficiente);

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
	 * <p>
	 * Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * Mecanismo de selección de datos: selección de datos aleatoria.
	 */
	@Property
	public void obtenerDelegado(String nombreArchivador, int espacioTotal) {
		ArchivadorSimple arch = new ArchivadorSimple(nombreArchivador, espacioTotal);

		assertEquals(null, arch.obtenerDelegado());
	}

}
