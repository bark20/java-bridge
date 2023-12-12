package bridge.domain.model;

import bridge.domain.constant.MoveCommand;
import bridge.domain.constant.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameDashboard {

    private final List<Status> upResult = new ArrayList<>();
    private final List<Status> downResult = new ArrayList<>();

    public void updateResult(Status status, MoveCommand moveCommand) {
        if (status == Status.SUCCESS) {
            checkResult(status, moveCommand);
        }
        if (status == Status.FAIL) {
            checkResult(status, moveCommand);
        }
    }

    private void checkResult(Status status, MoveCommand moveCommand) {
        if (moveCommand == MoveCommand.UP) {
            upResult.add(status);
            downResult.add(Status.SPACE);
        }
        if (moveCommand == MoveCommand.DOWN) {
            upResult.add(Status.SPACE);
            downResult.add(status);
        }
    }

    public List<Status> getUpResult() {
        return Collections.unmodifiableList(upResult);
    }

    public List<Status> getDownResult() {
        return Collections.unmodifiableList(downResult);
    }
}
