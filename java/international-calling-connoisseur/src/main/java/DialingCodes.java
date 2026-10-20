import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    Map<Integer, String> dialingCode = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return dialingCode;
    }

    public void setDialingCode(Integer code, String country) {
        dialingCode.put(code, country);
    }

    public String getCountry(Integer code) {
        String country = dialingCode.get(code);

        return country;
    }

    public void addNewDialingCode(Integer code, String country) {

        if (dialingCode.containsKey(code) || dialingCode.containsValue(country)) {
            return;
        } else {
            dialingCode.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {

        for (Map.Entry<Integer, String> entry : dialingCode.entrySet()) {

            if (entry.getValue() == country) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {

        if (dialingCode.containsValue(country)) {

            dialingCode.remove(findDialingCode(country));

        }
        dialingCode.put(code, country);
    }
}
