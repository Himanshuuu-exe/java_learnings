class eg86psp
{
public static void main(String gg[])
{

if(gg.length==0)
{
System.out.println("Not args passed");
}

int i,j,g;
int x[];
x=new int[gg.length];

for(i=0; i<gg.length; i++)
{
x[i]=Integer.parseInt(gg[i]);
}

for(i=0; i<gg.length-1; i++)
{
for(j=i+1; j<gg.length; j++)
{
if(x[i]>x[j])
{
g=x[i];
x[i]=x[j];
x[j]=g;
}
}
}

for(int r:x) System.out.println(r);

}
}