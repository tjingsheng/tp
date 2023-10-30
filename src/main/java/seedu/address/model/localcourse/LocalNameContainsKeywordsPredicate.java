package seedu.address.model.localcourse;

import java.util.function.Predicate;

public class LocalNameContainsKeywordsPredicate implements Predicate<LocalCourse> {
    private final String keyword;
    private final LocalCourseAttribute attribute;

    public LocalNameContainsKeywordsPredicate(String keywords, LocalCourseAttribute attribute) {
        this.keyword = keywords;
        this.attribute = attribute;
    }

    @Override
    public boolean test(LocalCourse localCourse) {
        if (attribute == LocalCourseAttribute.LOCALNAME) {
            return localCourse.getLocalName().getValue().toLowerCase().contains(keyword.toLowerCase());
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LocalNameContainsKeywordsPredicate)) {
            return false;
        }

        LocalNameContainsKeywordsPredicate otherPredicate = (LocalNameContainsKeywordsPredicate) other;
        return keyword.equals(otherPredicate.keyword) && attribute == otherPredicate.attribute;
    }
}

