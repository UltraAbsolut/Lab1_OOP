public class Water extends GameUnit{

    @Override
    public double damage(GameUnit GU) {
        if (GU instanceof Fire){
            coef = 4;
        }
        else if (GU instanceof  Water) {
            coef = 0;
        }
        else if (GU instanceof  Wind) {
            coef = 1;
        }
        else if (GU instanceof  Ground) {
            coef = 2;
        }
        return super.damage(GU);
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = "Я - Вода, Я - H2O";
    }

    @Override
    public String getPhrase() {
        return this.getPhrase();
    }

    public Water(String name,double strength, double hp, double height, double weight, String type) {
        super(name, strength, hp, height, weight, type);

    }
}