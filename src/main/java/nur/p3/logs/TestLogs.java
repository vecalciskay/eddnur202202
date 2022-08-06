package nur.p3.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class TestLogs
{
    private static final Logger logger = LogManager.getLogger(TestLogs.class);

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        logger.debug("Hello World!");
        logger.info("Hello World!");
        logger.warn("Hello World!");
        logger.error("Hello World!");
    }
}
