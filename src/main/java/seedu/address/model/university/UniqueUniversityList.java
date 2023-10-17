package seedu.address.model.university;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.UniqueLocalCourseList;
import seedu.address.model.localcourse.exceptions.DuplicateLocalCourseException;
import seedu.address.model.localcourse.exceptions.LocalCourseNotFoundException;
import seedu.address.model.university.exceptions.UniversityNotFoundException;

public class UniqueUniversityList implements Iterable<University> {
    private final ObservableList<University> internalList = FXCollections.observableArrayList();
    private final ObservableList<University> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public boolean contains(University toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameUniversity);
    }

    public void remove(LocalCourse toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new UniversityNotFoundException();
        }
    }

    public void setUniversities(UniqueUniversityList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    public ObservableList<University> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<University> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UniqueUniversityList)) {
            return false;
        }

        UniqueUniversityList otherUniqueUniversity = (UniqueUniversityList) other;
        return internalList.equals(otherUniqueUniversity.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    /**
     * Returns true if {@code localCourses} contains only unique LocalCourses.
     */
    private boolean universitiesAreUnique(List<University> universities) {
        // Last element would be second to last
        for (int i = 0; i < universities.size() - 1; i++) {
            // Starts from i + 1, to last element
            for (int j = i + 1; j < universities.size(); j++) {
                if (universities.get(i).isSameUniversity(universities.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
