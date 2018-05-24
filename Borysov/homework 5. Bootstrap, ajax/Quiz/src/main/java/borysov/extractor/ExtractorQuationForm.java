package borysov.extractor;

import borysov.entity.Answer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ExtractorQuationForm {
    List<Answer> extract(HttpServletRequest request);
}
