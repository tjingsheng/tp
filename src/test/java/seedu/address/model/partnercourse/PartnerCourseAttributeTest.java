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
        assertThrows(NullPointerException.class, () -> PartnerCourseAttribute.isValidAttributeForUpdate((String) null));

        // invalid partnerCourseAttribute for sort
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("")); // empty string
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort(" ")); // spaces only
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("partnername")); // cannot accept lowercase
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("pArTnerCODE"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("UNIT"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("DESCRIPTION"));

        // invalid partnerCourseAttribute for update
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("")); // empty string
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate(" ")); // spaces only
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("partnername")); // cannot accept lowercase
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("Description"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("UNIVERSITY"));

        // valid partnerCourseAttribute for sort
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("PARTNERCODE"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("PARTNERNAME"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("UNIVERSITY"));

        // valid partnerCourseAttribute for update
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNERCODE"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNERNAME"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("UNIT"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("DESCRIPTION"));

    }
}
