package exercise;

import exercise.daytimes.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    private Daytime daytime;
    @Autowired
    private Meal meal;

    @GetMapping(path = "/daytime")
    public String getTime() {
        String time = daytime.getName();
        String currentMeal = meal.getMealForDaytime(time);
        return String.format("It is %s now. Enjoy your %s", time, currentMeal);
    }
}
// END
