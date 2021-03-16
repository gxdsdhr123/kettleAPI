import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class TransTest {

    public static void main(String args[]) throws KettleException {

        new TransTest();
    }

    private TransTest() throws KettleException {

        System.setProperty("KETTLE_HOME", "C:/Program Files/JAVA/data-integration");
        KettleEnvironment.init();
        TransMeta transMeta = new TransMeta(this.getClass().getResource("/") + "test.xml");
        Trans trans = new Trans(transMeta);

        trans.execute(null); // You can pass arguments instead of null.
        trans.waitUntilFinished();
        if (trans.getErrors() > 0) {
            throw new RuntimeException("There were errors during transformation execution.");
        }
    }
}
