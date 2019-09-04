package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import processors.PathProcessor;

public class InitialCheck {
	private Boolean check;
	static Logger log = LogManager.getLogger(InitialCheck.class.getName());

	public InitialCheck() {
		try {
			PathProcessor pp = new PathProcessor();
			if (pp.getPath().length() > 0 ) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
			log.error("THE PATH FOUND ON APPLICATION SETTING IS INVALID");
		}
	}

	public Boolean getCheck() {
		return check;
	}

}
