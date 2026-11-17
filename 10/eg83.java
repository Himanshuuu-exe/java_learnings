class eg83psp
{
public static void main(String gg[])
{
int x[];
x=new int[3];

x[0]=10;
x[1]=20;
x[2]=30;

int y[];
y=new int[5];

for(int i=0; i<x.length; i++)
{
y[i]=x[i];
}
x=y;

x[3]=50;
x[4]=60;

for(int i=0; i<x.length; i++)
{
System.out.println(x[i]);
}

}
}