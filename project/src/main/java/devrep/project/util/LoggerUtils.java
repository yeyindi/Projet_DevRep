package devrep.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
	
	private final Logger logger = LoggerFactory.getLogger("rollingFileLogger");
	
	public LoggerUtils() {
		logger.info("test");
	}
	
	public void LogSuccess(String message) {
		logger.info("SUCCESS : "+message);
	}
	
	public void LogFail(String message) {
		logger.warn("FAIL : "+message);
	}

}
