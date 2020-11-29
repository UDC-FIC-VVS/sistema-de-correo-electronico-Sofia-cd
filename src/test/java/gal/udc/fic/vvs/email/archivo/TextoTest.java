package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private final String nombre = "Texto";
	private final String contenido = "12345";
	private final String mimeType = "text/plain";

	@Test
	public void audioObtenerMimeTypeCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(mimeType, audio.obtenerMimeType());
	}

	@Test
	public void audioObtenerNombreCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(nombre, audio.obtenerNombre());
	}

	@Test
	public void audioObtenerContenidoCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(contenido, audio.obtenerContenido());
	}

	@Test
	public void audioObtenerTamañoCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	@Test
	public void audioObtenerPreVisualizacionCorrectly() {
		Texto audio = new Texto(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());
	}

}
