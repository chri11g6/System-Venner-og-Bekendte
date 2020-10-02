JC		:= javac

JCFLAG	:=

lib		:= lib/json-java.jar
src		:= src
logic	:= $(src)/logic
view	:= $(src)/view
data	:= $(src)/data
dto		:= $(src)/dto
console	:= $(view)/console
page	:= $(console)/page
display	:= $(console)/display
io		:= $(data)/io
csv		:= $(io)/csv
json	:= $(io)/json

default: $(page)/MenuModul.class $(page)/iPageModul.class $(dto)/Interesser.class $(dto)/Person.class $(logic)/Global.class
	$(JC) -cp $(src) $(JCFLAG) $(src)/App.java

# page
$(page)/EditPersonInteresserModul.class: $(logic)/Global.class $(dto)/Interesser.class $(display)/DisplayEditPersonInteresser.class $(display)/iDisplay.class $(display)/PrintTools.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/EditPersonInteresserModul.java

$(page)/FileModul.class: $(logic)/Global.class $(logic)/SaveAndLoad.class $(logic)/iSaveAndLoad.class $(display)/DisplayFile.class $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/FileModul.java

$(page)/iPageModul.class:
	$(JC) -cp $(src) $(JCFLAG) $(page)/iPageModul.java

$(page)/MenuModul.class: $(logic)/Global.class $(display)/DisplayMenu.class $(display)/iDisplay.class $(page)/OpretPersonModul.class $(page)/FileModul.class $(page)/SearchModul.class $(page)/ViewModul.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/MenuModul.java

$(page)/OpretInteresserModul.class: $(logic)/Global.class $(dto)/Interesser.class $(display)/DisplayOpretInteresser.class $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/OpretInteresserModul.java

$(page)/OpretPersonModul.class: $(logic)/Global.class $(dto)/Interesser.class $(dto)/Person.class $(display)/DisplayOpretPerson.class $(display)/iDisplay.class $(page)/OpretInteresserModul.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/OpretPersonModul.java

$(page)/SearchModul.class: $(logic)/Global.class $(dto)/Interesser.class $(dto)/Person.class $(display)/DisplaySearch.class $(display)/iDisplay.class $(display)/PrintTools.class $(console)/SearchFilter.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/SearchModul.java

$(page)/ViewModul.class: $(logic)/Global.class $(display)/DisplayView.class $(display)/iDisplay.class $(display)/PrintTools.class $(page)/ViewPersonModul.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/ViewModul.java

$(page)/ViewPersonModul.class: $(logic)/Global.class $(display)/DisplayViewPerson.class $(display)/iDisplay.class $(page)/EditPersonInteresserModul.class
	$(JC) -cp $(src) $(JCFLAG) $(page)/ViewPersonModul.java

# console
$(console)/SearchFilter.class:
	$(JC) -cp $(src) $(JCFLAG) $(console)/SearchFilter.java

# display
$(display)/DisplayEditPersonInteresser.class: $(logic)/Global.class $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayEditPersonInteresser.java

$(display)/DisplayFile.class: $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayFile.java

$(display)/DisplayMenu.class: $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayMenu.java

$(display)/DisplayOpretInteresser.class: $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayOpretInteresser.java

$(display)/DisplayOpretPerson.class: $(logic)/Global.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayOpretPerson.java

$(display)/DisplaySearch.class: $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplaySearch.java

$(display)/DisplayView.class: $(display)/iDisplay.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayView.java

$(display)/DisplayViewPerson.class: $(logic)/Global.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/DisplayViewPerson.java

$(display)/iDisplay.class:
	$(JC) -cp $(src) $(JCFLAG) $(display)/iDisplay.java

$(display)/PrintTools.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(src) $(JCFLAG) $(display)/PrintTools.java

$(display)/Tools.class:
	$(JC) -cp $(src) $(JCFLAG) $(display)/Tools.java

# logic
$(logic)/Global.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(src) $(JCFLAG) $(logic)/Global.java

$(logic)/iSaveAndLoad.class:
	$(JC) -cp $(src) $(JCFLAG) $(logic)/iSaveAndLoad.java

$(logic)/SaveAndLoad.class: $(dto)/FileData.class $(data)/File.class $(data)/iFile.class
	$(JC) -cp $(src) $(JCFLAG) $(logic)/SaveAndLoad.java

# data
$(data)/File.class: $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class $(data)/iFile.class $(json)/JsonAll.class $(json)/JsonInteresser.class $(json)/JsonPerson.class $(io)/FileIO.class
	$(JC) -cp $(src) $(JCFLAG) $(data)/File.java

$(data)/iFile.class: $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class $(dto)/FileData.class
	$(JC) -cp $(src) $(JCFLAG) $(data)/iFile.java

# io
$(io)/FileIO.class:
	$(JC) -cp $(src) $(JCFLAG) $(io)/FileIO.java

# json
$(json)/JsonAll.class: $(dto)/FileData.class $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(lib):$(src) $(JCFLAG) $(json)/JsonAll.java

$(json)/JsonInteresser.class: $(dto)/Interesser.class
	$(JC) -cp $(lib):$(src) $(JCFLAG) $(json)/JsonInteresser.java

$(json)/JsonPerson.class: $(dto)/Person.class
	$(JC) -cp $(lib):$(src) $(JCFLAG) $(json)/JsonPerson.java

# csv
$(csv)/JsonPerson.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(src) $(JCFLAG) $(csv)/JsonPerson.java

# dto/dataType
$(dto)/Person.class: $(dto)/Interesser.class
	$(JC) -cp $(src) $(JCFLAG) $(dto)/Person.java

$(dto)/Interesser.class:
	$(JC) -cp $(src) $(JCFLAG) $(dto)/Interesser.java

$(dto)/FileData.class: $(dto)/Interesser.class $(dto)/Person.class
	$(JC) -cp $(src) $(JCFLAG) $(dto)/FileData.java

clean:
	find -iname "*.class" -delete