package view.console.page;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.DataType.Global;
import data.DataType.Interesser;
import data.DataType.Person;
import data.DataType.SearchFilter;
import view.console.Display.DisplaySearch;
import view.console.Display.PrintTools;
import view.console.Display.iDisplay;

public class SearchModul implements iPageModul {

    private iDisplay display = new DisplaySearch();
    private ArrayList<Person> personSearchList = new ArrayList<Person>();
    private ArrayList<Interesser> interesserSearchList = new ArrayList<Interesser>();

    @Override
    public void run() {
        boolean isRun = true;

        Global.sti.push("Søg");

        do {

            String[] key = display.getInputString(Global.getSti()).split(" ");

            switch (key[0]) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "pwd":
                    System.out.println("Du er i søge måde");
                    break;
                case "person":
                    search(key);
                    PrintTools.printPersonList(personSearchList);
                    break;
                case "interesser":
                    search(key);
                    PrintTools.printInteresserList(interesserSearchList);
                    break;
                case "q":
                case "exit":
                    isRun = false;
                    break;
                default:
                    System.out.println("'h' eller 'help' For at få hjælp");
                    break;
            }

        } while (isRun);
        Global.sti.pop();
    }

    private void search(String[] word) {
        ArrayList<SearchFilter> filtersList = new ArrayList<SearchFilter>();

        int counter = 3;

        try {

            if (word[0].equalsIgnoreCase("person")) {
                counter = 3;
            } else if (word[0].equalsIgnoreCase("interesser")) {
                counter = 2;
            }

            for (int i = 1; i < word.length; i += counter) {
                SearchFilter filter = new SearchFilter();
                if (word[0].equalsIgnoreCase("person")) {
                    switch (word[i]) {
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
                        case "interesser":
                            filter.permeter = "interesser";
                            break;
                        default:
                            throw new IllegalArgumentException("Der finde ikke en permeter der hedder " + word[i]);
                        // break;
                    }
                    filter.keyword = word[i + 1];
                } else if (word[0].equalsIgnoreCase("interesser")) {
                    filter.permeter = "interesser";
                    filter.keyword = word[i];
                } else {
                    throw new IllegalArgumentException("Kan ikke søge i: " + word[0]);
                }

                

                if (i - 1 > 0) {
                    switch (word[i - 1]) {
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
                            throw new IllegalArgumentException("Der finde ikke en operators der hedder " + word[i + 2]);
                        // break;
                    }
                } else {
                    filter.type = SearchFilter.Operators.OR;
                }

                filtersList.add(filter);
            }

            if (word[0].equalsIgnoreCase("person")) {
                searchPersonFunction(filtersList);
            } else if (word[0].equalsIgnoreCase("interesser")) {
                searchInteresserFunction(filtersList);
            } else {
                throw new IllegalArgumentException("Der ikke en function til: " + word[0]);
            }

        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke sætte denne parmeter fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }

    private void searchInteresserFunction(ArrayList<SearchFilter> filtersList) {
        ArrayList<ArrayList<SearchFilter>> fullList = sortFilter(filtersList);

        ArrayList<SearchFilter> orList = fullList.get(0);
        ArrayList<SearchFilter> andList = fullList.get(1);
        ArrayList<SearchFilter> notList = fullList.get(2);

        ArrayList<Interesser> bufferList = new ArrayList<Interesser>();

        interesserSearchList.clear();

        interesserSearchList.addAll(searchInteresserData(orList, Global.interesserList));
        if (andList.size() != 0) {
            bufferList.clear();
            bufferList.addAll(searchInteresserData(andList, interesserSearchList));
            interesserSearchList.clear();
            interesserSearchList.addAll(bufferList);
        }
        if (notList.size() != 0) {
            bufferList.clear();
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

    private void searchPersonFunction(ArrayList<SearchFilter> filtersList) {
        ArrayList<ArrayList<SearchFilter>> fullList = sortFilter(filtersList);

        ArrayList<SearchFilter> orList = fullList.get(0);
        ArrayList<SearchFilter> andList = fullList.get(1);
        ArrayList<SearchFilter> notList = fullList.get(2);

        ArrayList<Person> bufferList = new ArrayList<Person>();

        personSearchList.clear();

        personSearchList.addAll(searchPersonData(orList, Global.personList));
        if (andList.size() != 0) {
            bufferList.clear();
            bufferList.addAll(searchPersonData(andList, personSearchList));
            personSearchList.clear();
            personSearchList.addAll(bufferList);
        }
        if (notList.size() != 0) {
            bufferList.clear();
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

    private ArrayList<Interesser> searchInteresserData(ArrayList<SearchFilter> filterList, ArrayList<Interesser> interesserList){
        ArrayList<Interesser> bufferList = new ArrayList<Interesser>();
        filterList.forEach(filter -> {
            interesserList.forEach(interesser -> {
                if(regexTest(filter.keyword, interesser.navn)){
                    bufferList.add(interesser);
                }
            });
        });

        return bufferList;
    }

    private ArrayList<Person> searchPersonData(ArrayList<SearchFilter> filterList, ArrayList<Person> personList) {
        ArrayList<Person> bufferList = new ArrayList<Person>();
        filterList.forEach(filter -> {
            personList.forEach(person -> {
                switch (filter.permeter) {
                    case "fornavn":
                        if (regexTest(filter.keyword, person.forNavn)) {
                            bufferList.add(person);
                        }
                        break;
                    case "efternavn":
                        if (regexTest(filter.keyword, person.efterNavn)) {
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
                    case "interesser":
                        for (int i = 0; i < person.interesser.size(); i++) {
                            if (regexTest(filter.keyword, person.interesser.get(i).navn)) {
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

    private ArrayList<ArrayList<SearchFilter>> sortFilter(ArrayList<SearchFilter> filtersList){
        ArrayList<SearchFilter> orList = new ArrayList<SearchFilter>();
        ArrayList<SearchFilter> andList = new ArrayList<SearchFilter>();
        ArrayList<SearchFilter> notList = new ArrayList<SearchFilter>();

        ArrayList<ArrayList<SearchFilter>> fullList = new ArrayList<ArrayList<SearchFilter>>();

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
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(Text);
        return m.find();
    }

}
