class Bulb
{
private int wattage;

public Bulb()
{
this.wattage=0;
}

public Bulb(int wattage)
{
this.wattage=wattage;
}

public void setWattage(int wattage)
{
this.wattage=wattage;
}

public int getWattage()
{
return this.wattage;
}

}

class cons
{
public static void main(String gg[])
{
Bulb b1;
b1=new Bulb();
b1.setWattage(20);
System.out.println(b1.getWattage());

Bulb b2;
b2=new Bulb(100);

System.out.println(b2.getWattage());

}
}