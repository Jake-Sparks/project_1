# Smart Renewable City Energy Simulation
## Overview

This project is a Java-based simulation of a smart city energy system. It models how a city is powered using renewable energy sources, energy storage systems, and backup fossil fuel generation.

The system dynamically balances supply and demand using weather-driven generation and automated energy dispatch.

The system provides both operational simulation and analytical insights into energy sustainability and reliability.

-----

## Key Features

### Renewable Energy Sources
- Solar farms (based on sunlight intensity and hours)
- Wind farms (based on wind speed)

### Energy Storage Systems
- Battery storage (high efficiency, short-term)
- Pumped hydro storage (medium efficiency)
- Hydrogen storage (low efficiency, long-term)

### Backup Power System
- Fossil fuel plant activates ONLY when:
  - Renewables are insufficient
  - Storage is depleted
- Prevents blackouts but increases carbon emissions

---------

## Energy Dispatch Logic

The system follows a realistic priority order:

1. Renewable energy generation
2. Stored energy usage
3. Fossil fuel backup
4. Blackout (if all fail)

-------

## Simulation Components

### Weather System
- Random daily weather conditions
- Directly impacts solar and wind generation

### City Demand
- Based on population and consumption
- Fluctuates daily

### Energy Network
- Collects renewable energy
- Stores excess energy
- Balances supply and demand
- Activates fossil backup when required

-----

## Reporting & Analytics

Each simulation day includes:

- Total energy production
- Energy demand
- Renewable vs fossil energy usage
- Energy mix percentages
- Carbon emissions
- Excess energy wasted
- Storage levels
- System status

### System Status Levels
- STABLE – Fully powered by renewables
- STRAINED – Fossil backup used
- CRITICAL – Blackout occurred

------

## Example Output

--- Energy Report ---
Production: 1476.79 MWh
Demand: 1476.79 MWh

Renewable Energy Used: 850.00 MWh
Fossil Energy Used: 626.79 MWh
Energy Mix: 57.6% Renewable | 42.4% Fossil

Carbon Emissions Today: 589511.96 kg
System Status: STRAINED (Fossil Backup Used)

-------

## Examples of data inputs

### City

- Population: 10,000 - 1,000,000 
- Consumption: 10 - 30 kWh/day

### Solar Farm

- Capacity: 50 - 500
- Efficiency: 0.15-0.25 (REALISTIC) BUT for simulation sakes, 0.6 - 0.95

### Wind Farm

- Turbines: 5 - 50
- Turbine Capacity: 2 - 5 MW
- Efficiency: 0.6 - 0.9

### Storages

- Battery: 200 - 2000 MWh
- Pumped Hydro: 1000 - 10000 MWh
- Hydrogen: 500 - 5000 MWh

### Fossil Plant

- Capacity: 100 - 500 MW
- Efficiency: 0.7 - 0.95

## Example Input 

City:
- Population: 150,000
- Consumption: 25

Solar:
- 120 MW, efficiency 0.75

Wind:
- 10 turbines, 3 MW, efficiency 0.7

Storage:
- Battery: 500 MWh

Fossil:
- 250 MW, efficiency 0.9

### Result

- Frequent fossil usage
- Good carbon variation
- Status = STRAINED often

------

## Object-Oriented Design

This project demonstrates:

- Abstraction – EnergySource and EnergyStorage base classes
- Inheritance – Solar, Wind, Fossil subclasses
- Polymorphism – Unified handling of all energy types
- Encapsulation – EnergyReport stores simulation results

-------------

## How to Run

1. Compile the project
2. Run SimulationRunner
3. Follow menu options:
   - Create a city
   - Add energy sources
   - Add storage systems
   - Run simulation

-----

## Conclusion

This simulation models the real-world challenge of balancing renewable energy sustainability with grid reliability. It highlights how backup systems are required when renewable generation is insufficient. 

