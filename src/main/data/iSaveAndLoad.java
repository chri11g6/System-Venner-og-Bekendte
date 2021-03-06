package main.data;

import java.io.File;
import java.io.IOException;

public interface iSaveAndLoad {
	public void saveInteressersAsJSON(String path) throws IOException;

	public void savePersonsAsJSON(String path) throws IOException;

	public void saveAllAsJSON(String path) throws IOException;

	public void loadInteressersAsJSON(String path) throws IOException;

	public void loadPersonsAsJSON(String path) throws IOException;

	public void loadAllAsJSON(String path) throws IOException;

	public void saveInteressersAsJSON(File filePath) throws IOException;

	public void savePersonsAsJSON(File filePath) throws IOException;

	public void saveAllAsJSON(File filePath) throws IOException;

	public void loadInteressersAsJSON(File filePath) throws IOException;

	public void loadPersonsAsJSON(File filePath) throws IOException;

	public void loadAllAsJSON(File filePath) throws IOException;
}
