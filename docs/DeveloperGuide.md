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

_{ list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the
original source as well }_

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

**`Main`** (consisting of
classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java)
and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is
in charge of the app launch and shut down.

* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues
the command `delete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding
  API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using
the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component
through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the
implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified
in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The UI consists of a `MainWindow` that is made up of parts
e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`,
inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the
visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that
are in the `src/main/resources/view` folder. For example, the layout of
the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java)
is specified
in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**API
** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API
call as an example.

<puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" />

<box type="info" seamless>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of
PlantUML, the lifeline reaches the end of diagram.
</box>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates
   a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which
   is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:

* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a
  placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse
  the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as
  a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser`
  interface so that they can be treated similarly where possible e.g, during testing.

### Model component

**API
** : [`SeplendidModel.java`](https://github.com/AY2324S1-CS2103T-W10-2/tp/blob/master/src/main/java/seedu/address/model/SeplendidModel.java)

<puml src="diagrams/ModelClassDiagram.puml" width="100%" />


The `SeplendidModel` component,

* stores the local course, partner course, university, mapping and note data. `SeplendidModelManager` also serves as
  the facade class, for other components to access the data. It stores all the data, which the UI can access to
  display. Commands also take in the `SeplendidModel` object to perform their operations on the data.
* Local course are represented by `LocalCourse` objects, which are stored in a `UniqueLocalCourseList` object. Each
  `LocalCourse` has `LocalCode`, `LocalName`, `LocalDescription` and `LocalUnit` objects. `PartnerCourse` follows
  similarly, and `Mapping` depends on `LocalCode`, `PartnerCode` and `UniversityName` objects (on top of its own
  `MappingMiscInformation`).
* stores the currently 'searched for' `LocalCourse`, `PartnerCourse`, `University`, `Mapping` objects as separate
  filtered lists, exposed to outsiders as unmodifiable `ObservableList<LocalCourse>`, `ObservableList<PartnerCourse>`,
  `ObservableList<University>` and `ObservableList<Mapping>` objects respectively (e.g. the UI can be bound to one of
  these lists so that the UI automatically updates when the data in the list changes).
* does not depend on any of the other three components (as the `SeplendidModel` represents data entities of the domain,
  they should make sense on their own without depending on other components)

### Storage component

**API
** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="100%" />

The `Storage` component,

* can save local course, partner course, university, mapping, note data and user preference data in JSON format, and
  read them back into corresponding objects.
* inherits from both `LocalCourseStorage`, `PartnerCourseCatalogueStorage`, `UniversityCatalogueStorage`,
  `MappingCatalogueStorage`, `NoteCatalogueStorage` and `UserPrefStorage`
  , which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `SeplendidModel` component (because the `Storage` component's job is to save/retrieve
  objects that belong to the `SeplendidModel`).

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

A `UniqueMappingList` is stored internally in `MappingCatalogue`, ensuring that Additionally, it implements the
following operations (this list is not exhaustive):

* `MappingCatalogue#addMapping(Mapping)`— Adds a mapping to the mapping catalogue, and throws a
  `DuplicateMappingException` if the mapping already exists based on the primary key (`LocalCode`, `UniversityName`,
  `PartnerCode`).
* `MappingCatalogue#removeMapping(Mapping)`— Removes a mapping from the mapping catalogue, and throws a
  `MappingNotFoundException` if the mapping does not exist.
* `MappingCatalogue#hasMapping(Mapping)`— Checks whether a mapping exists in the mapping catalogue, to use to
* prevent duplicate insertion.
* `MappingCatalogue#hasMappingWithLocalCode(LocalCode)`— Checks whether a mapping with the specified `LocalCode`
  exists in the mapping catalogue, to use to prevent deleting a `LocalCourse` with such a `LocalCode`.
* `MappingCatalogue#hasMappingWithPartnerCode(PartnerCode)`— Checks whether a mapping with the specified
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

* **Alternative 1 (implemented choice)**: Use enum class for LocalCourse, PartnerCourse, and Mapping to store the
  attributes of each data types.
    * Pros: Easy to store constraint messages, easier to keep track of the attributes, can use for other commands such
      as ```search```.
    * Cons: Need to create new enum classes for each data types.
