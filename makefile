JC		:= javac

# lib		:= ../lib/json-java.jar
lib		:= lib/json-java.jar
src		:= src
logic	:= $(src)/logic
view	:= $(src)/view
data	:= $(src)/data
dto		:= $(src)/dto/dataType
console	:= $(view)/console
page	:= $(console)/page
display	:= $(console)/display
io		:= $(data)/io
csv		:= $(io)/csv
json	:= $(io)/json

default: $(page)/MenuModul.class $(page)/iPageModul.class $(dto)/Interesser.class $(dto)/Person.class $(logic)/Global.class
	$(JC) $(src)/App.java

# page
$(page)/EditPersonInteresserModul.class: $(logic)/Global.class $(dto)/Interesser.class $(display)/DisplayEditPersonInteresser.class $(display)/iDisplay.class $(display)/PrintTools.class
	$(JC) -cp . $(page)/EditPersonInteresserModul.java

$(page)/FileModul.class: $(logic)/Global.class $(logic)/SaveAndLoad.class $(logic)/iSaveAndLoad.class $(display)/DisplayFile.class $(display)/iDisplay.class
	$(JC) -cp . $(page)/FileModul.java

$(page)/iPageModul.class:
	$(JC) -cp . $(page)/iPageModul.java

$(page)/MenuModul.class: $(logic)/Global.class $(display)/DisplayMenu.class $(display)/iDisplay.class
	$(JC) -cp . $(page)/MenuModul.java

$(page)/OpretInteresserModul.class: $(logic)/Global.class $(dto)/Interesser.class $(display)/DisplayOpretInteresser.class $(display)/iDisplay.class
	$(JC) -cp . $(page)/OpretInteresserModul.java

$(page)/OpretPersonModul.class: $(logic)/Global.class $(dto)/Interesser.class $(dto)/Person.class $(display)/DisplayOpretPerson.class $(display)/iDisplay.class
	$(JC) -cp . $(page)/OpretPersonModul.java

$(page)/SearchModul.class: $(logic)/Global.class $(dto)/Interesser.class $(dto)/Person.class $(display)/DisplaySearch.class $(display)/iDisplay.class $(display)/PrintTools.class $(console)/SearchFilter.class
	$(JC) -cp . $(page)/SearchModul.java

$(page)/ViewModul.class: $(logic)/Global.class $(display)/DisplayView.class $(display)/iDisplay.class $(display)/PrintTools.class
	$(JC) -cp . $(page)/ViewModul.java

$(page)/ViewPersonModul.class: $(logic)/Global.class $(display)/DisplayViewPerson.class $(display)/iDisplay.class
	$(JC) -cp . $(page)/ViewPersonModul.java

# console
$(console)/SearchFilter.class:
	$(JC) -cp . $(console)/SearchFilter.java

# display
$(display)/DisplayEditPersonInteresser.class: $(logic)/Global.class $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplayEditPersonInteresser.java

$(display)/DisplayFile.class: $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplayFile.java

$(display)/DisplayMenu.class: $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplayMenu.java

$(display)/DisplayOpretInteresser.class: $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplayOpretInteresser.java

$(display)/DisplayOpretPerson.class: $(logic)/Global.class
	$(JC) -cp . $(display)/DisplayOpretPerson.java

$(display)/DisplaySearch.class: $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplaySearch.java

$(display)/DisplayView.class: $(display)/iDisplay.class
	$(JC) -cp . $(display)/DisplayView.java

$(display)/DisplayViewPerson.class: $(logic)/Global.class
	$(JC) -cp . $(display)/DisplayViewPerson.java

$(display)/iDisplay.class:
	$(JC) -cp . $(display)/iDisplay.java

$(display)/PrintTools.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp . $(display)/PrintTools.java

$(display)/Tools.class:
	$(JC) -cp . $(display)/Tools.java

# logic
$(logic)/Global.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp . $(logic)/Global.java

$(logic)/iSaveAndLoad.class:
	$(JC) -cp . $(logic)/iSaveAndLoad.java

$(logic)/SaveAndLoad.class: $(dto)/FileData.class $(data)/File.class $(data)/iFile.class
	$(JC) -cp . $(logic)/SaveAndLoad.java

# data
$(data)/File.class: $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class $(data)/iFile.class $(json)/JsonAll.class $(json)/JsonInteresser.class $(json)/JsonPerson.class $(io)/FileIO.class
	$(JC) -cp . $(data)/File.java

$(data)/iFile.class: $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class $(dto)/FileData.class
	$(JC) -cp . $(data)/iFile.java

# io
$(io)/FileIO.class:
	$(JC) -cp . $(io)/FileIO.java

# json
$(json)/JsonAll.class:  $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(lib) . $(json)/JsonAll.java

$(json)/JsonInteresser.class: $(dto)/Interesser.class
	$(JC) -cp $(lib) . $(json)/JsonInteresser.java

$(json)/JsonPerson.class: $(dto)/Person.class
	$(JC) -cp $(lib) . $(json)/JsonPerson.java

# csv
$(csv)/JsonPerson.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp . $(csv)/JsonPerson.java

# dto/dataType
$(dto)/Person.class: $(dto)/Interesser.class
	$(JC) -cp . $(dto)/Person.java

$(dto)/Interesser.class:
	$(JC) -cp . $(dto)/Interesser.java

$(dto)/FileData.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp . $(dto)/FileData.java

clean:
	find -iname "*.class" -delete