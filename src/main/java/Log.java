import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log {


    static Logger logger = Logger.getLogger(Log.class);

    public Log() {

        DOMConfigurator.configure("log4j.xml");
    }

    public void info(String messeage) {

        logger.info(messeage);
    }

    public void warning(String message) {
        logger.warn(message);
    }


    public void error(String message) {

        logger.error(message);
    }


}
