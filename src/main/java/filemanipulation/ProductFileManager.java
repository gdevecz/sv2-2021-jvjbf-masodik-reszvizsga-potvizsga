package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        try {
            List<String> rows = Files.readAllLines(path);
            fillProductsFromRows(rows);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void fillProductsFromRows(List<String> rows) {
        for (String row : rows) {
            products.add(getProductFromARow(row));
        }
    }

    public Product getProductFromARow(String row) {
        String[] data = row.split(";");
        return new Product(data[0], data[1], Integer.parseInt(data[2]));
    }

    public void writePriceOverToFile(Path path, int borderPrice) {
        try {
            List<String> toWrite = getProductsForWrite(expensivesThan(borderPrice));
            Files.write(path, toWrite);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> getProductsForWrite(List<Product> products) {
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            result.add(product.printToFile());
        }
        return result;
    }

    private List<Product> expensivesThan(int border) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice()>border) {
                result.add(product);
            }
        }
        return result;
    }
}
