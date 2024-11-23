public class Ground extends GameUnit{

    @Override
    public double damage(GameUnit GU) {
        if (GU instanceof Fire){
            coef = 0.5;
        }
        else if (GU instanceof  Water) {
            coef = 1;
        }
        else if (GU instanceof  Wind) {
            coef = 5;
        }
        else if (GU instanceof  Ground) {
            coef = 0;
        }
        return super.damage(GU);
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = "ЗемляЗемляЗемляЗемляЗемляЗемля";
    }

    @Override
    public String getPhrase() {
        return this.getPhrase();
    }

    public Ground(String name, double strength, double hp, double height, double weight, String type) {
        super(name, strength, hp, height, weight, type);

    }
}