package seedu.address.model.localcourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class LocalCourseAttributeTest {

    @Test
    public void isValidLocalCourseAttribute() {
        // null String
        assertThrows(NullPointerException.class, () -> LocalCourseAttribute.isValidAttribute((String) null));

        // invalid localCourseAttribute
        assertFalse(LocalCourseAttribute.isValidAttribute("")); // empty string
        assertFalse(LocalCourseAttribute.isValidAttribute(" ")); // spaces only
        assertFalse(LocalCourseAttribute.isValidAttribute("LOCAL"));
        assertFalse(LocalCourseAttribute.isValidAttribute("localcode"));

        // valid localCourseAttribute
        assertTrue(LocalCourseAttribute.isValidAttribute("LOCALCODE"));
        assertTrue(LocalCourseAttribute.isValidAttribute("LOCALNAME"));
    }
}
