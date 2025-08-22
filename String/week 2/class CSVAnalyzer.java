// ------------------- Problem 5: CSV Analyzer -------------------
import java.util.*;

class CSVAnalyzer{
    static String[][] parse(String data) {
        List<String[]> rows=new ArrayList<>();
        String[] lines=data.split("\n");
        for (String line:lines) {
            List<String> fields=new ArrayList<>();
            int start=0;
            for (int i=0;i<line.length();i++) {
                if (line.charAt(i)==',') {
                    fields.add(line.substring(start,i).trim());
                    start=i+1;
                }
            }
            fields.add(line.substring(start).trim());
            rows.add(fields.toArray(new String[0]));
        }
        return rows.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        System.out.println("Enter CSV text:");
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.useDelimiter("\\Z").next();
            String[][] table = parse(input);
            for (String[] row : table) {
                for (String f : row) System.out.printf("%-15s", f);
                System.out.println();
            }
        }
    }
}
