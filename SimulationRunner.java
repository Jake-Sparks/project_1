import java.util.Scanner;

public class SimulationRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        EnergyNetwork network = new EnergyNetwork();
        City city = null;
        boolean running = true;


        while (running) {

            System.out.println("\n==== SMART RENEWABLE CITY SIMULATION ====");
            System.out.println("1. Create City");
            System.out.println("2. Add Energy Source");
            System.out.println("3. Add Storage System");
            System.out.println("4. View System Details");
            System.out.println("5. Run Simulation (Daily Report)");
            System.out.println("6. Run Simulation (Summary Only)");
            System.out.println("7. Exit");

            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    if (city != null) {
                        System.out.println("A city has already been created.");
                        break;
                    }

                    System.out.print("Enter city population: ");
                    int population = scanner.nextInt();

                    System.out.print("Enter average daily consumption (kWh per person): ");
                    double consumption = scanner.nextDouble();

                    city = new City(population, consumption);
                    System.out.println("City created successfully.");

                    break;

                case 2:

                    if (city == null) {
                        System.out.println("Please create a city first.");
                        break;
                    }

                    System.out.println("\nAdd Energy Source");
                    System.out.println("1. Solar Farm");
                    System.out.println("2. Wind Farm");
                    System.out.println("3. Fossil Fuel Plant");

                    int sourceChoice = scanner.nextInt();

                    switch (sourceChoice) {

                        case 1:
                            System.out.print("Solar farm capacity (MW): ");
                            double capacity = scanner.nextDouble();

                            double solarEfficiency;

                            while (true) {
                                System.out.print("Efficiency (0-1): ");
                                solarEfficiency = scanner.nextDouble();

                                if (solarEfficiency >= 0 && solarEfficiency <= 1) {
                                    break;
                                }

                                System.out.println("Invalid Input: Efficiency must be between 0 and 1");
                            }

                            SolarFarm solar = new SolarFarm(capacity, solarEfficiency, "land", 0);
                            network.addEnergySource(solar);

                            System.out.println("Solar farm added.");
                            break;


                        case 2:

                            System.out.print("Number of turbines: ");
                            int turbines = scanner.nextInt();

                            System.out.print("Turbine capacity (MW): ");
                            double turbineCapacity = scanner.nextDouble();

                            double windEfficiency;

                            while (true) {
                                System.out.print("Efficiency (0-1): ");
                                windEfficiency = scanner.nextDouble();
                                
                                if (windEfficiency >= 0 && windEfficiency <= 1) {
                                    break;
                                }

                                System.out.println("Invalid Input: Efficiency must be between 0 and 1");
                            }

                            System.out.print("Location (land/offshore): ");
                            scanner.nextLine();
                            String location = scanner.nextLine();

                            WindFarm wind = new WindFarm(windEfficiency, location, turbines, turbineCapacity, 0);
                            network.addEnergySource(wind);
                            
                            System.out.println("Wind farm added.");

                            break;

                        case 3:
                            System.out.print("Fossil plant capacity (MW): ");
                            double fossilCapacity = scanner.nextDouble();
                            double fossilEfficiency;

                            while (true) {
                                System.out.print("Efficiency (0-1): ");
                                fossilEfficiency = scanner.nextDouble();

                                if (fossilEfficiency >= 0 && fossilEfficiency <= 1) {
                                    break;
                                }
                        
                                System.out.println("Invalid Input");
                            }

                            FossilFuelPlant fossil = new FossilFuelPlant(fossilCapacity, fossilEfficiency, "land", 750);

                            network.addEnergySource(fossil);

                            System.out.println("Fossil fuel plant added.");
                            break;

                        default:
                            System.out.println("Invalid energy source.");
                    }

                    break;

                case 3:

                    if (city == null) {
                        System.out.println("Please create a city first.");
                        break;
                    }

                    System.out.println("\nAdd Storage System");
                    System.out.println("1. Battery Storage");
                    System.out.println("2. Pumped Hydro Storage");
                    System.out.println("3. Hydrogen Storage");

                    int storageChoice = scanner.nextInt();

                    System.out.print("Enter storage capacity (MWh): ");
                    double storageCapacity = scanner.nextDouble();

                    switch (storageChoice) {

                        case 1:
                            BatteryStorage battery = new BatteryStorage(storageCapacity);
                            network.addStorage(battery);
                            System.out.println("Battery storage added.");
                            break;

                        case 2:
                            PumpedHydro hydro = new PumpedHydro(storageCapacity);
                            network.addStorage(hydro);
                            System.out.println("Pumped hydro storage added.");
                            break;

                        case 3:
                            HydrogenStorage hydrogen = new HydrogenStorage(storageCapacity);
                            network.addStorage(hydrogen);
                            System.out.println("Hydrogen storage added.");
                            break;

                        default:
                            System.out.println("Invalid storage type.");
                    }

                    break;


                case 4:

                    System.out.println("\n======= CITY NETWORK DETAILS =======");

                    if (city == null) {
                        System.out.println("No city created yet.");
                    } else {
                        System.out.println("City population: " + city.getPopulation());
                        System.out.println("Average consumption: " + city.getAverageConsumption() + " kWh per person");
                    }

                    System.out.println("\nEnergy Sources Installed: " + network.getEnergySources().size());
                    System.out.println("Storage Systems Installed: " + network.getStorageSystems().size());

                    System.out.println("\nStorage Status:");

                    for (int i = 0; i < network.getStorageSystems().size(); i++) {
                        EnergyStorage storage = network.getStorageSystems().get(i);
                        System.out.println(storage);
                    }

                    break;

                case 5:
                case 6:

                    if (city == null) {
                        System.out.println("Please create a city first.");
                        break;
                    }

                    System.out.print("Enter number of days to simulate: ");
                    int days = scanner.nextInt();

                    double totalProduction = 0;
                    double totalDemand = 0;
                    int blackoutDays = 0;
                    double totalCarbon = 0;
                    
                    for (int day = 1; day <= days; day++) {

                        Weather weather = new Weather();
                        
                        if (choice == 5) {
                            System.out.println("\n==============================");
                            System.out.println("            DAY " + day);
                            System.out.println("==============================");
                        }

                        double demand = city.getDailyDemand();
                        EnergyReport initial = network.collectEnergyWithCarbon(weather);
                        EnergyReport finalReport = network.balanceEnergy(initial.getTotalEnergy(), initial.getTotalCarbon(), demand);
                        double production = finalReport.getTotalEnergy();
                        double carbon = finalReport.getTotalCarbon();

                        if (choice == 5) {
                            
                            // ---weather report section---
                            System.out.println("\n--- Weather Report ---");
                            System.out.printf("Wind Speed: %.2f m/s\n", weather.getWindSpeed());
                            System.out.printf("Sun Intensity: %.2f\n", weather.getSunIntensity());
                            System.out.printf("Sun Hours: %.2f\n", weather.getSunHours());

                            // ---energy report section---
                            System.out.println("\n--- Energy Report ---");

                            // production
                            System.out.printf("Production: %.2f MWh\n", production);
                            // demand
                            System.out.printf("Demand: %.2f MWh\n", demand);

                            System.out.println("\nEnergy Breakdown:");
                            double renewable = finalReport.getRenewableUsed();
                            double fossil = finalReport.getFossilUsedEnergy();

                            // how much renewable or fossil energy used?
                            System.out.printf("Renewable Energy Used: %.2f MWh\n", renewable);
                            if (fossil>0) {
                                System.out.printf("Fossil Energy Used: %.2f MWh\n", fossil);
                            }

                            // percentage of this mix of values
                            double total = renewable + fossil;
                            if (total > 0) {
                                double renewablePercent = (renewable / total) * 100;
                                double fossilPercent = (fossil / total) * 100;

                                System.out.printf("Energy Mix: %.2f%% Renewable | %.2f%% Fossil\n", renewablePercent, fossilPercent);
                            }

                            System.out.println("\nSystem Impact:");

                            // excess energy wasted
                            if (finalReport.getExcessEnergy() > 0) {
                                System.out.printf("Excess Energy Wasted: %.2f MWh\n", finalReport.getExcessEnergy());
                            }

                            // carbon emissions of that day
                            System.out.printf("Carbon Emissions Today: %.2f kg\n", carbon);
                            
                            // what was the status level of the city for that day
                            String status;
                            if (finalReport.isBlackoutOccurred()) {
                                status = "CRITICAL (Blackout Occurred)";
                            } else if (finalReport.isFossilUsed()) {
                                status = "STRAINED (Fossil Fuel Backup has been used)";
                            } else {
                                status = "STABLE (Renewables Powered)";
                            }
                            System.out.println("System status: " + status);
                            
                            // ---storage report--
                            System.out.println("\n--- Storage Status ---");

                            for (int i = 0; i < network.getStorageSystems().size(); i++) {
                                EnergyStorage storage = network.getStorageSystems().get(i);
                                System.out.println(storage);
                            }
                        }

                        totalProduction += production;
                        totalDemand += demand;
                        totalCarbon += carbon;

                        if (finalReport.isBlackoutOccurred()) {
                            blackoutDays += 1;
                        }
                    }

                    System.out.println("\n========== SIMULATION SUMMARY ========");
                    System.out.printf("Total Energy Produced: %.2f MWh\n", totalProduction);
                    System.out.printf("Total Energy Demand: %.2f MWh\n", totalDemand);
                    System.out.printf("Total Carbon Emissions: %.2f kg\n", totalCarbon);
                    System.out.println("Blackout Days: " + blackoutDays);

                    break;

                case 7:
                    running = false;
                    System.out.println("Simulation ended.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}