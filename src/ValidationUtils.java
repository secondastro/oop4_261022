
import java.time.LocalDate;

public class ValidationUtils {
    public static String validationString(String value, String defaultValue) {
        return value==null||value.isBlank()||value.isEmpty()? defaultValue : value;
    }

    public static int validationAge(int value) {
        int age = 0;
        if (value < LocalDate.now().getYear()) {
            if (value > 0) {
                age = LocalDate.now().getYear() - value;
            } else {
                age = LocalDate.now().getYear() - Math.abs(value);
            }
        } else if (value>LocalDate.now().getYear() || value == 0) {
            throw new RuntimeException("Год не корректный");
        }
        return age;
    }

    public static int validationInt(int value){
        if (value==0) {
            throw new RuntimeException("Ошибка");
        } else if (value < 0) {
            value = Math.abs(value);
        }
        return value;
    }
}
