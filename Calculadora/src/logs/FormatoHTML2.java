package logs;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FormatoHTML2 extends Formatter {

	@Override
	public String format(LogRecord record) {
		String[] partes = record.getMessage().split(" ");
		
		return "<TR><TD> " + partes[1] + " </TD><TD> " + partes[3] + " </TD><TD> " + partes[5] + " </TD><TD> " + partes[7] + " </TD></TR>";
	}
	
	@Override
	public String getHead(Handler h) {
        return "<HTML> \n <HEAD> <link rel='stylesheet' href='C:\\Users\\irakaslea\\git\\Calculadora\\Calculadora\\src\\style.css'></HEAD> \n <BODY><TABLE><TBODY><TR><TH>Operacion</TH><TH>Operando1</TH><TH>Operando2</TH><TH>Resultado</TH>";
    }

	@Override
    public String getTail(Handler h) {
        return "</TR></TBODY></TABLE> </BODY> \n </HTML> \n";
    }

}
