---
  layout: default.md
    title: "Developer Guide"
    pageNav: 3
---

# SEPlendid Developer Guide

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

_{ list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well }_

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<puml src="diagrams/ArchitectureDiagram.puml" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.

### UI component

**API** : [`Ui.java`](https://github.com/AY2324S1-CS2103T-W10-2/tp/blob/master/src/main/java/seedu/address/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `ItemListPanel`, `ItemDetailPanel` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2324S1-CS2103T-W10-2/tp/blob/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2324S1-CS2103T-W10-2/tp/blob/master/src/main/resources/seplendidview/MainWindow.fxml)

The `UI` component,

* executes user commands using the `SeplendidLogic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `SeplendidLogic` component, because the `UI` relies on the `SeplendidLogic` to execute commands.
* depends on some classes in the `Model` component, as it displays `LocalCourse`, `PartnerCourse`, `University`, `Mapping`, and `Note` objects residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API call as an example.

<puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" />

<box type="info" seamless>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</box>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<puml src="diagrams/ModelClassDiagram.puml" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<box type="info" seamless>

**Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br>

<puml src="diagrams/BetterModelClassDiagram.puml" width="450" />

</box>


### Storage component

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="550" />

The `Storage` component,
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.
### Parser to handle both commands with and without arguments

The below diagram gives a high-level overview on how the `SeplendidParser` parses a command from our command set:
<puml src="diagrams/SeplendidParserActivityDiagram.puml" alt="SeplendidParserActivityDiagram" />

--------------------------------------------------------------------------------------------------------------------

### Mapping feature

The mapping `list/add/delete` mechanism is facilitated by `MappingCatalogue`. It stores `Mapping` objects which
contain the `LocalCode`, `UniversityName`, `PartnerCode` and `MappingMiscInformation` objects. This means that
`Mapping` is dependent on `LocalCourse`, `University` and `PartnerCourse` classes (and their respective
`LocalCourseCatalogue`, `UniversityCatalogue` and `PartnerCourseCatalogue`).

A `UniqueMappingList` is stored internally in `MappingCatalogue`, ensuring that  Additionally, it implements the
following operations (this list is not exhaustive):

* `MappingCatalogue#addMapping(Mapping)` — Adds a mapping to the mapping catalogue, and throws a
  `DuplicateMappingException` if the mapping already exists based on the primary key (`LocalCode`, `UniversityName`,
  `PartnerCode`).
* `MappingCatalogue#removeMapping(Mapping)` — Removes a mapping from the mapping catalogue, and throws a
  `MappingNotFoundException` if the mapping does not exist.
* `MappingCatalogue#hasMapping(Mapping)` — Checks whether a mapping exists in the mapping catalogue, to use to
* prevent duplicate insertion.
* `MappingCatalogue#hasMappingWithLocalCode(LocalCode)` — Checks whether a mapping with the specified `LocalCode`
  exists in the mapping catalogue, to use to prevent deleting a `LocalCourse` with such a `LocalCode`.
* `MappingCatalogue#hasMappingWithPartnerCode(PartnerCode)` — Checks whether a mapping with the specified
  `PartnerCode` exists in the mapping catalogue, to use to prevent deleting a `PartnerCourse` with such a `PartnerCode`.

These operations are exposed in the `SeplendidModel` interface as `SeplendidModel#addMapping(Mapping)`,
`SeplendidModel#deleteMapping(Mapping)`, `SeplendidModel#hasMapping(Mapping)`, `SeplendidModel#hasMapping(LocalCode,
UniversityName, PartnerCode)`,`SeplendidModel#hasMappingWithLocalCode(LocalCode)` and
`SeplendidModel#hasMappingWithPartnerCode(PartnerCode)` respectively.

When the user launches the application for the first time. All relevant data catalogues: `LocalCourseCatalogue`,
`PartnerCourseCatalogue`, `UniversityCatalogue`, `MappingCatalogue` are initialized with the initial state, containing
the seed data for that year's SEP.

Given below is an example usage scenario and how the `addMapping` mechanism works.

<puml src="diagrams/MappingAddSequenceDiagram.puml" alt="MappingAddSequenceDiagram" />

Before a mapping is added, the `MappingAddCommand` object will access the `SeplendidModel` instance to check if the
respective `LocalCourse`, `PartnerCourse` and `University` exists. If any of them does not exist, the command will
not execute `SeplendidModel#addMapping`.

<box type="info" seamless>

**Note:** If a command fails its execution, no `CommandResult` will be returned, and hence no update to the UI or
storage files.

</box>

<box type="info" seamless>

**Note:** The lifeline for `MappingAddCommand` should end at the destroy marker (X) but due to a limitation of
PlantUML, the lifeline reaches the end of diagram.

</box>

Similarly, the `MappingDeleteCommand` object will access the `SeplendidModel` instance to check if the mapping
exists, before deletion. Given below is an example usage scenario and how the `deleteMapping` mechanism works.

<puml src="diagrams/MappingDeleteSequenceDiagram.puml" alt="MappingDeleteSequenceDiagram" />

`MappingDeleteCommand` will call `SeplendidModel#getMessageIfExists` which returns an `Optional<Mapping>`. If it is
non-empty, the deletion will be performed, otherwise a `CommandException` will be thrown.

#### Design considerations:

**Aspect: How the dependency of `Mapping` on `LocalCourse`, `PartnerCourse` and `University` should be managed:**

* **Alternative 1 (implemented choice):** Disallow deletion of a `LocalCourse` or `PartnerCourse` if it exists in a
  mapping.
  * Note that `Unviersity` entries cannot be deleted as partner universities are fixed for every SEP application
    window.
  * Pros: Easy to implement, prevents accidental deletion.
  * Cons: May have to delete a large number of mappings to remove a course (no force deletion feature).

* **Alternative 2:** Deleting a `LocalCourse` or `PartnerCourse` will delete all its associated mappings.
  * Pros: Will use fewer actions to delete a course, if there exists mappings it is tied to.
  * Cons: We must ensure that deletion cascades, in order to maintain data integrity. This can introduce bugs if not
    done correctly.
--------------------------------------------------------------------------------------------------------------------
### Sorting feature
#### Implementation
#### Design considerations

**Aspect: Usage of enum class for attributes**

* **Alternative 1 (implemented choice)**: Use enum class for LocalCourse, PartnerCourse, and Mapping to store the attributes of each data types.
  * Pros: Easy to store constraint messages, easier to keep track of the attributes, can use for other commands such as ```search```.
  * Cons: Need to create new enum classes for each data types.
* **Alternative 2**: Use String to check
  * Pros: Don't need to create new enum classes
  * Cons: Hard to keep track of attributes of each data types.

### Sorting feature
#### Implementation
#### Design considerations

**Aspect: Usage of enum class for attributes**

* **Alternative 1 (implemented choice)**: Use enum class for LocalCourse, PartnerCourse, and Mapping to store the attributes of each data types.
  * Pros: Easy to store constraint messages, easier to keep track of the attributes, can use for other commands such as ```search```.
  * Cons: Need to create new enum classes for each data types.
* **Alternative 2**: Use String to check
  * Pros: Don't need to create new enum classes
  * Cons:

--------------------------------------------------------------------------------------------------------------------
### University Feature

The university `list/search/sort` mechanism is facilitated by `UniversityCatalogue`. It stores `University` objects
which contain the `UniversityName` object. This means that `University` is dependent on `University` class.

A `UniqueUniversityList` is stored internally in `UniversityCatalogue`. Additionally, it implements the following
operations:
- `UniversityCatalogue#hasUniversity(University)`  —  Checks whether a university exists in the university
  catalogue, to use to prevent duplicate insertion.
  .
  These operations are exposed in the `SeplendidModel` interface as `SeplendidModel#hasUniversity(University).

When the user launches the application for the first time. All relevant data catalogues: `UniversityCatalogue` are
initialised with the initial state, containing the seed data (list of partner universities) for SEP.

Given below is an examples usage scenario and how the `hasUniversity` mechanism works
[//]: # (I'll leave some of the ab3 implementation here so you can refer, please remove if you're the last person)

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</box>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

<puml src="diagrams/UndoRedoState4.puml" alt="UndoRedoState4" />

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

<puml src="diagrams/UndoRedoState5.puml" alt="UndoRedoState5" />

The following activity diagram summarizes what happens when a user executes a new command:

<puml src="diagrams/CommitActivityDiagram.puml" width="250" />

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Effort**

The implementation of SEPlendid proved to be a challenging endeavor. Below is the highlights of the extensive effort our
team dedicated to developing SEPlendid, along with a mention of some of the challenges we encountered along the way.

### Morphing of AB3 to SEPlendid

A large portion of code had to be refactored to morph AB3 to SEPlendid.

### Redesigning the UI

In recognising the significance of minimalism for achieving simplicity, we embarked on the task of redesigning the
original AB3 UI into our custom SEPlendid interface. The endeavor underscored the essential balance between simplicity
and functionality. The effort invested in the redesigning process was substantial, requiring meticulous design
considerations. Striving to meet both aesthetic standards and high functionality, we faced a steep learning curve with
JavaFX. Despite the initial challenges, our team persevered, overcoming obstacles and ultimately producing a UI that not
only met our design goals but also offered a visually appealing and highly functional experience tailored to the
requirements of a student exchange program mapping tool.

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

This product is for NUS Computing students who are applying for Student Exchange Programme (SEP), who prefer a
faster and more versatile tool to access SEP-related information, compared to the current EduRec system. Seniors who
had underwent the exchange program, or students who learn about courses through their research can also contribute
course mappings.

The following further describes our target users:
* has a need to view course mappings offered by partner universities
* is keen to contribute course mappings
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps


**Value proposition**
SEPlendid aims to provide an advanced search, allowing users to search for mappings by various attributes such
as partner universities' course names, and NUS course codes. We aim to also include features such as the ability to
contribute course mappings, and note-taking.

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​ | I want to …​                                                          | So that I can…​                                            |
|----------|---------|-----------------------------------------------------------------------|------------------------------------------------------------|
| `* * *`  | student | view the list of local courses offered by NUS                         | plan my study guide to map my local courses for exchange   |
| `* * *`  | student | view the list of partner courses offered by NUS' partner universities | plan my study guide to map to partner courses for exchange |
| `* * *`  | student | search a local course                                                 | find the local course I am interested to map               |
| `* * *`  | student | search a partner course                                               | find the partner course I am interested to map             |
| `* * *`  | student | search a university                                                   | find the university I am interested to exchange in         |
| `* * *`  | student | view the list of universities                                         | see what universities I am interested in                   |
| `* *`    | student | sort the list of local courses by coursename or coursecode            | easily review the local courses                            |
| `* *`    | student | sort the list of partner courses by coursename or coursecode          | easily review the partner courses                          |
| `* *`    | student | sort the list of universities alphabetically                          | easily review the universities                             |
| `* *`    | student | delete a local course                                                 | remove local courses that can no longer be mapped          |
| `* *`    | junior  | delete a partner course                                               | remove partner courses that can no longer be mapped        |
| `* *`    | student | delete a mapping                                                      | remove mappings that are obsolete                          |
| `* *`    | student | update a local course                                                 | update the mapping list based on new information           |
| `* * *`  | student | add notes                                                             | take note of the things I want to remember                 |
| `* *`    | student | view the list of my notes                                             | easily view my notes that I have taken                     |
| `* *`    | student | delete my notes                                                       | remove my note                                             |
| `* `     | student | update the list of my notes                                           | edit any mistakes or update new information                |
| `* `     | student | tag my notes                                                          | to organise my notes                                       |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `SEPlendid` and the **Actor** is the `user`, unless specified otherwise)

#### Local Course
**Use case: List local course**

**MSS**
1. User requests to list local courses.
2. SEPlendid shows all available local courses.
   Use case ends.

**Use case: Add a local course**

**MSS:**
1. User requests to add a local course.
2. SEPlendid adds and shows the local course.
   Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The local course is already added.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: Delete a local course**

**MSS:**
1. User requests to delete a local course.
2. SEPlendid deletes and shows the local course deleted.
   Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The local course does not exist.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: Sorts local course**

**MSS:**
1. User requests to sort the list of local courses.
2. SEPlendid sorts and shows sorted list of all available local courses.

Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.

#### Partner course
**Use case: List partner course**

**MSS:**
1. User requests to list partner courses.
2. SEPlendid shows all available partner courses.
   Use case ends.

**Use case: Add a partner course**

**MSS:**
1. User requests to add a partner course.
2. SEPlendid adds and shows the partner course.
   Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The partner course is already added.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: Delete a partner course**

**MSS:**
1. User requests to delete a partner course.
2. SEPlendid deletes and shows the partner course deleted.

Use case ends.

**Use case: Sorts partner course**

**MSS:**
1. User requests to sort the list of partner courses.
2. SEPlendid sorts and shows sorted list of all available partner courses.

Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The partner course does not exist.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: Sorts partner course**

**MSS:**
1. User requests to sort the list of partner courses.
2. SEPlendid sorts and shows sorted list of all available partner courses.

Use case ends.

**Extension:**
* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.


#### Mapping
**Use case: List mappings**

**MSS:**
1. User requests to list available mappings.
2. SEPlendid shows all available mappings.

3. Use case ends.

**Use case: Add mappings**

**MSS:**
1. User requests to add a mapping.
2. SEPlendid adds and show the mappings.

Use case ends.

**Extension:**

* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The mappingis already added.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: Delete mappings**

**MSS:**
1. User requests to delete a mapping.
2. SEPlendid deletes and shows the mappings deleted.

Use case ends.

**Extension:**

* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.
* 1b. The mappings does not exist.
  * 1b1. SEPlendid shows an error message.

  Use case resumes at step 1.


#### Universities

**Use case: List universities**

**MSS:**

1. User requests to list the universities.
2. SEPlendid shows all available universities.

Use case ends.

**Use case: Search universities**

**MSS:**

1. User requests to search for a university.
2. SEPlendid shows the specified university.

Use case ends.

**Use case: Sort universities**

**MSS:**
1. User requests to sort the list of universities.
2. SEPlendid shows the universities sorted alphabetically.

Use case ends.

#### Note

**Use case: Add a note**

**MSS**

1. User requests to add a note.
2. SEPlendid adds and shows the note.

Use case ends

**Extension:**

* 1a. The command format is invalid.
  * 1a1. SEPlendid shows an error message.

  Use case resumes at step 1.

**Use case: List notes**

**MSS**

1. User requests to list notes.
2. SEPlendid shows all available notes.

Use case ends

**Use case: Update a note**

**MSS**

1. User requests to list notes.
2. SEPlendid shows all available notes.
3. User requests to update a specific note in the list
4. SEPlendid updates and shows the note.

Use case ends

**Extension:**

* 2a. The list is empty.
  Use case ends.

* 3a. The command format is invalid.
  * 3a1. SEPlendid shows an error message.

    Use case resumes at step 2.
* 3b. The task does not exist.
  * 3b1. SEPlendid shows an error message.

  Use case resumes at step 2.

**Use case: Delete a note**

**MSS**

1. User requests to list notes.
2. SEPlendid shows all available notes.
3. User requests to delete a specific note in the list
4. SEPlendid deletes the note.

Use case ends

**Extension:**

* 2a. The list is empty.

Use case ends.
* 3a. The command format is invalid.
  * 3a1. SEPlendid shows an error message.

  Use case resumes at step 2.
* 3b. The task does not exist.
  * 3b1. SEPlendid shows an error message.

  Use case resumes at step 2.

**Use case: Tag a note**

**MSS**

1. User requests to list notes.
2. SEPlendid shows all available notes.
3. User requests to tag a specific note in the list
4. SEPlendid tags and shows the note.

Use case ends

**Extension:**

* 2a. The list is empty.

  Use case ends.

* 3a. The command format is invalid.
  * 3a1. SEPlendid shows an error message.

  Use case resumes at step 2.
* 3b. The task does not exist.
  * 3b1. SEPlendid shows an error message.

  Use case resumes at step 2.


### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 course mappings, along with its dependent data such as local courses, without a
    noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands)
    should be able to accomplish most of the tasks faster using commands than using the mouse.
4.  The response to any use action should become visible within 5 seconds.
5.  The user interface should be intuitive enough for users who are not IT-savvy.
6.  The application should be designed to handle a growing database of course mappings and related data.

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X.
* **Course Mapping**: A course offered by a partner university, which NUS Computing students going on exchange can
  take, and is an equivalent course to one offered in NUS.
* **CLI**: Command-Line Interface is a means of interacting with a computer program b inputting lines of text called
  command-lines.

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

This section provides you with instructions on how to test the app manually.

<box type="info" seamless>

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</box>

### Launch and shutdown

1. Initial launch

  1. Download the jar file and copy into an empty folder

  1. Double-click the jar file <br>
     Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

### Local Course

#### List all local courses

Prerequisite: 
- There is at least 1 local course stored in SEPlendid.

`localcourse list`

Expected Output: All local courses stored in SEPlendid will be shown in the Item List Box.

Expected Output in the Command Output Box: Listed all local courses

<box type="info" seamless>

**Note:** If there is no local course, the item list box will just be an empty box.

</box> 

#### Add a local course

`localcourse add [CS1111] [Test module] [4] [test]`

Expected Output: The new local course will be added to the list of local courses.

Expected Output in the Command Output Box: New local course added message.

`localcourse add [test]`

Expected Output in the Command Output Box: Error for invalid command format.

#### Delete a local course

Prerequisite: 
- A local course with local code of `CS1111` currently exists in the local course list.
- The local course specified should not be present in any of the current mappings.

`localcourse delete [CS1111]`

Expected Output: The local course will be deleted from the list of local courses.

Expected Output in the Command Output Box: Local course deleted message.

#### Update a local course

Prerequisites: 
- A local course with local code of `BT1101` currently exists in the local course list.

`localcourse update [BT1101] [unit] [3]`

Expected Output: The specified local course will be updated.

Expected Output in the Command Output Box: Local course updated message.

#### Search a local course by attributes

Prerequisite:
- There is at least 1 local course that have a localcode that contains the word `cs` stored in SEPlendid.

`localcourse search [localcode] [cs]`

Expected Output: A list of local courses that have a localcode of `cs`.

Expected Output in the Command Output Box: Local course searched message.

Prerequisite:
- There is no local course that have a localcode that contains the letter `z` stored in SEPlendid.

`localcourse search [localcode] [z]`

Expected Output: No result.

Expected Output in the Command Output Box: Local course searched message.

<box type="info" seamless>

**Note:** The query cannot start with a number. It must start with an alphabet.

</box> 

#### Sort local courses by attributes

Prerequisite:
- There is at least 1 local course stored in SEPlendid.

`localcourse sort [localname]`

Expected Output: All local courses stored in SEPlendid will be shown in the Item List Box sorted according to the localname in ascending order.

Expected Output in the Command Output Box: Sorted all local courses 

<box type="info" seamless>

**Note:** If there is no local course, the item list box will just be an empty box.

</box> 

### Partner Course

#### List all partner courses

Prerequisite: 
- There is at least 1 partner course stored in SEPlendid.

`partnercourse list`

Expected Output: All partner courses stored in SEPlendid will be shown in the Item List Box.

Expected Output in the Command Output Box: Listed all partner courses

<box type="info" seamless>

**Note:** If there is no partner course, the item list box will just be an empty box.

</box> 

#### Add a partner course

Prerequisite: 
- The university of the partner course should be added to the university list.

`partnercourse add [The Hong Kong Polytechnic University] [CS1111] [Test module] [4] [test]`

Expected Output: The new partner course will be added to the list of partner courses.

Expected Output in the Command Output Box: New partner course added message.

`partnercourse add [University of] [test]`

Expected Output in the Command Output Box: Error for invalid command format.

#### Delete a partner course

Prerequisite: 
- A partner course with partner code of `CS1111` and university of `The Hong Kong Polytechnic University` currently exists in the partner course list.
- The partner course specified should not be present in any of the current mappings.

`partnercourse delete [The Hong Kong Polytechnic University] [CS1111]`

Expected Output: The partner course will be deleted from the list of partner courses.

Expected Output in the Command Output Box: Partner course deleted message.

#### Update a partner course

Prerequisites:
- A partner course with partner code of `CSE469` and university of `Arizona State University` currently exists in the partner course list.

`partnercourse update [Arizona State University] [CSE469] [unit] [1]`

Expected Output: The specified partner course will be updated.

Expected Output in the Command Output Box: Partner course updated message.

#### Search a partner course by attributes

Prerequisite:
- There is at least 1 partner course that have a partnercode that contains the word `cs` stored in SEPlendid.

`partnercourse search [partnercode] [cs]`

Expected Output: A list of partner courses that have a partnercode of `cs`.

Expected Output in the Command Output Box: Partner course searched message.

Prerequisite:
- There is no partner course that have a partnercode that contains the letter `zz` stored in SEPlendid.

`partnercourse search [partnercode] [zz]`

Expected Output: No result.

Expected Output in the Command Output Box: Partner course searched message.

<box type="info" seamless>

**Note:** The query cannot start with a number. It must start with an alphabet.

</box> 

#### Sort partner courses by attributes

Prerequisite:
- There is at least 1 partner course stored in SEPlendid.

`partnercourse sort [university]`

Expected Output: All partner courses stored in SEPlendid will be shown in the Item List Box sorted according to the university in ascending order.

Expected Output in the Command Output Box: Sorted all partner courses

<box type="info" seamless>

**Note:** If there is no partner course, the item list box will just be an empty box.

</box> 

### University

#### List all universities

Prerequisite: 
- There is at least 1 university stored in SEPlendid.

`university list`

Expected Output: All universities stored in SEPlendid will be shown in the Item List Box.

Expected Output in the Command Output Box: Listed all universities

<box type="info" seamless>

**Note:** If there is no university, the item list box will just be an empty box.

</box> 

#### Search a university by attributes

Prerequisite:
- There is at least 1 university that have a name that contains the word `hong kong` stored in SEPlendid.

`university search [hong kong]`

Expected Output: A list of universities that have a name that contains `hong kong`.

Expected Output in the Command Output Box: University searched message.

Prerequisite:
- There is no university that have a name that contains the word `hk` stored in SEPlendid.

`university search [hk]`

Expected Output: No result.

Expected Output in the Command Output Box: University searched message.

#### Sort universities

Prerequisite:
- There is at least 1 university stored in SEPlendid.

`university sort`

Expected Output: All universities stored in SEPlendid will be shown in the Item List Box sorted according to the name in ascending order.

Expected Output in the Command Output Box: Sorted all universities

<box type="info" seamless>

**Note:** If there is no university, the item list box will just be an empty box.

</box> 

### Mapping

#### List all mappings

Prerequisite: 
- There is at least 1 mapping stored in SEPlendid.

`mapping list`

Expected Output: All mappings stored in SEPlendid will be shown in the Item List Box.

Expected Output in the Command Output Box: Listed all mappings

<box type="info" seamless>

**Note:** If there is no mapping, the item list box will just be an empty box.

</box> 

#### Add a mapping

Prerequisite: 
- The university of the partner course should be added to the university list.
- The local course with local code specified should be added to the local course list.
- The partner course with partner code specified should be added to the partner course list.

`mapping add [CS3230] [Arizona State University] [CSE469] [mapping]`

Expected Output: The new mapping will be added to the list of mappings.

Expected Output in the Command Output Box: New mapping added message.

`mapping add [University of] [test]`

Expected Output in the Command Output Box: Error for invalid command format.

#### Delete a mapping

Prerequisite:
- A mapping with local code of `CS3244`, partner code of `CSE494` and university of `Arizona State University` currently exists in the mapping list.

`mapping delete [CS3244] [Arizona State University] [CSE494]`

Expected Output: The mapping will be deleted from the list of mappings.

Expected Output in the Command Output Box: Mapping deleted message.

#### Search a mapping by attributes

Prerequisite:
- There is at least 1 mapping that have a localcode that contains the word `cs3230` stored in SEPlendid.

`mapping search [localcode] [cs3230]`

Expected Output: A list of mappings that have a localcode that contains the word `cs3230`.

Expected Output in the Command Output Box: Mapping searched message.

Prerequisite:
- There is no mapping that have a localcode that contains the word `z` stored in SEPlendid.

`mapping search [localcode] [z]`

Expected Output: No result.

Expected Output in the Command Output Box: Mapping searched message.

#### Sort mappings by attributes

Prerequisite:
- There is at least 1 mapping stored in SEPlendid.

`mapping sort [localcode]`

Expected Output: All mappings stored in SEPlendid will be shown in the Item List Box sorted according to the localcode in ascending order.

Expected Output in the Command Output Box: Sorted all mappings

<box type="info" seamless>

**Note:** If there is no mapping, the item list box will just be an empty box.

</box> 


### Note

#### List all notes

Prerequisite: There is at least 1 note stored in SEPlendid.

`note list`

Expected Output: All notes stored in SEPlendid will be shown in the Item List Box.

Expected Output in the Command Output Box: Listed all notes

<box type="info" seamless>

**Note:** If there is no note, the item list box will just be an empty box.

</box> 

#### Add a note

`note add [This is the content of the note] [tag]`

Expected Output: The new note will be added to the list of notes.

Expected Output in the Command Output Box: New note added message.

`note add [This note cannot be added] [test_]`

Expected Output in the Command Output Box: Error for invalid command format.

<box type="info" seamless>

**Note:** Note tag should consist of only alphanumeric characters and should not contain any whitespaces.

</box> 

#### Delete a note

Prerequisite:
- A note with index 1 currently exists in the note list. 

`note delete [1]`

Expected Output: The note will be deleted from the list of notes.

Expected Output in the Command Output Box: Note deleted message.

#### Update a note

Prerequisite:
- A note with index 1 currently exists in the note list.

`note update [1] [The new content]`

Expected Output: The specified note will be updated.

Expected Output in the Command Output Box: Note updated message.

#### Tag a note

Prerequisite:
- A note with index 1 currently exists in the note list.

`note tag [1] [newtag]`

Expected Output: The specified note will be updated.

Expected Output in the Command Output Box: Note tagged message.

<box type="info" seamless>

**Note:** Note tag should consist of only alphanumeric characters and should not contain any whitespaces.

</box> 

#### Clear tag a note

Prerequisite:
- A note with index 1 currently exists in the note list.

`note cleartag [1]`

Expected Output: The specified note will be updated.

Expected Output in the Command Output Box: Note cleartag message.

#### Search a note by tag

Prerequisite:
- There is at least 1 note that have a tag that contains the word `tag` stored in SEPlendid.

`note search [tag]`

Expected Output: A list of notes that have a tag that contains `tag`.

Expected Output in the Command Output Box: Note searched message.

Prerequisite:
- There is no note that have a tag that contains the word `test` stored in SEPlendid.

`note search [test]`

Expected Output: No result.

Expected Output in the Command Output Box: Note searched message.

<box type="info" seamless>

**Note:** The query should consist of only alphanumeric characters and should not contain any whitespaces.

</box>
