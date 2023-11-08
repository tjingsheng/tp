---
 layout: default.md
 title: "User Guide"
 pageNav: 3
---
<bottom-head>
    <link rel="stylesheet" href="stylesheets/userguide.css">
</bottom-head>

# SEPlendid User Guide
<br />

## 1. About SEPlendid
SEPlendid is a **Course Mapping System** that allows NUS Computing students to seamlessly plan for
their overseas courses, for the highly coveted Student Exchange Programmes (SEP). As a student, you can view and find 
course mappings in order to plan for your overseas studies without the hassle of creating complex Excel sheets. 
Utilise SEPlendid's **course mapping** function in order to quickly find possible mappings for certain courses you want
to map. Finally, SEPlendid's **note-taking system** will assist you in organising your important information you 
will need for planning for your courses.

This User Guide provides a comprehensive documentation on how you can streamline your process in your application for
SEP. It includes:
- **Step-by-step** instructions on how to launch SEPlendid
- SEPlendid's myriad of features and commands
- **Key parameters** to run SEPlendid smoothly

If you are a new user, please head over to  [How to use the User Guide](#) to start planning for your study guide!

<page-nav-print />
<br />
<br />

--------------------------------------------------------------------------------------------------------------------

## Table of Contents
<div class= "toc">

1. [About SEPlendid](#1-about-seplendid)


2. [Quick start](#2-quick-start)


3. [A Short Tutorial](#3-a-short-tutorial)


   - 3.1 [Graphical User Interface (GUI)](#3-1-graphical-user-interface-gui)


   - 3.2 [Command Format](#3-2-command-format)


   - 3.3 [Execute your first command](#3-3-execute-your-first-command)


4. [Commands](#4-commands)


   - 4.1 [Commands for localcourse](#4-1-commands-for-localcourse)


     - 4.1.1 [List all localcourses: `localcourse list`](#4-1-1-list-all-localcourses-localcourse-list)


     - 4.1.2 [Add a local course: `localcourse add`](#4-1-2-add-a-local-course-localcourse-add)


     - 4.1.3 [Delete a local course: `localcourse delete`](#4-1-3-delete-a-local-course-localcourse-delete)


     - 4.1.4 [Search a local course by attributes: `localcourse search`](#4-1-4-search-a-local-course-by-attributes-localcourse-search)


     - 4.1.5 [Sort a local course by attributes: `localcourse sort`](#4-1-5-sort-a-local-course-by-attributes-localcourse-sort)


   - 4.2 [Commands for partnercourse](#4-2-commands-for-partnercourse)


     - 4.2.1 [List all partnercourses: `partnercourse list`](#4-2-1-list-all-partnercourses-partnercourse-list)


     - 4.2.2 [Add a partnercourse: `partnercourse add`](#4-2-2-add-a-partnercourse-partnercourse-add)


     - 4.2.3 [Delete a partnercourse: `partnercourse delete`](#4-2-3-delete-a-partnercourse-partnercourse-delete)


     - 4.2.4 [Search a partnercourse by attributes: `partnercourse search`](#4-2-4-search-a-partnercourse-by-attributes-partnercourse-search)


     - 4.2.5 [Sort a partnercourse by attributes: `partnercourse sort`](#4-2-5-sort-a-partnercourse-by-attributes-partnercourse-sort)


   - 4.3 [Commands for universities](#4-3-commands-for-universities)


     - 4.3.1 [List all universities: `university list`](#4-3-1-list-all-universities-university-list)


     - 4.3.2 [Search a university by attributes: `university search`](#4-3-2-search-a-university-by-attributes-university-search)


     - 4.3.3 [Sort a university by attributes: `university sort`](#4-3-3-sort-a-university-by-attributes-university-sort)


   - 4.4 [Commands for mappings](#4-4-commands-for-mappings)


     - 4.4.1 [List all mappings: `mapping list`](#4-4-1-list-all-mappings-mapping-list)


     - 4.4.2 [Add a mapping: `mapping add`](#4-4-2-add-a-mapping-mapping-add)


     - 4.4.3 [Delete a mapping: `mapping delete`](#4-4-3-delete-a-mapping-mapping-delete)


     - 4.4.4 [Search a mapping by attributes: `mapping search`](#4-4-4-search-a-mapping-by-attributes-mapping-search)


     - 4.4.5 [Sort a mapping by attributes: `mapping sort`](#4-4-5-sort-a-mapping-by-attributes-mapping-sort)


   - 4.5 [Commands for notes](#4-5-commands-for-notes)


     - 4.5.1 [List all notes: `note list`](#4-5-1-list-all-notes-note-list)


     - 4.5.2 [Add a note: `note add`](#4-5-2-add-a-note-note-add)


     - 4.5.3 [Delete a note: `note delete`](#4-5-3-delete-a-note-note-delete)


     - 4.5.4 [Update a note: `note update`](#4-5-4-update-a-note-note-update)


     - 4.5.5 [Tag a note: `note tag`](#4-5-5-tag-a-note-note-tag)


     - 4.5.6 [Clear tag a note: `note cleartag`](#4-5-6-clear-tags-of-a-note-note-cleartag)


   - 4.6 [Viewing help : `help`](#4-5-6-viewing-help--help)


   - 4.7 [Saving the data](#4-5-7-saving-the-data)


5. [FAQ](#5-faq)


6. [Command summary](#6-command-summary)

</div>

<br />
<br />

--------------------------------------------------------------------------------------------------------------------

## 2. How to use SEPlendid's User Guide

As a new user in SEPlendid, this user guide serves as an easy-to-follow guide in aiding you in executing your first 
commands in SEPlendid, utilising SEPlendid to it's fullest potential!

Here is a step-by-step instruction in using SEPlendid for **new** users:
1. Download SEPlendid by heading over to the [installation](#) section which provides a guided tour for you to get
   started with SEPlendid.
2. Get familiar with SEPlendid by heading over to the [Quick Reference Guide](#) section which shows you how to navigate
   SEPlendid efficiently.

If you are an **experienced** user, you can head over to the [Command Summary](#) section for a well-curated overview
of the commands available in SEPlendid.

<Add admonition: INFO> 

## 3. Admonitions used in this User Guide

Throughout this guide, admonitions are used to highlight important information, so do pay **special** attention to them:

| Icon                     | Meaning                                  |
|--------------------------|------------------------------------------|
| :information_source: Info | Information you should keep in mind      | 
| :bulb: Tip               | Information you might find useful        |
| :exclamation: Warning    | Information you should be cautious about | 


## 4. Installation

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `seplendid.jar` from [here](https://github.com/AY2324S1-CS2103T-W10-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for SEPlendid.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar seplendid.jar`
   command to run the application.<br>
   You would be able to view SEPlendid's GUI shown below in a few seconds. The app contains a large sample data of 
   courses so that you can start planning for SEP immediately.<br>
   ![Ui](images/StartupWindowUI.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `university list` : Lists all of NUS' partner universities.
   
    * `mapping search [localcode] [CS2103]`: Searches and displays all NUS-to-partner university course mappings 
    based on local NUS course code `CS2103`.

    * `exit` : Exits SEPlendid.

6. If you are an experienced user, refer to the [Commands](#4-commands) below for more details of each feature and command.

--------------------------------------------------------------------------------------------------------------------


## 3. Quick Reference Guide

This section covers important information for you to utilise SEPlendid to its fullest capacity. You will learn how to 
navigate SEPlendid effectively and the commands section will cover on how you can run essential features on SEPlendid.

## 3.1. Graphical User Interface (GUI)

SEPlendid's GUI is designed to provide you with great visual feedback and user experience. SEPlendid's GUI allows you to
click and view the different courses which provides an in-depth insight about the course such as the course units and
description. Let's now take a look at the different components available in SEPlendid's GUI.

SEPlendid's GUI consists of these four main components:
1. Command Input Box
2. Command Result Box
3. List Panel for Local Courses, Partner Courses, Universities, Mappings or Notes
4. Display Panel for details of the selected item from the list panel.

Refer to the annotated diagram of SEPlendid's GUI which is numbered accordingly:

![Annotated GUI](images/AnnotatedUi.png)

## 3.2. Command Format
We will be using SEPlendid's commands throughout this User Guide. The following figure provides a visual example on 
what a command consist of:



<box type="info" seamless>

**Notes about the data and command format:**<br>

* Within SEPlendid, there are five main types of data. Each also represents a 'Command Word'. Each 'Command Word' 
begins a command, which can be coupled with an attribute, to narrow down to a specific functionality. \
e.g. `localcourse sort [localname]` will sort the list of local courses by their `localname`.

| Command Word    | Description                                        |
|-----------------|----------------------------------------------------|
| `localcourse`   | Courses offered by NUS Computing                   |
| `partnercourse` | Courses offered by NUS’ partner universities       |
| `mapping`       | Mappings between local courses and partner courses |
| `university`    | NUS’ partner universities                          |
| `note`          | A note to keep track of items                      |

Each of these data types have certain attributes. These are the columns or data that will be displayed for each 
command group: 

`localcourse`:

| Attribute          | Description                          |
|--------------------|--------------------------------------|
| `localcode`        | Course code for the local course     |
| `localname`        | Name of the local course             |
| `localunit`        | Number of units  of the local course |
| `localdescription` | Description of the local course      |

`partnercourse`:

| Attribute            | Description                                        |
|----------------------|----------------------------------------------------|
| `partnercode`        | Course code for the partner course                 |
| `partnername`        | Name of the partner course                         |
| `university`         | The partner university offering the partner course |
| `partnerunit`        | Number of units  of the partner course             |
| `partnerdescription` | Description of the partner course                  |


`mapping`:

| Attribute     | Description                                        |
|---------------|----------------------------------------------------|
| `localcode`   | Course code for the local course                   |
| `localname`   | Name of the local course                           |
| `partnercode` | Course code for the partner course                 |
| `partnername` | Name of the partner course                         |
| `university`  | The partner university offering the partner course |

`note`:

| Attribute  | Description                   |
|------------|-------------------------------|
| `index`    | Index for the particular note |
| `content`  | The content of the note       |
| `tag`      | Tag used to organise notes    |


* The command format is `command-word action-word [parameters]`. <br /> `action-word`s include `sort`, `search`, `add`, 
`delete`,
 `update`, `tag`, but not all `action-word`s can be used after each `command-word`. Refer to the [Command Summary]
 (#command-summary)
  for a quick overview of which `action-word`s can follow a `command-word`.

* `[parameters]` refer to any number of parameters which can follow an `action-word`. For instance, for the 
`localcourse add` command, the full format is `localcourse add [localcode] [localname]`, which signifies that we 
have two parameters (`localcode` and `localname`) to fill. <br />
An invocation of the command is exemplified by: 
  > `localcourse add [CS1010] [Programming Methodology]`. 

* The following characters do not exist in our datasets and are not accepted in our input: `[` and `]`.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit`) will be
  ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help` `[coming soon]`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.

</box>

## 3.3. Let's try your first command

In order to get you started with SEPlendid's commands, we should try out a command together!

Let's start with the most basic command `add` command. `add` command allows you to add a local, partner course or note.

One of the available commands for `add` is the command to add a localcourse into your storage.

**Format:** `localcourse add [localcode] [localname] [units]`

The first word of each command specifies the different core features with its own unique sets of functionalities.
- `localcourse` tells SEPlendid that this command word would execute actions only for local courses
- Attributes such as `localcode` and `localname` shows you what you should place in each portion of the command

<Add note on [] -> shows compulsory attributes>

**Example**
Let's imagine this scenario, you want to add a localcourse to your storage since this localcourse could be a new course 
offered by NUS Computing. For instance, a newly offered course by NUS is CS2105 which is an 
Introduction to Computer Networks. The course is will fulfil four course credits, and you would like to map this course 
for SEP.

The command you would like to input:
`localcourse add [CS2105] [Introduction to Computer Networks] [4.0]`

These are the fields you would take note of:
- `localcode`: CS2105
- `localname`: Introduction to Computer Networks
- `units`: 4.0 

Do take note of invalid formats:
- `localcourse add [CS2105]`
  The attributes such as localname and units are compulsory.
- `localcourse add CS2105 Introduction to Computer Networks 4.0`
  The brackets ("[ ]") wrapping each attribute is compulsory.
- `localcourse add`
  There is insufficient information on what localcourse to add.

**Another Example!**
Let's imagine this, you want to go to a specific partner university like Imperial College of London. You would like to
know whether this partner university is available for SEP.

**Format**: `university search [university]`

The command you would like to input:
`university search [Imperial]`

Do take note of invalid formats:
- `university search [university] [university]`
  The attribute `university` only takes in a String instead of List<String>.
- `university search`
  There is insufficient information on what university to query.

Conduct these checks before executing the commands:
- I know what I would like query e.g. localcourse, partnercourse, university etc.
- I know the restrictions of each command
- I know "[ ]" are compulsory for wrapping each attribute

Conducting these checks would prevent error messages and result in more efficient querying of results!

## 4. Commands

This section provides an in-depth overview of each command SEPlendid offers.

Overview of SEPlendid's commands:
- Purpose of the command
- Command format
- Behaviour of the command (for both valid and invalid inputs)
- Examples of valid and invalid inputs

## 4.1. Commands for localcourse

### 4.1.1. List all local courses: `localcourse list`

Lists all possible local courses that can be mapped, offered by NUS Computing. This is useful when:

- you wish to retrieve all local courses' information.
- you wish to view  local courses in greater detail.
- you wish to verify that a local course has been added successfully. 
- you wish to verify that a local course has been deleted successfully.
- you wish to verify that a local course has been updated successfully.

**Format**: `localcourse list`

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/LocalcourseListUi.png" alt="Localcourse List UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.1 Shows the entire list of local courses available in NUS Computing.
</div>

<br/>
<br />

### 4.1.2. Add a local course: `localcourse add`

Adds a local course using attributes such as localcode, localname, localunit and localdescription in this order. This is useful
when:
- you are adding a new local course offered by NUS Computing.
- you wish to add a local course that is not preloaded in SEPlendid.

**Format:** `localcourse add [localcode] [localname] [units] [description]`

**Example**: `localcourse add [CS1234] [ProgrammingFun] [4.0] [fun mod]`

Refer to the figure below to view the outcome of the execution of the command:

<div class="centered-container">
  <img src="images/LocalcourseAddUi.png" alt="Localcourse Add UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.2 Shows the added local course with the course code: CS1234.
</div>

<br/>
<br/>

### 4.1.3. Delete a local course: `localcourse delete`

Deletes local course with course code identified by `localcode`. This is useful when:
- you wish to remove a local course that is no longer offered by NUS Computing.

<box type="info" icon=":exclamation:" icon-color="red">
    Warning: You are unable to delete a local course if it exists in a mapping.
</box>

**Format:** `localcourse delete [localcode]`

**Example:** `localcourse delete [CS1234]`

<div class="centered-container">
  <img src="images/LocalcourseDeleteUi.png" alt="Localcourse Delete UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the deleted local course with the course code: CS1234.
</div>

<br/>
<br/>

### 4.1.4. Update a local course: `localcourse update`

Updates specified attributes of a local course, with course code identified by `localcode`.
These local course attributes include localcode, localname, localunit and localdescription. This is useful when:
- you wish to update a localcourse if there are changes made by NUS Computing.

<box type="tip" icon=":bulb:" >
    Tip: You can check the updated localcourse using <code>localcourse list</code>
</box>

**Format:** `localcourse update [localcode] [localcourseattribute] [updatedValue]`

**Example:** `localcourse update [BT1101] [localcode] [BT1102]`

<div class="centered-container">
  <img src="images/LocalcourseUpdateUi.png" alt="Localcourse Update UI" class="resized-image">
</div>
<div class = "centered-content" >
  <p class = "image-caption"> Figure 1.3 Shows the updated local course BT1101 to BT1102.
</div>

<br />
<br />

### 4.1.5. Search a localcourse by attributes: `localcourse search`

Searches localcourses using specified attributes such as localcode, localname, localunit, and localdescription.
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

<br />
<br />

### 4.1.6.: Sort local courses by attributes: `localcourse sort`
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

<br />
<br />

## 4.2. Commands for partnercourse
<br />

### 4.2.1. List all partner courses: `partnercourse list`

Lists all available partner courses, offered by every partner university. This is useful when:
- you wish to retrieve all partner courses' information.
- you wish to view  partner courses in greater detail.
- you wish to verify that a partner course has been added successfully.
- you wish to verify that a partner course has been deleted successfully.
- you wish to verify that a partner course has been updated successfully.

**Format:** `partnercourse list`

**Expected Outcome:** SEPlendid's GUI will show the list of partner courses available.

<br />
<br />

### 4.2.2. Add a partnercourse: `partnercourse add`

Adds a partner course with the specified partner course attributes. This is useful when:
- you are adding a new partner course offered by the particular partner university.
- you wish to add a partner course that is not preloaded in SEPlendid.

<box type="warning" icon=":exclamation:" icon-color="red">
    Warning: You are unable to add a partner course if the university does not exist in SEPlendid.
</box>

**Format**: `partnercourse add [university] [partnercode] [partnername] [units] [description]`

**Example:** `partnercourse add [University of Toronto] [ROB311] [Artificial Intelligence] [5.0] 
[Introduction module to AI]`
                                                          
**Expected Outcome:** SEPlendid's GUI will show you the added partnercourse.

<br />
<br />

### 4.2.3. Delete a partner course: `partnercourse delete`

Deletes partner course with attributes such as university and partnercode respectively. This is useful when:
- you wish to remove a partner course that is no longer offered by the partner university.

<box type="warning" icon=":exclamation:" >
    Warning: You are unable to delete a partner course if it exists in a mapping.
</box>

**Format:** `partnercourse delete [university] [partnercode]`

**Example:** `partnercourse delete [University of Toronto] [ROB311]`

**Expected Outcome:** SEPlendid's GUI will show the deleted partnercourse. 

<br />
<br />

### 4.2.4. Update a partner course: `partnercourse update`

Updates specified attributes of a partner course, with the partner course identified by `universityname`.
These partner course attributes include partnercode, partnername, partnerunit and partnerdescription. This is useful when:
- you wish to update a partnercourse if there are changes made by the partner university.

**Format**: `partnercourse update [universityname] [partnercode] [partnercourseattribute] [updatedValue]`

**Example:** `partnercourse update [University of Toronto] [ROB311] [unit] [10.0]`

**Expected Outcome:** SEPlendid's GUI will show the updated partnercourse.

<br />
<br />

### 4.2.5. Search a partnercourse by attributes: `partnercourse search`

Searches partnercourse using specified attributes such as partnercode, partnername, partnerunit, and partnerdescription.
This is useful when:
- you wish to find a specific partner course you are interested in.
- you wish to find partner courses that matches with your credits required.
- you wish to find partner courses that matches with the course description you are interested in.

**Format:** `partnercourse search [partnercode]` \
`partnercourse search [partnername]`

**Example:** `partnercourse search [partnercode] [CSE469]` 

**Expected Outcome:** SEPlendid's GUI will show you the searched partnercourse, CSE469.

<br />
<br />

### 4.2.6. Sort partner courses by attributes: `partnercourse sort`
Sorts local courses according to attributes such as partnername and partnercode. This is useful when:
- you wish to find partner courses with specific attributes.

**Format:** `partnercourse sort [partnercourseattribute]`

**Example:** `partnercourse sort [partnercode]`

**Expected Outcome:** SEPlendid's GUI will show you the sorted partnercourses according to partnercode. 

<br />
<br />

## 4.3. Commands for universities
<br />

### 4.3.1. List all universities: `university list`

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

<br />
<br />

### 4.3.2. Search a university by attributes: `university search`

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

<br />
<br />

### 4.3.3. Sort universities by attributes: `university sort`

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

<br />
<br />

## 4.4. Commands for mappings
<br />

### 4.4.1. List all mappings: `mapping list`
Lists all available mappings.
<box type="tip">
    Click on a mapping in the list to bring up a detailed view.
</box>

**Format:** `mapping list`

**Example:**
| `mapping list`                               |
|----------------------------------------------|
| ![mapping-list-ui](images/MappingListUi.png) |

### 4.4.2. Add a mapping: `mapping add`
Adds mapping for local course identified by `localcode`, offered by partner `university`, has partner course with code
`partnercode` and has information `information`.
<box type="info">
    You are only able to add a mapping consisting of existing local course, partner course and university.
</box>

**Format:** `mapping add  [localcode] [university] [partnercode] [information]`

**Example**:
| `mapping add [IS4231] [Lund University] [INFC40] [Sem 1 only.]` |
|-----------------------------------------------------------|
| ![mapping-add-ui](images/MappingAddUi.png)                |

### 4.4.3. Delete a mapping: `mapping delete`
Deletes mapping for local course identified by `localcode`, offered by partner `university`, and has partner course 
with code `partnercode`. \
\
**Format:** `mapping delete [localcode] [university] [partnercode]`

**Example:**
| `mapping delete [IS4231] [Lund University] [INFC40]` |
|--------------------------------------------------------------|
| ![mapping-delete-ui](images/MappingDeleteUi.png)             |

### 4.4.4. Search a mapping by attributes: `mapping search`
Searches for mappings which specified attribute (one of `localcode`, `localname`, `partnercode`, `partnername`, 
`university`, `information`) contains the value `query`. \
\
**Format:** `mapping search [localcode/localname/partnercode/partnername/university/information] [query]` 

**Example:**
| `mapping search [localcode] [CS3230]` |
|--------------------------------------------------------------|
| ![mapping-search-ui](images/MappingSearchUi.png)             |

### 4.4.5. Sort a mapping by attributes: `mapping sort`
Sorts all the mappings by the specified attribute (one of `localcode`, `localname`, `partnercode`, `partnername`, 
`university`, `information`) in ascending order. \
\
**Format:**  `mapping sort [localcode/localname/partnercode/partnername/university/information]` 

**Example:**
| `mapping sort [localcode]` |
|--------------------------------------------------------------|
| ![mapping-search-ui](images/MappingSortUi.png)             |

<br />
<br />

## 4.5. Commands for notes
<br />

### 4.5.1. List all notes: `note list`

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

<br />
<br />

### 4.5.2. Add a note: `note add`

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

<br />
<br />

### 4.5.3. Delete a note: `note delete`

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

<br />
<br />

### 4.5.4. Update a note: `note update`

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

<br />
<br />

### 4.5.5. Tag a note: `note tag`

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

<br />
<br />

### 4.5.6. Clear tags of a note: `note cleartag`

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

<br />
<br />

### 4.6. Viewing help : `help` 

Results in a pop-up window for you to copy the URL into an external browser to view SEPlendid's user guide.

Format: `help`

![Help](Images/Help.jpg)

<br />
<br />

### 4.6. Exiting SEPlendid : `exit`

Exits SEPlendid app.

Format: `exit`

<br />
<br />

### 4.7. Saving the data

SEPlendid's data are saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file [coming soon]

SEPlendid data are saved automatically as a JSON file `[JAR file location]/data/seplendid.json`. Advanced users are
welcome to update data directly by editing that data file.

<box type="warning" icon=":exclamation:" icon-color="red">
    <b>Warning:</b> If your changes to the data file makes its format invalid, SEPlendid will discard all data and start with an empty data 
file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>


--------------------------------------------------------------------------------------------------------------------

## 5. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that 
contains the data of your previous SEPlendid home folder.

**Q**: Can I run SEPlendid without the need for internet connection? <br>
**A**: No, SEPlendid is designed as an offline application to enhance your convenience of using the app.

**Q**: Why do I get an error message when searching a local course by its description?<br>
**A**: The attributes used for local course search is restricted. To search the local course, you must use this command:
- `localcourse search [localdescription] [description_keyword]`

<br />
<br />

--------------------------------------------------------------------------------------------------------------------
## 6. Command summary

### 6.1 
<table class="bordered-table">
    <tr>
        <td><code>command-word</code></td>
        <td><code>action-word</code></td>
        <td><code>parameters</code></td>
    </tr>
    <tr>
        <td rowspan="6"><code>localcourse</code></td>
        <td><code>list</code></td>
        <td> None.</td>
    </tr>
    <tr>
        <td><code>add</code></td>
        <td><code>[localcode] [localname] [units] [description]</code></td>
    </tr>
    <tr>
        <td><code>delete</code></td>
        <td><code>[localcode]</code></td>
    </tr>
    <tr>
        <td><code>update</code></td>
        <td><code>[localcode] [attribute] [updatedValue]</code></td>
    </tr>
    <tr>
        <td><code>search</code></td>
        <td><code>[localcode] [localname]</code></td>
    </tr>
    <tr>
        <td><code>sort</code></td>
        <td><code>[localcode/localname]</code></td>
    </tr>   
    <tr>
        <td rowspan="6"><code>partnercourse</code></td>
        <td><code>list</code></td>
        <td> None.</td>
    </tr>
    <tr>
        <td><code>add</code></td>
        <td><code>[university] [partnercode] [partnername] [units] [description]</code></td>
    </tr>
    <tr>
        <td><code>delete</code></td>
        <td><code>[university] [partnercode]</code></td>
    </tr>
    <tr>
        <td><code>update</code></td>
        <td><code>[university] [partnercode] [attribute] [updatedValue]</code></td>
    </tr>
    <tr>
        <td><code>search</code></td>
        <td><code>[partnercode] [partnername]</code></td>
    </tr>
    <tr>
        <td><code>sort</code></td>
        <td><code>[university/partnercode/partnername]</code></td>
    </tr>
    <tr>
        <td rowspan="5"><code>mapping</code></td>
        <td><code>list</code></td>
        <td> None.</td>
    </tr>
    <tr>
        <td><code>add</code></td>
        <td><code>[localcode] [university] [partnercode] [information]</code></td>
    </tr>
    <tr>
        <td><code>delete</code></td>
        <td><code>[localcode] [university] [partnercode]</code></td>
    </tr>
    <tr>
        <td><code>search</code></td>
        <td><code>[localcode/localname/partnercode/partnername/university/information] [query]</code></td>
    </tr>
    <tr>
        <td><code>sort</code></td>
        <td><code>[localcode/localname/partnercode/partnername/university/information]</code></td>
    </tr>
    <tr>
        <td rowspan="3"><code>university</code></td>
        <td><code>list</code></td>
        <td>None.</td>
    </tr>
    <tr>
        <td><code>search</code></td>
        <td><code>[universityname]</code></td>
    </tr>
    <tr>
        <td><code>sort</code></td>
        <td><code>[universityname]</code></td>
    </tr>
    <tr>
        <td rowspan="5"><code>note</code></td>
        <td><code>list</code></td>
        <td>None.</td>
    </tr>
    <tr>
        <td><code>add</code></td>
        <td><code>[content] [tag]</code></td>
    </tr>
    <tr>
        <td><code>delete</code></td>
        <td><code>[index]</code></td>
    </tr>
    <tr>
        <td><code>update</code></td>
        <td><code>[index] [content]</code></td>
    </tr>
    <tr>
        <td><code>tag</code></td>
        <td><code>[index] [tagname]</code></td>
    </tr>
</table>


