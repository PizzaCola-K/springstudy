package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Member;
import spring.MemberDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {

    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        memberDao = ctx.getBean(MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        ctx.close();
    }

    private static void insertMember() {
        System.out.println("----- insertMember");
        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(
                prefix + "@test.com",
                prefix, prefix, LocalDateTime.now()
        );
        memberDao.insert(member);
        System.out.println(member.getId() + " Data Insert");
    }

    private static void updateMember() {
        System.out.println("----- updateMember");
        Member member = memberDao.selectByEmail("madvirus@madvirus.net");
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);

        memberDao.update(member);
        System.out.println("Password Change: " + oldPw + " > " + newPw);
    }

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("MMddHHmmss");

    private static void selectAll() {
        System.out.println("----- selectAll");
        int total = memberDao.count();
        System.out.println("Whole Data: " + total);
        List<Member> members = memberDao.selectAll();
        members.forEach(m -> {
            System.out.println(m.getId() + ":" + m.getEmail() + ":" + m.getName());
        });
    }
}
