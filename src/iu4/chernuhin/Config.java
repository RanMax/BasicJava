package iu4.chernuhin;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 06.10.13
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class Config {
    private static final String PROPERTIES_FILE = "./server.properties";

    public static int PORT;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;

        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            PORT             = Integer.parseInt(properties.getProperty("PORT"));
        } catch (FileNotFoundException ex) {
            System.err.println("Properties config file not found");
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}