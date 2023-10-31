package seedu.address.model.partnercourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PartnerCourseAttributeTest {

    @Test
    public void isValidPartnerCourseAttribute() {
        // null String
        assertThrows(NullPointerException.class, () -> PartnerCourseAttribute.isValidAttributeForSort((String) null));

        // invalid partnerCourseAttribute
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("")); // empty string
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort(" ")); // spaces only
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("partnername")); // cannot accpet lowercase

        // valid partnerCourseAttribute
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("PARTNERCODE"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("PARTNERNAME"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("UNIVERSITY"));
    }
}
