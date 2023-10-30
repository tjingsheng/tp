package seedu.address.model.localcourse;

import java.util.function.Predicate;

public class LocalCodeContainsKeywordsPredicate implements Predicate<LocalCourse> {
    private final String keyword;
    private final LocalCourseAttribute attribute;

    public LocalCodeContainsKeywordsPredicate(String keywords, LocalCourseAttribute attribute) {
        this.keyword = keywords;
        this.attribute = attribute;
    }

    @Override
    public boolean test(LocalCourse localCourse) {
        if (attribute == LocalCourseAttribute.LOCALCODE) {
            return localCourse.getLocalCode().getValue().toLowerCase().contains(keyword.toLowerCase());
        } else {
            return false; // You can add handling for other attributes here if needed.
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LocalCodeContainsKeywordsPredicate)) {
            return false;
        }

        LocalCodeContainsKeywordsPredicate otherPredicate = (LocalCodeContainsKeywordsPredicate) other;
        return keyword.equals(otherPredicate.keyword) && attribute == otherPredicate.attribute;
    }
}
