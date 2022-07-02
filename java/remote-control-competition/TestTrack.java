import java.util.List;
import java.util.Arrays;

/**
 * Remote Control Competition
 * https://exercism.org/tracks/java/exercises/remote-control-competition
 */
public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        // Создать пустой список для хранения машин
        // Сравнить переданные машины
        // Если первая идет перед второй или они равны, то
        if (prc1.compareTo(prc2) <= 0) {
            // Добавить в список первую машину
            // Добавить в список вторую машину
            return Arrays.asList(prc1, prc2);
        }
        // Иначе
        else {
            // Добавить в список вторую машину
            // Добавить в список первую машину
            return Arrays.asList(prc2, prc1);
        }
        // Вернуть список машин
    }
}
