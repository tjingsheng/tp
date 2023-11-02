package seedu.address.model.partnercourse.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.COMP4000;

import org.junit.jupiter.api.Test;

public class PartnerCourseComparatorByUniversityTest {
    private PartnerCourseComparatorByUniversity partnerCourseComparatorByUniversity =
            new PartnerCourseComparatorByUniversity();

    @Test
    public void compare() {
        assertEquals(-1, partnerCourseComparatorByUniversity.compare(COMP4000, COMP1000));
        assertEquals(0, partnerCourseComparatorByUniversity.compare(COMP4000, COMP4000));
        assertEquals(1, partnerCourseComparatorByUniversity.compare(COMP1000, COMP4000));
    }
}
