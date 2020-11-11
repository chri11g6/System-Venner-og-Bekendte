package main.view.fxml.window.search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.dto.iInteresser;
import main.dto.iPerson;

class Search implements iSearch {

	private List<iPerson> personSearchList = new ArrayList<iPerson>();
	private List<iPerson> personsList = new ArrayList<iPerson>();

	private List<iInteresser> interesserSearchList = new ArrayList<iInteresser>();
	private List<iInteresser> interessersList = new ArrayList<iInteresser>();

	private boolean isSearchForPerson = false;

	@Override
	public List<iPerson> searchPerson(String searchText, List<iPerson> personsList) {
		clearAllList();
		this.personsList.addAll(personsList);
		isSearchForPerson = true;
		getSearchFromText(searchText);
		return personSearchList;
	}

	@Override
	public List<iInteresser> searchInteresser(String searchText, List<iInteresser> interessersList) {
		clearAllList();
		this.interessersList.addAll(interessersList);
		isSearchForPerson = false;
		getSearchFromText(searchText);
		return interesserSearchList;
	}

	private void clearAllList(){
		personSearchList.clear();
		personsList.clear();
		interesserSearchList.clear();
		interessersList.clear();
	}

	private void getSearchFromText(String word){
		boolean isAdvancedSearch = false;

		isAdvancedSearch = regexTest("fornavn", word);
		isAdvancedSearch |= regexTest("efternavn", word);
		isAdvancedSearch |= regexTest("telefon", word);
		isAdvancedSearch |= regexTest("email", word);
		isAdvancedSearch |= regexTest("alder", word);
		isAdvancedSearch |= regexTest("interesser", word);
		isAdvancedSearch |= regexTest("title", word);
		isAdvancedSearch |= regexTest("by", word);
		isAdvancedSearch |= regexTest("gade", word);
		isAdvancedSearch |= regexTest("land", word);
		isAdvancedSearch |= regexTest("nr", word);
		isAdvancedSearch |= regexTest("postNr", word);
		isAdvancedSearch |= regexTest("or", word);
		isAdvancedSearch |= regexTest("and", word);
		isAdvancedSearch |= regexTest("not", word);

		if(isAdvancedSearch){
			getSearchAdvanced(word);
		} else {
			getSearchSimple(word);
		}
	}

	private void getSearchSimple(String word){
		String oneWord = word.split(" ")[0];

		if(isSearchForPerson){
			for(iPerson person : personsList){
				if(testPersonSimple(person, oneWord)){
					personSearchList.add(person);
				}
			}
		} else {
			for(iInteresser interesser : interessersList){
				if(interesser.getNavn().equalsIgnoreCase(oneWord)){
					interesserSearchList.add(interesser);
				}
			}
		}

	}

	private boolean testPersonSimple(iPerson person, String word) {
		boolean isOK = false;

		isOK = regexTest(word, person.getForNavn());
		isOK |= regexTest(word, person.getEfterNavn());
		isOK |= regexTest(word, person.getTelefon());
		isOK |= regexTest(word, person.getEmail());
		isOK |= regexTest(word, person.getTitle());
		isOK |= regexTest(word, person.getBirthday().getBirthdays());
		isOK |= regexTest(word, person.getPersonInteresserList().toString());
		isOK |= regexTest(word, person.getAddress().getBy());
		isOK |= regexTest(word, person.getAddress().getGade());
		isOK |= regexTest(word, person.getAddress().getLand());
		isOK |= regexTest(word, person.getAddress().getNr());
		isOK |= regexTest(word, person.getAddress().getPostNr());

		return isOK;
	}

