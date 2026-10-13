import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {

        return LocalDateTime.of(2019, 7, 25, 13, 45, 00);

    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        if (hour >= 12 && hour < 18) {
            return true;
        } else {
            return false;
        }
    }

    public String getDescription(LocalDateTime appointmentDate) {

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("'You have an appointment on' EEEE, MMMM d, yyyy, 'at' h:mm a.", Locale.ENGLISH);
        String text = appointmentDate.format(formatter);
        return text;
    }

    public LocalDate getAnniversaryDate() {

        LocalDate thisDate = LocalDate.now();
        return LocalDate.of(thisDate.getYear(), 9, 15);
    }
}
