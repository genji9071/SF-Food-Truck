package github.genji9071.sfFoodTruck.util;

import github.genji9071.sfFoodTruck.entity.SfFoodTruckEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvConvertUtils {

    public static List<SfFoodTruckEntity> csv2List(String csvFile) {
        List<SfFoodTruckEntity> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine();
            String[] columns = line.split(",");

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Class<?> entityClass = Class.forName("github.genji9071.sfFoodTruck.entity.SfFoodTruckEntity");
                SfFoodTruckEntity entity = new SfFoodTruckEntity();
                for (int i = 0; i < columns.length; i++) {
                    try {
                        Field declaredField = entityClass.getDeclaredField(columns[i]);
                        declaredField.setAccessible(true);
                        declaredField.set(entity, row[i]);
                    } catch (NoSuchFieldException e) {
                        continue;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                result.add(entity);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
