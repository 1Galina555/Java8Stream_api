import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        /*
        Все задания, описанные ниже должны быть выполнены с помощью Java 8 Stream API.
1.	Напишите метод, который на вход принимает диапазон лет, возвращает список високосных годов в этом диапазоне.
Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
2.	Напишите метод, который на вход принимает целое число(количество зарплат) и возвращает список вещественных чисел,
состоящих из случайных зарплат, распределенных по закону нормального распределения. Примечание:
 У нормального распределения есть два параметра: mean(среднее значение)  и std(среднее отклонение).
  У класса Random есть метод nextGaussian(), который генерирует нормально распределенное число с параметрами mean=0,
  std=1. Для генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои).
  Используйте такую формулу генерации: случайная зарплата = nextGaussian() * std + mean.
        */
        Scanner enter = new Scanner(System.in);
        System.out.println("Задание 1.Список високосных лет");
        System.out.println("Введите год начала отсчета: ");
        int yearFirst = enter.nextInt();
        System.out.println("Введите год конца отсчета: ");
        int yearLast = enter.nextInt();

        List<Integer> yearsLeap = listYearLeap(yearFirst, yearLast);
        System.out.println(yearsLeap);

        System.out.println("Задание 2.Список зарплат по распределению Гаусса");
        System.out.println("Введите количество  зарплат: ");
        int numSalary = enter.nextInt();
        List<Double> salaries = salariesGaussian(numSalary);
        System.out.println(salaries);





    }

    public static List<Integer> listYearLeap (int yearFirst, int yearLast){
        List<Integer> year = new ArrayList<>();
        for(int i=yearFirst; i<=yearLast; i++ ){
            year.add(i);
        }

        List<Integer> leapYears = year.stream()
                .filter(c-> (  c%400 == 0 || (c%4==0 && c%100!=0)  ) )
                .toList();

        return leapYears;
    }

    public static List<Double> salariesGaussian (int numSalary){
        Random number = new Random();
        List<Double> salariesGaussian = DoubleStream.generate(() -> number.nextGaussian(11190, 29267))
                .filter(n -> n>=0)
                .limit(numSalary)
                .boxed()
                .toList();

        return salariesGaussian;
    }

}