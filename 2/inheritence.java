class Rectangle
{
private int length;
private int breadth;

public void setLength(int length)
{
this.length=length;
}

public void setBreadth(int breadth)
{
this.breadth=breadth;
}

public int getLength()
{
return this.length;
}

public int getBreadth()
{
return this.breadth;
}

}

class Box extends Rectangle
{
private int heigth;

public void setHeigth(int heigth)
{
this.heigth=heigth;
}

public int getHeigth()
{
return this.heigth;
}

}

class inheritncePsp
{

public static void main(String gg[])
{
Box b1=new Box();
b1.setBreadth(20);
b1.setLength(30);
b1.setHeigth(40);

System.out.println("Breadth is "+b1.getBreadth());
System.out.println("Breadth is "+b1.getLength());
System.out.println("Breadth is "+b1.getHeigth());

}
}