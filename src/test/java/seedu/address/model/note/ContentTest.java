package seedu.address.model.note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ContentTest {

    @Test
    public void isValidContent() {
        // Valid content
        assertTrue(Content.isValidContent("Valid Content"));
        assertTrue(Content.isValidContent("123 456"));
        assertTrue(Content.isValidContent(".,!?\"'():\\-–"));
        assertTrue(Content.isValidContent("Valid_Content!")); // Special characters

        // Invalid content
        assertFalse(Content.isValidContent("   Spaces in the content   "));
        assertFalse(Content.isValidContent("")); // Empty content
        assertFalse(Content.isValidContent(" Content with whitespace")); // Leading whitespace
        assertFalse(Content.isValidContent("Content with whitespace ")); // Trailing whitespace
        assertFalse(Content.isValidContent(" Content with invalid char @")); // Invalid character @
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Content(null));
    }

    @Test
    public void constructor_invalidContent_throwsIllegalArgumentException() {
        String invalidContent = "";
        assertThrows(IllegalArgumentException.class, () -> new Content(invalidContent));
    }
}
