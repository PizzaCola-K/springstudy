package expert001_01;

public class Car {
    Tire tire;

    public Car() {
        this.tire = new KoreaTire();
        //this.tire = new AmericaTire();
    }

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }
}