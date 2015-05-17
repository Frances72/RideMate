package RideMate.conf.factory;

import RideMate.domain.Chip;
import RideMate.domain.Cycler;
import RideMate.domain.Reader;
import RideMate.domain.Reading;

import java.util.Date;

/**
 * Created by User on 2015/05/10.
 */
public class ReadingFactory {
    public static Reading createReading(Chip chip, Cycler cycler, Reader reader, Date readTime){
        Reading reading = new Reading.Builder(chip).cycler(cycler).reader(reader).readTime(readTime).build();
        return reading;

    }
}
