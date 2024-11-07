/*public class OOPS {
    public int mul() {
        int a = 10;
        int b = 20;
        return a * b;
    }

    public void div() {
        int a = 10;
        int b = 20;
        System.out.println(a / b);
    }
public static void main(String[] args) {
        OOPS o = new OOPS();
        int result = o.mul();
        System.out.println(result);
        o.div();

    }
}*/

import java.awt.desktop.SystemSleepEvent;

/*public class OOPS {
    OOPS(){
        System.out.println("Calling Const");
    }
    OOPS(int a){
        System.out.println(a);
    }
 public static void main(String[] args){
        OOPS o=new OOPS();
        OOPS o1=new OOPS(10);
 }
}
*/

/*public class OOPS {
    private int id;
    private String name;
    private String address;
    private String phno;

    public OOPS() {}

    public OOPS(int id, String name, String address, String phno) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phno = phno;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setphno(String phno) {
        this.phno = phno;
    }

    public String getPhno() {
        return phno;
    }

    public static class user extends OOPS {
        public user(int id, String name, String address, String phno) {
            super(id, name, address, phno);
        }
    }

    public static void main(String[] args) {
        OOPS o = new OOPS();
        o.setid(1);
        int a = o.getid();
        System.out.println("ID: " + a);

        o.setname("abc");
        System.out.println("Name: " + o.getname());

        o.setaddress("123 Street");
        System.out.println("Address: " + o.getAddress());

        o.setphno("1234567890");
        System.out.println("Phone Number: " + o.getPhno());
    }
}

 */
/*class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class OOPS {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d= new Dog();
        Animal c = new Cat();
        a.sound();
        d.sound();
        c.sound();
    }
}
*/

