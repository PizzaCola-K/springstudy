package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.PreparedStatement;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
                        "VALUES (?, ?, ?, ?)", new String[] {"ID"}
            );
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, String.valueOf(member.getRegisterDateTime()));
            return pstmt;
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "UPDATE MEMBER SET NAME = ?, PASSWORD = ? WHERE EMAIL = ?",
                member.getName(), member.getPassword(), member.getEmail()
        );
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