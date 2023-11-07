package seedu.address.model.localcourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LocalCourseAttributeTest {

    @Test
    public void isValidLocalCourseAttributeForSearch() {
        // invalid localCourseAttribute
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("")); // empty string
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch(" ")); // spaces only
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("a")); // letter
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("123")); // number
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("LOCAL"));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("localunit"));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch(null));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("LOCALCODE"));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("LOCALNAME"));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("LOCALUNIT"));
        assertFalse(LocalCourseAttribute.isValidAttributeForSearch("LOCALDESCRIPTION"));

        // valid localCourseAttribute
        assertTrue(LocalCourseAttribute.isValidAttributeForSearch("localcode"));
        assertTrue(LocalCourseAttribute.isValidAttributeForSearch("localname"));
        assertTrue(LocalCourseAttribute.isValidAttributeForSearch("localdescription"));

    }

    @Test
    public void isValidLocalCourseAttributeForUpdate() {
        // invalid localCourseAttribute
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("")); // empty string
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate(" ")); // spaces only
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("a")); // letter
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("123")); // number
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("LOCAL"));
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate(null));
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("LOCALCODE"));
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("LOCALNAME"));
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("LOCALUNIT"));
        assertFalse(LocalCourseAttribute.isValidAttributeForUpdate("LOCALDESCRIPTION"));

        // valid localCourseAttribute
        assertTrue(LocalCourseAttribute.isValidAttributeForUpdate("localcode"));
        assertTrue(LocalCourseAttribute.isValidAttributeForUpdate("localname"));
        assertTrue(LocalCourseAttribute.isValidAttributeForUpdate("localunit"));
        assertTrue(LocalCourseAttribute.isValidAttributeForUpdate("localdescription"));
    }
}
