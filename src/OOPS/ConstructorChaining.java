package src.OOPS;

class Base {
    static {
        System.out.println("static base");
    }
    Base() {
        System.out.println("Base...");
    }
}

class Derived extends Base {
    static {
        System.out.println("static Derived");
    }
    Derived(){
        System.out.println("Derived...");
    }
}

class Deriderived extends Derived {
    static {
        System.out.println("static Deriderived");
    }
    Deriderived() {
        System.out.println("Deriderived...");
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        Deriderived d = new Deriderived();
    }
}


