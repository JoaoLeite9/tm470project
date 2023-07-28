
------------------------
1. PROJECT GOAL
------------------------
The goal for the project is to create a application for tracking health and fitness related metrics.

The project was designed and implemented as a submission for module TM470 under the Q67 course.

------------------------
2. DESCRIPTION
------------------------
The project uses JPA (Java Persistence API) alongside hibernate's H2 embeded database for holding
persistent user data locally.

Users can use the application to save, edit and delete exercise related entries quickly using pre-
defined types which they can also create, edit and delete.

------------------------
4. SETTING UP
------------------------
The application is self contained and plug-and-play, requiring no user set up.

------------------------
5. USING THE APPLICATION
------------------------

5.1 Running the Application

	To run the application simply run the executable jar file ("TM470Project.jar") and the main window
	should appear.


5.2 Creating a new entry

	From the main menu, press the "Create Entry" button, this will take you to the Entry Creation screen.
	Enter the details for your entry and press confirm to save it.

5.2 Creating a new entry type

	From the entry creation screen, press the button next to the drop down menu labeled "Type", this will
	take you to the entry type selection window where you can select types to edit. Press the "New" button
	on the top right of the screen and input the data for your new entry type. Press confirm to save it.

5.3 Editing or deleting an entry
	
	From the main menu, press the "View Data" button. This will bring you to a calendar window where you can
	select a day to see all entries associated with that day. Select the associated day and it will bring up
	the entry selection window. Select your entry to edit/delete and it will bring up the entry edit screen.
	The delete button on the top right will delete the entry and the confirm button will save any changes made
	to the entry.

5.4 Editing or deleting an entry
	
	From the main screen, select the "Create Entry" option. press the button next to the drop down menu labeled 
	"Type", this will take you to the entry type selection window where you can select types to edit. Selecting
	a type will bring up the entry type edit window. Selecting the confirm button will save changes while the 
	delete button will delete the entry type. 

	**WARNING** if the entry type has associated entries, all associated entries will be deleted. A confirmation
	window will appear if you are trying to delete an entry type that has entries.

5.5 Seeing the results of my data inputs

	To view an output of the data, select the "View Data" button from the main screen, this will open the calendar
	panel for a given month (by default the current system date month), pressing the "Visualize" button on the
	bottom right will show a line graph for the selected month. pressing the buttons to either side of the date
	label will change the date one month forward or backwards.


------------------------
6. ACKNOWLEDGEMENTS
------------------------

Acknowledgement of tools and programs used in the development of this project
(Unless otherwise stated the most recent version was used at time of writing 28/07/2023)

-Apache NetBeans IDE ver.13
-Apache Maven 
-InteliiJ IDEA Community Edition
-Hibernate 
-Java Persistence API (JPA)
-PostgreSQL ver.42.6.0
-JUnit ver.5.9.1
-JFreeGraph ver.1.5.3
