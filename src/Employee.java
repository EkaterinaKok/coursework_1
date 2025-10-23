//1. Создайла класс Employee с информацией о Ф. И. О., отделе и зарплате сотрудника:
public class Employee {
    //Поля скрыты
    private String fullName;
    private int department;
    private double salary;
//2. Добавила статическую переменную-счетчик, которая будет отвечать за id:
    private static int Count = 1;
//3. Добавьте в класс Employee поле id:
    private int id;

    // Конструктор
    public Employee(String fullName, int department, float salary) {
        this.id = Count++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

//4. Геттеры ко всем полям
    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getCount() {
        return Count;
    }

    public int getId() {
        return id;
    }

//4. Сеттеры для отдела и ЗП
    public void setDepartment(int department) {
        if (department >=1 && department<=5) {
            this.department = department;
        } else System.out.println("Отдел должен быть от 1 до 5.");
    }

    public void setSalary(double salary) {
        if (salary >= 50000 && salary <= 450000) {
            this.salary = salary;
        } else System.out.println("Зарплата должна быть в пределах от 50 до 450 тыс.руб.");
    }

//5. Метод для бухучета. Сравнение только по значению ЗП.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee otherSalary = (Employee) o;
        return this.salary == otherSalary.salary;
    }

//6. Вывод всех данных — через переопределение метода toString
    @Override
    public String toString() {
        return "№ " + id + ": " + fullName + ", отдел: " + department + ", зарплата: " + salary + " руб.";
    }

//6. Вывод только имени и зарплаты — через вызов System.out.println в отдельном методе public void printShortInfo()
    public void printShortInfo() {
        System.out.println("Имя: " + fullName + ", зарплата: " + salary + " руб.");
    }
}
