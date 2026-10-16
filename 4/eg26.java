class aaa
{
public aaa(int k)
{
System.out.println("parameterized constructor of aaa");
}
}

class bbb extends aaa
{
public bbb()
{
super(20);
}
}

class eg26psp
{
public void main(String gg[])
{
bbb b;
b=new bbb();
}
}