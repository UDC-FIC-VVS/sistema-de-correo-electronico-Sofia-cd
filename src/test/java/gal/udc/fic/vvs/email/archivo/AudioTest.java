package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {

	private final String nombre = "Audio";
	private final String contenido = "12345";
	private final String mimeType = "audio/ogg";

	@Test
	public void audioObtenerMimeTypeCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(mimeType, audio.obtenerMimeType());
	}

	@Test
	public void audioObtenerNombreCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(nombre, audio.obtenerNombre());
	}

	@Test
	public void audioObtenerContenidoCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(contenido, audio.obtenerContenido());
	}

	@Test
	public void audioObtenerTamañoCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	@Test
	public void audioObtenerPreVisualizacionCorrectly() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());
	}
}
