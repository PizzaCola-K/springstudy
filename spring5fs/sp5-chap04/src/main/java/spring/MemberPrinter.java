package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf(
                    "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF%n",
                    member.getId(), member.getEmail(),
                    member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf(
                    "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s%n",
                    member.getId(), member.getEmail(),
                    member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));
        }



    }
}
