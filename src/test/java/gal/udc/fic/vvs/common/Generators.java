package gal.udc.fic.vvs.common;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class Generators {

	public class ArchivadorSimpleGenerator extends Generator<ArchivadorSimple> {

		public ArchivadorSimpleGenerator() {
			super(ArchivadorSimple.class);

		}

		@Override
		public ArchivadorSimple generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
			return new ArchivadorSimple(sourceOfRandomness.toString(), sourceOfRandomness.nextInt());
		}
	}

	public class TextoGenerator extends Generator<Texto> {

		public TextoGenerator() {
			super(Texto.class);

		}

		@Override
		public Texto generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
			return new Texto(sourceOfRandomness.toString(), sourceOfRandomness.toString());
		}
	}

	public class MensajeGenerator extends Generator<Mensaje> {

		public MensajeGenerator() {
			super(Mensaje.class);

		}

		@Override
		public Mensaje generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {

			return new Mensaje(new Texto(sourceOfRandomness.toString(), sourceOfRandomness.toString()));
		}
	}
}
