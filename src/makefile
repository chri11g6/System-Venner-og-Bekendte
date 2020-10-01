JC		:= javac

logic	:= logic
view	:= view
data	:= data
dto		:= dto/dataType
console	:= $(view)/console
page	:= $(console)/page
display	:= $(console)/display
io		:= $(data)/io
csv		:= $(io)/csv
json	:= $(io)/json

default:
	# page
	$(JC) -cp . $(page)/EditPersonInteresserModul.java
	$(JC) -cp . $(page)/FileModul.java
	$(JC) -cp . $(page)/iPageModul.java
	$(JC) -cp . $(page)/MenuModul.java
	$(JC) -cp . $(page)/OpretInteresserModul.java
	$(JC) -cp . $(page)/OpretPersonModul.java
	$(JC) -cp . $(page)/SearchModul.java
	$(JC) -cp . $(page)/ViewModul.java
	$(JC) -cp . $(page)/ViewPersonModul.java
	# display
	$(JC) -cp . $(display)/DisplayEditPersonInteresser.java
	$(JC) -cp . $(display)/DisplayFile.java
	$(JC) -cp . $(display)/DisplayMenu.java
	$(JC) -cp . $(display)/DisplayOpretInteresser.java
	$(JC) -cp . $(display)/DisplayOpretPerson.java
	$(JC) -cp . $(display)/DisplaySearch.java
	$(JC) -cp . $(display)/DisplayView.java
	$(JC) -cp . $(display)/DisplayViewPerson.java
	$(JC) -cp . $(display)/iDisplay.java
	$(JC) -cp . $(display)/PrintTools.java
	$(JC) -cp . $(display)/Tools.java
	# console
	$(JC) -cp . $(console)/SearchFilter.java
	# logic
	$(JC) -cp . $(logic)/Global.java
	$(JC) -cp . $(logic)/iSaveAndLoad.java
	$(JC) -cp . $(logic)/SaveAndLoad.java
	# dto
	$(JC) -cp . $(dto)/FileData.java
	$(JC) -cp . $(dto)/iSaveAndLoad.java
	$(JC) -cp . $(dto)/SaveAndLoad.java
	# data
	$(JC) -cp . $(data)/File.java
	$(JC) -cp . $(data)/iFile.java
	# io
	$(JC) -cp . $(io)/FileIO.java
	# json
	$(JC) -cp . $(json)/JsonAll.java
	$(JC) -cp . $(json)/JsonInteresser.java
	$(JC) -cp . $(json)/JsonPerson.java
	# csv
	$(JC) -cp . $(csv)/CsvPerson.java

	$(JC) App.java

# default: $(page)/MenuModul.class $(page)/iPageModul.class $(dto)/Interesser.class $(dto)/Person.class $(logic)/Global.class
# 	$(JC) App.java

# # page
# $(page)/EditPersonInteresserModul.class: $(logic)/Global.class $(dto)/Interesser.class $(display)/DisplayEditPersonInteresser.class $(display)/iDisplay.class $(display)/PrintTools.class
# 	$(JC) -cp . $(page)/EditPersonInteresserModul.java

# $(page)/MenuModul.class: $(logic)/Global.class $(display)/DisplayMenu.class $(display)/iDisplay.class
# 	$(JC) -cp . $(page)/MenuModul.java

# $(page)/iPageModul.class:
# 	$(JC) -cp . $(page)/iPageModul.java

# # dto/dataType
# $(dto)/Person.class: $(dto)/Interesser.class
# 	$(JC) -cp . $(dto)/Person.java

# $(dto)/Interesser.class:
# 	$(JC) -cp . $(dto)/Interesser.java

# $(dto)/FileData.class: $(dto)/Interesser.class $(dto)/Person.class
# 	$(JC) -cp . $(dto)/FileData.java