public class Wind extends GameUnit{

    @Override
    public double damage(GameUnit GU) {
        if (GU instanceof Fire){
            coef = 3;
        }
        else if (GU instanceof  Water) {
            coef = 3;
        }
        else if (GU instanceof  Wind) {
            coef = 0;
        }
        else if (GU instanceof  Ground) {
            coef = 3;
        }
        return super.damage(GU);
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = "*звуки ветра";
    }

    @Override
    public String getPhrase() {
        return this.getPhrase();
    }

    public Wind(String name,double strength, double hp, double height, double weight, String type) {
        super(name, strength, hp, height, weight, type);

    }
}