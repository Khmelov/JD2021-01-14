package by.it.lapushkin.calc.logger;

public class LoggerManager {
    private LoggerBuilder builder;

    public void setBuilder(LoggerBuilder builder){
        this.builder = builder;
    }
    public Logger getLog(){
        return builder.getLogger();
    }
    public void constructLog(){
        builder.createNewLogger();
        builder.buildHead();
        builder.buildDate();
    }
}
