class Bulb
{

private int wattage;

public void setWattage(int wattage)
{
this.wattage=wattage;
}

public int getWattage()
{
return this.wattage;
}

}

class eg3psp
{

public static void main(String gg[])
{
Bulb b1,b2;

b1=new Bulb();
b1.setWattage(60);
System.out.println(b1.getWattage());

b2=new Bulb();
b2.setWattage(100);
System.out.println(b2.getWattage());

}

}