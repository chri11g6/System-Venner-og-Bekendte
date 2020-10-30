package main.data;

import java.io.IOException;
import java.util.List;

import main.dto.FileData;
import main.dto.iInteresser;
import main.dto.iPerson;

public interface iFile {
	public void saveInteressersAsJSON(FileData data) throws IOException;
	public void savePersonsAsJSON(FileData data) throws IOException;
	public void saveAllAsJSON(FileData data) throws IOException;

	public List<iInteresser> loadInteressersAsJSON(String path) throws IOException;
	public List<iPerson> loadPersonsAsJSON(String path) throws IOException;
	public FileData loadAllAsJSON(String path) throws IOException;
}
