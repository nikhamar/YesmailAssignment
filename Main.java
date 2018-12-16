public class Main {
    int[] monthDays = new int[]{31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};


    public static void main(String[] args) {


        CustomDate dt1 = new CustomDate(1, 1, 2018);

        CustomDate dt2 = new CustomDate(31, 12, 2018);


        Main m = new Main();


        System.out.println("difference: " + m.getDateDifference(dt1, dt2));


    }


    public int getDateDifference(CustomDate d1, CustomDate d2) {


        int count1 = getCount(d1);


        int count2 = getCount(d2);


        return (count2 - count1);


    }


    public int getCount(CustomDate date) {

        int count1 = date.year * 365 + date.day;


        for (int i = 0; i <= date.month - 1; i++) {

            count1 = count1 + monthDays[i];

        }


        count1 = count1 + countLeapYears(date);

        return count1;

    }


    public int countLeapYears(CustomDate date) {


        int years = date.year;


        if (date.month <= 2) {

            years = years - 1;

        }


        return (years / 4 - years / 100 + years / 400);

    }



}
