package application;

import processors.PathProcessor;

public class InitialCheck {
	private Boolean check;

	public InitialCheck() {
		try {
			PathProcessor pp = new PathProcessor(0);
			if (pp.getPath().length() > 0 ) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
		}

	}

	public Boolean getCheck() {
		return check;
	}

}
