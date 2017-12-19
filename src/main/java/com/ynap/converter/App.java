package com.ynap.converter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class App 
{
	
	//\"([^\"]*)\" -> doppio apice, poi una serie di caratteri che non siano doppio apice, poi doppio apice
	//oppure
	// (?<=,|^) --> se indietro hai una virgola, oppure sei ad inizio riga 
	//([^,]*) --> poi qualunque carattere non sia virgola
	//(?:,|$) --> non capturing group ?: virgola oppure fine riga 
    private static final Pattern CSV_PATTERN = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");  

    
    private List<String> allMatches = null;    
    private Matcher matcher = null;
    private String match = null;
    private int size;

    public App() {        
        allMatches = new ArrayList<String>();
        matcher = null;
        match = null;
    }

    public String[] parse(String csvLine) {
        matcher = CSV_PATTERN.matcher(csvLine);
        allMatches.clear();
        String match;
        while (matcher.find()) {
            match = matcher.group(1);
            if (match!=null) {
                allMatches.add(match);
            }
            else {
                allMatches.add(matcher.group(2));
            }
        }

        size = allMatches.size();       
        if (size > 0) {
            return allMatches.toArray(new String[size]);
        }
        else {
            return new String[0];
        }           
    }   

}
