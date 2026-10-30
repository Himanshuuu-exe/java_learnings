class aaa
{
public void sam()
{
System.out.println("This is sam");
}

public void tom()
{
System.out.println("This is Tom");
}
}

class bbb extends aaa
{
public void tom()
{
System.out.println("This is new Tommmy");
}
}

class eg56psp
{
public static void main(String gg[])
{
bbb b=new bbb();
b.sam();
b.tom();
}
}