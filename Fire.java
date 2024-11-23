public class Fire extends GameUnit {

    @Override
    public double damage(GameUnit GU) {
        if (GU instanceof Fire){
            coef = 0;
        }
        else if (GU instanceof  Water) {
            coef = 1;
        }
        else if (GU instanceof  Wind) {
            coef = 3;
        }
        else if (GU instanceof  Ground) {
            coef = 2;
        }
        return super.damage(GU);
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = "Я огонь вы все гореть";
    }

    @Override
    public String getPhrase() {
        return this.getPhrase();
    }

    public Fire(String name, double strength, double hp, double height, double weight, String type) {
        super(name, strength, hp, height, weight, type);

    }
}
