import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lab1 {
    public static native int findMax(int[] numbers, int length);

    static {
        Loader.load();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java Lab1 <archivo_de_numeros>");
            System.exit(1);
        }

        String filename = args[0];
        try {
            int[] numbers = readNumbersFromFile(filename);
            int max = findMax(numbers, numbers.length);
            System.out.println("El número máximo es: " + max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] readNumbersFromFile(String filename) throws IOException {
        List<Integer> numberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    numberList.add(Integer.parseInt(token));
                }
            }
        }

        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }

        return numbers;
    }
}

//java -jar javacpp.jar Lab1.java
//java -jar javacpp.jar Lab1 numMax.txt
