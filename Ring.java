package OOP.BoxingMatch;

public class Ring {
    Fighter f1;
    Fighter f2;
    Fighter tempF;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        /*
            -firstStart metodu üretilen random sayı 50den büyükse true değişse false döndürüyor.
            -Eğer metot true ise dövüşe 1. dövüşçü başlıyor. Bu yüzden bilgilerin değiştirilmesi gerekmemektedir.
            -Eğer metot false ise dövşe 2. dövüşçü başlayacağı için, 2. dövüşçünün ilk vuruş hamlesini ekranda yazırmak için,
            f1 ile f2 niteliklerinin değerlerini yer değiştiriyoruz. f1 değerlerini kaybetmemek i.in tempF isimli yeni bir nitelik oluşturuyoruz.
        */
        if (firstStart()) {
            System.out.println("Dövüşe: " + f1.name + " Başlayacak.");
        } else {
            System.out.println("Dövüşe: " + f2.name + " Başlayacak.");
            this.tempF = this.f1;
            this.f1 = this.f2;
            this.f2 = this.tempF;
        }

        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== YENİ ROUND ===========");
                f2.health = f1.hit(f2);
                if (isWin()) {
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()) {
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }


    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0) {
            System.out.println("Maçı Kazanan : " + f1.name);
            return true;
        }

        return false;
    }

    public boolean firstStart() {
        double randomNum = Math.random() * 100;
        return randomNum >= 50;

    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }
}
