import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.RowMetaAndData;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

import java.util.List;

public class JobTest {

    public static void main(String args[]) throws KettleException {

        new JobTest();
    }

    private JobTest () throws KettleException {

        KettleEnvironment.init();
        JobMeta jobMeta = new JobMeta(this.getClass().getResource("/") + "job.kjb", null);
        Job job = new Job(null, jobMeta);
        job.start();

        final List<RowMetaAndData> read;
        read = job.getResult().getRows();

        job.waitUntilFinished();
        System.out.println("test: "+job.getResult());
    }
}
