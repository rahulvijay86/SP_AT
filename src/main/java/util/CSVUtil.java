package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vnagarajan on 7/16/2016.
 */
public class CSVUtil {

        public static List<Map> readCSV(String filePath) {

            String csvFile = filePath;
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            List<Map> data = new ArrayList<Map>();//Creating list to store entire csv data

            try {
                //Reading CSV file
                br = new BufferedReader(new FileReader(csvFile));
                int i = 1;
                String[] columnNames = null;
                while ((line = br.readLine()) != null) {//Reading each line and checking whether it has data
                    if (i == 1) {//checking if this is first line in csv
                        columnNames = line.split(cvsSplitBy);//splitting by , to get each column name
                    } else {
                        // use comma as separator
                        String[] rowData = line.split(cvsSplitBy);//splitting by , to get value for each column
                        Map<String, String> maps = new HashMap<String, String>();//Creating a map to store each row(line) in csv
                        for(int j=1;j<=rowData.length;j++) {
                            maps.put(columnNames[j], rowData[j]);//Mapping column name with corresponding value and adding to a map
                        }
                        data.add(maps);//Adding data in each line to a list
                    }
                    i++;//incrementing i
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return data;
        }
    }
