package seedu.address.model.partnercourse.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.COMP2000;

import org.junit.jupiter.api.Test;
public class PartnerCourseComparatorByPartnerCodeTest {

    private PartnerCourseComparatorByPartnerCode partnerCourseComparatorByPartnerCode =
            new PartnerCourseComparatorByPartnerCode();

    @Test
    public void compare() {
        assertEquals(-1, partnerCourseComparatorByPartnerCode.compare(COMP1000, COMP2000));
        assertEquals(0, partnerCourseComparatorByPartnerCode.compare(COMP1000, COMP1000));
        assertEquals(1, partnerCourseComparatorByPartnerCode.compare(COMP2000, COMP1000));
    }
}