	private void getSearchAdvanced(String word) {
		String[] words = word.split(" ");

		List<SearchFilter> filtersList = new ArrayList<SearchFilter>();

		int counter = 3;

		try {

			if (isSearchForPerson) {
				counter = 3;
			} else {
				counter = 2;
			}

			for (int i = 0; i < words.length; i += counter) {
				SearchFilter filter = new SearchFilter();
				if (isSearchForPerson) {
					switch (words[i]) {
						case "not":
							if(i == 0){
								filter.type = SearchFilter.Operators.NOT;
								i += 1;
							}
						case "fornavn":
							filter.permeter = "fornavn";
							break;
						case "efternavn":
							filter.permeter = "efternavn";
							break;
						case "telefon":
							filter.permeter = "telefon";
							break;
						case "email":
							filter.permeter = "email";
							break;
						case "title":
							filter.permeter = "title";
							break;
						case "by":
							filter.permeter = "by";
							break;
						case "gade":
							filter.permeter = "gade";
							break;
						case "land":
							filter.permeter = "land";
							break;
						case "nr":
							filter.permeter = "nr";
							break;
						case "postNr":
							filter.permeter = "postNr";
							break;
						case "alder":
							i += 1;
							filter.permeter = "alder";
							filter.tegn = words[i];
							break;
						case "interesser":
							filter.permeter = "interesser";
							break;
						default:
							throw new IllegalArgumentException("Der finde ikke en permeter der hedder " + words[i]);
						// break;
					}
					filter.keyword = words[i + 1];
				} else {
					if(i == 0){
						filter.type = SearchFilter.Operators.NOT;
						i += 1;
					}
					filter.permeter = "interesser";
					filter.keyword = words[i];
				}

				if (i - 1 > 0) {
					switch (words[i - 1]) {
						case "and":
							filter.type = SearchFilter.Operators.AND;
							break;
						case "or":
							filter.type = SearchFilter.Operators.OR;
							break;
						case "not":
							filter.type = SearchFilter.Operators.NOT;
							break;
						default:
							throw new IllegalArgumentException(
									"Der finde ikke en operators der hedder " + words[i + 2]);
						// break;
					}
				} else {
					if(filter.type == null){
						filter.type = SearchFilter.Operators.OR;
					}
				}

				filtersList.add(filter);
			}

			if (isSearchForPerson) {
				searchPersonFunction(filtersList);
			} else {
				searchInteresserFunction(filtersList);
			}

		} catch (Exception e) {
			System.out.println("Kunne ikke sætte denne parmeter fordi:");
			System.out.println(e.getMessage());
		}
	}

	private void searchPersonFunction(List<SearchFilter> filtersList) {
		List<List<SearchFilter>> fullList = sortFilter(filtersList);

		List<SearchFilter> orList = fullList.get(0);
		List<SearchFilter> andList = fullList.get(1);
		List<SearchFilter> notList = fullList.get(2);

		List<iPerson> bufferList = new ArrayList<iPerson>();

		personSearchList.clear();

		if(orList.size() != 0){
			personSearchList.addAll(searchPersonData(orList, personsList));
		}else{
			personSearchList.addAll(personsList);
		}

		bufferList.clear();
		if (andList.size() != 0) {
			bufferList.addAll(searchPersonData(andList, personSearchList));
			personSearchList.clear();
			personSearchList.addAll(bufferList);
		}
		bufferList.clear();
		if (notList.size() != 0) {
			bufferList = searchPersonData(notList, personSearchList);
		}

		bufferList.forEach(person -> personSearchList.remove(person));
		bufferList.clear();

		// Sletter dubble person
		for (int i = 0; i < personSearchList.size(); i++) {
			if (bufferList.indexOf(personSearchList.get(i)) == -1) {
				bufferList.add(personSearchList.get(i));
			}
		}

		personSearchList.clear();
		personSearchList.addAll(bufferList);

	}

	private void searchInteresserFunction(List<SearchFilter> filtersList) {
		List<List<SearchFilter>> fullList = sortFilter(filtersList);

		List<SearchFilter> orList = fullList.get(0);
		List<SearchFilter> andList = fullList.get(1);
		List<SearchFilter> notList = fullList.get(2);

		List<iInteresser> bufferList = new ArrayList<iInteresser>();

		interesserSearchList.clear();

		if (orList.size() != 0){
			interesserSearchList.addAll(searchInteresserData(orList, interessersList));
		} else {
			interesserSearchList.addAll(interessersList);
		}

		bufferList.clear();
		if (andList.size() != 0) {
			bufferList.addAll(searchInteresserData(andList, interesserSearchList));
			interesserSearchList.clear();
			interesserSearchList.addAll(bufferList);
		}
		bufferList.clear();
		if (notList.size() != 0) {
			bufferList = searchInteresserData(notList, interesserSearchList);
		}

		bufferList.forEach(person -> interesserSearchList.remove(person));
		bufferList.clear();

		// Sletter dubble person
		for (int i = 0; i < interesserSearchList.size(); i++) {
			if (bufferList.indexOf(interesserSearchList.get(i)) == -1) {
				bufferList.add(interesserSearchList.get(i));
			}
		}

		interesserSearchList.clear();
		interesserSearchList.addAll(bufferList);

	}

