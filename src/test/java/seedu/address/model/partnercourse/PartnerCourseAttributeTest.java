package seedu.address.model.partnercourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PartnerCourseAttributeTest {

    @Test
    public void isValidPartnerCourseAttribute() {
        // null String
        assertThrows(NullPointerException.class, () -> PartnerCourseAttribute.isValidAttribute((String) null));

        // invalid partnerCourseAttribute
        assertFalse(PartnerCourseAttribute.isValidAttribute("")); // empty string
        assertFalse(PartnerCourseAttribute.isValidAttribute(" ")); // spaces only
        assertFalse(PartnerCourseAttribute.isValidAttribute("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttribute("partnername")); // cannot accpet lowercase

        // valid partnerCourseAttribute
        assertTrue(PartnerCourseAttribute.isValidAttribute("PARTNERCODE"));
        assertTrue(PartnerCourseAttribute.isValidAttribute("PARTNERNAME"));
        assertTrue(PartnerCourseAttribute.isValidAttribute("UNIVERSITY"));
    }
}
