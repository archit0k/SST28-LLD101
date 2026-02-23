
public interface Storage {
    void save(String name, String content);
    int countLines(String name);
}