* **Alternative 2**: Use String to check
    * Pros: Don't need to create new enum classes
    * Cons: Hard to keep track of attributes of each data types.

### Sorting feature

#### Implementation

#### Design considerations

**Aspect: Usage of enum class for attributes**

* **Alternative 1 (implemented choice)**: Use enum class for LocalCourse, PartnerCourse, and Mapping to store the
  attributes of each data types.
    * Pros: Easy to store constraint messages, easier to keep track of the attributes, can use for other commands such
      as ```search```.
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

- `UniversityCatalogue#hasUniversity(University)`— Checks whether a university exists in the university
  catalogue, to use to prevent duplicate insertion.
  .
  These operations are exposed in the `SeplendidModel` interface as `SeplendidModel#hasUniversity(University).

When the user launches the application for the first time. All relevant data catalogues: `UniversityCatalogue` are
initialised with the initial state, containing the seed data (list of partner universities) for SEP.

Given below is an examples usage scenario and how the `hasUniversity` mechanism works
[//]: # (I'll leave some of the ab3 implementation here so you can refer, please remove if you're the last person)

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once
to the right, pointing to the previously undone state, and restores the address book to that state.

<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address
book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()`
to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</box>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such
as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`.
Thus, the `addressBookStateList` remains unchanged.

<puml src="diagrams/UndoRedoState4.puml" alt="UndoRedoState4" />

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not
pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be
purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern
desktop applications follow.

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
| `* * *`  | student | view the list of mappings in SEPlendid                                | consider existing mappings for my exchange study plan      |
| `* * *`  | student | add a mapping                                                         | to keep track of new mappings I discovered                 |
| `* *`    | student | delete a mapping                                                      | remove mappings that are obsolete                          |
| `* *`    | student | search for a mapping based on the code of the local/partner course    | find the universities offering the course based on code    |
| `* *`    | student | search for a mapping based on the name of the local/partner course    | find the universities offering the course based on name    |
| `* *`    | student | search for a mapping based on the name of a university                | find the courses mappings offered by a partner university  |
| `*`      | student | sort the list of mappings based on any attribute                      | easily review the mappings                                 |
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
   Use case ends.

**Extension:**

* 1a. Afterwards, the user can choose to bring up a detail panel of a mapping.
    * 1a1. User clicks on a mapping item in the list.
    * 1a2. SEPlendid shows the corresponding detail panel of the clicked-on mapping.
      Use case ends.

**Use case: Add mappings**

**MSS:**

1. User requests to add a mapping.
2. SEPlendid adds and show the mappings.

Use case ends.

**Extension:**

* 1a. The command format is invalid.
    * 1a1. SEPlendid shows an error message.
      Use case resumes at step 1.

* 1b. The mapping is already added.
    * 1b1. SEPlendid shows an error message.
      Use case resumes at step 1.

* 1c. A local course or partner course specified by user for the mapping does not exist.
    * 1c1. SEPlendid informs the user through an error message that the course does not exist.
      Use case ends resumes at step 1.

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

**Use case: Sort mappings** \
Actor: User \
**MSS:**

1. User requests to sort the list of mappings based on an attribute.
2. SEPlendid sorts and shows sorted list of all available mappings, based on specified attribute. \
   Use case ends.

**Extension:**

* 1a. The mapping command format is invalid.
    * 1a1. SEPlendid shows an error message, detailing the mapping command set. \
      Use case resumes at step 1.

* 1b. The mapping attribute specified is invalid.
    * 1b1. SEPlendid shows an error message, detailing what attributes are available for sorting. \
      Use case resumes at step 1.

* 2a. Afterwards, the user can choose to bring up a detail panel of a mapping.
    * 2a1. User clicks on a mapping item in the list.
    * 2a2. SEPlendid shows the corresponding detail panel of the clicked-on mapping. \
      Use case ends.

**Use case: Search mappings** \
Actor: User \
**MSS:**

1. User requests to search the list of mappings based on an attribute, and given query.
2. SEPlendid searches and shows sorted list of all available mappings, each which has a value for the specified
   attribute that contains the query. \
   Use case ends.

**Extension:**

* 1a. The mapping command format is invalid.
    * 1a1. SEPlendid shows an error message, detailing the mapping command set. \
      Use case resumes at step 1.

* 1b. The mapping attribute specified is invalid.
    * 1b1. SEPlendid shows an error message, detailing what attributes are available for sorting. \
      Use case resumes at step 1.

* 1c. The query is empty.
    * 1c1. SEPlendid shows an error message, detailing that the mapping command format. \
      Use case resumes at step 1.

* 2a. Afterwards, the user can choose to bring up a detail panel of a mapping.
    * 2a1. User clicks on a mapping item in the list.
    * 2a2. SEPlendid shows the corresponding detail panel of the clicked-on mapping. \
      Use case ends.

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

1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 course mappings, along with its dependent data such as local courses, without a
   noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands)
   should be able to accomplish most of the tasks faster using commands than using the mouse.
4. The response to any use action should become visible within 5 seconds.
5. The user interface should be intuitive enough for users who are not IT-savvy.
6. The application should be designed to handle a growing database of course mappings and related data.

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X.
* **Course Mapping**: A course offered by a partner university, which NUS Computing students going on exchange can
  take, and is an equivalent course to one offered in NUS.
* **CLI**: Command-Line Interface is a means of interacting with a computer program b inputting lines of text called
  command-lines.

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<box type="info" seamless>

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</box>

### Launch and shutdown

1. Initial launch

    1. Download the jar file and copy into an empty folder

    1. Double-click the jar file Expected: Shows the GUI with a set of sample courses. The window size may not be
       optimum.

### Adding and delete a mapping

1. Add a mapping while all mappings are being shown)

    1. Prerequisites: List all mappings using the `mapping list` command. Multiple mappings in the list.

    1. Ensure your scroll to the bottom.

    1. Test case: `mapping add [IS4231] [Lund University] [INFC40] [Sem 1 only.]`<br>
       Expected: A new mapping is added, and will appear at the bottom of the list.

    1. Test case: `mapping delete [IS4231] [Lund University] [INFC40] [Sem 1 only.]`<br>
       Expected: The mapping is deleted, and disappears from the list.

    1. Other incorrect delete commands to try: `mapping ad`, `mapping add []`, `...` <br>
       Expected: An error message will appear.

### Saving data

1. Dealing with missing/corrupted data files

- If any of the `.json` files found under the `data/` directory created is edited to have invalid data. SEPlendid
  will reset to the default data, which has been programmatically added.
- Therefore, it is recommended to make a copy and keep a backup of existing data before making any changes to any of
  the files under `data/*.json`.
- One corrupted file will lead to a full reset of the application.

2. To simulate a missing/corrupted data file, delete the `data/` directory.

- A new director will be created in its place, with the default seed data.
- To corrupt the data, open any of the `.json` files under `data/` and edit the data in it. For instance, you may
  change a `localCode` to the empty string `""`. Restart the application, and observe that the data has been reset.

## Effort

### Morphing of AB3 to SEPlendid

As mappings was the core feature of SEPlendid, we decided to morph AB3 into SEPlendid. We identified the need for
several data types, minimally `LocalCourse`, `PartnerCourse`, `University` and `Mapping`. We also identified the
unique identifiers for each data type, and the relationships between them. For instance, a `Mapping` object has a
`LocalCode`, `PartnerCode` and `UniversityName` object. `LocalCode` is the unique identifier (or in database terms,
the primary key) of `LocalCourse`, and {`PartnerCode`, `UniversityName`} is the unique identifier of `PartnerCourse`.
As the `Mapping` object is dependent on `LocalCourse`, `PartnerCourse` and `University`, we decided to decouple
these data storages, to avoid data redundancy and inconsistency. Initially, AB3 only offered 1 data storage, which
is the address book and this led us to refactor a large portion of the codebase to accommodate the new data types.
A new parser implementation was also required to handle the new command format.

One challenge we encountered was the need to access model for other data, such as `LocalName` of `LocalCourse`,
which is not part of the unique identifier, for the purpose of searching and sorting. `Mapping` did not consist of a
`LocalName` object, as it would lead to data redundancy. This challenge was solved with passing only the method
reference of a model method `getLocalCourseIfExists` to the comparators and predicates used. This follows for
partner courses.
 
