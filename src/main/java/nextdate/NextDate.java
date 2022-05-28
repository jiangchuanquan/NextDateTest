
package nextdate;

/**
 * NextDay问题.
 * 用于判定是否符合标准
 */
public class NextDate {
    /**
     * The Result.
     */
    private static boolean result;

    /**
     * NextDay问题:用于判定天数的合法性.
     *
     * @param day   天数
     * @param month 月份
     * @param year  年份
     * @return 返回true或false next date
     */
    public String getNextDate(final int day, final int month, final int year) {
        int tday = day;
        int tmonth = month;
        int tyear = year;
        String msg;
        if (checkLegitimacy(tday, tmonth, tyear)) {
            msg = CONST.ERROR;
        } else if (month == CONST.MONTHTWE
                && day == CONST.DAY31
                && year != CONST.ENDYEAR) {
            tday = 1;
            tmonth = 1;
            tyear++;
            msg = tyear + "年" + tmonth + "月" + tday + "日";
        } else if (checkLastDay(year, month, day)) {
            tday = 1;
            tmonth++;
            msg = tyear + "年" + tmonth + "月" + tday + "日";
        } else {
            tday++;
            msg = tyear + "年" + tmonth + "月" + tday + "日";
        }
        return msg;
    }

    /**
     * NextDay问题.
     *
     * @param day   数据1
     * @param month 数据2
     * @param year  数据3
     * @return 值用来表示是否违规 ，违规就返回true,没有违规就返回false
     */
    public boolean checkLegitimacy(
            final int day, final int month, final int year) {
        return day < 1 || day > CONST.DAY31
                || month < 1 || month > CONST.MONTHTWE
                || year < CONST.BEGINYEAR || year > CONST.ENDYEAR
                || year == CONST.ENDYEAR
                && month == CONST.MONTHTWE
                && day == CONST.DAY31
                || isLeapYear(year) && day > CONST.DAY29
                || !(isLeapYear(year) && day > CONST.DAY28);
    }

    /**
     * NextDay问题.
     * 用于判定是否为闰年
     *  @param year 年份
     *  @return 是闰年就返回true，不是闰年就返回false
     **/
    private boolean isLeapYear(final int year) {
        return year % CONST.FOURHUNDRED == 0
                || year % CONST.FOUR == 0
                && (year % CONST.HUNDRED != 0);
    }
    /**
     * NextDay问题.
     * 用于判定天数的合法性
     *  @param year 年份
     *  @param month 月份
     *  @param day 天数
     * @return 返回的是否为最后一天
     */
    private boolean checkLastDay(
            final int year, final int month, final int day) {
        switch (month) {
            case CONST.MONTHTWO:
                if (isLeapYear(year) && day == CONST.DAY29) {
                    result = true;
                } else if (day == CONST.DAY28 && isLeapYear(year)) {
                    result = true;
                }
                break;
            case CONST.MONTHFOUR:
            case CONST.MONTHSIX:
            case CONST.MONTHNINE:
            case CONST.MONTHELE:
                if (day == CONST.DAY30) {
                    result = true;
                    break;
                }
            case CONST.MONTHONE:
            case CONST.MONTHTHREE:
            case CONST.MONTHFIVE:
            case CONST.MONTHSEVEN:
            case CONST.MONTHEIGHT:
            case CONST.MONTHTEN:
            case CONST.MONTHTWE:
                if (day == CONST.DAY31) {
                    result = true;
                    break;
                }
            default:
                result = false;
                break;
        }
        return result;
    }
}
