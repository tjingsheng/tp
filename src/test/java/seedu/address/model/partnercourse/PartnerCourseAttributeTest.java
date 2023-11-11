package seedu.address.model.partnercourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PartnerCourseAttributeTest {
    @Test
    public void isValidPartnerCourseAttributeForSearch() {
        // invalid partnerCourseAttribute
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("units"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch(""));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch(" "));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("a"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("123"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch(null));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PARTNERCODE"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PARTNERNAME"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PARTNERUNIT"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PARTNERDESCRIPTION"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("UNIVERSITY"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("UNITS"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("partner code"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PartnerCode"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSearch("PartnerName"));

        // valid partnerCourseAttribute
        assertTrue(PartnerCourseAttribute.isValidAttributeForSearch("partnercode"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSearch("partnername"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSearch("description"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSearch("university"));
    }

    @Test
    public void isValidPartnerCourseAttributeForSort() {
        // invalid partnerCourseAttribute
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("units"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("description"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort(""));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort(" "));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("a"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("123"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort(null));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNERCODE"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNERNAME"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNERUNIT"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PARTNERDESCRIPTION"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("UNIVERSITY"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("DESCRIPTION"));

        // valid partnerCourseAttribute
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("partnercode"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("partnername"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForSort("university"));

        // Additional invalid cases
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("partner code"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PartnerCode"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("PartnerName"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("partnerunit"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForSort("description"));
    }

    @Test
    public void isValidPartnerCourseAttributeForUpdate() {
        // invalid partnerCourseAttribute
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("university"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate(""));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate(" "));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("a"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("123"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNER"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate(null));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNERCODE"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PARTNERNAME"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("UNITS"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("DESCRIPTION"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("UNIVERSITY"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("partner code"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PartnerCode"));
        assertFalse(PartnerCourseAttribute.isValidAttributeForUpdate("PartnerName"));

        // valid partnerCourseAttribute
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("partnercode"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("partnername"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("unit"));
        assertTrue(PartnerCourseAttribute.isValidAttributeForUpdate("description"));
    }
}
