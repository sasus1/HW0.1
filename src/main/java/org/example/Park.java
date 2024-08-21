package org.example;

public class Park {
    private String name;
    public Park(String name) {
        this.name = name;
    }
    public class Attraction
    {
        private String attractionName;
        private String workingHours;
        private double cost;
        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        public void printInfo()
        {
            System.out.println("Attraction Name: " + attractionName);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Cost: " + cost + " Руб");
        }
    }
    public static void main(String[] args)
    {
        Park park = new Park("Park");
        Attraction attractionOne = park.new Attraction("Attraction1", "09:00 - 17:00", 18);
        attractionOne.printInfo();
    }
}
