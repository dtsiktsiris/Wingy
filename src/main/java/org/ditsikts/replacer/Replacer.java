package org.ditsikts.replacer;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public String replaceInString(String placeholders, Map<String,String> keeper){

        Pattern pattern = Pattern.compile("\\|#.+?##");
        Matcher matcher = pattern.matcher(placeholders);
//        matcher.groupCount()
        while (matcher.find()) {

//            System.out.println(matcher.);

            String value = placeholders.substring(matcher.start()+2, matcher.end()-2);
            if (keeper.containsKey(value)){
                placeholders = placeholders.replace(matcher.group(), keeper.get(value));
            }
//            System.out.println("Start index: " + matcher.start());
//            System.out.println(" End index: " + matcher.end());
//            System.out.println(" Found: " + matcher.group());
        }

        System.out.println(placeholders);
        return placeholders;
    }

    public Map<String, String> replaceInMap(Map<String, String> m, Map<String,String> keeper){
        for (Map.Entry<String, String> entry: m.entrySet()) {
            entry.setValue(replaceInString(entry.getValue(), keeper));
        }
        return m;
    }
}
