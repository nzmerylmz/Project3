package bankAccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddRelative {
    String fullname;
    String age;

    public AddRelative(String fullname, String age) {
        this.fullname = fullname;
        if (!relativeAgeChecker(age)){
            this.age=age;
        }else {
            this.age="0";
        }

    }

    public boolean relativeAgeChecker (String relativeAge){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String text = date.format(formatters);
        LocalDate today = LocalDate.parse(text, formatters);

        int num = today.compareTo(LocalDate.parse(relativeAge, formatters));

        if (num>=18){
            return true;
        }
        else {
            return false;
        }
    }
}
