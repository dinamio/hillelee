package command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    void execute(HttpServletRequest req);
}
