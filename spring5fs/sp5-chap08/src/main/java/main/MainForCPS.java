package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx.class);
        ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            cps.changePassword("madvirus@madvirus.net", "1234", "1111");
        } catch (MemberNotFoundException | WrongIdPasswordException e) {
            e.printStackTrace();
        }

        ctx.close();
    }
}
