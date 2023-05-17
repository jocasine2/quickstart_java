import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controllers.Person;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class PersonController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        String sql = "SELECT name, age FROM persons";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Person(rs.getString("name"), rs.getInt("age")));
    }

    @GetMapping("/teste-people")
    public String testePeople() {
        return "teste PEOPLE com sucesso!";
    }
}
