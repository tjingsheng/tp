---
 layout: default.md
   title: "User Guide"
   pageNav: 3
---

<bottom-head>
    <link rel="stylesheet" href="stylesheets/userguide.css">
</bottom-head>

# SEPlendid User Guide

## About SEPlendid

SEPlendid is designed as a **Course Mapping System** specifically for you, NUS Computing students. It empowers you to
seamlessly plan for your overseas courses, making the highly coveted Student Exchange Program (SEP) hassle-free. With
SEPlendid, you can effortlessly view and find course mappings without the need for complex Excel sheets.

Take advantage of SEPlendid's **course mapping** function to quickly discover possible mappings for the courses you want
to explore during your overseas studies. This feature is tailored to make your planning process smoother and more
user-friendly.

Additionally, utilise SEPlendid's **note-taking system** to effortlessly organise crucial information for planning your
courses. It's here to assist you in keeping track of all the important details you'll need for a successful SEP
application.

This user guide has been crafted to provide you with comprehensive documentation on how you can streamline your
application process for SEP. So, dive in and let SEPlendid be your guide as you embark on this exciting journey!

This user guide bring you:

- Easy-to-follow **Step-by-Step** instructions for launching SEPlendid
- A comprehensive overview of **SEPlendid's** myriad of features and commands
- Essential **Key Instructions** to run SEPlendid smoothly

