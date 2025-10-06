package course.packets.lab1;

public class Hero{
    private final String name;
    private MovementStrategy movementStrategy;

    public Hero(String name){
        this(name, new WalkStrategy());
    }

    public Hero(String name, MovementStrategy movementStrategy){
        this.name = name;
        this.movementStrategy = movementStrategy;
    }

    public String getName(){
        return this.name;
    }

    public void setNewStrategy(MovementStrategy movementStrategy){
        this.movementStrategy = movementStrategy;
    }

    public String move(String from, String to){
        return(name + ": " + movementStrategy.move(from, to));
    }
}
