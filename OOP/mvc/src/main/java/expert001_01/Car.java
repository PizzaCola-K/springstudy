package expert001_01;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    @Autowired
    Tire tire;

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Tire getTire() {
        return tire;
    }
}
