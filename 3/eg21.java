class aaa
{
public aaa(int k)
{
System.out.println("parameterized constructor of aaa");
}
}

class bbb extends aaa
{
}

class eg21psp
{
public void main(String gg[])
{
bbb b;
b=new bbb();
}
}