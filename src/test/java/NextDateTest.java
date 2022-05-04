import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NextDateTest {
    NextDate nextDate;
    int day;
    int month;
    int year;
    String expected;

    public NextDateTest(int day, int month, int year, String expected) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection nextDateTestCase(){
        return Arrays.asList(new Object[][]{
                {20,2,2600,"输入数据有问题"},
                {22,0,2001,"输入数据有问题"},
                {0,2,2001,"输入数据有问题"},
                {28,2,1920,"1920年2月29日"},
                {29,2,2020,"2020年3月1日"},
                {31,12,2001,"2002年1月1日"},
                {3,4,2003,"2003年4月4日"},
                {6,12,2007,"2007年12月7日"},
                {28,2,2000,"2000年2月29日"},
                {18,1,2021,"2021年1月19日"},
                {18,3,2008,"2008年3月19日"},
                {10,4,2021,"2021年4月11日"},
                {17,6,2008,"2008年6月18日"},
                {22,2,2021,"2021年2月23日"},
                {2,2,2008,"2008年2月3日"},
                {29,8,2021,"2021年8月30日"},
                {29,10,2008,"2008年10月30日"},
                {29,4,2021,"2021年4月30日"},
                {29,6,2008,"2008年6月30日"},
                {2,15,2040,"输入数据有问题"},
                {39,10,2041,"输入数据有问题"},
                {2,1,2001,"2001年1月3日"},
                {31,3,2002,"2002年4月1日"},
                {3,4,2003,"2003年4月4日"},
                {30,6,2004,"2004年7月1日"},
                {4,12,2005,"2005年12月5日"},

        });
    }

    @Test
    public void testNextDate(){
        nextDate = new NextDate();
        Assert.assertEquals(expected, nextDate.getNextDate(day, month, year));
    }
}
