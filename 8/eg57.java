//While Overriding securit can't be increased Keep in mind

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
//protected void tom()
//private void tom()
//void tom()
public void tom()
{
System.out.println("This is new Tommmy");
}
}

class eg57psp
{
public static void main(String gg[])
{
bbb b=new bbb();
b.sam();
b.tom();
}
}