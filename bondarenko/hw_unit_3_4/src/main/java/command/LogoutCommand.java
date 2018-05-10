package command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session != null){
            session.removeAttribute("user");
            session.invalidate();
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    public String toString() {
        return "LogoutCommand";
    }
}
