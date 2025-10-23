
public class Main {
    public static void main(String[] args) {
        String typeTax1 = "PROPORTIONAL";
        String typeTax2 = "PROGRESSIVE";
        Employee[] employees = new Employee[10];
        Employee[] employeesTest = new Employee[10];

        // создали объекты класса Employee
        Employee emp1 = new Employee("Ivanov Ivan Ivanovich", 2, 70000);
        Employee emp2 = new Employee("Petrov Petr Petrovich", 4, 160000);
        Employee emp3 = new Employee("Semenova Irina Olegovna", 3, 400000);
        Employee emp4 = new Employee("Smirnova Anna Vladimirovna", 1, 60000);
        Employee emp5 = new Employee("Petrov Dmitrii Sergeevich", 5, 140000);
        Employee emp6 = new Employee("Ivanova Mariia Aleksandrovna", 2, 280000);
        Employee emp7 = new Employee("Nikolaev Aleksei Petrovich", 3, 340000);
        Employee emp8 = new Employee("Vasileva Elena Nikolaevna", 4, 350000);
        Employee emp9 = new Employee("Morozov Ivan Konstantinovich", 1, 90000);
        Employee emp10 = new Employee("Fedorova Olga Dmitrievna", 5, 100000);
        Employee emp11 = new Employee("Kuznetsov Mikhail Andreevich", 3, 210000);

        System.out.println("\nВывод созданного объекта Employee через toString:");
        System.out.println(emp1);

        System.out.println("\nВывод созданного объекта Employee через метод printShortInfo:");
        emp1.printShortInfo();

        // cоздали объект класса EmployeeBook
        EmployeeBook book = new EmployeeBook(employees);
        // добавили в список 10 сотрудников
        book.addEmployeeInBook(emp1);
        book.addEmployeeInBook(emp2);
        book.addEmployeeInBook(emp3);
        book.addEmployeeInBook(emp4);
        book.addEmployeeInBook(emp5);
        book.addEmployeeInBook(emp6);
        book.addEmployeeInBook(emp7);
        book.addEmployeeInBook(emp8);
        book.addEmployeeInBook(emp9);

        System.out.println("\nСписок сотрудников:");
        book.printBook();

        System.out.println("\nЗаписываем сотрудника в список методом foundPlace:");
        book.foundPlace(emp10);
        System.out.println("\nНовый список с добавленным сотрудником:");
        book.printBook();

        System.out.println("\nЕще раз пробуем записать сотрудника в полный список методом foundPlace:");
        book.foundPlace(emp11);

        System.out.println("\nПробуем записать сотрудника в полный список методом addEmployeeInBook:");
        book.addEmployeeInBook(emp11); //11 сотрудник, не должен записаться

        System.out.println();
        book.averageSalary();

        System.out.println();
        book.taxPrint(typeTax1);
        System.out.println();
        book.taxPrint(typeTax2);
        System.out.println("\nОтработка ошибки на другую систему расчета налогов:");
        book.taxPrint("Неизвестная система расчета налогов");

        System.out.println("\nИндексация ЗП у сотрудников заданного отдела на указанный процент:");
        book.indexingSalary(4,17);
        book.indexingSalary(4,0);  //отработка ошибки, если процент = 0
        book.indexingSalary(4,-5); //отработка ошибки, если процент < 0
        book.indexingSalary(6,15); //отработка ошибки на неверный отдел

        System.out.println("\nПервый сотрудник заданного отдела и ЗП больше указанной:");
        book.salaryFilter(3,50000);
        book.salaryFilter(7,50000);  //отработка ошибки на неверный отдел
        book.salaryFilter(4,450000); //если нет совпадений

        System.out.println("\nПервые сотрудники (заданное количество) с ЗП меньше указанной:");
        book.salaryFilterTwo(150000, 2);
        System.out.println();
        book.salaryFilterTwo(100000, 5); //если нет столько сотрудников
        System.out.println();
        book.salaryFilterTwo(40000, 3);  //если нет подходящих вариантов

        // новый сотрудник для сравнения по ЗП в списке
        Employee empForEquals = new Employee("Fadeev Nikita Ivanovich", 1, 220000);

        System.out.println("\nСовпадение по ЗП:");
        book.equalsSalary(emp4); //есть
        book.equalsSalary(empForEquals); //нет

        System.out.println("\nПоиск сотрудника по заданному id");
        book.foundEqualsId(3);
        book.foundEqualsId(-3); //если некорректный id

// 11. Создать объект класса EmployeeBook, наполните его через метод добавления нового сотрудника — вызовите метод 11 раз, выведите результат исполнения метода на экран.
        System.out.println("\nТест на переполнение массива из 10 ячеек:");
        EmployeeBook bookTest = new EmployeeBook(employeesTest);
        for (int i = 0; i < 11; i++) {
            bookTest.addEmployeeInBook(emp1);
        }
    }
}