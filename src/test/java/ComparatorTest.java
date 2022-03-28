import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComparatorTest {
    private Comparator comparator;

    @Before
    public void setUp() {
        comparator = new Comparator();
    }

    @Test
    public void getMaxNumberTests() {
        assertEquals("Max value between 20 and 30", 30, comparator.getMaxValue(20, 30));
        assertEquals("Max value between 30 and 20", 30, comparator.getMaxValue(30, 20));
        assertEquals("Max value between 30 and 30", 30, comparator.getMaxValue(30, 30));

    }


}
