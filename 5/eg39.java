class aaa
{
{
System.out.println("1st Initializer Bloclk");
}

public void print()
{
System.out.println("Function Print");
}

{
System.out.println("2nd Initializer Block");
}

public aaa()
{
System.out.println("Default Constructor");
}

{
System.out.println("3rd Initializer");
}

public aaa(int e)
{
System.out.println("Parameterised Constructor");
}

}

class eg39psp
{
public static void main(String gg[])
{
aaa a1,a2;
a1=new aaa();
a2=new aaa(1);

}
}