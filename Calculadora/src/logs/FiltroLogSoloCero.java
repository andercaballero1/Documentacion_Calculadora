package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class FiltroLogSoloCero implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		String[] partes = record.getMessage().split(" ");
		int resultado = Integer.parseInt(partes[partes.length-1]);
		boolean hacerLog = false;
		if ( record.getMessage() != null && resultado == 0){
			hacerLog = true;
		}
		return hacerLog;
	}

}
