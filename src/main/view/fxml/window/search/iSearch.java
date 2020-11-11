package main.view.fxml.window.search;

import java.util.List;

import main.dto.iInteresser;
import main.dto.iPerson;

public interface iSearch {
	public List<iPerson> searchPerson(String searchText, List<iPerson> personsList);
	public List<iInteresser> searchInteresser(String searchText, List<iInteresser> interessersList);
}
