public class BusinessCardDemo {
    public static void main(String[] args) {
        BusinessCardO b1 = new BusinessCardO("Michal", "Rynski", 560434567, "Krakow");
        //b1.print();
        BusinessCardO b2 = new BusinessCardO("Jeeezus", "Andrzej");
        //b2.print();

        BankAccountBusinessCard b3 = new BankAccountBusinessCard("Jerzy", "Malinowski", 566324555, "Krak", "1234 5556 3334 5667 2234");
        //b3.print();

        Wallet w = new Wallet();
        w.addBusinessCard(b1);
        w.addBusinessCard(b2);
        w.addBusinessCard(b3);

        //w.printAllBusinessCards();
        
        w.showByCity("Krakow");
    }
}

