package expert001_01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("expert001_01/expert001_01.xml");
        Car car = context.getBean("car", Car.class);

        System.out.println(car.getTireBrand());
    }
}
