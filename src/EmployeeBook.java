// 7. Создан класс EmployeeBook c полем типа Employee[10]:
public class EmployeeBook {
    private Employee[] emp;
    private int size = 0;
    private double total;

    // Конструктор
    public EmployeeBook(Employee[] emp) {
        this.emp = emp;
    }

    // Добавление сотрудника в список
    public void addEmployeeInBook(Employee employee) {
        if (employee == null) {
            System.out.println("Пустое значение");
            return;
        }
        if (size >= emp.length) {
            System.out.println("Нет места для записи.");
            return;
        }
        this.emp[size] = employee;
        size++;
    }

// 8.1 Получение списка всех сотрудников со всеми данными о них.
    public void printBook() {
        if (emp == null) {
            System.out.println("Список пустой.");
            return;
        }
        for (Employee employee : emp) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

// 8.2 Подсчет среднего значения зарплат.
    public void averageSalary() {
        int count = 0;
        double average;

        if (emp == null){
            System.out.println("Список пустой.");
            return;
        }
        for (Employee employee : emp) {
            if (employee != null) {
                total = employee.getSalary() + total;
                count++;
            } else break;
        }
        average = total / count;
        System.out.println("Средняя зарплата сотрудников: " + average);
    }

// 8.3 Вывести значения налогов.
    public void taxPrint(String taxType) {
        double tax = 0;
        double percentProportional = 0.13;
        double percentProgressiveV1 = 0.13;
        double percentProgressiveV2 = 0.17;
        double percentProgressiveV3 = 0.21;

        if (emp == null) {
            System.out.println("Список пустой.");
            return;
        }

        switch (taxType) {
            case "PROPORTIONAL":
                System.out.println("Налог по схеме PROPORTIONAL:");
                for (Employee employee : emp) {
                    if (employee != null) {
                        tax = employee.getSalary() * percentProportional;
                        System.out.println(employee.getFullName() + " составляет - " + tax + " руб.");
                    }
                }
                break;
            case "PROGRESSIVE":
                System.out.println("Налог по схеме PROGRESSIVE:");
                for (Employee employee : emp) {
                    if (employee != null) {
                        if (employee.getSalary() <= 150000) tax = employee.getSalary() * percentProgressiveV1;
                        if (employee.getSalary() > 150000 && employee.getSalary() <= 350000)
                            tax = employee.getSalary() * percentProgressiveV2;
                        if (employee.getSalary() > 350000) tax = employee.getSalary() * percentProgressiveV3;
                        System.out.println(employee.getFullName() + " составляет - " + tax + " руб.");
                    } else return;
                }
                break;
            default:
                System.out.println("Неизвестный метод расчета налогов.");
                break;
        }
    }

// 8.4 Индексация зарплаты всех сотрудников полученного отдела на полученный процент.
    public void indexingSalary(int department, double percent) {
        percent = percent/100;

        if (department < 1 || department > 5) {
            System.out.println("Номер отдела должен быть от 1 до 5.");
            return;
        }
        if (percent <= 0) {
            System.out.println("Процент индексации некорректный. Изменения не применяются.");
            return;
        }
        if (emp == null) {
            System.out.println("Список пустой.");
            return;
        }

        for (Employee employee : emp) {
            if (employee != null) {
                if (employee.getDepartment() != department) continue; //Применила continue по заданию
                employee.setSalary(employee.getSalary() + (employee.getSalary() * percent));
                System.out.println("Индексация прошла успешно у " + employee.getFullName() + ", отдел " + department + ", на " + (percent*100) + "%. Новая ЗП: " + employee.getSalary() + " руб.");
            } else return;
        }
    }

// 8.5 Вывести первого сотрудника полученного отдела с зарплатой больше указанной вместе с порядковым номером в списке.
    public void salaryFilter(int department, double salaryFilter) {
        boolean found = false;

        if (department < 1 || department > 5) {
            System.out.println("Номер отдела должен быть от 1 до 5.");
            return;
        }
        if (emp == null) {
            System.out.println("Список пустой.");
            return;
        }

        for (Employee employee : emp) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > salaryFilter) {
                System.out.print("№ " + employee.getId() + " ");
                employee.printShortInfo();// использовала метод по заданию
                found = true;
                break;// использовала for и break по заданию
            }
        }
        if (!found) {
            System.out.println("Ни одного совпадения не найдено.");
        }
    }

// 8.6 Получить размер ЗП и кол-во сотрудников и вывести первое ко-во сотрудников с ЗП меньше указанной
    public void salaryFilterTwo(double wage, int countEmployees) {
        boolean found = false;
        int count = countEmployees;

        if (countEmployees == 0) {
            System.out.println("Количество сотрудников не должно равняться 0.");
            return;
        }

        for (Employee employee : emp) {
            while (countEmployees > 0) {  //использовала по заданию while и break
                if (employee != null && employee.getSalary() < wage) {
                    employee.printShortInfo();
                    countEmployees--;
                    found = true;
                }
                if (countEmployees != 0) {
                    found = false;
                    break;
                }
            }
        }
        if (!found && countEmployees == count) System.out.println("Ни один сотрудник не подходит под условие.");
        if (!found && countEmployees < count) System.out.println("Найдено " + (countEmployees + 1) + " сотрудников" + " из " + count + ", больше никто не подходит.");
    }

// 8.7 Получить объект сотрудника и вывести boolean после сравнения по методу бухучета (по ЗП).
    public boolean equalsSalary(Employee employeeFound) {
        boolean found = false;

        for (Employee employee : emp) {
            if (employee != null && employee.equals(employeeFound)) { //сравнение через equals по заданию
                found = true;
                break;
            }
        }
        return found;
    }

// 9. Найти свободную ячейку в массиве и положить в нее данные нового сотрудника, и вернуть результат boolean.
    public boolean foundPlace(Employee employeeAdd) {
        boolean found = false;

        for (Employee employee : emp) {
            if (employee == null) {
                addEmployeeInBook(employeeAdd);
                found = true;
                break;
            }
        }
        return found;
    }

// 10. Метод для получения сотрудника по id.
    public void foundEqualsId(int id) {
        boolean found = false;

        if (id <= 0) {
            System.out.println("Некорректный id. ");
            return;
        }

        for (Employee employee : emp) {
            if (employee != null && employee.getId() == id) {
                System.out.println("Найден сотрудник под заданным номером " + id + ":");
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) System.out.println("Сотрудник не найден по заданному id.");
    }
}
