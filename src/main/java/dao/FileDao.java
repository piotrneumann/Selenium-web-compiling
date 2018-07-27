package dao;

import dto.DataTransfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDao {

    private String filePath;

    public FileDao(String filePath) {
        this.filePath = filePath;
    }

    public List<DataTransfer> getDataTransfer() {
        System.out.println(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<DataTransfer> dataTransfersList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String dane = scanner.nextLine();
            list.add(dane);
        }
        for (String a : list) {
            String[] data = a.split(";");
            dataTransfersList.add(
                    new DataTransfer(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7])
            );
        }
        return dataTransfersList;
    }
}
