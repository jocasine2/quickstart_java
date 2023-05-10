import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final JdbcTemplate jdbcTemplate;

    public PersonController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/people")
    public List<Map<String, Object>> getPeople() {
        String sql = "SELECT name, age FROM people";
        return jdbcTemplate.queryForList(sql);
    }

}
