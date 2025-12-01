package pr13.task2;

public class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    public String getFullNameInitials() {
        StringBuilder result = new StringBuilder();

        // Фамилия
        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }

        // Имя
        if (firstName != null && !firstName.isEmpty()) {
            addInitial(result, firstName.charAt(0));
        }

        // Отчество
        if (middleName != null && !middleName.isEmpty()) {
            addInitial(result, middleName.charAt(0));
        }

        return result.toString();
    }


    private void addInitial(StringBuilder builder, char initial) {
        if (!builder.isEmpty()) {
            builder.append(' ');
        }
        builder.append(initial).append('.');
    }

}
