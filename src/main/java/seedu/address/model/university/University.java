package seedu.address.model.university;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class University {
    private final University universityName;
    public University(University uN) {
        requireAllNonNull(uN);
        universityName = uN;
    }

    //Getters
    public University getUniversityName() {
        return universityName;
    }

    public boolean isSameUniversity(University otherUniversity) {
        if (otherUniversity == null) {
            return true;
        }
        return otherUniversity != null
                && otherUniversity.getUniversityName().equals(getUniversityName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof University)) {
            return false;
        }

        University otherUniversity = (University) other;
        return universityName.equals(otherUniversity.universityName);
    }
}
