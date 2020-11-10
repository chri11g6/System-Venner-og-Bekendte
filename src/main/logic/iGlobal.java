package main.logic;

import java.io.File;

import main.dto.iPerson;

public interface iGlobal {
	public iPersonLogicData getPersonList();
	public iInteresserLogicData getInteresserList();

	public void setFilePathHolder(File filePath);
	public File getFilePathHolder();

	public void setPersonHolder(iPerson person);
	public iPerson getPersonHolder();

	public void saveToPersonList();

	public void SletFromPersonList();

	public String getSti();
}
