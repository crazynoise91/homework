package untitled;

class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    // Конструктор
    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации о товаре
    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Свободен"));
        System.out.println();
    }
}

class Park {
    private String name;
    private Attraction[] attractions;

    // Конструктор
    public Park(String name, int numberOfAttractions) {
        this.name = name;
        this.attractions = new Attraction[numberOfAttractions];
    }

    // Внутренний класс Attraction
    class Attraction {
        private String attractionName;
        private String workingHours;
        private double ticketPrice;

        // Конструктор
        public Attraction(String attractionName, String workingHours, double ticketPrice) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.ticketPrice = ticketPrice;
        }

        // Метод для вывода информации об аттракционе
        public void displayInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена билета: " + ticketPrice);
            System.out.println();
        }
    }

    // Метод для добавления аттракциона
    public void addAttraction(int index, String name, String hours, double price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, hours, price);
        }
    }

    // Метод для вывода информации об аттракционах
    public void displayAttractions() {
        System.out.println("Аттракционы в парке " + name + ":");
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание массива товаров
        Product[] productsArray = new Product[5];

        // Заполнение массива товарами
        productsArray[0] = new Product("Samsung $25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 14", "15.09.2022", "Apple Inc.", "USA", 999, false);
        productsArray[2] = new Product("Xiaomi Mi 11", "01.03.2021", "Xiaomi", "China", 799, true);
        productsArray[3] = new Product("Sony WH-1000XM4", "01.08.2020", "Sony", "Japan", 349, false);
        productsArray[4] = new Product("Dell XPS 13", "15.01.2021", "Dell", "USA", 1299, true);

        // Вывод информации о каждом товаре
        System.out.println("Информация о товарах:");
        for (Product product : productsArray) {
            product.displayInfo();
        }

        // Создание парка аттракционов
        Park amusementPark = new Park("Веселый парк", 3);

        amusementPark.addAttraction(0, "Американские горки", "10:00 - 22:00", 500);
        amusementPark.addAttraction(1, "Колесо обозрения", "10:00 - 23:00", 300);
        amusementPark.addAttraction(2, "Поездка на поезде", "10:00 - 20:00", 200);

        // Вывод информации об аттракционах
        amusementPark.displayAttractions();
    }
}