If you are a new user, please head over to  [How to navigate this User Guide?](#1-how-to-navigate-this-user-guide) to
start planning for your SEP study guide!

<br> 

--------------------------------------------------------------------------------------------------------------------

## Table of Contents

<div class= "toc">

1. [How to navigate this User Guide?](#1-how-to-navigate-this-user-guide)
2. [Icons used in this User Guide](#2-icons-used-in-this-user-guide)
3. [Installation](#3-installation)
4. [Quick Reference Guide](#4-quick-reference-guide)
    - 4.1 [Graphical User Interface (GUI)](#41-graphical-user-interface-gui)
    - 4.2 [Command format](#42-command-format)
    - 4.3 [Your first command](#43-your-first-command)
5. [Commands](#5-commands)
    - 5.1 [Commands for local courses](#51-commands-for-local-courses)
        - 5.1.1 [List all local courses: `localcourse list`](#511-list-all-local-courses-localcourse-list)
        - 5.1.2 [Add a local course: `localcourse add`](#512-add-a-local-course-localcourse-add)
        - 5.1.3 [Delete a local course: `localcourse delete`](#513-delete-a-local-course-localcourse-delete)
        - 5.1.4 [Update a local course: `localcourse update`](#514-update-a-local-course-localcourse-update)
        - 5.1.5 [Search for a local course by an attribute: `localcourse search`](#515-search-for-a-local-course-by-an-attribute-localcourse-search)
        - 5.1.6 [Sort all local courses by an attribute: `localcourse sort`](#516-sort-all-local-courses-by-an-attribute-localcourse-sort)
    - 5.2 [Commands for partner courses](#52-commands-for-partner-courses)
        - 5.2.1 [List all partner courses: `partnercourse list`](#521-list-all-partner-courses-partnercourse-list)
        - 5.2.2 [Add a partner course: `partnercourse add`](#522-add-a-partner-course-partnercourse-add)
        - 5.2.3 [Delete a partner course: `partnercourse delete`](#523-delete-a-partner-course-partnercourse-delete)
        - 5.2.4 [Update a partner course: `partnercourse update`](#524-update-a-partner-course-partnercourse-update)
        - 5.2.5 [Search for a partner course by an attribute: `partnercourse search`](#525-search-for-a-partner-course-by-an-attribute-partnercourse-search)
      - 5.2.6 [Sort all partner courses by an attribute: `partnercourse sort`](#526-sort-all-partner-courses-by-an-attribute-partnercourse-sort)
    - 5.3 [Commands for universities](#53-commands-for-universities)
        - 5.3.1 [List all universities: `university list`](#531-list-all-universities-university-list)
        - 5.3.2 [Search for a university by an attribute: `university search`](#532-search-for-a-university-by-an-attribute-university-search)
      - 5.3.3 [Sort all universities by an attribute: `university sort`](#533-sort-all-universities-by-an-attribute-university-sort)
    - 5.4 [Commands for mappings](#54-commands-for-mappings)
        - 5.4.1 [List all mappings: `mapping list`](#541-list-all-mappings-mapping-list)
        - 5.4.2 [Add a mapping: `mapping add`](#542-add-a-mapping-mapping-add)
        - 5.4.3 [Delete a mapping: `mapping delete`](#543-delete-a-mapping-mapping-delete)
        - 5.4.4 [Search for a mapping by an attribute: `mapping search`](#544-search-a-mapping-by-attributes-mapping-search)
        - 5.4.5 [Sort all mappings by an attribute: `mapping sort`](#545-sort-a-mapping-by-attributes-mapping-sort)
    - 5.5 [Commands for notes](#55-commands-for-notes)
        - 5.5.1 [List all notes: `note list`](#551-list-all-notes-note-list)
        - 5.5.2 [Add a note: `note add`](#552-add-a-note-note-add)
        - 5.5.3 [Delete a note: `note delete`](#553-delete-a-note-note-delete)
        - 5.5.4 [Update a note: `note update`](#554-update-a-note-note-update)
        - 5.5.5 [Tag a note: `note tag`](#555-tag-a-note-note-tag)
        - 5.5.6 [Clear all tags from a note: `note cleartag`](#556-clear-all-tags-in-a-note-note-cleartag)
    - 5.6 [View help : `help`](#56-view-help--help)
    - 5.7 [Exit SEPlendid: `exit`](#57-exit-seplendid--exit)
    - 5.8 [Save the data](#58-save-the-data)
6. [FAQ](#6-faq)
7. [Command summary](#7-command-summary)

</div>
<br>
<br>
--------------------------------------------------------------------------------------------------------------------

## 1. How to navigate this User Guide?

As a new user in SEPlendid, this user guide serves as an easy-to-follow guide, guiding you through the execution of your
first commands in SEPlendid. You can unlock SEPlendid full potential in this guide!

Here is a step-by-step instruction for you to navigate the user guide:

1. Download SEPlendid in your device by heading over to the [Installation](#3-installation) section.
2. Quickly familarise yourself with SEPlendid by heading over to the [Quick Reference Guide](#4-quick-reference-guide)
   section.

If you are an **experienced** user, you can head over to the [Command summary](#7-command-summary) section for a
well-curated overview of the commands available in SEPlendid.

<br>
<br>

## 2. Icons used in this User Guide

Throughout this guide, icons are used to highlight important information, so do pay **special** attention to them:

| Icon                      | Meaning                                  |
|---------------------------|------------------------------------------|
| :information_source: Info | Information you should keep in mind      | 
| :bulb: Tip                | Information you might find useful        |
| :exclamation: Warning     | Information you should be cautious about | 

<br>
<br>

## 3. Installation

1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest `seplendid.jar` from [here](https://github.com/AY2324S1-CS2103T-W10-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for SEPlendid.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar seplendid.jar`
   command to run SEPlendid.
   <box type="info" seamless>
   SEPlendid's GUI will appear on your screen in a few seconds. SEPlendid is preloaded with a large sample data of for
   you to start planning for your SEP immediately.
   </box>
    <div class="centered-container">
      <img src="images/StartupWindowUI.png" alt="UI" class="resized-image">
    </div>
    <div class = "centered-content" >
      <p class = "image-caption"> Figure 1.1 Shows the SEPlendid's GUI upon opening.
    </div>

5. Type the command in the command box and press Enter to execute it. For example, typing **`help`** and pressing Enter
   will open the help window.<br>
   Some example commands you can try:

    * `university list`: Lists all of NUS' partner universities.

    * `mapping search [localcode] [CS2103]`: Searches and displays all NUS-to-partner university course mappings
      with the local code `CS2103`.

    * `exit`: Exits SEPlendid.

6. If you are an experienced user, refer to the [Commands](#5-commands) below for more details of each feature and
   command.

<br>
<br>

--------------------------------------------------------------------------------------------------------------------

## 4. Quick Reference Guide

This section covers important information for you to utilise SEPlendid to its fullest capacity. You will learn how to
navigate SEPlendid effectively and the commands section will cover on how you can run essential features on SEPlendid.

<br>
<br>

### 4.1 Graphical User Interface (GUI)

SEPlendid's GUI is designed to provide you with great visual feedback and user experience. SEPlendid's GUI allows you to
click and view the different courses which provides an in-depth insight about the course such as the course units and
description. Let's now take a look at the different components available in SEPlendid's GUI.

SEPlendid's GUI consists of these four main components:

1. Command Input Box
2. Command Result Box
3. List Panel for the list of local courses, partner courses, universities, mappings or notes
4. Display Panel for details of the selected item from the list panel.

Refer to the annotated diagram of SEPlendid's GUI which is annotated respectively:

<div class="centered-container">
  <img src="images/AnnotatedUi.png" alt="Annotated GUI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.2 Shows the SEPlendid's Starting GUI.
</div>

<br>
<br>

### 4.2 Command Format

We will be using SEPlendid's commands throughout this User Guide. The following figure provides a visual example on
what a command consist of:

**Notes about the data and command format:**<br>

The commands of SEPlendid can be classified into five main groups for your easy recall. Each group corresponds to one of
SEPlendid's data type and also represents a 'Command Word'. Each command begins with a 'Command Word' coupled with an
'Action Word' followed by either an 'Attribute', the required command 'Argument(s)', or both.

For example:

```
localcourse search [localname] [computing]
```

This command consists of the Command Word `localcourse`, the Action Word `sort`, the Attribute `localname` and the
required Argument `computing`. This command returns you the all local courses with the word 'computing' in its local
name.

**Command Words** :

There are seven Command Words you may use. The first five corresponds to a SEPlendid data type. The remaining two,
`exit` and `help` command exists as a single 'Command Word' with their own unique purposes.

| Command Word    | Description                                        |
|-----------------|----------------------------------------------------|
| `localcourse`   | Courses offered by NUS Computing                   |
| `partnercourse` | Courses offered by NUS’ partner universities       |
| `mapping`       | Mappings between local courses and partner courses |
| `university`    | NUS’ partner universities                          |
| `note`          | Your own notes                                     |
| `help`          | The help command to open the help window           |
| `exit`          | The exit command to exit SEPlendid                 |

<br>

**Action Words** :

<box type="warning" seamless>
Not all Action Words are available for every Command Word.<br>

You can visit the [command summary](#7-command-summary) section to see which Action Words are available for each Command
Word.
</box>

| Action Word | Description                                        |
|-------------|----------------------------------------------------|
| `list`      | List all the data of the data type                 |
| `add`       | Add a record of the data type                      |
| `delete`    | Delete a record of the data type                   |
| `update`    | Update a record of the data type                   |
| `search`    | Search for a data type by an attribute             |
| `sort`      | Sort all the data of the data type by an attribute |
| `tag`       | Tag a note                                         |
| `cleartag`  | Clear all tags from a note                         |

<br>

**Attributes** :

Each of SEPlendid data types (or Command Words) have certain attributes. <br>
These are the attributes for each data type:

`localcourse`:

| Attribute          | Description                         |
|--------------------|-------------------------------------|
| `localcode`        | Course code of the local course     |
| `localname`        | Name of the local course            |
| `unit`             | Number of units of the local course |
| `localdescription` | Description of the local course     |

`partnercourse`:

| Attribute     | Description                                        |
|---------------|----------------------------------------------------|
| `partnercode` | Course code of the partner course                  |
| `partnername` | Name of the partner course                         |
| `university`  | The partner university offering the partner course |
| `unit`        | Number of units of the partner course              |
| `description` | Description of the partner course                  |

`mapping`:

| Attribute     | Description                                        |
|---------------|----------------------------------------------------|
| `localcode`   | Course code of the local course                    |
| `localname`   | Name of the local course                           |
| `partnercode` | Course code of the partner course                  |
| `partnername` | Name of the partner course                         |
| `university`  | The partner university offering the partner course |

`note`:

| Attribute | Description         |
|-----------|---------------------|
| `index`   | Index of the note   |
| `content` | Content of the note |
| `tag`     | Tag of the note     |

<br>

<box type="warning" seamless>
The following characters do not exist in our datasets and are not accepted in our input: `[` and `]`.
</box>

<box type="warning" seamless>
If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

<br>
<br>

### 4.3 Your first command

In order to get you started with SEPlendid's commands, we should try out some commands together!

**The First Command** :
Let's start with a `localcourse` command. The `localcourse` has an `add` Action Word to allow you to add a new local
course into your SEPlendid. On top of that, we need some Arguments. For the `localcourse add` command, the arguments
are `localcode`, `localname`, `unit` and, `localdescription`.

Here is how it looks like:

```
localcourse add [localcode] [localname] [unit] [localdescription]
```

<box type="tip" icon=":bulb:" >
    None of the Arguments are optional. You have to provide all the required Arguments to SEPlendid. 
</box>

Now that you know how a `localcourse add` Command looks like, let's imagine a scenario:

There is a newly offered course by NUS Computing, CS2105. Interested in this course, you want to add this localcourse
into your SEPlendid.

**Step-by-Step of your First Command** :

Let's go build the command together.

Firstly, you need to take note of the required Arguments:

- `localcode`: CS2105
- `localname`: Introduction to Computer Networks
- `unit`: 4.0
- `localdescription`: This course provides computer networks teachings.

Secondly, you must make sure your command is not invalid, here are some examples for you:

- `localcourse add` You have provided no Arguments.
- `localcourse add [CS2105]` You are missing the Arguments providing the local name and units.
- `localcourse add CS2105 Introduction to Computer Networks 4.0` You are missing the compulsory square brackets ("[ ]")
  wrapping each attribute.

Thirdly, you should conduct these checks before executing the commands:

- [ ] I know what I would like to query For example, local course, partner course, university etc.
- [ ] I know the restrictions of each command
- [ ] I know "[ ]" are compulsory for wrapping each attribute

<box type="tip" icon=":bulb:" >
   Conducting these checks would prevent error messages and result in more efficient querying of results!
</box>

Lastly, putting it all together:
Copy and execute the command into your SEPlendid's command input box

```
localcourse add [CS2105] [Introduction to Computer Networks] [4.0] [This course provides computer networks teachings.]
```

**Summarising Your First Command** :

- The Command Word `localcourse` lets you inform SEPlendid that this command is related to your local courses.
- The Action Word `add` lets you inform SEPlendid that you are adding a new record of the data type, in this case, a
  local course.
- The Argument `CS2105` lets you inform SEPlendid that the new local course has a local code of 'CS1234'.
- The Argument `Introduction to Computer Networks` lets you inform SEPlendid that the new local course has a local name
  of 'Introduction to Computer Networks'.
- The Argument `4.0` lets you inform SEPlendid that the new local course is worth four units.
- The Argument `This course provides computer networks teachings.` lets you inform SEPlendid that the new local course
  has a description of 'This course provides computer networks teachings.'.

Well done making your first command! Now, you are equipped with the basics to start using SEPlendid!

<br>
<br>

## 5. Commands

This section provides an in-depth overview of each command SEPlendid offers.

Overview of SEPlendid's commands:

- Purpose of the command
- Command format
- Behaviour of the command (for both valid and invalid inputs)
- Examples of valid and invalid inputs

<br>
<br>

### 5.1 Commands for local courses

<br>

#### 5.1.1 List all local courses: `localcourse list`

Lists all possible local courses that can be mapped, offered by NUS Computing. This is useful when:

- you wish to retrieve all local courses' information.
- you wish to view local courses in greater detail.
- you wish to verify that a local course has been added successfully.
- you wish to verify that a local course has been deleted successfully.
- you wish to verify that a local course has been updated successfully.

**Format**: `localcourse list`

- This results in the displaying of all the available localcourses provided by NUS Computing.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/LocalcourseListUi.png" alt="Localcourse List UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.1 Shows the entire list of local courses available in NUS Computing.
</div>

<br>
<br>

#### 5.1.2 Add a local course: `localcourse add`

Adds a local course using attributes such as localcode, localname, unit and localdescription in this order. This is
useful
when:

- you are adding a new local course offered by NUS Computing.
- you wish to add a local course that is not preloaded in SEPlendid.

**Format:** `localcourse add [localcode] [localname] [unit] [localdescription]`

**Example**: `localcourse add [CS1234] [ProgrammingFun] [4.0] [fun mod]`

- This adds a local course with the course code 'CS1234' with the local name 'ProgrammingFun' which fulfils '4.0' units
  and has a description of a 'fun mod'

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/LocalcourseAddUi.png" alt="Localcourse Add UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.2 Shows the added local course with the course code: CS1234.
</div>

<br>
<br>

#### 5.1.3 Delete a local course: `localcourse delete`

Deletes local course with course code identified by `localcode`. This is useful when:

- you wish to remove a local course that is no longer offered by NUS Computing.

<box type="info" icon=":exclamation:" icon-color="red">
    Warning: You are unable to delete a local course if it exists in a mapping.
</box>

**Format:** `localcourse delete [localcode]`

**Example:** `localcourse delete [CS1234]`

- This deletes a localcourse with the course code 'CS1234'

<div class="centered-container">
  <img src="images/LocalcourseDeleteUi.png" alt="Localcourse Delete UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the deleted local course with the course code: CS1234.
</div>

<br>
<br>

#### 5.1.4 Update a local course: `localcourse update`

Updates specified attributes of a local course, with course code identified by `localcode`.
These local course attributes include `localcode`, `localname`, `unit` and `localdescription`. This is useful when:

- you wish to update a local course if there are changes made by NUS Computing.

<box type="tip" icon=":bulb:" >
    You can check the updated localcourse using <code>localcourse list</code>
</box>

**Format:** `localcourse update [localcode] [attribute] [updatedValue]`

**Example:** `localcourse update [BT1101] [localcode] [BT1102]`

- This updates a local course with the course code from 'BT1101' to 'BT1102'

<div class="centered-container">
  <img src="images/LocalcourseUpdateUi.png" alt="Localcourse Update UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the updated local course BT1101 to BT1102.
</div>

<br>
<br>

#### 5.1.5 Search for a local course by an attribute: `localcourse search`

Searches local courses using specified attributes such as `localcode`, `localname`, `unit`, and `localdescription`.
This is useful when:

- you wish to find a specific local course you are interested in.
- you wish to find local courses that matches with your credits required.
- you wish to find local courses that matches with the course description you are interested in.

**Format:** `localcourse search [localcode] [keyword]`\
`localcourse search [localname] [keyword]`

**Example:** `localcourse search [localcode] [BT2101]`

<div class="centered-container">
  <img src="images/LocalcourseSearchUi.png" alt="Localcourse Search UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the searched local course BT2102.
</div>

<br>
<br>

#### 5.1.6 Sort all local courses by an attribute: `localcourse sort`

Sorts local courses according to attributes such as localname and localcode. This is useful when:

- you wish to find local courses with specific attributes.

**Format:** `localcourse sort [localcourseattribute]`

**Example:** `localcourse sort [localname]`

<div class="centered-container">
  <img src="images/LocalcourseSearchUi.png" alt="Localcourse Search UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the searched local course BT2102.
</div>

<br>
<br>

### 5.2 Commands for partner courses

<br>

#### 5.2.1 List all partner courses: `partnercourse list`

Lists all available partner courses, offered by every partner university. This is useful when:

- you wish to retrieve all partner courses' information.
- you wish to view partner courses in greater detail.
- you wish to verify that a partner course has been added successfully.
- you wish to verify that a partner course has been deleted successfully.
- you wish to verify that a partner course has been updated successfully.

**Format:** `partnercourse list`

**Expected Outcome:** SEPlendid's GUI will show the list of partner courses available.

<br>
<br>

#### 5.2.2 Add a partner course: `partnercourse add`

Adds a partner course with the specified partner course attributes. This is useful when:

- you are adding a new partner course offered by the particular partner university.
- you wish to add a partner course that is not preloaded in SEPlendid.

<box type="warning" icon=":exclamation:" icon-color="red">
    <b>Warning:</b> You are unable to add a partner course if the university does not exist in SEPlendid.
</box>

**Format**: `partnercourse add [university] [partnercode] [partnername] [units] [description]`

**Example:** `partnercourse add [University of Toronto] [ROB311] [Artificial Intelligence] [5.0]
[Introduction module to AI]`

**Expected Outcome:** SEPlendid's GUI will show you the added partnercourse.

<br>
<br>

#### 5.2.3 Delete a partner course: `partnercourse delete`

Deletes partner course with attributes such as university and partnercode respectively. This is useful when:

- you wish to remove a partner course that is no longer offered by the partner university.

<box type="warning" icon=":exclamation:" >
    <b>Warning:</b> You are unable to delete a partner course if it exists in a mapping.
</box>

**Format:** `partnercourse delete [university] [partnercode]`

**Example:** `partnercourse delete [University of Toronto] [ROB311]`

**Expected Outcome:** SEPlendid's GUI will show the deleted partnercourse.

<br>
<br>

#### 5.2.4 Update a partner course: `partnercourse update`

Updates specified attributes of a partner course, with the partner course identified by `universityname`.
These partner course attributes include partnercode, partnername, unit and description. This is useful when:

- you wish to update a partnercourse if there are changes made by the partner university.

**Format**: `partnercourse update [universityname] [partnercode] [partnercourseattribute] [updatedValue]`

**Example:** `partnercourse update [University of Toronto] [ROB311] [unit] [10.0]`

**Expected Outcome:** SEPlendid's GUI will show the updated partnercourse.

<br>
<br>

#### 5.2.5 Search for a partner course by an attribute: `partnercourse search`

Searches partnercourse using specified attributes such as `partnercode`, `partnername`, `unit`, and `description`.
This is useful when:

- you wish to find a specific partner course you are interested in.
- you wish to find partner courses that matches with your credits required.
- you wish to find partner courses that matches with the course description you are interested in.

**Format:** `partnercourse search [partnercode]` \
`partnercourse search [partnername]`

**Example:** `partnercourse search [partnercode] [CSE469]`

**Expected Outcome:** SEPlendid's GUI will show you the searched partner course, CSE469.

<br>
<br>

#### 5.2.6 Sort all partner courses by an attribute: `partnercourse sort`

Sorts local courses according to attributes such as `partnername` and `partnercode`. This is useful when:

- you wish to find partner courses with specific attributes.

**Format:** `partnercourse sort [partnercourseattribute]`

**Example:** `partnercourse sort [partnercode]`

**Expected Outcome:** SEPlendid's GUI will show you the sorted partner courses according to `partnercode`.

<br>
<br>

### 5.3 Commands for universities

<br>

#### 5.3.1 List all universities: `university list`

Lists all available partner universities that NUS Computing students are able to exchange at. This is useful when:

- you wish to retrieve all the universities available for you to exchange at.

**Format:** `university list`

**Example:**
Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/UniversityListUi.png" alt="University List UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the list of partner universities available for NUS Computing students.
</div>

<br>
<br>

#### 5.3.2 Search for a university by an attribute: `university search`

Searches universities that matches the keyword of the university name. This is useful when:

- you wish to find a specific university you are interested in.

**Format:** `university search [university]`

**Example:**
<div class="centered-container">
  <img src="images/UniversitySearchUi.png" alt="University Search UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the searched university, Imperial College of London.
</div>

<br>
<br>

#### 5.3.3 Sort all universities by an attribute: `university sort`

Sorts universities by the university name, alphabetically. This is useful when:

- you wish to view universities alphabetically.

**Format:** `university sort [universityname]`

**Example:** `university sort [universityname]`

<div class="centered-container">
  <img src="images/UniversitySortUi.png" alt="University Sort UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the sorted university list.
</div>

<br>
<br>

### 5.4 Commands for mappings

<br>

#### 5.4.1 List all mappings: `mapping list`

Lists all available mappings from a local course offered by NUS Computing, to a partner course offered by a partner
university. This is useful when:

* you wish to retrieve all mappings' information.
* you wish to view mappings in greater detail.
* you wish to verify that a mapping has been added, deleted or updated successfully.

<box type="tip">
    Click on a mapping in the list to bring up a detailed view.
</box>

**Format:** `mapping list`

- This results in the displaying of all available mappings stored in SEPlendid.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/MappingListUi.png" alt="Mapping List UI" class="resized-image">
</div>
<div class="centered-content" >
  <p class="image-caption"> Figure 3.1 Shows the entire list of mappings stored in SEPlendid.
</div>

<br>
<br>

#### 5.4.2 Add a mapping: `mapping add`

Adds mapping for local course identified by `localcode`, offered by partner `university`, has partner course with code
`partnercode` and has information `information`. This is useful when:

* you wish to add a mapping between a local course and a partner course.

<box type="info">
    You are only able to add a mapping consisting of existing local course, partner course and university.
</box>

**Format:** `mapping add  [localcode] [university] [partnercode] [information]`

**Example:** `mapping add [IS4231] [Lund University] [INFC40] [Sem 1 only.]`

- This adds a mapping of local course `IS4231` to `INFC40` offered by `Lund University`.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/MappingAddUi.png" alt="Mapping Add UI" class="resized-image">
</div>
<div class="centered-content" >
  <p class="image-caption"> Figure 3.2 Shows the added mapping of local course IS4231 to INFC40 offered by Lund University.
</div>

<br>
<br>

#### 5.4.3 Delete a mapping: `mapping delete`

Deletes mapping for local course identified by `localcode`, offered by partner `university`, and has partner course with
code `partnercode`. This is useful when:

* you wish to remove a mapping between a local course and a partner course.

**Format:** `mapping delete [localcode] [university] [partnercode]`

**Example:** `mapping delete [IS4231] [Lund University] [INFC40]`

- This deletes a mapping of local course `IS4231` to `INFC40` offered by `Lund University`.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/MappingDeleteUi.png" alt="Mapping Dekete UI" class="resized-image">
</div>
<div class="centered-content" >
  <p class="image-caption"> Figure 3.3 Shows the deletion of mapping of local course IS4231 to INFC40 offered by Lund 
  University.
</div>

<br>
<br>

#### 5.4.4 Search a mapping by attributes: `mapping search`

Searches for mappings using specified attribute such as `localcode`, `localname`, `partnercode`, `partnername`,
`university`, `information`. This is useful when:

* you wish to find a mapping which you are interested in, or have added.

**Format:** `mapping search [localcode/localname/partnercode/partnername/university/information] [query]`

**Example:** `mapping search [localcode] [CS3230]`

- This results in the displaying of all mappings of the local course `CS3230`.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/MappingSearchUi.png" alt="Mapping Search UI" class="resized-image">
</div>
<div class="centered-content" >
  <p class="image-caption"> Figure 3.4 Shows the search for mappings of local course CS3230.
</div>

<br>
<br>

#### 5.4.5 Sort a mapping by attributes: `mapping sort`

Sorts mappings according to attributes such as `localcode`, `localname`, `partnercode`, `partnername`, `university`,
`information`) in ascending order. This is useful when:

* you wish to view or find mappings alphabetically

**Format:**  `mapping sort [localcode/localname/partnercode/partnername/university/information]`

**Example:**
`mapping sort [localcode]`

- This results in the displaying of all mappings, sorted by their local course codes in ascending order.

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/MappingSortUi.png" alt="Mapping Sort UI" class="resized-image">
</div>
<div class="centered-content" >
  <p class="image-caption"> Figure 3.5 shows the sorting of mappings by their local course codes in ascending order.
</div>

<br>
<br>

### 5.5 Commands for notes

<br>

#### 5.5.1 List all notes: `note list`

Lists all notes that you have recorded in SEPlendid. This is useful when:

- you wish to retrieve all of your consolidated notes.
- you wish to verify that your note has been added successfully.
- you wish to verify that your note has been deleted successfully.
- you wish to verify that your note has been updated successfully.

**Format:** `note list`

**Example:**
<div class="centered-container">
  <img src="images/NoteListUi.png" alt="Note List UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the list of notes you have recorded.
</div>

<br>
<br>

#### 5.5.2 Add a note: `note add`

Adds a note with the content you wish to add with a tag. This is useful when:

- you wish to record a course or mapping you would are interested in doing for exchange.
- you wish to record down important information.

**Format:** `note add [content] [tag]`

**Example:**
<div class="centered-container">
  <img src="images/NoteAddUi.png" alt="Note Add UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the note you have added.
</div>

<br>
<br>

#### 5.5.3 Delete a note: `note delete`

Deletes specified index of the note. This is useful when:

- you wish to remove a note that contains outdated information.

**Format:** `note delete [index]`

**Example:**
<div class="centered-container">
  <img src="images/NoteDeleteUi.png" alt="Note Delete UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the note you have deleted.
</div>

<br>
<br>

#### 5.5.4 Update a note: `note update`

Updates specified note according to the index and updates the content of the note. This is useful when:

- you wish to edit to correct your mistakes made in the note.
- you wish to update the note with new information.

**Format:** `note update [index] [content]`

**Example:**
<div class="centered-container">
  <img src="images/NoteDeleteUi.png" alt="Note Delete UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the note you want to delete.
</div>

<br>
<br>

#### 5.5.5 Tag a note: `note tag`

Adds a tag to the specified note according to the index. This is useful when:

- you want to easily view the different key points of the note.

**Format:** `note tag [index] [tag]`

**Example:**
<div class="centered-container">
  <img src="images/NoteTagUi.png" alt="Note Tag UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the notes updated with a tag you have specified.
</div>

<br>
<br>

#### 5.5.6 Clear all tags in a note: `note cleartag`

Clears all tags for the specified note according to its index. This is useful when:

- you wish to remove all the tags that are no longer relevant to your note.

**Format:** `note cleartag [index]`

**Example:**
<div class="centered-container">
  <img src="images/NoteTagUi.png" alt="Note Tag UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the note where all the tags have been removed.
</div>

<br>
<br>

#### 5.5.7 Search notes by tag: `note search`

Searches for notes which tag contains the value `tagKeyword`. This is useful when:

- you wish to find your notes with the tags you are interested in.

**Format:** `note search [tagKeyword]`

**Example:**
<div class="centered-container">
  <img src="images/NoteSearchUi.png" alt="Note Search UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the note which tags contains the keyword.
</div>

<br>
<br>

#### 5.6 View help : `help`

Results in a pop-up window for you to copy the URL into an external browser to view SEPlendid's user guide.

Format: `help`

![Help](Images/Help.jpg)

<br>
<br>

#### 5.7 Exit SEPlendid : `exit`

Exits SEPlendid app.

Format: `exit`

<br>
<br>

#### 5.8 Save the data

SEPlendid's data are saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

<br>
<br>

#### Editing the data file

SEPlendid data are saved automatically as a JSON file `[JAR file location]/data/seplendid.json`. Advanced users are
welcome to update data directly by editing that data file.

<box type="warning" icon=":exclamation:" icon-color="red">
    <b>Warning:</b> If your changes to the data file makes its format invalid, SEPlendid will discard all data and start with an empty data 
file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

<br>
<br>

--------------------------------------------------------------------------------------------------------------------

## 6. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that
contains the data of your previous SEPlendid home folder.

**Q**: Can I run SEPlendid without the need for internet connection? <br>
**A**: No, SEPlendid is designed as an offline application to enhance your convenience of using the app.

**Q**: Why do I get an error message when searching a local course by its description?<br>
**A**: The attributes used for local course search is restricted. To search the local course, you must use this command:

- `localcourse search [localdescription] [description_keyword]`

<br>
<br>

--------------------------------------------------------------------------------------------------------------------

## 7. Command summary

| Command Word    | Action Word | Parameters                                                       |
|-----------------|-------------|------------------------------------------------------------------|
| `localcourse`   | `list`      | None.                                                            |
|                 | `add`       | `[localcode] [localname] [units] [description]`                  |
|                 | `delete`    | `[localcode]`                                                    |
|                 | `update`    | `[localcode] [attribute] [newvalue]`                             |
|                 | `search`    | `[attribute] [query]`                                            |
|                 | `sort`      | `[attribute]`                                                    |
| `partnercourse` | `list`      | None.                                                            |
|                 | `add`       | `[university] [partnercode] [partnername] [units] [description]` |
|                 | `delete`    | `[university] [partnercode]`                                     |
|                 | `update`    | `[university] [partnercode] [attribute] [newvalue]`              |
|                 | `search`    | `[attribute] [query]`                                            |
|                 | `sort`      | `[attribute]`                                                    |
| `mapping`       | `list`      | None.                                                            |
|                 | `add`       | `[localcode] [university] [partnercode] [information]`           |
|                 | `delete`    | `[localcode] [university] [partnercode]`                         |
|                 | `search`    | `[attribute] [query]`                                            |
|                 | `sort`      | `[attribute]`                                                    |
| `university`    | `list`      | None.                                                            |
|                 | `search`    | `[query]`                                                        |
|                 | `sort`      | None.                                                            |
| `note`          | `list`      | None.                                                            |
|                 | `add`       | `[content] [tag]`                                                |
|                 | `delete`    | `[index]`                                                        |
|                 | `update`    | `[index] [content]`                                              |
|                 | `tag`       | `[index] [tag]`                                                  |
|                 | `cleartag`  | `[index]`                                                        |
|                 | `search`    | `[query]`                                                        |
