package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.university.UniqueUniversityList;
import seedu.address.model.university.University;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class UniversityCatalogue implements ReadOnlyUniversityCatalogue {

    private final UniqueUniversityList universities;

    {
        universities = new UniqueUniversityList();
    }

    public UniversityCatalogue() {
    }

    public UniversityCatalogue(ReadOnlyUniversityCatalogue toBeCopied) {
        this();
    }

    public boolean hasUniversity(University universityQuery) {
        requireNonNull(universityQuery);
        return universities.contains(universityQuery);
    }

    public void addUniversity(University uN) {
        universities.add(uN);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("university", universities)
                .toString();
    }

    @Override
    public ObservableList<University> getUniversityList() {
        return universities.asUnmodifiableObservableList();
    }

    public void setUniversities(List<University> universities) {
        this.universities.setUniversities(universities);
    }
    public void resetData(ReadOnlyUniversityCatalogue newData) {
        requireNonNull(newData);
        setUniversities(newData.getUniversityList());
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UniversityCatalogue)) {
            return false;
        }

        UniversityCatalogue otherUniversityCatalogue = (UniversityCatalogue) other;
        return universities.equals(otherUniversityCatalogue.universities);
    }

    @Override
    public int hashCode() {
        return universities.hashCode();
    }
}
