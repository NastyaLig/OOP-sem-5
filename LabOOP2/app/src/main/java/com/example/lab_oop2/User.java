package com.example.lab_oop2;

public class User {
    public boolean userSex;
    public int userWeigth;
    public int userHeigth;
    public int userAge;
    public double userLifeStyle;
    public double BMR;

    public double GetNumberOfCalories(User u)
    {
        if(u.userSex)
            u.BMR = Math.round(66.4730 + (13.7516 * u.userWeigth)
                    + (5.0033 + u.userHeigth)
                    - (6.7550 * u.userAge)) * u.userLifeStyle;
        else
            u.BMR = Math.round(65.0955 + (9.5634 * u.userWeigth)
                    + (1.8496 * u.userHeigth)
                    - (4.6756 * u.userAge)) * u.userLifeStyle;
        return u.BMR;
    }
}
