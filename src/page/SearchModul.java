package page;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataType.Global;
import DataType.Person;
import DataType.SearchFilter;
import Display.DisplaySearch;
import Display.PrintTools;
import Display.iDisplay;

public class SearchModul implements iPageModul {

    private iDisplay display = new DisplaySearch();
    private ArrayList<Person> searchList = new ArrayList<Person>();

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
                case "search":
                    search(key);
                    PrintTools.printPersonList(searchList);
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

        try {
            for (int i = 1; i < word.length; i += 3) {
                SearchFilter filter = new SearchFilter();
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

            searchFunction(filtersList);

        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke sætte denne parmeter fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }

    private void searchFunction(ArrayList<SearchFilter> filtersList) {
        ArrayList<SearchFilter> orList = new ArrayList<SearchFilter>();
        ArrayList<SearchFilter> andList = new ArrayList<SearchFilter>();
        ArrayList<SearchFilter> notList = new ArrayList<SearchFilter>();

        ArrayList<Person> bufferList = new ArrayList<Person>();

        searchList.clear();

        filtersList.forEach(filter -> {
            if (filter.type == SearchFilter.Operators.OR) {
                orList.add(filter);
            } else if (filter.type == SearchFilter.Operators.AND) {
                andList.add(filter);
            } else if (filter.type == SearchFilter.Operators.NOT) {
                notList.add(filter);
            }
        });

        searchList.addAll(searchData(orList, Global.personList));
        if(andList.size() != 0){
            bufferList.clear();
            bufferList.addAll(searchData(andList, searchList));
            searchList.clear();
            searchList.addAll(bufferList);
        }
        if(notList.size() != 0){
            bufferList.clear();
            bufferList = searchData(notList, searchList);
        }

        bufferList.forEach(person -> searchList.remove(person));
        bufferList.clear();

        // filter dubble
        for (int i = 0; i < searchList.size(); i++) {
            if (bufferList.indexOf(searchList.get(i)) == -1){
                bufferList.add(searchList.get(i));
            }
        }

        searchList.clear();
        searchList.addAll(bufferList);

    }

    private ArrayList<Person> searchData(ArrayList<SearchFilter> filterList, ArrayList<Person> personList){
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

    private boolean regexTest(String regex, String Text){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(Text);
        return m.find();
    }

}
