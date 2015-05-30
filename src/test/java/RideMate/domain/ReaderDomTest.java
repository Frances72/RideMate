package RideMate.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 2015/05/26.
 */
public class ReaderDomTest {

    @Test
    public void testCreate() throws Exception {
        Reader reader = new Reader.Builder(5.3).build();
        Assert.assertEquals(5.3, reader.getDistance());

    }
    @Test
    public void update() throws Exception{
        Reader reader = new Reader.Builder(7.9).build();
        Reader newreader = new Reader.Builder(reader.getDistance()).build();

        Assert.assertEquals(7.9, newreader.getDistance());

    }
}
