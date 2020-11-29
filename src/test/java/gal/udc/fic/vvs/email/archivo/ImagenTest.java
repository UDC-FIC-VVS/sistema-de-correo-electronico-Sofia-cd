package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	private final String nombre = "Imagen";
	private final String contenido = "12345";
	private final String mimeType = "image/png";

	@Test
	public void audioObtenerMimeTypeCorrectly() {
		Imagen audio = new Imagen(nombre, contenido);
		assertEquals(mimeType, audio.obtenerMimeType());
	}

	@Test
	public void audioObtenerNombreCorrectly() {
		Imagen audio = new Imagen(nombre, contenido);
		assertEquals(nombre, audio.obtenerNombre());
	}

	@Test
	public void audioObtenerContenidoCorrectly() {
		Imagen audio = new Imagen(nombre, contenido);
		assertEquals(contenido, audio.obtenerContenido());
	}

	@Test
	public void audioObtenerTamañoCorrectly() {
		Imagen audio = new Imagen(nombre, contenido);
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	@Test
	public void audioObtenerPreVisualizacionCorrectly() {
		Imagen audio = new Imagen(nombre, contenido);
		assertEquals(nombre + "(" + contenido.length() + " bytes, " + mimeType + ")", audio.obtenerPreVisualizacion());
	}
}
