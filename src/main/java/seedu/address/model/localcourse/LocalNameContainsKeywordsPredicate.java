package seedu.address.model.localcourse;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;

public class LocalNameContainsKeywordsPredicate {
    private final String keyword;
    public LocalNameContainsKeywordsPredicate(String keywords) {
        this.keyword = keywords;
    }

    @Override
    public boolean test(LocalCourse localCourse) {
        return localCourse.getLocalName().getValue().toLowerCase()
                .contains(keyword.toLowerCase());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalNameContainsKeywordsPredicate)) {
            return false;
        }

        LocalNameContainsKeywordsPredicate otherLocalNameContainsKeywordsPredicate =
                (LocalNameContainsKeywordsPredicate) other;
        return keyword.equals(otherLocalNameContainsKeywordsPredicate.keyword);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keyword", keyword).toString();
    }
}
