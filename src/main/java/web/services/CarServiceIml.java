package web.services;

import org.springframework.stereotype.Component;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceIml implements CarService {

    private static int CARS_COUNT;

    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, "Mercedes-Benz GLE", 2018));
        cars.add(new Car(++CARS_COUNT, "Nissan Rogue II", 2020));
        cars.add(new Car(++CARS_COUNT, "Audi Q1 I", 2018));
        cars.add(new Car(++CARS_COUNT, "Ford Escape IV", 2016));
        cars.add(new Car(++CARS_COUNT, "Mitsubishi Outlander IV", 2021));
    }

    public List<Car> cars() {
        return cars;
    }
}

