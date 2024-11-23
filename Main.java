
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double rand = random.nextDouble();

        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("Введите имя персонажа, его силу, количество единиц здоровья, рост, вес и тип");

        System.out.println("Выбирайте любые значения, но с умом!)");

        System.out.print("Имя: ");
        String name = in.nextLine();

        System.out.print("Сила: ");
        int strength = in.nextInt();
        while(strength <= 0 || strength >=1000) {
            System.out.println("Введите корректное значение.");
            System.out.print("Сила: ");
            strength = in.nextInt();
        }

        System.out.print("Здоровье: ");
        int hp = in.nextInt();
        while(hp <= 0 || hp >=1000) {
            System.out.println("Введите корректное значение.");
            System.out.print("Здоровье: ");
            hp = in.nextInt();
        }

        System.out.print("Рост: ");
        int height = in.nextInt();
        while(height <= 0 || height >=1000) {
            System.out.println("Введите корректное значение.");
            System.out.print("Рост: ");
            height = in.nextInt();
        }

        System.out.print("Вес: ");
        double weight = in.nextInt();
        while(weight <= 0 || weight >=1000) {
            System.out.println("Введите корректное значение.");
            weight = in.nextInt();
        }

        System.out.print("Тип: ");
        String type = in.nextLine();

        String nothing = in.nextLine();

        System.out.println("Для ознакомления с функциями, напишите 'func'");

        Fire myGameUnit = new Fire(name,strength,hp, height, weight, type);
        Fire enemyGU1 = new Fire("Earth", 200, 300, 500, 200, "Healer");
        Wind enemyGU2 = new Wind("Saver", 150, 350, 100, 100, "Dam Deal");
        Water enemyGU3 = new Water("Big_Daddy", 120, 400, 500, 500, "Tank");
        Ground enemyGU4 = new Ground("Fighter", 300, 110, 140, 200, "Flung");

        String a = "";
        while(!a.equals("stop")){
            if(enemyGU1.getHealth() <= 0 && enemyGU2.getHealth() <= 0 && enemyGU3.getHealth() <= 0 && enemyGU4.getHealth() <= 0){
                System.out.println("Вы всех победили, поздравляем!");
                System.exit(1);
            }
            else if(myGameUnit.getHealth() <= 0){
                System.out.println("Проигрыш");
                System.exit(1);
            }
            switch (a) {
                case "skills":
                    System.out.println("Кого?");
                    System.out.println("Введите натуральное число от 1 до 6.");
                    int ans = in.nextInt();
                    while (!(ans == 1 || ans == 2 || ans == 3 || ans == 4 || ans == 5)) {
                        System.out.println("Введите натуральное число от 1 до 6.");
                        ans = in.nextInt();
                    }
                    switch (ans) {
                        case 1:
                            System.out.println(enemyGU1.getValues(enemyGU1));
                            break;
                        case 2:
                            System.out.println(enemyGU2.getValues(enemyGU2));
                            break;
                        case 3:
                            System.out.println(enemyGU3.getValues(enemyGU3));
                            break;
                        case 4:
                            System.out.println(enemyGU4.getValues(enemyGU4));
                            break;
                        case 5:
                            System.out.println(myGameUnit.getValues(myGameUnit));
                            break;
                    }
                case "func":
                    System.out.println("""
                        
                        stop - закончить
                        attack - атаковать другого GU
                        skills - показатели персонажа в данный момент
                        func - список всех функций
                        phrase - сказать свою фразу
                        """);
                    break;
                case "phrase":
                    System.out.println("Вы хотите напомнить всем, кто тут главный и сказать свою фразу?");
                    String nothing3 = in.nextLine();
                    myGameUnit.getPhrase();
                case "attack":
                    System.out.println("Кого?");
                    int en = in.nextInt();
                    while (!(en == 1 || en == 2 || en == 3 || en == 4)) {
                        System.out.println("Введите натуральное число от 1 до 5.");
                        en = in.nextInt();
                    }
                    switch (en) {
                        case 1:
                            myGameUnit.attack(enemyGU1);
                            enemyGU1.attack(myGameUnit);
                            break;
                        case 2:
                            myGameUnit.attack(enemyGU2);
                            enemyGU2.attack(myGameUnit);
                            break;
                        case 3:
                            myGameUnit.attack(enemyGU3);
                            enemyGU3.attack(myGameUnit);
                            break;
                        case 4:
                            myGameUnit.attack(enemyGU4);
                            enemyGU4.attack(myGameUnit);
                            break;
                    }
                    break;
                default:
                    System.out.println("Что-что?");
                    break;
            }
        a = in.nextLine();
        }
        System.out.println("До свидания!)");
    }
}