	private List<iInteresser> searchInteresserData(List<SearchFilter> filterList, List<iInteresser> interesserList) {
		List<iInteresser> bufferList = new ArrayList<iInteresser>();
		filterList.forEach(filter -> {
			interesserList.forEach(interesser -> {
				if (regexTest(filter.keyword, interesser.getNavn())) {
					bufferList.add(interesser);
				}
			});
		});

		return bufferList;
	}

	private List<iPerson> searchPersonData(List<SearchFilter> filterList, List<iPerson> personList) {
		List<iPerson> bufferList = new ArrayList<iPerson>();
		filterList.forEach(filter -> {
			personList.forEach(person -> {
				switch (filter.permeter) {
					case "fornavn":
						if (regexTest(filter.keyword, person.getForNavn())) {
							bufferList.add(person);
						}
						break;
					case "efternavn":
						if (regexTest(filter.keyword, person.getEfterNavn())) {
							bufferList.add(person);
						}
						break;
					case "telefon":
						if (regexTest(filter.keyword, person.getTelefon())) {
							bufferList.add(person);
						}
						break;
					case "email":
						if (regexTest(filter.keyword, person.getEmail())) {
							bufferList.add(person);
						}
						break;
					case "title":
						if (regexTest(filter.keyword, person.getTitle())) {
							bufferList.add(person);
						}
						break;
					case "by":
						if (regexTest(filter.keyword, person.getAddress().getBy())) {
							bufferList.add(person);
						}
						break;
					case "gade":
						if (regexTest(filter.keyword, person.getAddress().getGade())) {
							bufferList.add(person);
						}
						break;
					case "land":
						if (regexTest(filter.keyword, person.getAddress().getLand())) {
							bufferList.add(person);
						}
						break;
					case "nr":
						if (regexTest(filter.keyword, person.getAddress().getNr())) {
							bufferList.add(person);
						}
						break;
					case "postNr":
						if (regexTest(filter.keyword, person.getAddress().getPostNr())) {
							bufferList.add(person);
						}
						break;
					case "alder":
						switch (filter.tegn) {
							case "<":
								if (person.getBirthday().getAlder() < Integer.parseInt(filter.keyword)){
									bufferList.add(person);
								}
								break;
							case ">":
								if (person.getBirthday().getAlder() > Integer.parseInt(filter.keyword)){
									bufferList.add(person);
								}
								break;
							case "=<":
							case "<=":
								if (person.getBirthday().getAlder() <= Integer.parseInt(filter.keyword)){
									bufferList.add(person);
								}
								break;
							case "=>":
							case ">=":
								if (person.getBirthday().getAlder() >= Integer.parseInt(filter.keyword)){
									bufferList.add(person);
								}
								break;
							case "=":
							case "==":
								if (person.getBirthday().getAlder() == Integer.parseInt(filter.keyword)){
									bufferList.add(person);
								}
								break;
						}
						
						break;
					case "interesser":
						for (int i = 0; i < person.getPersonInteresserList().getInteresser().size(); i++) {
							if (regexTest(filter.keyword,
									person.getPersonInteresserList().getInteresser().get(i).getNavn())) {
								bufferList.add(person);
								break;
							}
						}
						break;
					default:
						break;
				}
			});
		});

		return bufferList;
	}

	private List<List<SearchFilter>> sortFilter(List<SearchFilter> filtersList) {
		List<SearchFilter> orList = new ArrayList<SearchFilter>();
		List<SearchFilter> andList = new ArrayList<SearchFilter>();
		List<SearchFilter> notList = new ArrayList<SearchFilter>();

		List<List<SearchFilter>> fullList = new ArrayList<List<SearchFilter>>();

		filtersList.forEach(filter -> {
			if (filter.type == SearchFilter.Operators.OR) {
				orList.add(filter);
			} else if (filter.type == SearchFilter.Operators.AND) {
				andList.add(filter);
			} else if (filter.type == SearchFilter.Operators.NOT) {
				notList.add(filter);
			}
		});

		fullList.add(orList);
		fullList.add(andList);
		fullList.add(notList);

		return fullList;
	}

	private boolean regexTest(String regex, String Text) {
		if(Text == null){
			return false;
		}

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(Text);
		return m.find();
	}

}
