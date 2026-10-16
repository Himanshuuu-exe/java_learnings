/*
static property : One copy of static property is
shared by all objects
*/
class Bulb
{
private int wattage; // non static
static private int price; // static

public void setPrice(int p)
{
price=p;
}
public void setWattage(int w)
{
wattage=w;
}
public int getPrice()
{
return price;
}
public int getWattage()
{
return wattage;
}
}

class eg23psp
{
public static void main(String gg[])
{
Bulb b1,b2;
b1=new Bulb();
b2=new Bulb();
b1.setWattage(60);
b1.setPrice(10);
System.out.println("Wattage : "+b1.getWattage());
System.out.println("Price : "+b1.getPrice());
b2.setWattage(100);
b2.setPrice(40);
System.out.println("Wattage : "+b2.getWattage());
System.out.println("Price : "+b2.getPrice());
System.out.println("Wattage : "+b1.getWattage());
System.out.println("Price : "+b1.getPrice());
}
}
