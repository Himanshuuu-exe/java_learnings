class aaa
{
public void sam()
{
System.out.println("I am sam");
}
}

class  bbb extends aaa
{
public void tom()
{
System.out.println("I am Tom");
}
}

class eg11psp
{
public static void main(String gg[])
{
aaa a;
a=new bbb();

bbb b;
b=new aaa();
}
}