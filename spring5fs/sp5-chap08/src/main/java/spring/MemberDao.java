package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE EMAIL = ?",
                new MemberRowMapper(),
                email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
    }

    public void update(Member member) {
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query(
                "SELECT * FROM MEMBER",
                new MemberRowMapper()
        );
        return results;
    }

    public Integer count() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM MEMBER", Integer.class
        );
    }
}