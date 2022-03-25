package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class FiltroLogSoloMultiplicar implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		boolean hacerLog = false;
		if (record.getMessage() != null && record.getMessage().contains("*")){
			hacerLog = true;
		}
		return hacerLog;
	}

}
