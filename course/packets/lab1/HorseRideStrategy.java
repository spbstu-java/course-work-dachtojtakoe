package course.packets.lab1;

public class HorseRideStrategy implements MovementStrategy {
    public String move(String from, String to){
        return "Начальная точка " + from + " скачу на лошади в " + to;
    }
}
