package seedu.address.model.localcourse.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalObjects.CS2030S;
import static seedu.address.testutil.TypicalObjects.MA2001;

import org.junit.jupiter.api.Test;


public class LocalCourseComparatorByLocalCodeTest {
    private LocalCourseComparatorByLocalCode localCourseComparatorByLocalCode = new LocalCourseComparatorByLocalCode();

    @Test
    public void compare() {
        assertEquals(-1, localCourseComparatorByLocalCode.compare(CS2030S, MA2001));
        assertEquals(0, localCourseComparatorByLocalCode.compare(CS2030S, CS2030S));
        assertEquals(1, localCourseComparatorByLocalCode.compare(MA2001, CS2030S));
    }
}
