package persistence.commons;

public class MissingDataException extends RuntimeException {

	private static final long serialVersionUID = -6664324794874412147L;

		public MissingDataException(Exception e) {
			super(e);
		}
	}

