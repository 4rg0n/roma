package roma;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominic Roenicke <droenicke@cyberport.de>
 */
public class Roma
{
    private Map<Character, Integer> romaMap;

    public Roma() {
        romaMap = new HashMap<>();

        romaMap.put('I', 1);
        romaMap.put('V', 5);
        romaMap.put('X', 10);
        romaMap.put('L', 50);
        romaMap.put('C', 100);
        romaMap.put('D', 500);
        romaMap.put('M', 1000);
    }

    public Integer calculateNumeral(final String roma)
    {
        Integer result = 0;

        if (roma == null) {
            throw new InvalidArgumentException("Darf not null sein.");
        }

        for (int i = 0; i < roma.length(); i++) {
            char romaLetter = roma.charAt(i);
            Integer romaValue = romaMap.get(romaLetter);

            if (romaValue == null) {
                throw new InvalidArgumentException(romaLetter + " ist kacke!");
            }

            if (i + 1 < roma.length()) {
                char nextRomaLetter = roma.charAt(i + 1);

                if (romaLetter == 'I' && (nextRomaLetter == 'V' || nextRomaLetter == 'X')) {
                    result -= 1;
                    continue;
                }

                if (romaLetter == 'X' && (nextRomaLetter == 'L' || nextRomaLetter == 'C')) {
                    result -= 10;
                    continue;
                }

                if (romaLetter == 'C' && (nextRomaLetter == 'D' || nextRomaLetter == 'M')) {
                    result -= 10;
                    continue;
                }

                Integer nextRomaValue = romaMap.get(nextRomaLetter);

                if (nextRomaValue == null) {
                    throw new InvalidArgumentException(nextRomaLetter + " ist kacke!");
                }

                if (nextRomaValue > romaValue) {
                    throw new InvalidArgumentException("Versteh ich nich =(");
                }

                if (roma.length() > i + 3) {
                    if (roma.charAt(i + 1) == romaLetter && roma.charAt(i + 2) == romaLetter && roma.charAt(i + 3) == romaLetter) {
                        throw new InvalidArgumentException("Versteh ich nich =(");
                    }
                }
            }

            result += romaValue;
        }


        return result;
    }

    private void validate(String roma) throws InvalidArgumentException
    {





    }
}
