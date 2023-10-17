package seedu.address.model.partnercourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.partnercourse.exceptions.DuplicatePartnerCourseException;
import seedu.address.model.partnercourse.exceptions.PartnerCourseNotFoundException;

public class UniquePartnerCourseList implements Iterable<PartnerCourse> {
    private final ObservableList<PartnerCourse> internalList = FXCollections.observableArrayList();
    private final ObservableList<PartnerCourse> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalList);

    public boolean contains(PartnerCourse toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSamePartnerCourse);
        //why not equal?
    }

    public void add(PartnerCourse toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePartnerCourseException();
        }
        internalList.add(toAdd);
    }

    public void setPartnerCourse(PartnerCourse target, PartnerCourse editedPartnerCourse) {
        requireAllNonNull(target, editedPartnerCourse);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PartnerCourseNotFoundException();
        }

        if (!target.isSamePartnerCourse(editedPartnerCourse) && contains(editedPartnerCourse)) {
            throw new DuplicatePartnerCourseException();
        }

        internalList.set(index, editedPartnerCourse);
    }

    public void remove(PartnerCourse toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new PartnerCourseNotFoundException();
        }
    }

    public void setPartnerCourses(UniquePartnerCourseList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    public void setPartnerCourses(List<PartnerCourse> partnerCourses) {
        requireNonNull(partnerCourses);
        if (!partnerCoursesAreUnique(partnerCourses)) {
            throw new DuplicatePartnerCourseException();
        }

        internalList.setAll(partnerCourses);
    }

    public ObservableList<PartnerCourse> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<PartnerCourse> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof UniquePartnerCourseList)) {
            return false;
        }

        UniquePartnerCourseList otherUniquePartnerCourseList = (UniquePartnerCourseList) other;
        return internalList.equals(otherUniquePartnerCourseList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    private boolean partnerCoursesAreUnique(List<PartnerCourse> partnerCourses) {
        for (int i = 0; i < partnerCourses.size() - 1; i++) {
            for (int j = i + 1; j < partnerCourses.size(); j++) {
                if (partnerCourses.get(i).isSamePartnerCourse(partnerCourses.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

}
