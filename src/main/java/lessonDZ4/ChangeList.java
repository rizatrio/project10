package lessonDZ4;

import java.util.List;

@FunctionalInterface
public interface ChangeList {
    List<String> changeList(List<String> list);
}
