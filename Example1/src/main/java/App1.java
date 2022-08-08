import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App1 {
//    დავბეჭდოთ ცვლადების მნიშვნელობები
    public static void main(String[] args){
        App1 app = new App1();
        Properties prop = app.loadPropertiesFile("db.properties");
        prop.forEach((k,v) -> System.out.println(k+":"+v));
    }

    private Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();

        try(InputStream resourceAssStream = getClass().getClassLoader().getResourceAsStream(filePath)){
           prop.load(resourceAssStream);
        }catch (IOException e){
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}
