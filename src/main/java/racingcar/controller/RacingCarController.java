package racingcar.controller;

import racingcar.io.InputManager;
import racingcar.io.OutputView;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputManager = new InputManager();
        this.outputView = new OutputView();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        outputView.printRacingCarNamesMessage();
        startRacing();
    }

    private void startRacing() {
        Cars cars = inputManager.inputCarNames();

        outputView.printAttemptCountMessage();
        int attemptCount = inputManager.inputAttemptCount();
        outputView.printExecutionResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            racingCarService.startRacing(cars);
            outputView.printGameResult(cars.statusCarsPosition());
        }

    }
}
