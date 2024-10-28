package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDataSet {
    @DataProvider(name = "SeriesCSVData")
    public Object[][] getCSVData() throws IOException {
        String filePath = "./src/test/resources/data.csv";
        List<Object[]> seriesData = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord csvRecord:csvParser){
            String series = csvRecord.get("expression");
            String seriesResult = csvRecord.get("expected_result");
            seriesData.add(new Object[]{series, seriesResult});
        }
        return seriesData.toArray(new Object[0][]);
    }
}
