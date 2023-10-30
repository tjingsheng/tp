package seedu.address.model.partnercourse.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.COMP2000;

import org.junit.jupiter.api.Test;

public class PartnerCourseComparatorByPartnerNameTest {
    private PartnerCourseComparatorByPartnerName partnerCourseComparatorByPartnerName =
            new PartnerCourseComparatorByPartnerName();

    @Test
    public void compare() {
        assertEquals(-1, partnerCourseComparatorByPartnerName.compare(COMP2000, COMP1000));
        assertEquals(0, partnerCourseComparatorByPartnerName.compare(COMP2000, COMP2000));
        assertEquals(1, partnerCourseComparatorByPartnerName.compare(COMP1000, COMP2000));
    }
}
