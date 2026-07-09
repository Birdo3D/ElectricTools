package main.fr.birdo.electrictools.items;

public class Breaker {

    private final int line;
    private final int column;
    private String name = "";
    private CircuitType circuitType = CircuitType.EMPTY;

    public Breaker(int line, int column){
        this.line = line;
        this.column = column;
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCircuitType(CircuitType circuitType){
        this.circuitType = circuitType;
    }

    public CircuitType getCircuitType(){
        return this.circuitType;
    }
}
