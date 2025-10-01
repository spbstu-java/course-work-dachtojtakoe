package course.packets.lab1;

public class FlyStrategy implements MovementStrategy {
    public String move(String from, String to){
        return "Начальная точка " + from + " лечу в " + to;
    }
}
