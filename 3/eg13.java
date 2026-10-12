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

a.sam(); //correct as a ek pointer jo aaa se bana, a me bbb ka add, bbb aaa ko janta hai 

a.tom(); //incorrect
}
}