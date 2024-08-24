package org.example;

public class Employee {
    String name; /
    String position;
    String email;
    String phone_number;
    int salary;
    int age;

    public Employee(String name, String position, String email, String phone_number, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    public String toString(){
        return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                name, position, email, phone_number, salary, age);}

    public void print(){
        System.out.println(this);
    }


    public static void main(String[] args)  {

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иванов Иван Иванович", "Генеральный директор", "ii@primer,ru", "+79446665234", 250000, 78);
        persArray[1] = new Employee("Семенов Семен Семенович", "Продавец", "cc@primer,ru", "+79998234412", 12000, 23);
        persArray[2] = new Employee("Сергеев Сергей сергеевич", "Охранник", "cc@primer,ru", "+79956451554", 16000, 65);
        persArray[3] = new Employee("Петров Петр Петрович", "Грузчик", "pp@primer,ru", "+79995552166", 15000, 30);
        persArray[4] = new Employee("Антонов Антон Атонович", "Бухгалтер", "aa@primer,ru", "+79995545886", 17000, 29);

        for (int i=0; i < persArray.length; i++)
            if (persArray[i].age > 40) persArray[i].print();

    }
}
