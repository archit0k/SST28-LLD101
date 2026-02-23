import java.util.List;

public interface Store {
    void save(StudentRecord r);
    int count();
    List<StudentRecord> all();
}