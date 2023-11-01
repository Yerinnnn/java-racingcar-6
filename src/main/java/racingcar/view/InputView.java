package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.utils.Validator;

import java.util.List;

public class InputView {

    public void setCarName(List<Car> cars) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> car_name = List.of(Console.readLine().split(","));

        if (car_name.size() < 2) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상 입력하세요.");
        }

        car_name.stream().forEach(name -> cars.add(new Car(name)));
    }

    public int setPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        Validator.attemptCount(num);
        int attempt_count = Integer.parseInt(num);

        return attempt_count;
    }
}
