public class NextDate {
    public int isData_legalization(int a,int b,int c){
        if(a>=b&&a<=c)
            return 0;
        else
            return 1;
    }
    public int IsLeapYear(int year)
    {
        int isleapYear;

        if(( (year%400)==0) || (((year%4)==0) && ((year%100)!=0)) )
            isleapYear=1;
        else
            isleapYear=0;
        return isleapYear;
    }
public int isday(int year,int day)
{
    int q=0;
    int isleapYear = IsLeapYear(year);
    if((day==28&&isleapYear==1))
        q = 1;
    else if(day==28 &&isleapYear==0)
        q= 2;
    else if(day ==29 &&isleapYear==1)
        q = 3;
    else
        q = 4;
    return q;
}
    public String getNextDate(int day, int month, int year){
        int isleapYear=(IsLeapYear(year));
        int x = 0;
        int y =28;
        int sum = 0;      //用来判断符合基本条件的个数，如果为0则三个都满足，只要大于等于1，就是不符合要求的。
        sum+=isData_legalization(day,1,31);
        sum+=isData_legalization(month,1,12);
        sum+=isData_legalization(year,1900,2050);
        int tDay = day, tMonth = month, tYear = year;
        if(sum ==0)
        {
//用于判断是否为闰年
            switch (month){
                case 2:
                    tDay=day+1;
                    y=isleapYear+y;//本年度二月份最大天数
                    tMonth+=tDay/(y+1);
                    tDay=((tDay/(y+1)+tDay)%(y+1));

                    break;
                case 12:
                    if (day<31){
                        tDay = day + 1;
                    }else {
                        tDay = 1;
                        tMonth = 1;
                        if (year == 2050){
                            return "输入数据有问题";
                        }else {
                            tYear = year + 1;
                        }
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    tDay = day+1;
                    tMonth += tDay/32;
                    tDay = (tDay/32+tDay)%32;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    tDay=day+1;
                    tMonth+=tDay/31;
                    tDay=(tDay/31+tDay)%31;
                    break;
                default:
                    return "输入数据有问题";
            }
            return  tYear + "年" + tMonth + "月" + tDay + "日";
        }
        return "输入数据有问题";
    }
}
