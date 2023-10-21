package seedu.address.model.university;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code University}'s {@code UniversityName} matches any of the keywords given.
 */
public class UniversityNameContainsKeywordsPredicate implements Predicate<University> {
    private final List<String> keywords;
    public UniversityNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(University university) {
        return keywords.stream()
                .anyMatch(keyword -> university.getUniversityName().getName().toLowerCase()
                        .contains(keyword.toLowerCase()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof seedu.address.model.university.UniversityNameContainsKeywordsPredicate)) {
            return false;
        }

        seedu.address.model.university.UniversityNameContainsKeywordsPredicate otherNameContainsKeywordsPredicate =
                (seedu.address.model.university.UniversityNameContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}



