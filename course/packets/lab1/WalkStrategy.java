package course.packets.lab1;

public class WalkStrategy implements MovementStrategy {
    public String move(String from, String to){
        return "Начальная точка " + from + " иду пешком в "  + to;
    }
}
