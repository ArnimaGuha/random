import java.time.LocalTime;
import java.util.Scanner;
import java.util.Date;
class random_numbers
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range");
        int mi=sc.nextInt();
        int ma=sc.nextInt();
        System.out.println("Enter how many numbers to be displayed");
        int count=sc.nextInt();
        int arr[]=new int[count];
        arr[0]=-1;
        int co=0;
        for(int j=1;co<count;j++)
        {
            LocalTime obj=LocalTime.now();
            String time=obj.toString();//getting time
            
            Date date=new Date();
            long milli=System.currentTimeMillis();//getting milisecs
            
            String ci="",ai="",bi="";
            int counter=0;
            for(int i=0;i<time.length();i++)
            {
                char k=time.charAt(i);
                if(Character.isDigit(k))
                {
                    if(counter==0)
                        ai=ai+k;
                    if(counter==1)
                        bi=bi+k;
                    if(counter==2)
                        ci=ci+k;
                }
                else{
                    counter++;
                    }
            }
            double a=Double.parseDouble(ai);
            double b=Double.parseDouble(bi);
            double c=Double.parseDouble(ci);//kuch to garbad hai
            double max=Math.max(a,Math.max(b,c));
            double min=Math.min(a,Math.min(b,c));
            double mid=(a+b+c)-(max+min);
            double result=(((((min+1)*j*mid)/max)%milli));
            int p=0;
            int z=0;
            while((int)result!=0)
            {
                int digit=(int)result%10;
                p++;
                result/=10;
            }
            double r=(result/Math.pow(10,p-1));
            int ans=(int)(r*(ma-mi)+mi);
            for(int i=0;i<co;i++)
            {
                if(ans==arr[i])
                z++;
            }
            if(z==0)
            {
            arr[co]=ans;
            co++;
            }
            else
            continue;
        }
        int s=0;
        //sorting the array in ascending order
        for(int i=0;i<count-1;i++)
        {
            for(int j=0;j<count-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    s=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=s;
                }
            }
        }
        //printing the elements
        for(int i=0;i<count;i++)
        System.out.println(arr[i]);
    }
        
}