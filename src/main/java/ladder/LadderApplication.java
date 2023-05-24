package ladder;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.generator.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<User> userList = InputView.inputUsers();
        int height = InputView.inputHeight();
        GameResult gameResult = InputView.inputLadderGameResults();

        ResultView.printLadderInfoMessage();
        ResultView.printUsers(Users.create(userList));
        ResultView.printLadder(Ladder.create(userList.size(), height, new RandomPointGenerator()));
        ResultView.printGameResult(gameResult);
    }
}
