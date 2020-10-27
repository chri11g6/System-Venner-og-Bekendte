package main.data;

import java.io.IOException;
import java.util.List;

import main.dto.FileData;
import main.dto.Interesser;
import main.dto.Person;

public interface iFile {
	public void saveInteressersAsJSON(FileData data) throws IOException;
	public void savePersonsAsJSON(FileData data) throws IOException;
	public void saveAllAsJSON(FileData data) throws IOException;

	public List<Interesser> loadInteressersAsJSON(String path) throws IOException;
	public List<Person> loadPersonsAsJSON(String path) throws IOException;
	public FileData loadAllAsJSON(String path) throws IOException;
}
