package data.DataType;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private int id;
    private static int counter = 0;
    public String forNavn;
    public String efterNavn;
    public int alder;
    private String telefon;
    private String email;
    public ArrayList<Interesser> interesser = new ArrayList<Interesser>();

    public Person(){
        this.id = counter;
        counter++;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail() {
        if(this.email != null){
            return this.email;
        }else{
            return "";
        }
    }

    public void setEmail(String email) {
        if (email.isEmpty()){
            this.email = "";
            return;
        }

        Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
        Matcher m = p.matcher(email);

        if (m.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email er ikke gyldig");
        }
    }

    public String getTelefon() {
        if(this.telefon != null){
            return this.telefon;
        }else{
            return "";
        }
    }

    public void setTelefon(String telefon) {
        if (telefon.isEmpty()){
            this.telefon = "";
            return;
        }

        Pattern p = Pattern.compile("(\\+?\\d{1,6})?(\\d{2} ?){4}");
        Matcher m = p.matcher(telefon);

        if (m.matches()) {
            this.telefon = telefon;
        } else {
            throw new IllegalArgumentException("Telefon nummer er ikke gyldig");
        }
    }
}
