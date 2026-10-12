class aaa
{
public aaa()
{
System.out.println("default constructor of aaa");
}
}

class bbb extends aaa
{
// in the following constructor, compiler will insert
// super(); at the first line
bbb()
{
System.out.println("default constructor of bbb");
}
// in the following constructor, compiler will insert
// super(); at the first line
bbb(int e)
{
System.out.println("parameterized constructor of bbb");
}
}

class eg20psp
{
public void main(String gg[])
{
bbb b;
b=new bbb();
bbb b2;
b2=new bbb(60);
}
}