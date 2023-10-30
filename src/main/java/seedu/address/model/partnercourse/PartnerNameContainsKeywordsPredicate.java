package seedu.address.model.partnercourse;

import java.util.function.Predicate;

/**
 * Tests that a {@code PartnerCourse}'s {@code PartnerName} matches any of the keywords given.
 */
public class PartnerNameContainsKeywordsPredicate implements Predicate<PartnerCourse> {
    private final String keyword;
    private final PartnerCourseAttribute attribute;

    /**
     * Creates a PartnerNameContainsKeywordsPredicate to initialise the keyword and attribute.
     * @param keywords
     * @param attribute
     */
    public PartnerNameContainsKeywordsPredicate(String keywords, PartnerCourseAttribute attribute) {
        this.keyword = keywords;
        this.attribute = attribute;
    }

    @Override
    public boolean test(PartnerCourse partnerCourse) {
        if (attribute == PartnerCourseAttribute.LOCALNAME) {
            return partnerCourse.getPartnerName().getValue().toLowerCase().contains(keyword.toLowerCase());
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerNameContainsKeywordsPredicate)) {
            return false;
        }

        PartnerNameContainsKeywordsPredicate otherPredicate = (PartnerNameContainsKeywordsPredicate) other;
        return keyword.equals(otherPredicate.keyword) && attribute == otherPredicate.attribute;
    }
}
