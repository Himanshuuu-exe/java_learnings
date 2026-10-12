class aaa
{
public void sam()
{
System.out.println("I am Sam");
}

public void tom()
{
System.out.println("I am Tom of aaa, a dummy Tom");
}

}

class bbb extends aaa
{
/*
public void tom()
{
System.out.println("I am Tom");
}
*/
}

class eg14psp
{
public static void main(String gg[])
{
aaa a;
a=new bbb();
a.sam();
a.tom();
}
}