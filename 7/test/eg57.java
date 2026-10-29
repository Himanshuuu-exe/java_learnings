import pqrst.ink.zinc.*;

class eg57psp
{
public static void main(String gg[])
{
Bulb b;
b=new Bulb();
b.setWattage(60);
System.out.println(b.getWattage());

Tom t;
t=new Tom();
t.setPrice(1000);
System.out.println(t.getPrice());

t.printBrand();

}
}