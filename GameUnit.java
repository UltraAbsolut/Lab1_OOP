import java.util.Scanner;
import java.util.Random;

public class GameUnit {

    protected String name;
    protected double strength;
    protected double hp;
    protected double height;
    protected double weight;
    protected String type;
    protected double coef = 1;
    protected String phrase = "Вы немощи, а я нет.";

    Random random = new Random();
    double rand = random.nextDouble();

    Scanner in = new Scanner(System.in);

    public GameUnit(String name,double strength, double hp, double height, double weight, String type){
        this.name = name;
        this.strength = strength;
        this.hp = hp;
        this.height =height;
        this.weight = weight;
        this.type = type;
    }

//strength
    public void setStrength(double strength){
        this.strength = strength;
    }

    public double getStrength(){
        return this.strength;
    }

//health
    public void setHealth(double hp) {
        this.hp = hp;
    }

    public double getHealth(){
        return this.hp;
    }

//height
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

//type
    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

//weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }

//name
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
//phrase
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase(){
        return this.phrase;
    }


//attack
public void attack(GameUnit GU) {
    if (rand <= 0.5) {
        System.out.println("Слушайте сюда!");
        System.out.println(GU.getPhrase());
        if (GU.getType() == "Healer") {
            if (rand <= 0.5) {
                GU.setHealth(100 * rand);
            }
        }
        else if(GU.getType() == "Tank"){
            GU.setHealth(this.hp * 1.5);
        }
        double damGU = damage(GU);
        if (GU.getHealth() <= 0) {
            System.out.println("Уже мертв.");
        } else {
            GU.setHealth(GU.getHealth() - damGU);
            if (GU.getHealth() <= 0) {
                System.out.println("Сильный удар. Здоровье " + GU.getName() + ": " + "0");
                System.out.println("Уничтожен.");
            } else {
                System.out.println("Сильный удар. Здоровье " + GU.getName() + ": " + GU.getHealth() + ".");
            }
        }
    }
}
//getValues
    public String getValues(GameUnit GU) {
        if(this.hp <= 0){
            return "___________________________\n" + "Мертв.\n" + "Гроб Имени " + this.name + "___________________________";
        }
        return "___________________________\n" + "Сила: " + this.strength + " \nЗдоровье: " + this.hp + " \nРост: " + this.height + " \nВес: " + this.weight + " \nИмя: " + this.name + "\n___________________________";
    }
//damage
    public double damage(GameUnit GU){
        Random random = new Random();
        double rand = random.nextDouble();
        int res = 1;
        switch(this.type) {
            case ("Tank"):
                if (rand < 0.03) return (this.strength + this.weight / this.height * 10 * coef);
                break;
            case ("Healer"):
                res = (rand <= 0.05) ? 2 : 1;
                break;
            case ("Flung"):
                res = (rand <= 0.15) ? 2 : 1;
                break;
            default:
                res = (rand <= 0.1) ? 3 : 1;
                break;
            }
        return (this.strength * (double) res  * coef);
    }
}

